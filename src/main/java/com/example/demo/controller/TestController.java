package com.example.demo.controller;

import com.example.demo.config.MyWebSocketHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@RestController
public class TestController {

    @GetMapping("/hello")
    public void hello(){
        WebSocketClient client = new StandardWebSocketClient();
        WebSocketSession session = null;

        try {
            String serverUri = "ws://localhost:8000?serial=L001";
            session = client.doHandshake(new MyWebSocketHandler(), serverUri).get();

            // 연결 성공 시 추가 작업 수행
            session.sendMessage(new TextMessage("메세지 ~~~~"));

            // 웹소켓 사용이 끝난 후에는 닫아주어야 함
            // 닫으면 소켓을 이젠 수신은 못받고 안닫으면 소켓에서 수신을 계속 받을 수 있다.
            // session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
