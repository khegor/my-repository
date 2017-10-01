package com.rocksoft.LogStr.db.dao.daoInterf;

import com.rocksoft.LogStr.db.models.HeadOfDepartment;

import java.util.List;

/**
 * Created by Esenin on 29.09.2017.
 */
public interface HeadOfDepartmentDao {

    void createHeadOfDepartment(HeadOfDepartment headOfDepartment);
    HeadOfDepartment getHeadOfDepartmentById(long id);
    void updateHeadOfDepartment(HeadOfDepartment headOfDepartment);
    void deleteHeadOfDepartmentById(long id);
}
