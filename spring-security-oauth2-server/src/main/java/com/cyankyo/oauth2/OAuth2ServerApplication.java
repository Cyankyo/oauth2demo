/*
 * Project: oauth2demo
 *
 * File Created at 2020/5/14
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

/**
 * @Type OAuth2ServerApplication.java
 * @Desc
 * @Author chentuoyi
 * @Date 2020/5/14 9:49
 * @Version 1.0
 */
package com.cyankyo.oauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 认证服务器，用于获取 Token
 * <p>
 * Description:
 * </p>
 *
 * @author cyankyo
 * @version v1.0.0
 * @date 2019-04-01 16:06:45
 */
@SpringBootApplication
@MapperScan("com.cyankyo.oauth2.server.mapper")
public class OAuth2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2ServerApplication.class, args);
    }

}

/*
 * Revision history
 * -------------------------------------------------------------------------
 *
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2020/5/14 chentuoyi create
 */