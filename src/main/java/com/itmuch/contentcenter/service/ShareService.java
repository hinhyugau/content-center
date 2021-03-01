package com.itmuch.contentcenter.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.itmuch.contentcenter.domain.Share;
import com.itmuch.contentcenter.domain.dto.ShareDTO;

/**
 * 服务接口
 *
 * @author bryan
 * @description
 * @since 2021-02-28 14:41:04
 */
public interface ShareService extends IService<Share> {
    /**
     * 根据Id查询Share
     *
     * @param id
     * @return
     */
    ShareDTO findShareById(Integer id);
}