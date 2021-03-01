package com.itmuch.contentcenter.controller;

import com.itmuch.contentcenter.domain.dto.ShareDTO;
import com.itmuch.contentcenter.service.ShareService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{id}")
    public ShareDTO findShareById(@PathVariable Integer id) {
        return this.shareService.findShareById(id);
    }
}