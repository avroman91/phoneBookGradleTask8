package org.example.phoneBook.menu;

import java.util.List;
import java.util.Scanner;

public class Menu {

    public Menu(List<MenuAction> actions) {
        this.actions = actions;
    }

    private Scanner scanner = new Scanner(System.in);
    private List<MenuAction> actions;

    private void printActions() {
        for (int i = 0; i < actions.size(); i++) {
            System.out.printf("%d - %s\n", i + 1, actions.get(i).getName());
        }
        System.out.printf("%d - exit\n", actions.size() + 1);
    }

    private int getChoice() {
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice - 1;
    }

    public void run() {
        while (true) {
            printActions();
            int choice = getChoice();
            if (choice < 0 || choice > actions.size()) {
                System.out.println("Incorrect choice");
                continue;
            }
            if (choice == actions.size()) {
                break;
            }
            actions.get(choice).doAction(scanner);
        }
    }

    public void addAction(MenuAction action) {
        actions.add(action);
    }

}
