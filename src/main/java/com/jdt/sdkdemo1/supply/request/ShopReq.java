package com.jdt.sdkdemo1.supply.request;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author fangziyin1
 * @version 1.0
 * @description: TODO
 * @date 2021/6/25 16:11
 */
@Data
@AllArgsConstructor
public class ShopReq {
    /**
     * 江湖业务单号
     */
    private String bizId;
    /**
     * 供应商商品编码
     */
    private String goodsId;
    /**
     * sku发放类型：0直充、1卡密
     */
    private Integer goodsType;
}
