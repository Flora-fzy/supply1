package com.jdt.sdkdemo1.supply.result;

/**
 * @author  fangziyin1
 * @version 1.0
 * @date
 * @description result枚举值
 * 枚举定义规范：
 *   (1接口请求成功、-1接口请求失败、2002库存不足、2003余额不足、2004商品不可售)
 * */
public enum ResultCodeEnum {

    SUCCESS(1, "接口请求成功"),
    FAIL(-1, "接口请求失败"),
    BIZ_GOODS_OUTOFSTOCK(2002,"库存不足"),
    BIZ_MONEY_NOT_ENOUGH(2003,"余额不足"),
    BIZ_GOODS_NOT_SALE(2004,"商品不可售");

    private Integer code;
    private String msg;

    ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public Integer code() {
        return code;
    }

    public String msg() {
        return msg;
    }
}
