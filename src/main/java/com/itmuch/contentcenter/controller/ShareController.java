package com.itmuch.contentcenter.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.itmuch.contentcenter.domain.dto.ShareDTO;
import com.itmuch.contentcenter.service.ShareService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 服务控制器
 *
 * @author bryan
 * @description
 * @since 2021-02-28 14:41:04
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/shares")
public class ShareController {
    private final ShareService shareService;

    private final DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
    public ShareDTO findShareById(@PathVariable Integer id) {
        return this.shareService.findShareById(id);
    }

    /**
     * 测试： 服务发现，证明内容中心总能找到用户中心
     *
     * @return
     */
    @GetMapping("/test")
    public List<ServiceInstance> setDiscoveryClient() {
        return discoveryClient.getInstances("user-center");
    }
}