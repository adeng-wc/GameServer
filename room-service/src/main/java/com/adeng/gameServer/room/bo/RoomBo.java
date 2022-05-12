package com.adeng.gameServer.room.bo;

import lombok.Data;

import java.util.Map;

/**
 * 房间对象，
 *
 * @author wengcheng on 2022/5/12
 */
@Data
public class RoomBo {
    /**
     * 房间id
     */
    private Long id;
    /**
     * 房间名称
     */
    private String name;
    /**
     * 单个房间的最大人数
     */
    private int userSocketMax = 100;
    /**
     * 房间内的用户session
     */
    private Map<String, UseSocketSessionBo> userSessionMap;

}
