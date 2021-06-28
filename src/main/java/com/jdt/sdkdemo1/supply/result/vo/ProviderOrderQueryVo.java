package com.jdt.sdkdemo1.supply.result.vo;

import com.jdt.sdkdemo1.supply.result.ResultCodeEnum;
import lombok.Data;

/**
 * @author fangziyin1
 * @version 1.0
 * @description: TODO
 * @date 2021/6/25 16:22
 */
@Data
public class ProviderOrderQueryVo {
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
