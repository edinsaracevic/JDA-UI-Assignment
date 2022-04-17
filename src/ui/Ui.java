package ui;

import db.Person;

import java.util.Scanner;

public class Ui {
    public final static int ic = 0;
    public final static int showPersons = 1;
    public final static int addPerson = 2;
    public final static int updatePerson = 3;
    public final static int deletePerson = 4;
    public final static int searchPerson = 5;
    public final static int exitProgram = 6;

    public int menu() {
        System.out.println("" + showPersons + " - Show Persons, " + addPerson + " - Add Person, " + updatePerson +
                " - Update Person, " + deletePerson + " - Delete Person, " + searchPerson + " - Search Person, " + exitProgram + " - Exit Program");

        Scanner scanner = new Scanner(System.in);
        int menuSelected = 0;
        while(true){
            try{
                menuSelected = Integer.parseInt(scanner.nextLine());

                if (menuSelected < 1 || menuSelected > 6){
                    System.out.println("That menu item doesn't exist, chose another option");
                    continue;
                }break;
            } catch (NumberFormatException e) {
                System.out.println("Enter valid number");
            }
        }
        return menuSelected;
    }

    public int getPersonId(){
        System.out.println("Insert ID of a person");

        Scanner scanner = new Scanner(System.in);
        int selectedId = 0;
        while(true) {
            try {
                selectedId = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please, enter valid id");
            }
        }
        return selectedId;
    }

    public Person getPerson() {
        Person p = new Person();
        Scanner scanner = new Scanner(System.in);

        while(p.name == null) {
            System.out.println("Enter name");
            String name = scanner.nextLine();
            if(name.isEmpty()) {
                System.out.println("name can't be empty");
                continue;
            }
            p.name = name;

            System.out.println("Enter surname");
            p.surname = scanner.nextLine();

            System.out.println("Enter age");
            String ageInput = scanner.nextLine();
            if(isValidNumber(ageInput)) {
                p.age = Integer.parseInt(ageInput);
                continue;
            } else if (!isValidNumber(ageInput)){
                System.out.println("Please provide a valid number");
                break;
            }

            System.out.println("Enter address");
            p.address = scanner.nextLine();

            System.out.println("Enter salary");
            String salaryInput = scanner.nextLine();
            if(isValidNumber(salaryInput)) {
                p.salary = Integer.parseInt(salaryInput);
            } else if (!isValidNumber(salaryInput)){
                System.out.println("Please provide a valid number");
                break;
            }
        }
        return p;
    }

    static boolean isValidNumber(String x) {
        try {
            return (Integer.parseInt(x) < 999);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void updatePerson(Person person) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name");
        String name = scanner.nextLine();
        if(!name.isEmpty()) {
            person.name = name;
        }

        System.out.println("Enter surname");
        String surname = scanner.nextLine();
        if(!surname.isEmpty()) {
            person.surname = surname;
        }

        System.out.println("Enter age");
        String age = scanner.nextLine();
        if(!age.isEmpty()) {
            person.age = Integer.parseInt(age);
        }

        System.out.println("Enter address");
        String address = scanner.nextLine();
        if(!address.isEmpty()) {
            person.address = address;
        }

        System.out.println("Enter salary");
        String salary = scanner.nextLine();
        if(!salary.isEmpty()) {
            person.salary = Integer.parseInt(salary);
        }
    }
}
