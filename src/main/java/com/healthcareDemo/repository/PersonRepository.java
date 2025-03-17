package com.healthcareDemo.repository;

import com.healthcareDemo.model.Person;
import com.healthcareDemo.service.ConnectionService;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

    private static Connection connection = null;

    private void initConnection() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection = new ConnectionService().getConnection();
        }
    }

    List<Person> personList = new ArrayList<>();

    public boolean addPerson(Person person)  {
        try {
            this.initConnection();
            Statement statement = connection.createStatement();
            return statement.execute("insert into person (personId, type, firstName, lastName, age," +
                    " gender, contactNo, alternateMobile, address) values " +
                    "("+person.getPersonId()+", '"+person.getType()+"', '"+person.getFirstName()+"', " +
                    "'"+person.getLastName()+"', "+person.getAge()+", '"+person.getGender()+"', "+person.getContactNo()+", "+person.getAlternateMobile()+", '"+person.getAddress()+"')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            //close the connection
            if(connection!= null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("connection is closed: "+e.getMessage());
                }
            }
        }

    }

    public List<Person> viewPerson(Person person) {

        List<Person> people = new ArrayList<>();

        try{
            this.initConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet =statement.executeQuery("select * from person");
            while(resultSet.next()){
                int personId = resultSet.getInt("personId");
                String type = resultSet.getString("type");
                String firstName =resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                Long contactNo = resultSet.getLong("contactNo");
                Long alternateMobile = resultSet.getLong("alternateMobile");
                String address = resultSet.getString("address");
                people.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(connection!=null){
                try{
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("connection is closed: "+e.getMessage());
                }
            }
        }

        return people;
    }

    public boolean deletePerson(int personId) throws SQLException {

        Person person = null;
        try{
            this.initConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("delete from person where personId= "+personId);
        }catch (SQLException e){
            System.err.println("connection is closed: "+e.getMessage());
        }
       return false;
    }
}