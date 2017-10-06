package com.rocksoft.LogStr.db.dao.mybatis;

import com.rocksoft.LogStr.db.dao.AbstarctDao;
import com.rocksoft.LogStr.db.dao.StorekeeperDao;
import com.rocksoft.LogStr.db.models.Storekeeper;

/**
 * Created by Esenin on 06.10.2017.
 */
public class MybatisStorekeeperDao extends AbstarctDao implements StorekeeperDao {
    @Override
    public void createStorekeeper(Storekeeper storekeeper) {

    }

    @Override
    public Storekeeper getStorekeeperById(long id) {
        return null;
    }

    @Override
    public void updateStorekeeper(Storekeeper storekeeper) {

    }

    @Override
    public void deleteStorekeeperById(long id) {

    }
}
