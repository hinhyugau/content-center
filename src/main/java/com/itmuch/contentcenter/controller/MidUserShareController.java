package com.itmuch.contentcenter.controller;

import com.itmuch.contentcenter.service.MidUserShareService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/midUserShare")
public class MidUserShareController {

    private final MidUserShareService midUserShareService;

}