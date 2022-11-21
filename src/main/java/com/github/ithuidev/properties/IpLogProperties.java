package com.github.ithuidev.properties;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : ithuidev
 * @create : 2022/11/21
 */

@Component("ipLogProperties")
@ConfigurationProperties(prefix = "tools.ip")
public class IpLogProperties {
    /**
     * 日志显示周期
     * */
    private long cycle = 10L;
    /**
     * 是否周期内重置数据
     * */
    private Boolean cycleReset = false;
    /**
     * 日志输出模式 detail:详细模式 simple:简单模式
     * */
    private String model = LogModel.DETAIL.value;
    public enum LogModel {
        DETAIL("detail"),
        SIMPLE("simple");
        private String value;
        private LogModel(String value) { this.value = value; }
        public String getValue() { return value; }
    }

    public long getCycle() {
        return cycle;
    }

    public void setCycle(long cycle) {
        this.cycle = cycle;
    }

    public Boolean getCycleReset() {
        return cycleReset;
    }

    public void setCycleReset(Boolean cycleReset) {
        this.cycleReset = cycleReset;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
