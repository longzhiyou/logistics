package lzy.tcp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;

/**
 * User: longzhiyou
 * Date: 2017/5/5
 * Time: 10:05
 */
@Component
@Data
public class TCPServer {

    @Autowired
    @Qualifier("bossGroup")
    private EventLoopGroup bossGroup;

    @Autowired
    @Qualifier("workerGroup")
    private EventLoopGroup workerGroup;


    @Autowired
    private ServerBootstrap serverBootstrap;

    @Autowired
    private InetSocketAddress inetSocketAddress;


    @Autowired
    SupervisoryServerHandler supervisoryServerHandler;

    private Channel  serverChannel;

    @PostConstruct
    public void start() throws Exception {

        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                //添加解码器与消息处理器
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    public void initChannel(SocketChannel ch) throws Exception {
//                        ch.pipeline().addLast(new FixedLengthFrameDecoder(16));
                            ch.pipeline().addLast(new StringDecoder());//设置字符串解码器 自动将报文转为字符串
                        ch.pipeline().addLast(supervisoryServerHandler);//处理网络IO 处理器
//                        ch.pipeline().addLast(new SupervisoryServerHandler());//处理网络IO 处理器

                    }
                })
                .option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, true);
//        serverChannel = serverBootstrap.bind(inetSocketAddress).sync();
//        System.out.println("bind completed.");
//        serverChannel.channel().closeFuture().sync();

        serverChannel =  serverBootstrap.bind(inetSocketAddress).sync().channel();
    }

    @PreDestroy
    public void stop() throws Exception {

        serverChannel.close();
        serverChannel.parent().close();
        workerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();

//        serverChannel.close();
//        serverChannel.parent().close();
    }


}
