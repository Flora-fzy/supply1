package com.jdt.sdkdemo1.supply.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fangziyin1
 * @version 1.0
 * @description: TODO
 * @date 2021/6/25 10:12
 */

@Data
@AllArgsConstructor
public class OrderReq extends GoodsReq{
    /**
     *充值账号
     */
    private String gameUserId;
    /**
     * 手机号
     */
    private String mobileNo;
    /**
     * 商品数量
     */
    private String goodsNum;

}
