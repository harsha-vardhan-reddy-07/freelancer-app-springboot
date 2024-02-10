package com.freelance.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.freelance.models.ChatModel;

public interface ChatRepo extends MongoRepository<ChatModel, String>{

    
} 
