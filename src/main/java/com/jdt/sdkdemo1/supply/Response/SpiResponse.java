package com.jdt.sdkdemo1.supply.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author fangziyin1
 * @version 1.0
 * @description: TODO
 * @date 2021/6/25 15:50
 */
@Data
@AllArgsConstructor
public class SpiResponse {
    private String tradeMsg;
    private String tradeState;
    private String date;
    private String retResponse;
}
