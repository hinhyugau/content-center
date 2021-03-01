package com.itmuch.contentcenter.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (notice)实体类
 *
 * @author bryan
 * @description
 * @since 2021-02-28 14:41:04
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("notice")
public class Notice extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * content
     */
    private String content;
    /**
     * showFlag
     */
    private Integer showFlag;
}