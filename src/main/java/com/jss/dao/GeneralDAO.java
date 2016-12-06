package com.jss.dao;

import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * Created by Jack on 03.12.2016.
 */
@Data
@Repository
public abstract class GeneralDAO<ENTITY_CLASS, ID_TYPE>
        implements CommonDAO<ENTITY_CLASS, ID_TYPE> {

    public GeneralDAO() {
    }
}
