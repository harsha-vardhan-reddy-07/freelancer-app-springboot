package com.freelance.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collection = "applications")
public class ApplicationModel {
    
    public String _id;
    public String projectId;
    public String clientId;
    public String clientName;
    public String clientEmail;
    public String freelancerId;
    public String freelancerName;
    public String freelancerEmail;
    public List<String> freelancerSkills;
    public String title;
    public String description;
    public Number budget;
    public List<String> requiredSkills;
    public String proposal;
    public Number bidAmount;
    public Number estimatedTime;
    public String status = "Pending";

    public ApplicationModel(){

    }

    public String get_id() {
        return _id;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public String getFreelancerId() {
        return freelancerId;
    }

    public String getFreelancerName() {
        return freelancerName;
    }

    public String getFreelancerEmail() {
        return freelancerEmail;
    }

    public List<String> getFreelancerSkills() {
        return freelancerSkills;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Number getBudget() {
        return budget;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public String getProposal() {
        return proposal;
    }

    public Number getBidAmount() {
        return bidAmount;
    }

    public Number getEstimatedTime() {
        return estimatedTime;
    }

    public String getStatus() {
        return status;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public void setFreelancerId(String freelancerId) {
        this.freelancerId = freelancerId;
    }

    public void setFreelancerName(String freelancerName) {
        this.freelancerName = freelancerName;
    }

    public void setFreelancerEmail(String freelancerEmail) {
        this.freelancerEmail = freelancerEmail;
    }

    public void setFreelancerSkills(List<String> freelancerSkills) {
        this.freelancerSkills = freelancerSkills;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBudget(Number budget) {
        this.budget = budget;
    }

    public void setRequiredSkills(List<String> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public void setProposal(String proposal) {
        this.proposal = proposal;
    }

    public void setBidAmount(Number bidAmount) {
        this.bidAmount = bidAmount;
    }

    public void setEstimatedTime(Number estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
