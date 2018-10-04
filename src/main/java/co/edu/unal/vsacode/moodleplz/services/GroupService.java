package co.edu.unal.vsacode.moodleplz.services;

import co.edu.unal.vsacode.moodleplz.models.*;
import co.edu.unal.vsacode.moodleplz.repositories.GroupRepository;
import co.edu.unal.vsacode.moodleplz.repositories.StaffMemberDAL;
import co.edu.unal.vsacode.moodleplz.repositories.StaffMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    private GroupRepository repository;

    @Autowired
    private StaffMemberRepository staffMemberRepository;

    @Autowired
    private StaffMemberDAL staffMemberDAL;

    @Autowired
    private StaffMemberService staffMemberService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmailService emailService;

    public List<Group> getGroups(){
        return repository.findAll();
    }

    public Group getGroup(String id) {
        Optional<Group> result = repository.findById(id);
        return result.orElse(null);
    }


    public Group generateGroup(Project project){

        List<String> members = new ArrayList<>();

        for(SkillScore s : project.getNeededSkills()){
            StaffMember member = staffMemberDAL.findBySatisfiedSkill(s);

            if(member != null){
                members.add(member.getId());
            }

        }

        for(KnowledgeScore k : project.getNeededKnowledges()){
            StaffMember member = staffMemberDAL.findBySatisfiedKnowledge(k);
            if(member != null){
                members.add(member.getId());
            }
        }

        Group group = new Group( members, project.getId()); //TODO give a list of members to choose the wanted



        return group;
    }

    public Group createGroup(Group group){
        Group savedGroup = repository.save(group);
        Project selectedProject = projectService.getProjectById(savedGroup.getProjectId());
        if(selectedProject.getAssignedGroupId() != null){
            emailService.changesAssigendGroup(getGroup(selectedProject.getAssignedGroupId()), selectedProject);
        }
        selectedProject.setAssignedGroupId(savedGroup.getId());
        projectService.saveProject(selectedProject);
        emailService.createGroupNotification(savedGroup);
        return savedGroup;

    }

    public Group updateGroup(Group newGroup, String id){
        if(!repository.findById(id).isPresent()){
            return null;
        }
        else{
            Group oldGroup = getGroup(id);
            newGroup.setId(id);
            Group updatedGroup = repository.save(newGroup);
            emailService.updateGroupNotification(updatedGroup, oldGroup);
            return updatedGroup;
        }

    }

    public void deleteGroup(String id){
        if(repository.findById(id).isPresent()) {
            emailService.deleteGroupNotification(getGroup(id));
            repository.deleteById(id);
        }
    }
}
