package com.oguz.sample.searchQueryTest;

import com.oguz.sample.model.Person;
import com.oguz.sample.model.Places;
import com.oguz.sample.relationshipmodel.FriendRelationship;
import com.oguz.sample.relationshipmodel.WorkRelationship;
import com.oguz.sample.repository.FriendRelationshipRepository;
import com.oguz.sample.repository.PersonRepository;
import com.oguz.sample.repository.PlacesRepository;
import com.oguz.sample.repository.WorkRelationshipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Scanner;

/**
 * Created by oguz on 22.06.2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchQuery {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    WorkRelationshipRepository workRelationshipRepository;

    @Autowired
    FriendRelationshipRepository friendRelationshipRepository;

    @Autowired
    PlacesRepository placesRepository;

    @Test
    public void nameSearchTest() {
        Person person = new Person();
        WorkRelationship workRelationship = new WorkRelationship();

        String user = "A1";
        String searchName = "A3";
        System.out.println("Hoş geldin "+ user +" Aramak istediğiniz kişinin ismini giriniz");
        person = personRepository.findByName(searchName);
        Places places = new Places();
         places= placesRepository.workSearch(person.getName());


        System.out.println("Aranan kişi'nin adı : " + person.getName() + "\n" +
                "Aranan kişinin soyadı : " + person.getSurname() + "\n" +
                "Aranan kişi : " + places.getName() + " 'de çalışıyor..." + "\n" +
                "Arkadaş ilişkiniz \n");

        for (FriendRelationship friendRelationship: this.friendRelationshipRepository.friendWay(user,2,searchName)) {
            System.out.println(friendRelationship);
        }
    }
    @Test
    public void workSearchTest () {
        String user = "A2";
        System.out.println(workRelationshipRepository.findByWorkType("STUDENT"));
        WorkRelationship workRelationship = workRelationshipRepository.findNodeWorkType(user);
        if (workRelationshipRepository.findByWorkType(user)==null) {
            System.out.println("iş bulunamadı");
        } else {
            Places places = placesRepository.workSearch(user);
            System.out.println("\n isim'e göre iş bulma : " + workRelationship.getWorkType() + "\n" +
                    "Nerede Çalışıyor : " + places.getName());

        }
    }
    @Test
    public void firstDegreeFriend () {
        String user = "A2";
        String limit = "10";
        List<Person> personList = personRepository.findByFirstDegreeFriend(user);
        for (int i = 0 ; i<personList.size(); i++)
        System.out.println(personList.get(i));
    }
}
