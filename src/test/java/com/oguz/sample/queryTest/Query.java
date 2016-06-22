package com.oguz.sample.queryTest;

import com.oguz.sample.model.Person;
import com.oguz.sample.relationshipmodel.FriendRelationship;
import com.oguz.sample.repository.FriendRelationshipRepository;
import com.oguz.sample.repository.PersonRepository;
import com.oguz.sample.repository.WorkRelationshipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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


    @Autowired
    WorkRelationshipRepository workRelationshipRepository;

    @Test
    public void metricMatchTest () {
/*
        List<Person> pList;
        for (Person person: this.personRepository.matchMetric("A1","A2")) {
            System.out.println(person);
        }*/
        for (FriendRelationship friendRelationship: this.friendRelationshipRepository.friendWay("A1",2,"A2")) {
            System.out.println(friendRelationship);
        }
        System.out.println();
    }

    @Test
    public void findFriendByTypeTest () {


        for (FriendRelationship friendRelationship: this.friendRelationshipRepository.findFriendByType("A9","Facebook")) {
            System.out.println(friendRelationship);
        }
        System.out.println();
    }

    @Test
    public void findFriendAllTest () {


        for (FriendRelationship friendRelationship: this.friendRelationshipRepository.findFriendAll("A9")) {
            System.out.println(friendRelationship);
        }
        System.out.println();
    }

    @Test
    public void workNotFriendTest () {

        List<Person> list=new ArrayList<Person>();
        for (Person person: this.personRepository.workNotFriend("A73")) {
            list.add(person);
        }
        Random r=new Random();
        System.out.println(list.get(r.nextInt(list.size()-1)).getName()+" İsimli kişide sizinle aynı yerde çalışıyor" +
                " Merhaba Demek İster misin ?");
    }
}
