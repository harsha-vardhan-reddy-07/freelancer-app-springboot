package com.freelance.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collection = "projects")
public class ProjectModel {

    public String _id;
    public String clientId;
    public String clientName;
    public String clientEmail;
    public String title;
    public String description;
    public Number budget;
    public List<String> skills;
    public List<String> bids;
    public List<Number> bidAmounts;
    public String postedDate;
    public String status = "Available";
    public String freelancerId;
    public String freelancerName;
    public String deadline;
    public Boolean submission = false;
    public Boolean submissionAccepted = false;
    public String projectLink = "";
    public String manualLink = "";
    public String submissionDescription = "";

    public ProjectModel(){

    }

    public String get_id() {
        return _id;
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

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Number getBudget() {
        return budget;
    }

    public String getStatus() {
        return status;
    }


    public String getFreelancerId() {
        return freelancerId;
    }

    public String getFreelancerName() {
        return freelancerName;
    }

    public String getDeadline() {
        return deadline;
    }

    public Boolean getSubmission() {
        return submission;
    }

    public Boolean getSubmissionAccepted() {
        return submissionAccepted;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public String getManualLink() {
        return manualLink;
    }

    public String getSubmissionDescription() {
        return submissionDescription;
    }

    public List<String> getSkills() {
        return skills;
    }

    public List<String> getBids() {
        return bids;
    }

    public List<Number> getBidAmounts() {
        return bidAmounts;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBudget(Number budget) {
        this.budget = budget;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public void setBids(List<String> bids) {
        this.bids = bids;
    }

    public void setBidAmounts(List<Number> bidAmounts) {
        this.bidAmounts = bidAmounts;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setFreelancerId(String freelancerId) {
        this.freelancerId = freelancerId;
    }

    public void setFreelancerName(String freelancerName) {
        this.freelancerName = freelancerName;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setSubmission(Boolean submission) {
        this.submission = submission;
    }

    public void setSubmissionAccepted(Boolean submissionAccepted) {
        this.submissionAccepted = submissionAccepted;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }

    public void setManualLink(String manualLink) {
        this.manualLink = manualLink;
    }

    public void setSubmissionDescription(String submissionDescription) {
        this.submissionDescription = submissionDescription;
    }

    


    
}
