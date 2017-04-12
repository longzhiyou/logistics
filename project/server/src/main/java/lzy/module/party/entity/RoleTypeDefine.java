package lzy.module.party.entity;

/**
 * 角色类型定义，保存在RoleType表中
 * 1.当事人角色类型
 * 2.订单角色类型ORDER
 * 3.装运SHIPMENT
 * 4.发票INVOICE
 * Created by bukeyan on 2017/4/9.
 */

public interface RoleTypeDefine {


    int PARTY=0;
    int ORDER=100;
    int SHIPMENT=200;
    int INVOICE=200;

    //客户
    int CUSTOMER = PARTY+1;
    //雇员
    int EMPLOYEE = PARTY+2;
    int SUPPLIER = PARTY+3;
    //内部组织
    int INTERNAL = PARTY+4;





}
