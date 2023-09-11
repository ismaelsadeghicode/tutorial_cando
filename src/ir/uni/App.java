package ir.uni;

import ir.uni.model.User;
import ir.uni.service.Action;
import ir.uni.service.UserAction;
import ir.uni.service.UserActionImpl;

import java.util.*;

public class App {

    public static Set<User> users = new HashSet<>();
    public static int generateId = 0;

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        Map<Integer, String> actions = new LinkedHashMap<>();
        actions.put(1 , "create");
        actions.put(2 , "update");
        actions.put(3 , "delete");
        actions.put(4 , "read");
        actions.put(5 , "exit");

        Map<Integer, String> actionApp = new LinkedHashMap<>();
        actionApp.put(1, "admin");
        actionApp.put(2, "client");
        actionApp.put(3, "guest");
        actionApp.put(4, "exit");

        Map<Integer, User> userMap = new HashMap<>();


        while (true) {
            System.out.println("####### UNI #########");
            for (Map.Entry action: actions.entrySet()) {
                System.out.println(action.getKey() + "-" + action.getValue());
            }
            System.out.print("Enter action: ");

            int input = scanner.nextInt();

            int status = 0;
            UserAction userAction = new UserActionImpl();
            String username;
            String password;

            System.out.println("##################");
            switch (input) {

                case 1:
                    for (Map.Entry action: actionApp.entrySet()) {
                        System.out.println(action.getKey() + "-" + action.getValue());
                    }
                    int inp = scanner.nextInt();
                    System.out.println("##################");
                    switch (inp) {
                        case 1:
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
                            user.setId(++generateId);
                            userMap.put(user.getId() , user);
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
                    System.out.println("List Users: " + userAction.read());
                    for (User userData : userMap.values()) {
                        System.out.println(userData.getId() + "- " + userData.getUsername());
                    }
                    break;
            }

        }
    }
}