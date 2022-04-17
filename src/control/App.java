package control;

import db.Baza;
import ui.Ui;

import java.sql.SQLException;

public class App {

    public static void launch() throws SQLException {
        System.out.println("Created by Edin Saračević for Java Data Access Assignment");
        System.out.println("Starting application...");

        Controller controller = new Controller();

        controller.db = new Baza();
        controller.ui = new Ui();

        mainLoop:
        while (true) {
            switch (controller.ui.menu()) {

                case Ui.showPersons:
                    controller.showPersons();
                    break;
                case Ui.addPerson:
                    controller.addPerson();
                    break;
                case Ui.updatePerson:
                    controller.updatePerson();
                    break;
                case Ui.deletePerson:
                    controller.deletePerson();
                    break;
                case Ui.searchPerson:
                    System.out.println("Enter value you want to search");
                    controller.searchPersons();
                    break;
                case Ui.exitProgram:
                    System.out.println("Closing application... Bye");
                    System.exit(0);
                    break mainLoop;

            }
        }
    }
}
