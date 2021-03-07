package com.itmuch.contentcenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itmuch.contentcenter.domain.Share;
import com.itmuch.contentcenter.domain.dto.ShareDTO;
import com.itmuch.contentcenter.domain.dto.UserDTO;
import com.itmuch.contentcenter.feignclient.UserFeignClient;
import com.itmuch.contentcenter.mapper.ShareMapper;
import com.itmuch.contentcenter.service.ShareService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 服务接口实现
 *
 * @author bryan
 * @description
 * @since 2021-02-28 14:41:04
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ShareServiceImpl extends ServiceImpl<ShareMapper, Share> implements ShareService {
    private final RestTemplate restTemplate;

    private final RedisTemplate redisTemplate;

    private final UserFeignClient userFeignClient;

    //private final DiscoveryClient discoveryClient;

    /**
     * 根据id查询Share
     *
     * @param id
     * @return
     */
    @Override
    public ShareDTO findShareById(Integer id) {
        //获取分享详情
        Share share = this.baseMapper.selectById(id);
        //发布人Id
        Integer userId = share.getUserId();
       /* List<ServiceInstance> instances = this.discoveryClient.getInstances("user-center");
        List<String> targetURLS = instances.stream()
                .map(instance -> instance.getUri().toString() + "/users/{id}")
                .collect(Collectors.toList());
        int i = ThreadLocalRandom.current().nextInt(targetURLS.size());

        //调用用户微服务的/users/{userId}
        //用HTTP GET方法请求，并且返回一个对象
        log.info("请求的目标地址:{}", targetURLS.get(i));
        UserDTO forObject = restTemplate.getForObject(targetURLS.get(i), UserDTO.class, userId);*/
        //UserDTO forObject = restTemplate.getForObject("http://user-center/users/{id}", UserDTO.class, userId);
        UserDTO userBuId = this.userFeignClient.findUserBuId(id);
        ShareDTO shareDTO = new ShareDTO();
        //消息装配
        BeanUtils.copyProperties(share, shareDTO);
        shareDTO.setWxNickname(userBuId.getWxNickname());
        return shareDTO;
    }
}