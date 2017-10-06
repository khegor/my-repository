package com.rocksoft.LogStr.db.dao.mybatis;

import com.rocksoft.LogStr.db.dao.AbstarctDao;
import com.rocksoft.LogStr.db.dao.LogistDao;
import com.rocksoft.LogStr.db.models.Logist;

/**
 * Created by Esenin on 06.10.2017.
 */
public class MybatisLogistDao extends AbstarctDao implements LogistDao{
    @Override
    public void createLogist(Logist logist) {

    }

    @Override
    public Logist getLogistById(long id) {
        return null;
    }

    @Override
    public void updateLogist(Logist logist) {

    }

    @Override
    public void deleteLogistById(long id) {

    }
}
