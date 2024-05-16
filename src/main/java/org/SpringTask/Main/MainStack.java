package org.SpringTask.Main;

import org.SpringTask.Bean.Demo_Stack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class MainStack {
    public static void main(String[] args) {
        Logger log = (Logger) LogManager.getLogger(MainStack.class);

        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Demo_Stack DS = (Demo_Stack) context.getBean("StackBean");
        log.info("log working");
        try {


            Scanner input = new Scanner(System.in);
            System.out.print("Enter stack capacity: ");
            int capacity = input.nextInt();
            DS.setCapacity(capacity);

            System.out.println("Enter numbers to push onto the stack:");
            for (int i = 0; i < capacity; i++) {
                DS.push(input.nextInt());
            }

            DS.displayStack();

            System.out.println("Performing stack operations:");
            System.out.println("1. Pop");
            System.out.println("2. Remove element at index");
            System.out.println("3. Exit");

            int choice;
            do {
                System.out.print("Enter choice: ");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        DS.pop();
                        DS.displayStack();
                        break;
                    case 2:
                        System.out.print("Enter index to remove: ");
                        System.out.println("Index Count Start from 0");
                        int indexToRemove = input.nextInt();
                        DS.removeAtIndex(indexToRemove);
                        DS.displayStack();
                        break;
                    case 3:
                        System.out.println("Exiting program.");
                        DS.displayStack();
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                        break;
                }
            } while (choice != 3);
        }catch (Exception e){
            System.out.println("Exception:- "+e);
            new MainStack().main(args);
        }
    }
}
