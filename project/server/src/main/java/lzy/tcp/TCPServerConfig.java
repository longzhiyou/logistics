package lzy.tcp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;

/**
 * User: longzhiyou
 * Date: 2017/5/5
 * Time: 10:05
 */
@Configuration
public class TCPServerConfig {


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
        return new InetSocketAddress(60000);
    }

    @Bean
    public ServerBootstrap serverBootstrap() {
        return new ServerBootstrap();
    }


}
