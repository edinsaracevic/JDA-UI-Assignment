package control;

import db.Baza;
import db.Person;
import ui.Ui;

import java.sql.SQLException;
import java.util.List;

public class Controller {

    public Baza db;
    public Ui ui;

    public void showPersons() throws SQLException {
        List allPersons = db.getAllPersons();
        System.out.println(
                "id" +
                "\tname       " +
                "\tsurname  " +
                "\tage   " +
                "\tsalary    " +
                "\taddress");
        System.out.println("---------------------------------------------------------------------------------");
        for(Object object : allPersons){
            Person person = (Person) object;
            System.out.println(person);
        }
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println();
    }

    public void searchPersons() throws SQLException {
        List searchPerson = db.searchPerson();
        System.out.println(
                "id" +
                        "\tname       " +
                        "\tsurname  " +
                        "\tage   " +
                        "\tsalary    " +
                        "\taddress");
        System.out.println("---------------------------------------------------------------------------------");
        for(Object object : searchPerson){
            Person person = (Person) object;
            System.out.println(person);
        }
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println();
    }

    public void addPerson() throws SQLException {
        Person toAdd = ui.getPerson();
        db.insertPerson(toAdd);
    }

    public void deletePerson() throws SQLException {
        int id = ui.getPersonId();
        db.deletePerson(id);
    }

    public void updatePerson() throws SQLException {
        int id = ui.getPersonId();
        Person personToUpdate = db.getPerson(id);
        if(personToUpdate == null) {
            System.out.println("Person doesn't exist in database");
            return;
        } else {
            ui.updatePerson(personToUpdate);
            db.updatePerson(personToUpdate);
        }
    }

}
