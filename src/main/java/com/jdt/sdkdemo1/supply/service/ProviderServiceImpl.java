package com.jdt.sdkdemo1.supply.service;

import com.jdt.sdkdemo1.supply.dao.ProviderService;
import com.jdt.sdkdemo1.supply.request.CardOrderReq;
import com.jdt.sdkdemo1.supply.request.OrderReq;
import com.jdt.sdkdemo1.supply.request.ShopReq;
import com.jdt.sdkdemo1.supply.result.Result;
import com.jdt.sdkdemo1.supply.result.ResultCodeEnum;
import com.jdt.sdkdemo1.supply.result.vo.ProviderAssetBalanceVo;
import com.jdt.sdkdemo1.supply.result.vo.ProviderOrderQueryVo;
import com.jdt.sdkdemo1.supply.result.vo.ProviderOrderTradeByCardVo;
import com.jdt.sdkdemo1.supply.result.vo.ProviderOrderTradeVo;
import com.jdt.sdkdemo1.supply.util.DES3Utils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fangziyin1
 * @version 1.0
 * @description: TODO
 * @date 2021/6/25 11:15
 */
@Component
public class ProviderServiceImpl implements ProviderService {
    /**
     * 订单号-订单类型
     */
    Map<String,Integer> orderStateCache = new HashMap<>();
    /**
     * 订单号-兑换码
     */
    Map<String,Integer> orderCodeCache = new HashMap<>();

    @Override
    //public Result providerOrder(String goodsId, Integer goodsNum, String orderTime, String gameUserId, String mobileNo, String parValue, String bizId, String recharfeType) {
    public Result providerOrder(OrderReq req) {
        ProviderOrderTradeVo vo = new ProviderOrderTradeVo();
        if(StringUtils.isEmpty(req.getGoodsId())){
            Result<ProviderOrderTradeVo> r = Result.getResult(ResultCodeEnum.BIZ_GOODS_NOT_SALE, "商品不出售");
            return r;
        }
        int code = (int) (Math.random()*1000000);
        vo.setGoodsId(req.getGoodsId());
        vo.setOrderState(1);
        vo.setRetCode(Integer.valueOf(code));
        vo.setRetMsg("很好");
        orderStateCache.put(req.getGoodsId(),vo.getOrderState());
        orderCodeCache.put(req.getGoodsId(),vo.getRetCode());
        Result<ProviderOrderTradeVo> r = Result.getSuccessResultVo();
        r.setData(vo);

        return r;
    }

    //@Value("supply.des3.license")
    private String des3License="d5e0c4e1-c974-483e-934e-49390ce4d547";

    @Override
    public Result queryProviderOrder(ShopReq req) {
        ProviderOrderQueryVo vo = new ProviderOrderQueryVo();
        if(StringUtils .isEmpty(req.getBizId())){
            Result<ProviderOrderTradeVo> r = Result.getResult(ResultCodeEnum.FAIL, "订单号不存在");
            return r;
        }
        String securityCode = ""+req.getBizId()+orderCodeCache.get(req.getGoodsId())+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        try {
            //System.out.println("des3License:"+des3License);
            vo.setCards(DES3Utils.encrypt(securityCode,des3License));
            //加密
            //vo.setCards(securityCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        vo.setGoodsId(req.getGoodsId());
        vo.setRetCode(1);

        vo.setRetMsg(String.valueOf(orderCodeCache.get(req.getGoodsId())));


        vo.setOrderState(1);
        Result<ProviderOrderQueryVo> r = Result.getSuccessResultVo();
        r.setData(vo);
        return r;
    }

    @Override
    public Result grantProviderCard(CardOrderReq req) {
        ProviderOrderTradeByCardVo vo = new ProviderOrderTradeByCardVo();
        if(StringUtils.isEmpty(req.getGoodsId())){
            Result<ProviderOrderTradeVo> r = Result.getResult(ResultCodeEnum.BIZ_GOODS_NOT_SALE, "商品不出售");
            return r;
        }
        String securityCode = req.getBizId()+orderCodeCache.get(req.getGoodsId())+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        try {
            vo.setCards(DES3Utils.encrypt(securityCode,des3License));
            //加密
            //vo.setCards(securityCode);//加密
        } catch (Exception e) {
            e.printStackTrace();
        }
        vo.setGoodsId(req.getGoodsId());
        vo.setRetCode(1);
        vo.setRetMsg(String.valueOf(orderCodeCache.get(req.getGoodsId())));
        vo.setOrderState(1);
        Result<ProviderOrderTradeByCardVo> r = Result.getSuccessResultVo();
        r.setData(vo);
        return r;
    }

    @Override
    public Result queryAssetBalance() {
        ProviderAssetBalanceVo vo = new ProviderAssetBalanceVo();
        vo.setRetCode(1);
        vo.setRetMsg("123");
        vo.setRechargeBalance(1.11);
        vo.setDefaultBalance(2.22);
        Result<ProviderAssetBalanceVo> r = Result.getSuccessResultVo();
        r.setData(vo);
        return r;
    }
}
