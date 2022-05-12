package com.adeng.gameServer.room.bo;

import com.adeng.gameServer.common.bo.SocketSessionBo;
import lombok.Data;

/**
 * 用户 socket
 *
 * @author wengcheng on 2022/5/12
 */
@Data
public class UseSocketSessionBo extends SocketSessionBo {

    /**
     * 用户id
     */
    private Long id;
}
