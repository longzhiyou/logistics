package lzy.websocket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 *
 * Created by bukeyan on 2017/5/6.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Value("${webSocket.host}")
    private String host;

    @Value("${webSocket.port}")
    private Integer port;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //Javascript connection subscribes to this URI
        //这里配置了两个前缀，若是destination以这两个前缀开头，则会转发给该Broker
        config.enableSimpleBroker("/topic", "/queue");
        //STOMP messages are sent to this URI + suffix
        //这个前缀不需要与web项目名相同，可以自己随意指定
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //URI used for SockJS connection
        registry.addEndpoint("/websocket").setAllowedOrigins("*").withSockJS();
    }

//    @Bean
//    public ServerEndpointExporter serverEndpointExporter() {
//        return new ServerEndpointExporter();
//    }
}
