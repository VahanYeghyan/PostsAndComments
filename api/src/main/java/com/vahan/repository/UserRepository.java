package com.vahan.repository;

import com.vahan.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by TCE\vahany on 3/29/17.
 */
public interface UserRepository extends MongoRepository<User,Integer> {

    User getUserByName(String name);

    User getUserById(long id);
}
