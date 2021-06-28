package com.jdt.sdkdemo1.supply.dao;

import com.jdt.sdkdemo1.supply.request.CardOrderReq;
import com.jdt.sdkdemo1.supply.request.OrderReq;
import com.jdt.sdkdemo1.supply.request.ShopReq;
import com.jdt.sdkdemo1.supply.result.Result;

/**
 * @description: TODO
 * @author fangziyin1
 * @date 2021/6/25 11:14
 * @version 1.0
 */
public interface ProviderService {
    //public Result providerOrder(String goodsId,Integer goodsNum,String orderTime,String gameUserId,String mobileNo,String parValue,String bizId,String recharfeType);
    public Result providerOrder(OrderReq or);
    public Result queryProviderOrder(ShopReq req);
    public Result grantProviderCard(CardOrderReq req);
    Result queryAssetBalance();
}
