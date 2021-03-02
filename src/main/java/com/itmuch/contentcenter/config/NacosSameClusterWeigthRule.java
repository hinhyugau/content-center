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
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author bryan
 * @Date 2021/3/2 9:36 下午
 * @Version 1.0
 */
@Slf4j
public class NacosSameClusterWeigthRule extends AbstractLoadBalancerRule {
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
            //获取当前服务的集群clusterName
            String clusterName = this.nacosDiscoveryProperties.getClusterName();
            BaseLoadBalancer baseLoadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
            //将要请求微服务的名称ServiceId
            String name = baseLoadBalancer.getName();
            //拿到服务发现相关API
            NamingService namingService = nacosServiceManager.getNamingService(nacosDiscoveryProperties.getNacosProperties());
            //获取当前服务名称所有的实例
            List<Instance> instances = namingService.selectInstances(name, true);
            List<Instance> sameClusterInstances = instances.stream().filter(instance -> {
                return Objects.equals(instance.getClusterName(), clusterName);
            }).collect(Collectors.toList());
            //如果sameClusterInstances为空就用其他集群
            List<Instance> instancesToBeChosen = new ArrayList();
            if (CollectionUtils.isEmpty(sameClusterInstances)) {
                instancesToBeChosen = instances;
            } else {
                instancesToBeChosen = sameClusterInstances;
            }
            //自定义扩展获取实例
            Instance hostByRandomWeightSuper = Extendsbalancer.getHostByRandomWeightSuper(instancesToBeChosen);
            log.info("访问集群为：{}",hostByRandomWeightSuper.getClusterName());
            return new NacosServer(hostByRandomWeightSuper);
        } catch (NacosException e) {
            log.error("根据集群配置读取报错:{}", e.getErrMsg());
            return null;
        }
    }
}
