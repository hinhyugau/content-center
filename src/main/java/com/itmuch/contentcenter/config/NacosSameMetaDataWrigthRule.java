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
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: 根据MeteData规则
 * @Author bryan
 * @Date 2021/3/3 9:30 上午
 * @Version 1.0
 */
@Slf4j
public class NacosSameMetaDataWrigthRule extends AbstractLoadBalancerRule {
    @Autowired
    private NacosServiceManager nacosServiceManager;
    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
    }

    @Override
    public Server choose(Object key) {
        try {
            //根据配置文件获取当前消费服务中的metadata
            Map<String, String> metadata = this.nacosDiscoveryProperties.getMetadata();
            //获取metadata具体参数
            String version = metadata.get("version");
            BaseLoadBalancer baseLoadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
            //获取要请求微服务名称（ServiceId）
            String serviceName = baseLoadBalancer.getName();
            // 获取服务相关API
            NamingService namingService = this.nacosServiceManager.getNamingService(this.nacosDiscoveryProperties.getNacosProperties());
            // 获取当前服务所有健康实例
            List<Instance> instances = namingService.selectInstances(serviceName, true);
            // 过滤metadata相同的实例
            List<Instance> instancesSameMetadata = instances.stream().filter(instance -> {
                return ObjectUtils.equals(instance.getMetadata().get("version"), version);
            }).collect(Collectors.toList());
            List<Instance> instancesToBeChosen = new ArrayList();
            if (CollectionUtils.isEmpty(instancesSameMetadata)) {
                instancesToBeChosen = instances;
            }else{
                instancesToBeChosen = instancesSameMetadata;
            }
            Instance hostByRandomWeightSuper = Extendsbalancer.getHostByRandomWeightSuper(instancesToBeChosen);
            return new NacosServer(hostByRandomWeightSuper);
        } catch (NacosException e) {
            log.error("根据MetaData访问相关服务报错{}!", e.getErrMsg());
        }
        return null;
    }
}