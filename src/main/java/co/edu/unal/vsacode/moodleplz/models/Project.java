package co.edu.unal.vsacode.moodleplz.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class Project {
    @Id
    private String id;
    private String name;

    private Date startDate;
    private Date endDate;

    private List<Skill> neededSkill;
    private List<Knowledge> neededKnowledge;

    private Group assignedGroup;

    //private int staffNeeded; //TODO

    public Project(){

    }


    public Project(String name, Date startDate, List<Skill> neededSkill, List<Knowledge> neededKnowledge) {
        this.startDate = startDate;
        this.name = name;
        this.neededSkill = neededSkill;
        this.neededKnowledge = neededKnowledge;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Skill> getNeededSkill() {
        return neededSkill;
    }

    public void setNeededSkill(List<Skill> neededSkill) {
        this.neededSkill = neededSkill;
    }

    public List<Knowledge> getNeededKnowledge() {
        return neededKnowledge;
    }

    public void setNeededKnowledge(List<Knowledge> neededKnowledge) {
        this.neededKnowledge = neededKnowledge;
    }

    public Group getAssignedGroup() {
        return assignedGroup;
    }

    public void setAssignedGroup(Group assignedGroup) {
        this.assignedGroup = assignedGroup;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }


    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", neededSkill=" + neededSkill +
                ", neededKnowledge=" + neededKnowledge +
                ", assignedGroup=" + assignedGroup +
                '}';
    }
}
