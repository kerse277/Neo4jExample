package com.oguz.sample.repository;

import com.oguz.sample.model.Person;
import com.oguz.sample.model.Places;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by oguz on 18.06.2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private  PlacesRepository placesRepository;


    @Test
    public void testPersonRepositoryInsert () {
        personRepository.deleteAll();
        String genders [] = {"M","F"};
        String Hoby [] = {"Music","Art","Play Game"};
        for(int i= 1; i<1000; i++) {
        Person person = new Person()
                .setGender(genders[i%2])
                .setHoby(Hoby[i%3])
                .setName("A"+i)
                .setPhoto("/home/oguz/IMG/img.jpeg")
                .setSurname("B"+i)
                .setTc("100000000"+i);
        person =personRepository.save(person);
       System.out.println(person.getName());
        }
    }

    @Test
    public void relationTest() {
        personRepository.deleteAll();
        Person person1 = new Person()
                .setName("oguzhan")
                .setSurname("YILMAZ");
        personRepository.save(person1);
        Person person2 = new Person();
        person2.setName("memo")
                .setSurname("KERSE");
        personRepository.save(person2);

        Person p = new Person();
        p = personRepository.findByName("oguzhan");

        Person p2 = new Person();


        p2 = personRepository.findByName("memo");
        p2.friend(p);
        p.friend(p2);

        personRepository.save(p);
        personRepository.save(p2);

        //personRepository.save(person2);

        //personRepository.save(person3);

    }

    @Test
    public void personRepositoryAllTest () {

        Person person = new  Person()
                .setName("memo")
                .setSurname("kerse");
        personRepository.save(person);
        //findOne
       // person = personRepository.findOne(person.getId());
        System.out.println(person.getName());
        //findByName
        person = personRepository.findByName("A1");
        System.out.println(person.getName());
        //Count
        Integer COUNT = Math.toIntExact(personRepository.count());
        System.out.println("Kayıt Sayısı = " + COUNT);

    }
    @Test
    public void personRepositoryQueryTest () {
        Person person = new Person();
       person = personRepository.getPersonFromName("Oguz2");
        System.out.println(person.getName());
    }

}
