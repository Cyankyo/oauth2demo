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

package com.cyankyo.oauth2.resource.controller;

import com.cyankyo.oauth2.resource.domain.TbContent;
import com.cyankyo.oauth2.resource.dto.ResponseResult;
import com.cyankyo.oauth2.resource.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TbContentController {

    @Autowired
    private TbContentService tbContentService;

    /**
     * 获取全部资源
     *
     * @return
     */
    @GetMapping("/")
    public ResponseResult<List<TbContent>> selectAll() {
        return new ResponseResult<>(HttpStatus.OK.value(), HttpStatus.OK.toString(), tbContentService.list());
    }

    /**
     * 获取资源详情
     *
     * @param id
     *
     * @return
     */
    @GetMapping("/view/{id}")
    public ResponseResult<TbContent> getById(@PathVariable Long id) {
        return new ResponseResult<>(HttpStatus.OK.value(), HttpStatus.OK.toString(), tbContentService.getById(id));
    }

    /**
     * 新增资源
     *
     * @param tbContent
     *
     * @return
     */
    @PostMapping("/insert")
    public ResponseResult<Integer> insert(@RequestBody TbContent tbContent) {
        boolean count = tbContentService.save(tbContent);

        if (count) {
            return new ResponseResult(Integer.valueOf(HttpStatus.OK.value()), HttpStatus.OK.toString(), count);
        } else {
            return new ResponseResult<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.toString());
        }
    }

    /**
     * 更新资源
     *
     * @param tbContent
     *
     * @return
     */
    @PutMapping("/update")
    public ResponseResult<Integer> update(@RequestBody TbContent tbContent) {
        boolean count = tbContentService.updateById(tbContent);

        if (count) {
            return new ResponseResult(HttpStatus.OK.value(), HttpStatus.OK.toString(), count);
        } else {
            return new ResponseResult<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.toString());
        }
    }

    /**
     * 删除资源
     *
     * @param id
     *
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseResult<Integer> delete(@PathVariable Long id) {
        boolean count = tbContentService.removeById(id);

        if (count) {
            return new ResponseResult(Integer.valueOf(HttpStatus.OK.value()), HttpStatus.OK.toString(), count);
        } else {
            return new ResponseResult<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.toString());
        }
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