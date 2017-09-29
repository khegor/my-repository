package com.rocksoft.LogStr.db.main.all; /**
 * Created by Esenin on 26.08.2017.
 */

import java.sql.*;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Main {


    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) throws SQLException{

        BasicConfigurator.configure();

        /*try {
            Class.forName(Utils.getConfig("driver")).newInstance();
        } catch (Exception ex) {
            LOGGER.error("Driver registration error!");
            return;
        }*/

        /*try (Connection connection = DriverManager.getConnection(Utils.getConfig("url"), Utils.getConfig("username"), Utils.getConfig("password"));
              Statement statement = connection.createStatement()) {
            statement.execute("INSERT INTO mydb.DRIVER (NAME, SURNAME, ESTABLISHED_POST, ADDRESSES_ID, DATE_OF_BIRTH) VALUES (\"Sima\", \"Standartou\", \"driver\", 1, \"1992-08-05 18:19:03\");");
//            statement.execute("DELETE FROM mydb.driver WHERE ESTABLISHED_POST =\"Director\"");
//            statement.execute("INSERT INTO mydb.DRIVERS (NAME, SURNAME, ESTABLISHED_POST, ADDRESSES_ID, DATE_OF_BIRTH) VALUES (\"Oleg\", \"Green\", \"driver\", 7, \"1982-08-05\");");
        } catch (SQLException ex) {
            ex.printStackTrace();
            return;
        }*/
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