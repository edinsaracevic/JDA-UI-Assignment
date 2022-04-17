package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Baza {

    public Connection connect() throws SQLException {
        Connection konekcija = DriverManager.getConnection(Konekcija.database, Konekcija.user, Konekcija.password);
        return konekcija;
    }

    public void insertPerson(Person person) throws SQLException {
        Connection konekcija = connect();
        Statement statement = konekcija.createStatement();
        String query = "insert into person values (null, '" + person.name + "','" + person.surname
                + "','" + person.age + "','" + person.address + "','" + person.salary + "')";
        statement.execute(query);
        statement.close();
        konekcija.close();
    }

    public void deletePerson(int id) throws SQLException {
        Connection konekcija = connect();
        Statement statement = konekcija.createStatement();
        String query = "delete from person where id = " + id;
        statement.execute(query);
        statement.close();
        konekcija.close();
    }

    public List<Person> searchPerson() throws SQLException {
        List persons = new ArrayList();

        Scanner scanner = new Scanner(System.in);
        String userIput = scanner.next();
        Connection konekcija = connect();
        Statement statement = konekcija.createStatement();
        String query = "select * from person where name like '%" +userIput+ "%' OR surname like '%" +userIput+ "%' OR address like '%" +
                userIput+ "%' OR age like '%" +userIput+ "%' OR salary like '%" + userIput + "%'";
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()) {
            Person person = new Person();
            person.id = rs.getInt("id");
            person.name = rs.getString("name");
            person.surname = rs.getString("surname");
            person.age = rs.getInt("age");
            person.address = rs.getString("address");
            person.salary = rs.getInt("salary");

            persons.add(person);
        }
        statement.close();
        konekcija.close();
        if(persons.isEmpty()){
            System.out.println("Nothing to show for that search");
        }
        return persons;
    }

    public void updatePerson(Person person) throws SQLException {
        Connection konekcija = connect();
        PreparedStatement ps = konekcija.prepareStatement("update person set name = ?, surname = ?, age = ?, address = ?, salary = ? where id = ?");
        ps.setString(1, person.name);
        ps.setString(2, person.surname);
        ps.setInt(3, person.age);
        ps.setString(4, person.address);
        ps.setInt(5, person.salary);
        ps.setInt(6, person.id);
        ps.execute();
        ps.close();
        konekcija.close();
    }

    public List<Person> getAllPersons() throws SQLException {
        List persons = new ArrayList();

        Connection konekcija = connect();
        Statement st = konekcija.createStatement();
        String query = "select * from person";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()) {
            Person person = new Person();
            person.id = rs.getInt("id");
            person.name = rs.getString("name");
            person.surname = rs.getString("surname");
            person.age = rs.getInt("age");
            person.address = rs.getString("address");
            person.salary = rs.getInt("salary");

            persons.add(person);
        }
        st.close();
        konekcija.close();
        return persons;
    }

    public Person getPerson(int id) throws SQLException {
        Person person = null;
        Connection konekcija = connect();

        PreparedStatement ps = konekcija.prepareStatement("select * from person where id = ?");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            person = new Person();
            person.id = rs.getInt("id");
            person.name = rs.getString("name");
            person.surname = rs.getString("surname");
            person.age = rs.getInt("age");
            person.address = rs.getString("address");
            person.salary = rs.getInt("salary");
        }
        rs.close();
        ps.close();
        konekcija.close();

        return person;
    }

}


