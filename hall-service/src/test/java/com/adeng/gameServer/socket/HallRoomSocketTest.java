package com.adeng.gameServer.socket;

import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.handshake.ServerHandshake;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;

/**
 * @author wengcheng on 2022/5/12
 */
@Slf4j
@SpringBootTest
public class HallRoomSocketTest {

    @Test
    public void test() throws Exception {
        String ws = "ws://10.221.45.19:8080/api/v1/websocket/room/张三";
        WebSocketClient client = new WebSocketClient(new URI(ws)) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                log.info("onOpen:连接中");
            }

            @Override
            public void onMessage(String s) {
                log.info("onMessage:收到消息" + s);
            }

            @Override
            public void onClose(int i, String s, boolean b) {
                log.info("onClose:连接关闭");
            }

            @Override
            public void onError(Exception e) {
                e.printStackTrace();
                log.error("onError：异常关闭");
            }
        };

        client.connect();

        while (!client.getReadyState().equals(ReadyState.OPEN)){
            log.info("等待连接");
        }
        log.info("连接成功");

        client.send("测试信息");

        client.close();
    }

    public static void main(String[] args) throws Exception {
        String ws = "ws://10.221.45.19:8080/api/v1/websocket/room/张三";
        WebSocketClient client = new WebSocketClient(new URI(ws)) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                log.info("onOpen:连接中");
            }

            @Override
            public void onMessage(String s) {
                log.info("onMessage:收到消息" + s);
            }

            @Override
            public void onClose(int i, String s, boolean b) {
                log.info("onClose:连接关闭");
            }

            @Override
            public void onError(Exception e) {
                e.printStackTrace();
                log.error("onError：异常关闭");
            }
        };

        client.connect();

        while (!client.getReadyState().equals(ReadyState.OPEN)){
            log.info("等待连接");
        }
        log.info("连接成功");

        client.send("测试信息");

        client.close();
    }
}
