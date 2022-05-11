package com.adeng.gameServer.hall.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 大厅服务
 *
 * @author wengcheng on 2022/5/11
 */
@RequestMapping("/api/server/hall")
@RestController
public class HallController {

    @PostMapping(value = "matchServers")
    @ResponseBody
    public List<String> alipayQueryOrderResp() {

        return new ArrayList<>();
    }
}
