package com.rocksoft.LogStr.db.dao.mybatis;

import com.rocksoft.LogStr.db.dao.AbstarctDao;
import com.rocksoft.LogStr.db.dao.DirectorDao;
import com.rocksoft.LogStr.db.models.Director;

/**
 * Created by Esenin on 06.10.2017.
 */
public class MybatisDirectorDao extends AbstarctDao implements DirectorDao {

    @Override
    public void createDirector(Director director) {

    }

    @Override
    public Director getDirectorById(long id) {
        return null;
    }

    @Override
    public void updateDirector(Director director) {

    }

    @Override
    public void deleteDirectorById(long id) {

    }
}
