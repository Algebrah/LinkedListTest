package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
LinkedList<String> linkedList = new LinkedList<>();
        addInOrder(linkedList, "Justin");
        addInOrder(linkedList, "Josephine");
        addInOrder(linkedList, "Percival");
        addInOrder(linkedList, "Sabrina");
        addInOrder(linkedList, "Yoshi");
        addInOrder(linkedList, "Mario");

        visit(linkedList);
    }

    private static void printLinkedList(LinkedList<String> linkedList) {
        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println("Family Member: " + iterator.next());
        }
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                System.out.println(newCity + " is already included in list");
                return false;
            } else if (comparison > 0) {
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0) {
                //carry on
            }

        }
        stringListIterator.add(newCity);
        return true;
    }

    public static void visit(LinkedList items) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = items.listIterator();

        if (items.isEmpty()) {
            System.out.println("This list is empty");
            return;
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Visiting is over");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward) {
                       if(listIterator.hasNext()) {
                           listIterator.next();
                       }
                       goingForward=true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("You are visiting " + listIterator.next());
                    } else {
                        System.out.println("You've reached the end of the list.");
                        goingForward=false;
                    }
                    break;
                case 2:
                    if(goingForward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("You are visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }

    }

    private static void printMenu() {
        System.out.println("Available Actions");
        System.out.println("0 - to quit \n" +
                "1 - go to the next position \n" +
                "2 - go to the previous position \n" +
                "3 - print menu options");
    }
}