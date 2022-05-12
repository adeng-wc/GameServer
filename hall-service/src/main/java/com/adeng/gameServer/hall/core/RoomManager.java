package com.adeng.gameServer.hall.core;

import com.adeng.gameServer.common.bo.SocketSessionBo;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 维护注册上来的room地址
 *
 * @author wengcheng on 2022/5/11
 */
@Slf4j
public class RoomManager {

    /**
     * 用于存所有的连接服务的客户端，这个对象存储是安全的
     */
    public static ConcurrentHashMap<String, SocketSessionBo> sockMap = new ConcurrentHashMap<>();

}
