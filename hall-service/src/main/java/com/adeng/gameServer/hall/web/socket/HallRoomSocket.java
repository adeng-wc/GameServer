package com.adeng.gameServer.hall.web.socket;

import com.adeng.gameServer.common.bo.SocketSessionBo;
import com.adeng.gameServer.hall.core.RoomManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * 大厅管理 注册上来的 room socket
 *
 * @author wengcheng on 2022/5/12
 */
@Slf4j
@Component
@ServerEndpoint("/api/v1/websocket/room/{name}")
public class HallRoomSocket {

    @OnOpen
    public void OnOpen(Session session, @PathParam(value = "name") String name) {
        SocketSessionBo bo = new SocketSessionBo();
        bo.setSession(session);
        bo.setName(name);
        RoomManager.sockMap.put(name, bo);
        log.info("[WebSocket] 连接成功，当前连接人数为：={}", RoomManager.sockMap.size());
    }

    @OnClose
    public void OnClose(@PathParam(value = "name") String name) {
        RoomManager.sockMap.remove(name);
        log.info("[WebSocket] {} 退出成功，当前连接人数为：={}", name, RoomManager.sockMap.size());
    }

    @OnMessage
    public void OnMessage(String message) {
        log.info("[WebSocket] 收到消息：{}", message);
        //判断是否需要指定发送，具体规则自定义
        if (message.indexOf("TOUSER") == 0) {
            String name = message.substring(message.indexOf("TOUSER") + 6, message.indexOf(";"));
            AppointSending(name, message.substring(message.indexOf(";") + 1, message.length()));
        } else {
            GroupSending(message);
        }
    }

    /**
     * 群发
     *
     * @param message
     */
    public void GroupSending(String message) {
        for (String name : RoomManager.sockMap.keySet()) {
            try {
                RoomManager.sockMap.get(name).getSession().getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 指定发送
     *
     * @param name
     * @param message
     */
    public void AppointSending(String name, String message) {
        try {
            RoomManager.sockMap.get(name).getSession().getBasicRemote().sendText(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
