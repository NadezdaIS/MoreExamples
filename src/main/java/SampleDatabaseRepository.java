import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.sql.DriverManager;

public class SampleDatabaseRepository {
    PropertiesConfiguration databaseProperties = new PropertiesConfiguration();
    private String someClassProperty;

    // some other kinds of variables and properties here


    public SampleDatabaseRepository(){

        try {
            databaseProperties.load("database.properties");
            String pass = databaseProperties.getString("database.password");
            String user = databaseProperties.getString("database.user");
            String host = databaseProperties.getString("database.host");
            String port = databaseProperties.getString("database.port");
            String dbName = databaseProperties.getString("database.name");

            String connectionUrl = host + ":" + port + "/" + dbName;

            // for example you can make connecting to sql using all information
            // from file, and each team member can have own copy of properties.configuration file

            //DriverManager.getConnection(connectionUrl, user, pass);

            System.out.println(connectionUrl);
            System.out.println("user: " + user);
            System.out.println("pass: " + pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void doSomething() {
        try {
            this.databaseProperties.load("database.properties");
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }
        String pass = databaseProperties.getString("database.password");
        String user = databaseProperties.getString("database.user");

        this.someClassProperty = databaseProperties.getString("database.user");
        System.out.println(pass + user);

        this.doSomethingElse(user, pass);
    }

    private void doSomethingElse(String user, String pass) {
        System.out.println(user + pass + this.someClassProperty);
    }

}

