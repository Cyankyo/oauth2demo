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

package com.cyankyo.oauth2.server.service.impl;

import com.cyankyo.oauth2.server.domain.TbPermission;
import com.cyankyo.oauth2.server.domain.TbRolePermission;
import com.cyankyo.oauth2.server.domain.TbUser;
import com.cyankyo.oauth2.server.domain.TbUserRole;
import com.cyankyo.oauth2.server.service.TbPermissionService;
import com.cyankyo.oauth2.server.service.TbUserService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 自定义用户认证与授权
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @see com.cyankyo.oauth2.server.config
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private TbPermissionService tbPermissionService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("load user by username");
        // 查询用户信息
        TbUser tbUser = tbUserService.getByUserName(username);
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        if (tbUser != null) {
            //查询权限详情
            List<TbPermission> tbPermissions = tbPermissionService.getPermissionByUserid(tbUser.getId());


            // 声明用户授权
            tbPermissions.forEach(tbPermission -> {
                if (tbPermission != null && tbPermission.getEnname() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tbPermission.getEnname());
                    grantedAuthorities.add(grantedAuthority);
                }
            });
        }else {
            throw new UsernameNotFoundException(username);
        }

        // 由框架完成认证工作
        return new User(username, tbUser.getPassword(), grantedAuthorities);

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