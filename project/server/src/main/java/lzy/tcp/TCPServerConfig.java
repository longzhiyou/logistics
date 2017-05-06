package lzy.tcp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;

/**
 * User: longzhiyou
 * Date: 2017/5/5
 * Time: 10:05
 */
@Configuration
public class TCPServerConfig {


    @Value("${tcp.port}")
    private Integer port;

    @Bean
    public EventLoopGroup bossGroup() {
        return new NioEventLoopGroup();
    }

    @Bean
    public EventLoopGroup workerGroup() {
        return new NioEventLoopGroup();
    }


    @Bean
    public InetSocketAddress inetSocketAddress() {
        return new InetSocketAddress(port);
    }

    @Bean
    public ServerBootstrap serverBootstrap() {
        return new ServerBootstrap();
    }


}
