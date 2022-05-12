package com.adeng.gameServer.hall.web.controller;

import com.adeng.gameServer.hall.core.RoomManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * 大厅服务
 *
 * @author wengcheng on 2022/5/11
 */
@RequestMapping("/api/server/hall")
@RestController
public class HallController {

    /**
     * 查询注册的 roomServers
     *
     * @return
     */
    @PostMapping(value = "roomServers")
    @ResponseBody
    public ArrayList<String> matchServers() {
        return new ArrayList<>(RoomManager.sockMap.keySet());
    }

    /**
     * 创建房间请求，返回房间的 ws.
     * <p>
     * 1. 客户端发起 创建房间的 http请求
     * 2. 业务逻辑处理之后 返回 ws
     * 3. 客户端发起 ws 连接
     *
     * @return
     */
    @PostMapping(value = "createRoom")
    @ResponseBody
    public String createRoom() {


        return "1";
    }

}
