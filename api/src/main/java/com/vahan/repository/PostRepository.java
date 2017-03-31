package com.vahan.repository;

import com.vahan.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by TCE\vahany on 3/29/17.
 */

public interface PostRepository extends MongoRepository<Post,Integer> {

}
