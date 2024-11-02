package com.marchgoose.txpoker.controller;

import com.marchgoose.txpoker.vo.UserPingMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author steeveen
 * @date 2024/10/31 22:56
 */
@Controller
@Slf4j
public class RoomController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    private Map<String,String> userSession=new HashMap<>();

    @MessageMapping("/send")
    @SendTo("/topic/your-topic")
    public String handlePing( String message){
        log.info("send message:{}",message);
        return "haha:"+message;
    }
}
