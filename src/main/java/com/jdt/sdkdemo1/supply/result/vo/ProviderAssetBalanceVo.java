package com.jdt.sdkdemo1.supply.result.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fangziyin1
 * @version 1.0
 * @description: TODO
 * @date 2021/6/28 9:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderAssetBalanceVo {
    /**
     * 业务返回码
     */
    private Integer retCode;
    /**
     * 业务返回信息
     */
    private String retMsg;
    /**
     * 直充授信
     */
    private double rechargeBalance;
    /**
     * 默认授信
     */
    private double defaultBalance;
}
