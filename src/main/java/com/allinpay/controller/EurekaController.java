package com.allinpay.controller;

import com.allinpay.core.common.ResponseData;
import com.allinpay.entity.PreOrder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EurekaController {

    @RequestMapping("/secretPayment")
    public ResponseData secretPayment(@RequestBody List<PreOrder> orderList) {
        return ResponseData.success().setData("陈宫");
    }

    @RequestMapping("/test")
    public ResponseData test(@RequestBody PreOrder order) {
        return ResponseData.success().setData("陈宫");
    }

    @RequestMapping("/test2")
    public ResponseData test2(String name, int age) {
        return ResponseData.success().setData("陈宫");
    }
}
