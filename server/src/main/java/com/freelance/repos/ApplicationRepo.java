package com.freelance.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.freelance.models.ApplicationModel;

public interface ApplicationRepo extends MongoRepository<ApplicationModel, String>{
    
}
