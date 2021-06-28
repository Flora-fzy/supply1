package com.jdt.sdkdemo1.supply.result.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fangziyin1
 * @version 1.0
 * @description: TODO
 * @date 2021/6/25 18:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderOrderTradeByCardVo {
    /**
     * 卡密列表json数组字符串
     */
    private String cards;
    /**
     * 供应商商品编码
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
