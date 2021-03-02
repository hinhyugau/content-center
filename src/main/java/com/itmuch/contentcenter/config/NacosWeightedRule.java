package com.itmuch.contentcenter.config;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.NacosServiceManager;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Author bryan
 * @Date 2021/3/2 5:43 下午
 * @Version 1.0
 */
@Slf4j
public class NacosWeightedRule extends AbstractLoadBalancerRule {
    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;
    @Autowired
    private NacosServiceManager nacosServiceManager;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        try {
            BaseLoadBalancer loadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
            //获取微服务名称
            String serviceName = loadBalancer.getName();
            // NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();
            //拿到相关API
            NamingService namingService = nacosServiceManager.getNamingService(nacosDiscoveryProperties.getNacosProperties());
            //nacos client自动通过基于权重的负载均衡算法,给我们选择一个实例
            Instance instance = namingService.selectOneHealthyInstance(serviceName);
            log.info("选择的实例为：{},端口号为：{}", instance.getServiceName(), instance.getIp());
            return new NacosServer(instance);
        } catch (NacosException e) {
            log.error("自定义权重失败:{}", e.getErrMsg());
        }
        return null;
    }
}
