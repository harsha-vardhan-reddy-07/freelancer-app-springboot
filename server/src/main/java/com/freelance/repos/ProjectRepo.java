package com.freelance.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.freelance.models.ProjectModel;

public interface ProjectRepo extends MongoRepository<ProjectModel, String>{

    
} 
