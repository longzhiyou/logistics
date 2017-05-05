package lzy.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import jdk.nashorn.internal.runtime.options.LoggingOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: longzhiyou
 * Date: 2017/5/5
 * Time: 10:58
 */
public class SupervisoryServerHandler extends ChannelInboundHandlerAdapter {

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
        logger.info("rec:"+msg);
//        ByteBuf in = (ByteBuf) msg;
//        int length = in.readableBytes();
    }
}
