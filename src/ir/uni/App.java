package ir.uni;

import ir.uni.model.User;
import ir.uni.service.Action;
import ir.uni.service.UserAction;
import ir.uni.service.UserActionImpl;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {

    public static Set<User> users = new HashSet<>();

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("####### UNI #########");
            System.out.println();
            System.out.println("# 1- create");
            System.out.println("# 2- update");
            System.out.println("# 3- delete");
            System.out.println("# 4- read");
            System.out.println("# 5- exit");
            System.out.print("Enter action: ");
            int input = scanner.nextInt();

            int status = 0;
            UserAction userAction = new UserActionImpl();
            String username;
            String password;
            switch (input) {
                case 1:
                    System.out.println("##################");
                    System.out.println("1- admin");
                    System.out.println("2- client");
                    System.out.println("3- guest");
                    System.out.println("4- exit");

                    int inp = scanner.nextInt();
                    switch (inp) {
                        case 1:
                            System.out.println("##################");
                            System.out.print("Enter Your Username: ");
                            username = scanner.next();
                            System.out.println();
                            System.out.print("Enter Your Password: ");
                            password = scanner.next();
                            System.out.println();
                            User user = new User();
                            user.setUsername(username);
                            user.setPassword(password);
                            userAction.create(user);
                            break;
                        case 2:

                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            System.exit(0);
                            break;
                        default:
                            System.out.println(" action not found!");
                            break;

                    }
                    if (status == 4) {
                        break;
                    }
                    break;
                case 2:
                    System.out.println("List Users Before: " + userAction.read());
                    User user = new User();
                    System.out.println("##################");
                    System.out.print("Enter Your Username: ");
                    username = scanner.next();
                    System.out.println();
                    System.out.print("Enter Your Username: ");
                    password = scanner.next();
                    user.setUsername(username);
                    user.setPassword(password);
                    userAction.update(user);
                    System.out.println("List Users After: " + userAction.read());
                    break;
                case 3:
                    System.out.println("List Users Before: " + userAction.read());
                    System.out.println("##################");
                    System.out.print("Enter Your Username: ");
                    username = scanner.next();
                    User user1 = (User) userAction.findByUsername(username);
                    userAction.delete(user1);

                    System.out.println("List Users After: " + userAction.read());
                    break;
                case 4:
                    System.out.println("List Usewrs: " + userAction.read());
                    break;
            }

        }
    }
}