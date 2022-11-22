package it.lucagobbi.includo.service.impl;

import it.lucagobbi.includo.model.dto.*;
import it.lucagobbi.includo.service.CurriculumService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CurriculumServiceImpl implements CurriculumService {

    @Override
    public JasperPrint generateCV(Curriculum cv) throws IOException, JRException {
        Map<String, Object> params = new HashMap<>();
        List<Map<String, ?>> dataMapList = getDataMapList(cv);
        InputStream template = new ClassPathResource("jasper/cv.jrxml").getInputStream();
        JasperReport jasperReport = JasperCompileManager.compileReport(template);
        JasperPrint print = JasperFillManager.fillReport(jasperReport, params, new JRMapCollectionDataSource(dataMapList));
        return print;
    }

    private List<Map<String, ?>> getDataMapList(Curriculum cv) {
        List<Map<String, ?>> dataMapList = new ArrayList<>();
        Map<String, Object> generalDataMap = new HashMap<>();
        generalDataMap.put("user", getUserDataMap(cv.getUser()));
        generalDataMap.put("intro", getIntroduction(cv.getIntroduction()));
        generalDataMap.put("educationItems", getEducationItemsDataMap(cv.getEducationItems()));
        generalDataMap.put("experienceItems", getExperienceItemsDataMap(cv.getExperienceItems()));
        generalDataMap.put("contacts", getContactsDataMap(cv.getContacts()));
        dataMapList.add(generalDataMap);
        return dataMapList;
    }

    private Map<String, Object> getUserDataMap(UserView user) {
        Map<String, Object> userDataMap = new HashMap<>();
        userDataMap.put("name", user.getName());
        userDataMap.put("surname", user.getSurname());
        userDataMap.put("dateOfBirth", user.getDateOfBirth());
        userDataMap.put("email", user.getEmail());
        userDataMap.put("phoneNumber", user.getPhoneNumber());
        userDataMap.put("address", user.getAddress());
        return userDataMap;
    }

    private Map<String, Object> getIntroduction(String intro) {
        return Map.of("intro", intro);
    }

    private List<Map<String, ?>> getEducationItemsDataMap(List<EducationItem> educationItems) {
        List<Map<String, ?>> educationItemsDataMapList = new ArrayList<>();
        for(EducationItem educationItem : educationItems) {
            Map<String, Object> educationItemDataMap = fillItemDataMap(educationItem);
            educationItemDataMap.put("field", educationItem.getField());
            educationItemDataMap.put("title", educationItem.getTitle());
            educationItemDataMap.put("graduation", educationItem.getGraduation());
            educationItemsDataMapList.add(educationItemDataMap);
        }
        return educationItemsDataMapList;
    }

    private List<Map<String, ?>> getExperienceItemsDataMap(List<ExperienceItem> experienceItems) {
        List<Map<String, ?>> experienceItemsDataMapList = new ArrayList<>();
        for(ExperienceItem experienceItem : experienceItems) {
            Map<String, Object> experienceItemDataMap = fillItemDataMap(experienceItem);
            experienceItemsDataMapList.add(experienceItemDataMap);
        }
        return experienceItemsDataMapList;
    }

    private Map<String, Object> fillItemDataMap(Item item) {
        Map<String, Object> itemDataMap = new HashMap<>();
        itemDataMap.put("dateOfStart", item.getDateOfStart());
        itemDataMap.put("dateOfEnd", item.getDateOfEnd());
        itemDataMap.put("location", item.getLocation());
        itemDataMap.put("description", item.getDescription());
        return itemDataMap;
    }

    private List<Map<String, ?>> getContactsDataMap(List<Contact> contacts) {
        List<Map<String, ?>> contactsDataMapList = new ArrayList<>();
        for(Contact contact : contacts) {
            Map<String, Object> contactDataMap = new HashMap<>();
            contactDataMap.put("social", contact.getSocial());
            contactDataMap.put("link", contact.getLink());
        }
        return contactsDataMapList;
    }

}
