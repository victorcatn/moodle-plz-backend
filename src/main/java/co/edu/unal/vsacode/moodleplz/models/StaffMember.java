package co.edu.unal.vsacode.moodleplz.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class StaffMember {

    @Id
    private String id;
    private String document;
    private String email;
    private String password;
    private String name;
    private String lastName;

    private Boolean isHRM; //TODO: separate classes for HRM and staff member

    private List<Skill> skills;
    private List<Knowledge> knowledge;

    private String groupId;

    public StaffMember(String document, String email, String password, String name, String lastName){
        this.document = document;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        if(document.length()>10) return; //TODO: find better validation techniques
        this.document = document;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Knowledge> getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(List<Knowledge> knowledge) {
        this.knowledge = knowledge;
    }

    public Boolean isHRM() {
        return isHRM;
    }

    public void setHRM(Boolean HRM) {
        isHRM = HRM;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
