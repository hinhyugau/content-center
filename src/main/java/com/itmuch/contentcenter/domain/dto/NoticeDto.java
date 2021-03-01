package com.itmuch.contentcenter.domain.dto;

import lombok.Data;

/**
 * @Description: Notice Dto
 * @Author bryan
 * @Date 2021/2/28 2:45 下午
 * @Version 1.0
 */
@Data
public class NoticeDto {
    /**
     * content
     */
    private String content;
    /**
     * showFlag
     */
    private Integer showFlag;
}
