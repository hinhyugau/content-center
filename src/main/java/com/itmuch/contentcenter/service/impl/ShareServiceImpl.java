package com.itmuch.contentcenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itmuch.contentcenter.domain.Share;
import com.itmuch.contentcenter.domain.dto.ShareDTO;
import com.itmuch.contentcenter.domain.dto.UserDTO;
import com.itmuch.contentcenter.mapper.ShareMapper;
import com.itmuch.contentcenter.service.ShareService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
        //调用用户微服务的/users/{userId}
        //用HTTP GET方法请求，并且返回一个对象
        UserDTO forObject = restTemplate.getForObject("http://localhost:8080/users/{id}", UserDTO.class, userId);
        ShareDTO shareDTO = new ShareDTO();
        //消息装配
        BeanUtils.copyProperties(share, shareDTO);
        shareDTO.setWxNickname(forObject.getWxNickname());
        return shareDTO;
    }
}