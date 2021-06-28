package com.jdt.sdkdemo1.supply.result.vo;

import lombok.Data;

/**
 * @author fangziyin1
 * @version 1.0
 * @description: TODO
 * @date 2021/6/25 9:46
 */
@Data
public class ProviderOrderTradeVo {
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 业务返回码
     */
    private Integer retCode;
    /**
     * 业务返回信息
     */
    private String retMsg;
    /**
     * 订单状态
     */
    private Integer orderState;
}
