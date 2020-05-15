package com.cyankyo.oauth2.server.service;

import com.cyankyo.oauth2.server.domain.TbUser;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author cyankyo
 * @since 2020-05-15
 */
public interface TbUserService {
    /**
     *
     * @param username
     * @return
     */
    TbUser getByUserName(@Param("username") String username);
}
