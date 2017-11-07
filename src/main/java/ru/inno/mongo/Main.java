package ru.inno.mongo;

import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException {
        Scanner scanner = new Scanner(System.in);
        MongoManager.init();
        String query;
        while (true) {
            String command = scanner.nextLine();
            switch (command) {
                case "insert":
                    MongoManager.insert();
                    break;
                case "delete":
//                    query = scanner.nextLine();
                    MongoManager.delete("Sara Conor");
                    break;
                case "find":
//                    query = scanner.nextLine();
                    MongoManager.find("Sara Conor");
                    break;
                case "update":
//                    query = scanner.nextLine();
                    MongoManager.update("Sara Conor", 60);
                    break;
                default : return;

            }
        }
    }
}
