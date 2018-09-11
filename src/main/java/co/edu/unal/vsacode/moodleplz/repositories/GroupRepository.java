package co.edu.unal.vsacode.moodleplz.repositories;

import co.edu.unal.vsacode.moodleplz.models.Group;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends MongoRepository<Group, String> {

}
