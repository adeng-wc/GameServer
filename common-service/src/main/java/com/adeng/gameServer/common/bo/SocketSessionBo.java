package com.adeng.gameServer.common.bo;

import lombok.Data;

import javax.websocket.Session;

/**
 * @author wengcheng on 2022/5/12
 */
@Data
public class SocketSessionBo {

    /**
     * 与某个客户端的连接对话，需要通过它来给客户端发送消息
     */
    private Session session;

    /**
     * 标识当前连接客户端的用户名
     */
    private String name;
}
