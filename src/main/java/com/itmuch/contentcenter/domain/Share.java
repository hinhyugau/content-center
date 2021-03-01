package com.itmuch.contentcenter.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (share)实体类
 *
 * @author bryan
 * @description
 * @since 2021-02-28 14:41:04
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("share")
public class Share extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 用户Id
     */
    private Integer userId;
    /**
     * 标题
     */
    private String title;

    /**
     * 是否原创0否，1是
     */
    private Integer isOriginal;
    /**
     * 作者
     */
    private String author;
    /**
     * 封面
     */
    private String cover;
    /**
     * 概要信息
     */
    private String summary;
    /**
     * 价格
     */
    private Integer price;
    /**
     * 下载地址
     */
    private String download;
    /**
     * 购买人数
     */
    private Integer buyCount;
    /**
     * 是否显示0：不显示1:显示\n
     */
    private Integer showFlag;
    /**
     * 审核状态：NOT_YET：不通过YES_YET:通过
     */
    private String auditStatus;
    /**
     * 审核不通过原因
     */
    private String reason;

}