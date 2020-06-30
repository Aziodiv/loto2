package com.bta.loto.repository;

import com.bta.loto.model.PlayResult;

import java.time.LocalDateTime;
import java.util.List;

public class PlayResultRepository extends  AbstractRepository<PlayResult>{


    @Override
    public int save(PlayResult entity) {

        return 0;
    }

    @Override
    public List<PlayResult> findAll() {
        return null;
    }

    public PlayResult findByDate(LocalDateTime dateTime){

return null;
    }

}
