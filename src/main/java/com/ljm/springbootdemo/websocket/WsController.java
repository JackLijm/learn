package com.ljm.springbootdemo.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class WsController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/welcome")
    //当服务器有消息时，会对订阅了@SendTo中的路径的浏览器发送消息
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message)throws Exception{
        Thread.sleep(1500);
        return new WiselyResponse("Wellcom, " + message.getName() + " !");
    }

    @MessageMapping("/chat")
    public void handleChat(Principal principal,String msg){
        if(principal.getName().equals("wyf")){
            messagingTemplate.convertAndSendToUser("wisely","/queue/notifications",principal.getName()
            + "-send: " + msg);
        }else {
            messagingTemplate.convertAndSendToUser("wyf","/queue/notifications",principal.getName()
                    + "-send: " + msg);
        }
    }
}
