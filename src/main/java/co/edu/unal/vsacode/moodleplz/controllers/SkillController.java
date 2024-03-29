package co.edu.unal.vsacode.moodleplz.controllers;

import co.edu.unal.vsacode.moodleplz.models.Skill;
import co.edu.unal.vsacode.moodleplz.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    private SkillService skillService;


    @GetMapping
    List<Skill> getSkills(){
        return skillService.getSkill();
    }

    @GetMapping("/{id}")
    Skill getSkill(@PathVariable String id){return skillService.getSkillById(id);}

    @PostMapping
    public Skill saveSkill(@RequestBody Skill newSkill){
        return skillService.saveSkill(newSkill);
    }

    @PutMapping("/{id}")
    public Skill updateSkill(@PathVariable (name = "id") String id, @RequestBody Skill newSkill){
        newSkill.setId(id);
        return skillService.updateSkill(newSkill);
    }

    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable (name = "id") String id){
        skillService.deleteSkill(id);
    }
}
