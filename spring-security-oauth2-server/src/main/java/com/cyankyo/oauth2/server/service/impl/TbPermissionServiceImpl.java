package com.cyankyo.oauth2.server.service.impl;

import com.cyankyo.oauth2.server.domain.TbPermission;
import com.cyankyo.oauth2.server.mapper.TbPermissionMapper;
import com.cyankyo.oauth2.server.service.TbPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author cyankyo
 * @since 2020-05-15
 */
@Service
public class TbPermissionServiceImpl implements TbPermissionService {
    @Resource
    private TbPermissionMapper tbPermissionMapper;

    @Override
    public List<TbPermission> getPermissionByUserid(Long id) {
        return tbPermissionMapper.selectByUserId(id);
    }
}
