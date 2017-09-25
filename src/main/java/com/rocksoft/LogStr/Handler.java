package com.rocksoft.LogStr; /**
 * Created by Esenin on 26.08.2017.
 */
import java.util.ArrayList;
import java.util.List;

import com.rocksoft.LogStr.db.models.*;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler {

    private static final Logger LOGGER = Logger.getLogger(Handler.class);

    private static final String STAFF_TAG = "staff";
    private static final String ADMINISTRATION_TAG = "administration";
    private static final String WORKERS_TAG = "workers";
    private static final String WORKER_TAG = "worker";
    private static final String ADMIN_TAG = "admin";
    private static final String NAME_TAG = "name";
    private static final String SURNAME_TAG = "surname";
    private static final String ESTABLISHED_POST = "establishedPost";
    private static final String ADDRESS_TAG = "address";
    private static final String COUNTRY_TAG = "country";
    private static final String CITY_TAG = "city";
    private static final String STREET_TAG = "street";
    private static final String HOMENUMBER_TAG = "homeNumber";
    private static final String DATE_OF_BIRTH_TAG = "dateOfBirth";

    private Worker worker;
    private Administration adminisration;
    private DriverCar driverCar;
    private Logist logist;
    private Storekeeper storekeeper;
    private Director director;
    private HeadOfDepartment headOfDepertment;
    private Address address;
    private Staff staff;
    private List<Worker> workerList;
    private List<Administration> administationList;

    private String currentElement;
    private String currentAttribute;

    @Override
    public void startDocument() throws SAXException {

    }

    @Override
    public void startElement(String namespace, String localName, String qName, Attributes attr) throws SAXException {
        currentElement = qName;
        currentAttribute = attr.getValue(0);

        switch (currentElement) {

            case STAFF_TAG:
                this.staff = new Staff();
                break;
            case WORKERS_TAG:
                this.workerList = new ArrayList<>();
                break;
            case WORKER_TAG:
                switch (currentAttribute) {
                    case "driverCar":
                        this.worker = new DriverCar();
                        break;
                    case "storekeeper":
                        this.worker = new Storekeeper();
                        break;
                    case "logist":
                        this.worker = new Logist();
                        break;
                    default:
                        break;
                }
                break;
            case ADMINISTRATION_TAG:
                this.administationList = new ArrayList<>();
                break;
            case ADMIN_TAG:
                switch (currentAttribute) {
                    case "director":
                        this.adminisration = new Director();
                        break;
                    case "headOfDepartment":
                        this.adminisration = new HeadOfDepartment();
                        break;
                    default:
                        break;
                }
                break;
            case ADDRESS_TAG:
                this.address = new Address();
            default:
                break;
        }
    }

    @Override
    public void endElement(String namespace, String localName, String qName) throws SAXException {
        switch (qName) {
            case STAFF_TAG:
                break;
            case WORKERS_TAG:
                this.staff.setWorkerList(workerList);
                break;
            case WORKER_TAG:
                this.workerList.add(worker);
                this.worker = null;
                break;
            case ADMINISTRATION_TAG:
                this.staff.setAdministationList(administationList);
                break;
            case ADMIN_TAG:
                this.administationList.add(adminisration);
                this.adminisration = null;
                break;
            case ADDRESS_TAG:
                if(worker != null) {
                    this.worker.setAddress(address);
                }else {
                    this.adminisration.setAddress(address);
                }
                this.address = null;
                break;
            default:
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int end) {

        String text = new String(ch, start, end).trim();
        String a = String.valueOf(ch);
        if(text.isEmpty() || currentElement == null) {
            return;
        }
        switch (currentElement) {
            case NAME_TAG:
                if(worker != null)
                    this.worker.setName(text);
                else
                    this.adminisration.setName(text);
                break;
            case SURNAME_TAG:
                if(worker != null) {
                    this.worker.setSurname(text);
                }else {
                    this.adminisration.setSurname(text);
                }
                break;
            case ESTABLISHED_POST:
                if(worker != null) {
                    this.worker.setEstablishedPost(text);
                }else {
                    this.adminisration.setEstablishedPost(text);
                }
                break;
            case COUNTRY_TAG:
                this.address.setCountry(text);
                break;
            case CITY_TAG:
                this.address.setCity(text);
                break;
            case STREET_TAG:
                this.address.setStreet(text);
                break;
            case HOMENUMBER_TAG:
                this.address.setHomeNumber(text);
                break;
            case DATE_OF_BIRTH_TAG:
                if(worker != null) {
                    this.worker.setDateOfBirth(text);
                }else {
                    this.adminisration.setDateOfBirth(text);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        LOGGER.info("end");
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<Worker> workerList) {
        this.workerList = workerList;
    }

    public List<Administration> getAdministationList() {
        return administationList;
    }

    public void setAdministationList(List<Administration> administationList) {
        this.administationList = administationList;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Administration getAdminisration() {
        return adminisration;
    }

    public void setAdminisration(Administration adminisration) {
        this.adminisration = adminisration;
    }

    public DriverCar getDriverCar() {
        return driverCar;
    }

    public void setDriverCar(DriverCar driverCar) {
        this.driverCar = driverCar;
    }

    public Logist getLogist() {
        return logist;
    }

    public void setLogist(Logist logist) {
        this.logist = logist;
    }

    public Storekeeper getStorekeeper() {
        return storekeeper;
    }

    public void setStorekeeper(Storekeeper storekeeper) {
        this.storekeeper = storekeeper;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public HeadOfDepartment getHeadOfDepertment() {
        return headOfDepertment;
    }

    public void setHeadOfDepertment(HeadOfDepartment headOfDepertment) {
        this.headOfDepertment = headOfDepertment;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static String getNameTag() {
        return NAME_TAG;
    }

    public static String getEstablishedPost() {
        return ESTABLISHED_POST;
    }

    public static String getSurnameTag() {
        return SURNAME_TAG;
    }

    public static String getCountryTag() {
        return COUNTRY_TAG;
    }

    public static String getCityTag() {
        return CITY_TAG;
    }

    public static String getStreetTag() {
        return STREET_TAG;
    }

    public static String getHomenumberTag() {
        return HOMENUMBER_TAG;
    }

}
