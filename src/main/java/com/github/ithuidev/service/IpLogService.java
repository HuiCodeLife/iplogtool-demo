package com.github.ithuidev.service;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : ithuidev
 * @create : 2022/11/21
 */
public interface IpLogService {

    /**
     * 记录ip访问次数
     */
    void logCount();

    /**
     * 打印记录ip日志
     */
    void printIpLogInfo();
}

