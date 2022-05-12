package com.adeng.gameServer.room.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 大厅配置
 *
 * @author wengcheng on 2022/5/12
 */
@Component
@ConfigurationProperties(prefix = "hall.websocket")
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")//需要设置UTF-8，防止乱码
@Data
public class HallSocketProperties {

    private String ws;
}
