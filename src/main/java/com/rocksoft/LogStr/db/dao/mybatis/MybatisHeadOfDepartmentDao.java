package com.rocksoft.LogStr.db.dao.mybatis;

import com.rocksoft.LogStr.db.dao.AbstarctDao;
import com.rocksoft.LogStr.db.dao.HeadOfDepartmentDao;
import com.rocksoft.LogStr.db.models.HeadOfDepartment;

/**
 * Created by Esenin on 06.10.2017.
 */
public class MybatisHeadOfDepartmentDao extends AbstarctDao implements HeadOfDepartmentDao {
    @Override
    public void createHeadOfDepartment(HeadOfDepartment headOfDepartment) {

    }

    @Override
    public HeadOfDepartment getHeadOfDepartmentById(long id) {
        return null;
    }

    @Override
    public void updateHeadOfDepartment(HeadOfDepartment headOfDepartment) {

    }

    @Override
    public void deleteHeadOfDepartmentById(long id) {

    }
}
