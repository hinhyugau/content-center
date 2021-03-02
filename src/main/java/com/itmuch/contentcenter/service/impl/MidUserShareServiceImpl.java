package com.itmuch.contentcenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itmuch.contentcenter.domain.MidUserShare;
import com.itmuch.contentcenter.domain.dto.MidUserShareDTO;
import com.itmuch.contentcenter.mapper.MidUserShareMapper;
import com.itmuch.contentcenter.service.MidUserShareService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
public class MidUserShareServiceImpl extends ServiceImpl<MidUserShareMapper, MidUserShare> implements MidUserShareService {
    private final MidUserShareMapper midUserShareMapper;

    @Override
    public void add(MidUserShareDTO midUserShareDto) {

    }
}