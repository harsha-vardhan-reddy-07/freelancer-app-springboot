package com.freelance.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.freelance.models.UserModel;

public interface UserRepo extends MongoRepository<UserModel, String>{

    UserModel findByEmail(String email);
} 
