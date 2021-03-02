package com.itmuch.contentcenter.config;

import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.client.naming.core.Balancer;

import java.util.List;

/**
 * @Description:
 * @Author bryan
 * @Date 2021/3/2 10:02 下午
 * @Version 1.0
 */
public class Extendsbalancer extends Balancer {
    public static Instance getHostByRandomWeightSuper(List<Instance> instances) {
        return getHostByRandomWeight(instances);
    }
}
