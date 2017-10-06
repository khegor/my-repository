package com.rocksoft.LogStr.db.dao;

import com.rocksoft.LogStr.db.models.Storekeeper;

/**
 * Created by Esenin on 29.09.2017.
 */
public interface StorekeeperDao {

    void createStorekeeper(Storekeeper storekeeper);
    Storekeeper getStorekeeperById(long id);
    void updateStorekeeper(Storekeeper storekeeper);
    void deleteStorekeeperById(long id);
}
