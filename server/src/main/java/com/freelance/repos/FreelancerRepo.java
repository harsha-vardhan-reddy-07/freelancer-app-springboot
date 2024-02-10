package com.freelance.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.freelance.models.FreelancerModel;


public interface FreelancerRepo extends MongoRepository<FreelancerModel, String>{

    FreelancerModel findByUserId(String userId);
} 