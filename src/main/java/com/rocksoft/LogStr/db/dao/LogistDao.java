package com.rocksoft.LogStr.db.dao;

import com.rocksoft.LogStr.db.models.Logist;

/**
 * Created by Esenin on 29.09.2017.
 */
public interface LogistDao {

    void createLogist(Logist logist);
    Logist getLogistById(long id);
    void updateLogist(Logist logist);
    void deleteLogistById(long id);

}
