package com.rocksoft.LogStr; /**
 * Created by Esenin on 26.08.2017.
 */

import java.io.File;

import java.io.IOException;
import java.sql.*;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.fabric.jdbc.FabricMySQLConnection;
import com.mysql.fabric.jdbc.FabricMySQLDriver;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.xml.sax.SAXException;

public class Main {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false";

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) throws SQLException{

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException ex) {
            LOGGER.error("Driver registration error!");
            return;
        }

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
              Statement statement = connection.createStatement()) {
//            statement.execute("INSERT INTO mydb.DRIVER (NAME, SURNAME, ESTABLISHED_POST, ADDRESSES_ID, DATE_OF_BIRTH) VALUES (\"Sima\", \"Standartou\", \"driver\", 1, \"1992-08-05 18:19:03\");");
//            statement.execute("DELETE FROM mydb.driver WHERE ESTABLISHED_POST =\"Director\"");
            statement.execute("INSERT INTO mydb.DRIVER (NAME, SURNAME, ESTABLISHED_POST, ADDRESSES_ID, DATE_OF_BIRTH) VALUES (\"Oleg\", \"Green\", \"driver\", 6, \"1982-08-05\");");
        } catch (SQLException ex) {
            ex.printStackTrace();
            return;
        }
//        BasicConfigurator.configure();
//        File xml = new File("src/main/resources/com/rocksoft/LogStr/log.xml");
//        SAXParserFactory parserF = SAXParserFactory.newInstance();
//        Handler handler = new Handler();
//        try {
//            SAXParser saxparser = parserF.newSAXParser();
//            saxparser.parse(xml, handler);
//            List<Worker> workerList = handler.getWorkerList();
//            LOGGER.info("SAX:");
//            for (Worker worker : workerList) {
//                LOGGER.info(worker);
//            }
//            List<Administration> administrationList = handler.getAdministationList();
//            for (Administration administration : administrationList) {
//                LOGGER.info(administration);
//            }
//        } catch (ParserConfigurationException | SAXException | IOException e) {
//            LOGGER.error(e);
//        }
//        try {
//            JAXBContext jaxbContext = JAXBContext.newInstance(Staff.class);
//            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//            Staff staff = (Staff) unmarshaller.unmarshal(xml);
//            LOGGER.info("JAXB:");
//            for (Worker worker : staff.getWorkerList()) {
//                LOGGER.info(worker);
//            }
//            for (Administration administration : staff.getAdministationList()) {
//                LOGGER.info(administration);
//            }
//        } catch (JAXBException e) {
//            LOGGER.error(e);
//        }
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            Staff staff = mapper.readValue(new File("src/main/resources/com/rocksoft/LogStr/logstr.json"), Staff.class);
//            LOGGER.info("JACKSON:");
//            for (Worker worker : staff.getWorkerList()) {
//                LOGGER.info(worker);
//            }
//            for (Administration administration : staff.getAdministationList()) {
//                LOGGER.info(administration);
//            }
//        } catch (IOException e) {
//            LOGGER.error(e);
//        }

    }
}