package com.jdt.sdkdemo1.supply.request;

import lombok.Data;

/**
 * @author fangziyin1
 * @version 1.0
 * @description: TODO
 * @date 2021/6/25 9:57
 */
@Data
public class GoodsReq extends BaseReq{
    /**
     * 商品编号
     */
    private String goodsId;

    /**
     * 话费直充等面值
     */
    private String parValue;
    /**
     * 充值类型：mobile手机号card卡券直充
     */
    private String rechargeType;

}
