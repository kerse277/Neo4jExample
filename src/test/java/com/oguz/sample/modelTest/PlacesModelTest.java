package com.oguz.sample.modelTest;

import com.oguz.sample.model.Person;
import com.oguz.sample.model.Places;
import com.oguz.sample.relationshipmodel.WorkRelationship;
import com.oguz.sample.repository.PersonRepository;
import com.oguz.sample.repository.PlacesRepository;
import com.oguz.sample.repository.WorkRelationshipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

/**
 * Created by oguz on 21.06.2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlacesModelTest {

    @Autowired
    PlacesRepository placesRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    WorkRelationshipRepository workRelationshipRepository;

    @Test
    public void placesInsert() {
        String placesType [] = {"HOSPITAL","ENGINEER OFFICE","SCHOOL","SPORT CLUB"};
        String placesNameHospital [] ={"ANKARA HASTANESİ","GAZİ HASTANESİ","HACETTEPE HASTANESİ"};
        String placesNameEngineerOffice [] ={"BEAM TEKNOLOJİ","ABC TEKNOLOJİ","ABC","TEKNOLOJİ","COMPUTER"};
        String placesNameSchool [] = {"GAZİ ÜNİVERSİTESİ","ANKARA ÜNİVERSİTESİ","ORTA DOĞU TEKNİK ÜNİVERSİTESİ","BİLKENT ÜNİVERSİTESİ","SELÇUK ÜNİVERSİTESİ"};
        String placesNameClub [] = {"GALATASARAY","ANKARAGÜCÜ","FENERBAHÇE","BEŞİKTAŞ","SİVASSPOR","İSTANBUL BÜYÜKŞEHİR BELEDİYE SPOR","TRABZON SPOR","KONYA SPROR"};
        String placesName [] = {"ANKARA HASTANESİ","GAZİ HASTANESİ","HACETTEPE HASTANESİ","BEAM TEKNOLOJİ","ABC TEKNOLOJİ","ABC","TEKNOLOJİ","COMPUTER","GAZİ ÜNİVERSİTESİ","ANKARA ÜNİVERSİTESİ"
                ,"ORTA DOĞU TEKNİK ÜNİVERSİTESİ","BİLKENT ÜNİVERSİTESİ","SELÇUK ÜNİVERSİTES","GALATASARAY","ANKARAGÜCÜ","FENERBAHÇE","BEŞİKTAŞ","SİVASSPOR","İSTANBUL BÜYÜKŞEHİR BELEDİYE SPOR","TRABZON SPOR","KONYA SPROR"};
        String hospital [] = {"NURSE","DOCTOR"};
        String engineer [] = {"ENGINEER","DEVOLOPER"};
        String school [] = {"TEACHER","STUDENT"};
        String sport [] = {"FOOTBOLLER","DIRECTOR"};

        Random random = new Random();
        int randomNumber;

        for (int i = 0; i<3; i++) {
            Places places = new Places();
            places.setType(placesType[0])
                    .setName(placesNameHospital[i]);
                    placesRepository.save(places);
        }
        for (int i = 0; i<5; i++) {
            Places places = new Places();
            places.setType(placesType[1])
                    .setName(placesNameEngineerOffice[i]);
            placesRepository.save(places);
        }
        for (int i = 0; i<5; i++) {
            Places places = new Places();
            places.setType(placesType[2])
                    .setName(placesNameSchool[i]);
            placesRepository.save(places);
        }
        for (int i = 0; i<8; i++) {
            Places places = new Places();
            places.setType(placesType[3])
                    .setName(placesNameClub[i]);
            placesRepository.save(places);
        }



    }
    @Test
    public void insertWorkTest() {
        String placesType [] = {"HOSPITAL","ENGINEER OFFICE","SCHOOL","SPORT CLUB"};
        String placesName [] = {"ANKARA HASTANESİ","GAZİ HASTANESİ","HACETTEPE HASTANESİ","BEAM TEKNOLOJİ","ABC TEKNOLOJİ","ABC","TEKNOLOJİ","COMPUTER","GAZİ ÜNİVERSİTESİ","ANKARA ÜNİVERSİTESİ"
                ,"ORTA DOĞU TEKNİK ÜNİVERSİTESİ","BİLKENT ÜNİVERSİTESİ","SELÇUK ÜNİVERSİTESİ","GALATASARAY","ANKARAGÜCÜ","FENERBAHÇE","BEŞİKTAŞ","SİVASSPOR","İSTANBUL BÜYÜKŞEHİR BELEDİYE SPOR","TRABZON SPOR","KONYA SPROR"};
        String hospital [] = {"NURSE","DOCTOR"};
        String engineer [] = {"ENGINEER","DEVOLOPER"};
        String school [] = {"TEACHER","STUDENT"};
        String sport [] = {"FOOTBOLLER","DIRECTOR"};
        Random r = new Random();
        int randomSayi,rn2;
        for (int i = 1; i<=200; i++) {
            randomSayi = r.nextInt(1);
            rn2=r.nextInt(placesName.length-1);
            WorkRelationship wR = new WorkRelationship();
            Person person = new Person();
            person = personRepository.findByName("A"+i);
            Places places= new Places();

            places = placesRepository.findByName(placesName[rn2]);
            if (places.getType().equals(placesType[0]))  {
                wR.setStartNode(person)
                        .setEndNode(places)
                        .setWorkType(hospital[i%2]);
                workRelationshipRepository.save(wR);
            }
            else if (places.getType().equals(placesType[1])) {
                wR.setStartNode(person)
                        .setEndNode(places)
                        .setWorkType(engineer[i%2]);
                workRelationshipRepository.save(wR);
            }
            else if (places.getType().equals(placesType[2])) {
                wR.setStartNode(person)
                        .setEndNode(places)
                        .setWorkType(school[i%2]);
                workRelationshipRepository.save(wR);

            }
            else if (places.getType().equals(placesType[3])) {
                wR.setStartNode(person)
                        .setEndNode(places)
                        .setWorkType(sport[i%2]);
                workRelationshipRepository.save(wR);
            }
        }
    }
}
