package com.flora.test.designPattern.structurePattern.proxy.jingtai.service;

import com.flora.test.designPattern.structurePattern.proxy.jingtai.domain.Student;

/**
 * @Author qinxiang
 * @Date 2023/6/22-下午11:57
 */
public interface IStudentService {
    /**
     * 添加学生
     */
    void save();

    /**
     * 查询学生信息
     * @param id
     * @return
     */
    Student query(Long id);
}
