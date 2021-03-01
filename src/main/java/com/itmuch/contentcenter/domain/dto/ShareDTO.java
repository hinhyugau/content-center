package com.itmuch.contentcenter.domain.dto;

import com.itmuch.contentcenter.domain.Share;
import lombok.Data;

/**
 * @Description: Share Dto
 * @Author bryan
 * @Date 2021/2/28 2:46 下午
 * @Version 1.0
 */
@Data
public class ShareDTO extends Share {
    /**
     * 微信名
     */
    private String wxNickname;
}
