package com.itmuch.contentcenter.domain.dto;

import com.itmuch.contentcenter.domain.BaseEntity;
import lombok.Data;

/**
 * @Description: UserDTO
 * @Author bryan
 * @Date 2021/3/1 2:45 下午
 * @Version 1.0
 */
@Data
public class UserDTO extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 微信Id
     */
    private String wxId;
    /**
     * 微信名
     */
    private String wxNickname;
    /**
     * 权限
     */
    private String roles;
    /**
     * 头像地址
     */
    private String avatarUrl;

    /**
     * 积分
     */
    private Integer bonus;
}
