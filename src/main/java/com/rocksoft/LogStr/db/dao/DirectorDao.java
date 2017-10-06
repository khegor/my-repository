package com.rocksoft.LogStr.db.dao;

import com.rocksoft.LogStr.db.models.Director;

/**
 * Created by Esenin on 26.09.2017.
 */
public interface DirectorDao {

    void createDirector(Director director);
    Director getDirectorById(long id);
    void updateDirector(Director director);
    void deleteDirectorById(long id);
}
