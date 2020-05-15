package com.cyankyo.oauth2.server.service.impl;

import com.cyankyo.oauth2.server.domain.TbUser;
import com.cyankyo.oauth2.server.mapper.TbPermissionMapper;
import com.cyankyo.oauth2.server.mapper.TbUserMapper;
import com.cyankyo.oauth2.server.service.TbUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author cyankyo
 * @since 2020-05-15
 */
@Service
public class TbUserServiceImpl  implements TbUserService {
    @Resource
    private TbUserMapper tbUserMapper;
    @Override
    public TbUser getByUserName(String username) {
        return tbUserMapper.selectByUsername(username);
    }
}
