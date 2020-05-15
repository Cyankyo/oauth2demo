package com.cyankyo.oauth2.server.service;

import com.cyankyo.oauth2.server.domain.TbPermission;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author cyankyo
 * @since 2020-05-15
 */
public interface TbPermissionService  {

    List<TbPermission> getPermissionByUserid(Long id);
}
