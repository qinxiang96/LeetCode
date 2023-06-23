package com.flora.test.designPattern.structurePattern.proxy.dongtai.CGLIB.service;


import com.flora.test.designPattern.structurePattern.proxy.dongtai.CGLIB.domain.Student;

/**
 * @Author qinxiang
 * @Date 2023/6/23-上午1:02
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
