package com.freelance.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.freelance.models.ApplicationModel;
import com.freelance.models.FreelancerModel;
import com.freelance.models.ProjectModel;
import com.freelance.models.UserModel;
import com.freelance.repos.ApplicationRepo;
import com.freelance.repos.ChatRepo;
import com.freelance.repos.FreelancerRepo;
import com.freelance.repos.ProjectRepo;
import com.freelance.repos.UserRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Controller
public class RouteController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    FreelancerRepo freelancerRepo;

    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    ApplicationRepo applicationRepo;

    @Autowired
    ChatRepo chatRepo;

    @PostMapping("/register")
    public UserModel registerMethod(@RequestBody UserModel userData) {
        try {
            UserModel user = userRepo.save(userData);

            if(userData.getUsertype().equals("freelancer")) {
                FreelancerModel freelancer = new FreelancerModel();
                freelancer.setUserId(user.get_id());
                List<String> skills = new ArrayList<String>();
                freelancer.setSkills(skills);
                freelancer.setFunds(0);
                freelancer.setApplications(skills);
                freelancer.setCompletedProjects(skills);
                freelancer.setCurrentProjects(skills);
                freelancer.setDescription("");

                freelancerRepo.save(freelancer);
            }
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/login")
    public UserModel loginMethod(@RequestBody UserModel userData) {
        try {
            UserModel user = userRepo.findByEmail(userData.getEmail());
            if (user.getPassword().equals(userData.getPassword())) {
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/fetch-freelancer/{id}")
    public FreelancerModel fetchFreelancer(@PathVariable("id") String id) {
        try {
            FreelancerModel freelancer = freelancerRepo.findByUserId(id);
            return freelancer;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/update-freelancer")
    public FreelancerModel updateFreelancer(@RequestBody FreelancerModel freelancerData) {
        try {
        FreelancerModel freelancer = freelancerRepo.findById(freelancerData.getUserId()).get();
            freelancer.setSkills(freelancerData.getSkills());

            // Split skills in the frontend itself
            freelancer.setDescription(freelancerData.getDescription());

            freelancerRepo.save(freelancer);
            return freelancer;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/fetch-project/{id}")
    public ProjectModel fetchProject(@PathVariable("id") String id) {
        try {
            ProjectModel project = projectRepo.findById(id).get();
            return project;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/fetch-projects")
    public List<ProjectModel> fetchProjects() {
        try {
            List<ProjectModel> projects = projectRepo.findAll();
            return projects;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/new-project")
    public ProjectModel newProject(@RequestBody ProjectModel projectData) {
        try {
            // Split skills in the frontend itself
            ProjectModel project = projectRepo.save(projectData);
            return project;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/make-bid")
    public ApplicationModel makeBid(@RequestBody ApplicationModel applicationData) {
        try {
            
            ProjectModel project = projectRepo.findById(applicationData.getProjectId()).get();
            UserModel user = userRepo.findById(applicationData.getFreelancerId()).get();
            FreelancerModel freelancer = freelancerRepo.findByUserId(applicationData.getFreelancerId());
            ApplicationModel application = applicationRepo.save(applicationData);
            UserModel client = userRepo.findById(applicationData.getClientId()).get();
            
            applicationData.setClientName(client.getUsername());
            applicationData.setClientEmail(client.getEmail());
            applicationData.setFreelancerName(user.getUsername());
            applicationData.setFreelancerEmail(user.getEmail());
            applicationData.setFreelancerSkills(freelancer.getSkills());
            applicationData.setTitle(project.getTitle());
            applicationData.setDescription(project.getDescription());
            applicationData.setBudget(project.getBudget());
            applicationData.setRequiredSkills(project.getSkills());

            applicationRepo.save(applicationData);

            List <String> bids = project.getBids();
            bids.add(applicationData.get_id());
            project.setBids(bids);

            List <Number> bidAmounts = project.getBidAmounts();
            bidAmounts.add(applicationData.getBidAmount());
            project.setBidAmounts(bidAmounts);

            projectRepo.save(project);

            List <String> applications = freelancer.getApplications();
            applications.add(applicationData.get_id());
            freelancer.setApplications(applications);

            freelancerRepo.save(freelancer);

            return applicationData;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/fetch-applications")
    public List<ApplicationModel> fetchApplications() {
        try {
            List<ApplicationModel> applications = applicationRepo.findAll();
            return applications;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/approve-application/{id}")
    public ApplicationModel approveApplications(@PathVariable("id") String id) {
        try {
            ApplicationModel application = applicationRepo.findById(id).get();
            ProjectModel project = projectRepo.findById(application.getProjectId()).get();
            FreelancerModel freelancer = freelancerRepo.findByUserId(application.getFreelancerId());
            UserModel user = userRepo.findById(application.getFreelancerId()).get();

            application.status = "Accepted";

            List <String> currentProjects = freelancer.getCurrentProjects();
            currentProjects.add(application.getProjectId());
            freelancer.setCurrentProjects(currentProjects);

            project.setFreelancerId(application.getFreelancerId());
            project.setFreelancerName(user.getUsername());
            project.setBudget(application.getBidAmount());
            project.setStatus("Assigned");

            projectRepo.save(project);
            freelancerRepo.save(freelancer);
            applicationRepo.save(application);

            return application;

        } catch (Exception e) {
            return null;
        }
    }
    

    @GetMapping("/reject-application/{id}")
    public ApplicationModel rejectApplications(@PathVariable("id") String id) {
        try {
            ApplicationModel application = applicationRepo.findById(id).get();
            application.status = "Rejected";
            applicationRepo.save(application);
            return application;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/submit-project/{id}")
    public ProjectModel submitProject(@PathVariable("id") String id ,@RequestBody ProjectModel projectData) {
        try {

            System.out.println(projectData);
            // send _id of the project
            ProjectModel project = projectRepo.findById(id).get();
            project.setProjectLink(projectData.getProjectLink());
            project.setManualLink(projectData.getManualLink());
            project.setSubmission(true);
            project.setSubmissionDescription(projectData.getSubmissionDescription());

            projectRepo.save(project);


            return project;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/approve-submission/{id}")
    public ProjectModel approveSubmission(@PathVariable("id") String id) {
        try {
            ProjectModel project = projectRepo.findById(id).get();

            FreelancerModel freelancer = freelancerRepo.findByUserId(project.getFreelancerId());

            project.setSubmissionAccepted(true);
            project.setStatus("Completed");

            projectRepo.save(project);

            List <String> completedProjects = freelancer.getCompletedProjects();
            completedProjects.add(id);
            freelancer.setCompletedProjects(completedProjects);

            List <String> currentProjects = freelancer.getCurrentProjects();
            currentProjects.remove(id);
            freelancer.setCurrentProjects(currentProjects);

            freelancerRepo.save(freelancer);
            return project;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/reject-submission/{id}")
    public ProjectModel rejectSubmission(@PathVariable("id") String id) {
        try {
            ProjectModel project = projectRepo.findById(id).get();
            project.setSubmissionAccepted(false);
            project.setSubmission(false);
            project.setProjectLink("");
            project.setManualLink("");
            project.setSubmissionDescription("");

            projectRepo.save(project);
            return project;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/fetch-users")
    public List<UserModel> fetchUsers() {
        try {
            List<UserModel> users = userRepo.findAll();
            return users;
        } catch (Exception e) {
            return null;
        }
    }
    

}
