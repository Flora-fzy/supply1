package com.jdt.sdkdemo1.supply.request;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author fangziyin1
 * @version 1.0
 * @description: TODO
 * @date 2021/6/25 18:13
 */
@Data
@AllArgsConstructor
public class CardOrderReq {
    private String goodsId;
    private Integer goodsNum;
    private String bizId;
}
