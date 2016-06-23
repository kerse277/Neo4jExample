package com.oguz.sample.queryTest;

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
        import org.neo4j.ogm.model.Node;
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

    @Autowired
    PlacesRepository placesRepository;

    @Test
    public void findFriendByTypeTest () {


        for (FriendRelationship friendRelationship: this.friendRelationshipRepository.findFriendByType("A5","Facebook")) {
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

        for (FriendRelationship friendRelationship: this.friendRelationshipRepository.friendWay(5, user,searchName, 3)) {
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