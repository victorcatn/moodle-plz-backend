package co.edu.unal.vsacode.moodleplz.controllers;

import co.edu.unal.vsacode.moodleplz.models.Project;
import co.edu.unal.vsacode.moodleplz.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    /**
     * Do a request in order to show all projects
     * @return list of projects
     */
    @GetMapping
    List<Project> getProject() {
        return projectService.getProject();
    }

    /**
     * Receive in the URL the id of one project and show it
     * @param id id generated by the class Project
     * @return a project list with all project with the code provided
     */
    @GetMapping("/{id}")
    Optional<Project> getProjectById(@PathVariable String id){
        return projectService.getProject(id);
    }

    /**
     * Received in the URL the name of a project and show it
     * @param name name assigned by the user to the project
     * @return a project list with all project with the name provided
     */
    @GetMapping("/{name}")
    Optional<Project> getProjectByName(@PathVariable String name){
        return projectService.getProject(name);
    }



    /**
     * Invoke the service saveProject in order to save the project in the repository
     * @param project company´s project
     * @return the project saved
     */
    @PostMapping
    Project saveProject(@RequestBody Project project) {
        return projectService.saveProject(project);
    }

    /**
     * Invoke the service saveProject in order to update a project with the id provided
     * @param newProject company´s project
     * @param id id generated by the class
     * @return the project updated
     */
    @PutMapping("/{id}")
    Project editProject(@RequestBody Project newProject, @PathVariable String id) {
        newProject.setId(id);
        return projectService.saveProject(newProject);
    }

    /**
     * Delete a project with the id provided
     * @param id id generated by the class
     */
    @DeleteMapping("/{id}")
    void deleteProject(@PathVariable String id) {
        projectService.deleteProject(id);
    }
}