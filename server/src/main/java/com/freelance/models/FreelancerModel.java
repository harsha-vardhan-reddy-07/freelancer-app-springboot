package com.freelance.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collection = "freelancer")
public class FreelancerModel {

    public String _id;
    public String userId = "";
    public List<String> skills = new ArrayList<String>();
    public String description = "";
    public List<String> currentProjects = new ArrayList<String>();
    public List<String> completedProjects = new ArrayList<String>();
    public List<String> applications = new ArrayList<String>();
    public Number funds = 0;

    public FreelancerModel(){

    }

    public String get_id() {
        return _id;
    }

    public String getUserId() {
        return userId;
    }

    public List<String> getSkills() {
        return skills;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getCurrentProjects() {
        return currentProjects;
    }

    public List<String> getCompletedProjects() {
        return completedProjects;
    }

    public List<String> getApplications() {
        return applications;
    }

    public Number getFunds() {
        return funds;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCurrentProjects(List<String> currentProjects) {
        this.currentProjects = currentProjects;
    }

    public void setCompletedProjects(List<String> completedProjects) {
        this.completedProjects = completedProjects;
    }

    public void setApplications(List<String> applications) {
        this.applications = applications;
    }

    public void setFunds(Number funds) {
        this.funds = funds;
    }

    
    
}
