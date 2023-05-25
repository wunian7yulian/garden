package com.lynwood.g.govern.fence.sys.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lynwood.g.base.rock.mybatis.GBaseEntity;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName sys_oauth_client
 */
@TableName(value ="sys_oauth_client")
@Data
public class SysOauthClient extends GBaseEntity implements Serializable {
    /**
     * 
     */
    @TableId
    private String clientId;

    /**
     * 
     */
    private String resourceIds;

    /**
     * 
     */
    private String clientSecret;

    /**
     * 
     */
    private String scope;

    /**
     * 
     */
    private String authorizedGrantTypes;

    /**
     * 
     */
    private String webServerRedirectUri;

    /**
     * 
     */
    private String authorities;

    /**
     * 
     */
    private Integer accessTokenValidity;

    /**
     * 
     */
    private Integer refreshTokenValidity;

    /**
     * 
     */
    private String additionalInformation;

    /**
     * 
     */
    private String autoapprove;



    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}