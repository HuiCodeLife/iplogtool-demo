package com.github.ithuidev.service.impl;

import com.github.ithuidev.properties.IpLogProperties;
import com.github.ithuidev.service.IpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : ithuidev
 * @create : 2022/11/21
 */
public class IpLogServiceImpl implements IpLogService {
    private Map<String, Integer> ipMap = new ConcurrentHashMap<>();

    @Autowired
    private HttpServletRequest request;
    /**
     * 记录ip访问次数
     */
    @Override
    public void logCount() {
        //获取ip地址
        String remoteAddr = request.getRemoteAddr();
        //记录到ipMap中
        if (ipMap.containsKey(remoteAddr)) {
            ipMap.put(remoteAddr, ipMap.get(remoteAddr) + 1);
        } else {
            ipMap.put(remoteAddr, 1);
        }
    }

    @Autowired
    private IpLogProperties ipLogProperties;

    @Override
    @Scheduled(cron = "0/#{ipLogProperties.cycle} * * * * ?")
    public void printIpLogInfo() {
        if(IpLogProperties.LogModel.DETAIL.getValue().equals(ipLogProperties.getModel())){
            System.out.println(" IP访问监控(详细模式,ip地址+访问次数)");
            System.out.println("+-----ip-address-----+-count-+");
            for (Map.Entry<String, Integer> info : ipMap.entrySet()) {
                String ip = info.getKey();
                Integer count = info.getValue();
                System.out.printf("|%18s |%7d |%n", ip, count);
            }
            System.out.println("+--------------------+-------+");
        }else if(IpLogProperties.LogModel.SIMPLE.getValue().equals(ipLogProperties.getModel())){
            System.out.println(" IP访问监控(简单模式,ip地址)");
            System.out.println("+-----ip-address-----+");
            for (String ip : ipMap.keySet()) {
                System.out.printf("|%18s |%n", ip);
            }
            System.out.println("+--------------------+");
        }
        //重置周期数据
        if(ipLogProperties.getCycleReset()){
            ipMap.clear();
        }
    }
}
