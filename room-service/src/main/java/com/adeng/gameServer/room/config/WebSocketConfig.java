package com.adeng.gameServer.room.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author wengcheng on 2022/5/11
 */
@Component
public class WebSocketConfig {

    /**
     * ServerEndpointExporter 作用
     * <p>
     * 这个Bean会自动注册使用@ServerEndpoint注解声明的websocket endpoint
     *
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
