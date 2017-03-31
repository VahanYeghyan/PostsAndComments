package com.vahan.service;

import com.vahan.domain.SequenceId;
import com.vahan.domain.User;
import com.vahan.exception.SequenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * Created by TCE\vahany on 3/30/17.
 */
@Service
public class SequenceDao {

    @Autowired
    private MongoOperations mongoOperation;

    public long getNextSequenceId(String key) throws SequenceException {

        Query query = new Query(Criteria.where("_id").is(key));

        Update update = new Update();
        update.inc("seq", 1);

        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);

        SequenceId sequenceId = mongoOperation.findAndModify(query, update, options, SequenceId.class);

        if (sequenceId == null) {
            throw new SequenceException("Unable to get sequence id for key : " + key);
        }

        return sequenceId.getSeq();

    }
}
