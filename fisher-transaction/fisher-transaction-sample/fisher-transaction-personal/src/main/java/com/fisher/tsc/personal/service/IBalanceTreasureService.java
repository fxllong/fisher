package com.fisher.tsc.personal.service;


public interface IBalanceTreasureService{

    /**
     * 处理来自资金端的转账消息
     * @param message
     */
    void dealWithTranferFromCapitalMessage(String message);

}
