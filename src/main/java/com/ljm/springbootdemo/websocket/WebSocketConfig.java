package com.ljm.springbootdemo.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.AbstractWebSocketMessage;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
//注解开启使用STOMP协议来传输基于代理（message broker）的消息，这时控制器可以使用MessageMapping =@RequestMapping
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Override
    //注册STOMP协议的节点（endpoint),并映射制定的ulr
    public void registerStompEndpoints(StompEndpointRegistry registry){
        //注册一个节点，平指定使用SockJS协议
        registry.addEndpoint("/endpointWisely").withSockJS();
        registry.addEndpoint("/endpointChat").withSockJS();
    }

    @Override
    //配置消息代理类
    public void configureMessageBroker(MessageBrokerRegistry registry){
        //广播式 应配置一个/topic消息代理
        registry.enableSimpleBroker("/topic","/queue");
    }


}
