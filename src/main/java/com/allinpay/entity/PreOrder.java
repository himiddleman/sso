package com.allinpay.entity;

import lombok.Data;

/**
 * @description: 退款表和订单表的字段一致，使用公共类
 * @author: tanguang
 * @date: 2019-07-29
 */
@Data
public class PreOrder {
    /**
     * 清算流水号
     */
    private String payIndex;
    /**
     * 清算日期
     */
    private String settleDate;
    /**
     * 车牌颜色 0 蓝色 1 黄色 2 黑色 3 白色 4 渐变绿色 5 黄绿双拼色
     * 6 蓝白渐变色 9 其他
     */
    private String licenseColor;
    /**
     * 车牌号
     */
    private String licenseCode;
    /**
     * 付款账号
     */
    private String payAccount;
    /**
     * 金额 单位分
     */
    private String amount;
    /**
     * 车道日期
     */
    private String transDate;
    /**
     * 车道时间
     */
    private String transTime;
    /**
     * 出入口站点
     */
    private String station;
    /**
     * 订单状态 0 保付 1 非保付
     */
    private String protectStatus;
    /**
     * 文件下发时间
     */
    private String distributeTime;
    /**
     * 省份归属 01 省内 02 省外
     */
    private String province;
    /**
     * 服务应答状态 0 成功 1 失败
     */
    private String ackStatus;
}
