package com.cyankyo.oauth2.server.mapper;

import com.cyankyo.oauth2.server.domain.TbUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author cyankyo
 * @since 2020-05-15
 */
@Repository
public interface TbUserMapper {

    TbUser selectByUsername(@Param("username") String username);
}
