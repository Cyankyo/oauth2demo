package com.cyankyo.oauth2.server.mapper;

import com.cyankyo.oauth2.server.domain.TbPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author cyankyo
 * @since 2020-05-15
 */
@Repository
public interface TbPermissionMapper {

    List<TbPermission> selectByUserId(@Param("userId") Long id);
}
