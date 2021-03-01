package com.itmuch.contentcenter.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.itmuch.contentcenter.domain.MidUserShare;
import com.itmuch.contentcenter.domain.dto.MidUserShareDTO;

/**
 * 服务接口
 *
 * @author bryan
 * @description
 * @since 2021-02-28 14:41:04
 */
public interface MidUserShareService extends IService<MidUserShare> {

    void add(MidUserShareDTO midUserShareDto);
}
