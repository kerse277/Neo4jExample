package com.oguz.sample.queryTest;

import com.oguz.sample.model.Person;
import com.oguz.sample.relationshipmodel.FriendRelationship;
import com.oguz.sample.repository.FriendRelationshipRepository;
import com.oguz.sample.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by oguz on 21.06.2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Query {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    FriendRelationshipRepository friendRelationshipRepository;

    @Test
    public void matchTest() {
        Person person = new Person();
        person = personRepository.metric();
        System.out.println(person.getName());
    }
    @Test
    public void workTest() {
        String w = personRepository.work();
        System.out.println(w);
    }
    @Test
    public void metricMatchTest () {

        List<Person> pList;
        for (Person person: this.personRepository.matchMetric()) {
            System.out.println(person);
        }
        for (FriendRelationship friendRelationship: this.friendRelationshipRepository.matchMetric()) {
            System.out.println(friendRelationship);
        }
        System.out.println();
    }
}
