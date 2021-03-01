package com.itmuch.contentcenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itmuch.contentcenter.domain.Notice;
import com.itmuch.contentcenter.mapper.NoticeMapper;
import com.itmuch.contentcenter.service.NoticeService;
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
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

}