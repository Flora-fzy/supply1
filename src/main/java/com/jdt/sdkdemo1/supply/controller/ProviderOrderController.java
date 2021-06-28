package com.jdt.sdkdemo1.supply.controller;

import com.jdt.sdkdemo1.supply.Response.SpiResponse;
import com.jdt.sdkdemo1.supply.request.BalanceReq;
import com.jdt.sdkdemo1.supply.request.CardOrderReq;
import com.jdt.sdkdemo1.supply.request.OrderReq;
import com.jdt.sdkdemo1.supply.request.ShopReq;
import com.jdt.sdkdemo1.supply.result.Result;
import com.jdt.sdkdemo1.supply.result.vo.ProviderAssetBalanceVo;
import com.jdt.sdkdemo1.supply.result.vo.ProviderOrderQueryVo;
import com.jdt.sdkdemo1.supply.result.vo.ProviderOrderTradeByCardVo;
import com.jdt.sdkdemo1.supply.result.vo.ProviderOrderTradeVo;
import com.jdt.sdkdemo1.supply.service.ProviderServiceImpl;
import com.jdt.sdkdemo1.supply.util.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fangziyin1
 * @version 1.0
 * @description: 调用供应商下单
 * @date 2021/6/25 10:42
 */
@RestController
@Slf4j
@RequestMapping("/spi")
public class ProviderOrderController {

    private ProviderServiceImpl impl = new ProviderServiceImpl();

    @GetMapping("/hello")
    public String hello(){
        log.info("hello={}", "hello ");
        return "hello";

    }

    @PostMapping("/createVirtualAssetOrder")
    public void providerCreateOrder(@RequestBody OrderReq or){
        //待会改成HttpServletRequest request, HttpServletResponse response
//        DefaultSpiJddClient defaultSpiJddClient = new DefaultSpiJddClient(EsuSdkConfig.getAppInfo());
//        String bizContent = defaultSpiJddClient.receive(request);
//        log.info("demo-request,bizContent={}", bizContent);
        String bizContent = JacksonUtil.pojo2Json(or);
        log.info("demo-request,bizContent={}", bizContent);
        //ProviderServiceImpl ps = new ProviderServiceImpl();
        //Result<ProviderOrderTradeVo> rp  = ps.providerOrder(or.getGoodsId(), or.getGoodsNum(), or.getOrderTime(), or.getGameUserId(), or.getMobileNo(), or.getParValue(), or.getBizId(), or.getRechargeType());
        Result<ProviderOrderTradeVo> rp  = impl.providerOrder(or);

        Map<String, String> responseDemo = new HashMap<>();
        responseDemo.put("respDemo", bizContent);
        /**
         * 业务逻辑结束，开始封装响应
         */
        SpiResponse spiResponse = new SpiResponse("000000", "成功",
                new SimpleDateFormat("yyyyMMdd-HH:mm:ss").format(new Date()), JacksonUtil.pojo2Json(responseDemo));
        //String body = defaultSpiJddClient.callback(request, response, spiResponse);
        //log.info("demo-response,body={}", body);
        log.info("demo-response,body={}", JacksonUtil.pojo2Json(rp));
        //return JacksonUtil.pojo2Json(rp);
//        response.setCharacterEncoding("utf-8");
//        PrintWriter writer = response.getWriter();
//        writer.write(body);
    }
    @PostMapping("queryVirtualAssetOrder")
    public void providerQueryOrder(@RequestBody ShopReq req){
        //待会改成HttpServletRequest request, HttpServletResponse response
//        DefaultSpiJddClient defaultSpiJddClient = new DefaultSpiJddClient(EsuSdkConfig.getAppInfo());
//        String bizContent = defaultSpiJddClient.receive(request);
//        log.info("demo-request,bizContent={}", bizContent);
        String bizContent = JacksonUtil.pojo2Json(req);
        log.info("demo-request,bizContent={}", bizContent);
        //ProviderServiceImpl ps = new ProviderServiceImpl();
        Result<ProviderOrderQueryVo> rp = impl.queryProviderOrder(req);
        Map<String, String> responseDemo = new HashMap<>();
        responseDemo.put("respDemo", bizContent);
        /**
         * 业务逻辑结束，开始封装响应
         */
        SpiResponse spiResponse = new SpiResponse("000000", "成功",
                new SimpleDateFormat("yyyyMMdd-HH:mm:ss").format(new Date()), JacksonUtil.pojo2Json(responseDemo));
        //String body = defaultSpiJddClient.callback(request, response, spiResponse);
        log.info("demo-response,body={}", JacksonUtil.pojo2Json(rp));
        //获得字符输出流
//        response.setCharacterEncoding("utf-8");
//        PrintWriter writer = response.getWriter();
//        writer.write(body);
    }
    @PostMapping("grantAssetCard")
    public void grantAssetCard(@RequestBody CardOrderReq req){
        String bizContent = JacksonUtil.pojo2Json(req);
        log.info("demo-request,bizContent={}", bizContent);
        //ProviderServiceImpl ps = new ProviderServiceImpl();
        Result<ProviderOrderTradeByCardVo> rp = impl.grantProviderCard(req);
        Map<String, String> responseDemo = new HashMap<>();
        responseDemo.put("respDemo", bizContent);
        SpiResponse spiResponse = new SpiResponse("000000", "成功",
                new SimpleDateFormat("yyyyMMdd-HH:mm:ss").format(new Date()), JacksonUtil.pojo2Json(responseDemo));
        log.info("demo-response,body={}", JacksonUtil.pojo2Json(rp));
    }

    @PostMapping("queryAssetBalance")
    public void queryAssetBalance(){
        //String bizContent = JacksonUtil.pojo2Json(req);
        //log.info("demo-request,bizContent={}", bizContent);
        //ProviderServiceImpl ps = new ProviderServiceImpl();
        Result<ProviderAssetBalanceVo> rp = impl.queryAssetBalance();
        //Map<String, String> responseDemo = new HashMap<>();
        //responseDemo.put("respDemo", bizContent);
        //SpiResponse spiResponse = new SpiResponse("000000", "成功",
        //       new SimpleDateFormat("yyyyMMdd-HH:mm:ss").format(new Date()), JacksonUtil.pojo2Json(responseDemo));
        log.info("demo-response,body={}", JacksonUtil.pojo2Json(rp));
    }
}
