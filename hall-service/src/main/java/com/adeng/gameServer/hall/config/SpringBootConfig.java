package com.adeng.gameServer.hall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author wengcheng on 2022/5/12
 */
@Component
public class SpringBootConfig {

    /**
     * 配置 websocket
     *
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
