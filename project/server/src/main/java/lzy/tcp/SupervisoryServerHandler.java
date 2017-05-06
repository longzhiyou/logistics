package lzy.tcp;

import com.xiaoleilu.hutool.date.DateUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lzy.websocket.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: longzhiyou
 * Date: 2017/5/5
 * Time: 10:58
 */
@Component
public class SupervisoryServerHandler extends ChannelInboundHandlerAdapter {

    @Autowired
    private SimpMessagingTemplate template;

    private static final Logger logger = LoggerFactory.getLogger(SupervisoryServerHandler.class);
    private  void  printMessage(ByteBuf in){

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateToStr = sdf.format(date);
        System.out.println(dateToStr);

        while (in.isReadable()) { // (1)

            byte b = in.readByte();
            String hex = Integer.toHexString( b& 0xFF);
            if (hex.length() == 1)
            {
                hex = '0' + hex;
            }
            System.out.print(hex.toUpperCase() + " ");
        }
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        //这里将来应该放入缓冲区
        String text = "[" + DateUtil.now() + "]:" + msg;
        logger.info("rec:"+text);


        template.convertAndSend("/topic/greetings", new Greeting("Hello, " + text + "!"));


//        ByteBuf in = (ByteBuf) msg;
//        int length = in.readableBytes();
    }
}
