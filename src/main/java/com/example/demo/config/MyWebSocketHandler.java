package com.example.demo.config;

import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebSocketHandler extends TextWebSocketHandler {
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 연결이 성립된 후 호출되는 메서드
        System.out.println("웹소켓 서버에 연결되었습니다.");
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 메시지 수신 시 호출되는 메서드
        String payload = message.getPayload();
        System.out.println("받은 메시지: " + payload);
    }
}
