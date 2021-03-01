package com.itmuch.contentcenter.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (mid_user_share)实体类
 *
 * @author bryan
 * @description
 * @since 2021-02-28 14:41:04
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("mid_user_share")
public class MidUserShare extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * shareId
     */
    private Integer shareId;
    /**
     * userId
     */
    private Integer userId;

}