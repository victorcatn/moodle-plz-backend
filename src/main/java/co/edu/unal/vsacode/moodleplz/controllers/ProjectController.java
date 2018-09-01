package co.edu.unal.vsacode.moodleplz.controllers;

import co.edu.unal.vsacode.moodleplz.models.Project;
import co.edu.unal.vsacode.moodleplz.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * Receive in the URL the code of one project and show it
     * @param code Code of a project
     * @return a project list with all project with the code provided
     */
    @GetMapping("/{code}")
    List<Project> getProject(@PathVariable String code){
        return projectService.getProjectbyCode(code);
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
        return projectService.saveProject(newProject);
    }

    /**
     * Delete a project with the id provided
     * @param id id generated by the class
     */
    @DeleteMapping("/{id}")
    void deleteProject(@PathVariable String id) {
        Project project = new Project();
        project.setId(id);
        projectService.deleteProject(project);
    }
}
