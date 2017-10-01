package com.rocksoft.LogStr.db.servces;

import com.rocksoft.LogStr.db.dao.daoImpl.HeadOfDepartmentDaoImpl;
import com.rocksoft.LogStr.db.dao.daoInterf.HeadOfDepartmentDao;
import com.rocksoft.LogStr.db.models.HeadOfDepartment;

/**
 * Created by Esenin on 29.09.2017.
 */
public class HeadOfDepartmentService {

    HeadOfDepartmentDaoImpl headOfDepartmentDao = new HeadOfDepartmentDaoImpl();

    public void createHeadOfDepartment(HeadOfDepartment headOfDepartment) {
        headOfDepartmentDao.createHeadOfDepartment(headOfDepartment);
    }


    public HeadOfDepartment getHeadOfDepartmentById(long id) {
        return headOfDepartmentDao.getHeadOfDepartmentById(id);
    }


    public void updateHeadOfDepartment(HeadOfDepartment headOfDepartment) {
        headOfDepartmentDao.updateHeadOfDepartment(headOfDepartment);
    }


    public void deleteHeadOfDepartmentById(long id) {
        headOfDepartmentDao.deleteHeadOfDepartmentById(id);
    }

    public void closeAll(){
        headOfDepartmentDao.closeAllConns();
    }

}
