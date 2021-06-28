package com.jdt.sdkdemo1.supply.request;

import lombok.Data;

/**
 * @author fangziyin1
 * @version 1.0
 * @description: TODO
 * @date 2021/6/25 10:00
 */
@Data
public class BaseReq {
    /**
     * 下单时间
     */
    private String orderTime;
    /**
     * 江湖业务单号
     */
    private String bizId;
}
