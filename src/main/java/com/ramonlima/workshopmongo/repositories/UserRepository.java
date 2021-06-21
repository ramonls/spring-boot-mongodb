package com.ramonlima.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ramonlima.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
