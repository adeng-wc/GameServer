package com.adeng.gameServer.room.core;

import com.adeng.gameServer.room.config.HallSocketProperties;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * 房间服务启动之后，需要向大厅服务注册
 *
 * @author wengcheng on 2022/5/12
 */
@Slf4j
@Component
public class HallSocketClient {

    @Autowired
    private HallSocketProperties socketConfig;

    private WebSocketClient client;

    @PostConstruct
    public void init() throws URISyntaxException {

        String ws = socketConfig.getWs() + "/10.221.45.19:8081";

        client = new WebSocketClient(new URI(ws)) {
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
        log.info("room 启动，向 hall 发起 socket 连接：{}。", ws);
    }


    @PreDestroy
    public void destroy() {
        client.close();
        log.info("socket close。");
    }
}

