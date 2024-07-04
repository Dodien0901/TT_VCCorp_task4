package com.example.vccorp_task4;

import com.example.vccorp_task4.controller.UserController;
import com.example.vccorp_task4.model.User;

import java.util.List;

import java.util.Scanner;

public class Main {
    private static UserController userController = new UserController();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = getIntInput("Nhập lựa chọn của bạn: ");
            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    deleteUser();
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    findUserById();
                    break;
                case 5:
                    findUsersByName();
                    break;
                case 6:
                    findUsersByAddress();
                    break;
                case 7:
                    findAllUsers();
                    break;
                case 8:
                    exit = true;
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Thêm người dùng");
        System.out.println("2. Xóa người dùng");
        System.out.println("3. Cập nhật người dùng");
        System.out.println("4. Tìm người dùng theo ID");
        System.out.println("5. Tìm người dùng theo tên");
        System.out.println("6. Tìm người dùng theo địa chỉ");
        System.out.println("7. Hiển thị tất cả người dùng");
        System.out.println("8. Thoát");
    }

    private static void addUser() {
        System.out.println("\n--- THÊM NGƯỜI DÙNG ---");
        String name = getStringInput("Nhập tên: ");
        String address = getStringInput("Nhập địa chỉ: ");
        int age = getIntInput("Nhập tuổi: ");

        User newUser = new User();
        newUser.setName(name);
        newUser.setAddress(address);
        newUser.setAge(age);

        userController.addUser(newUser);
    }

    private static void deleteUser() {
        System.out.println("\n--- XÓA NGƯỜI DÙNG ---");
        int id = getIntInput("Nhập ID người dùng cần xóa: ");
        userController.deleteUser(id);
    }

    private static void updateUser() {
        System.out.println("\n--- CẬP NHẬT NGƯỜI DÙNG ---");
        int id = getIntInput("Nhập ID người dùng cần cập nhật: ");
        User user = userController.findById(id);
        if (user != null) {
            String name = getStringInput("Nhập tên mới (để trống nếu không thay đổi): ");
            String address = getStringInput("Nhập địa chỉ mới (để trống nếu không thay đổi): ");
            int age = getIntInput("Nhập tuổi mới (nhập 0 nếu không thay đổi): ");

            if (!name.isEmpty()) user.setName(name);
            if (!address.isEmpty()) user.setAddress(address);
            if (age != 0) user.setAge(age);

            userController.updateUser(user);
        } else {
            System.out.println("Không tìm thấy người dùng với ID " + id);
        }
    }

    private static void findUserById() {
        System.out.println("\n--- TÌM NGƯỜI DÙNG THEO ID ---");
        int id = getIntInput("Nhập ID người dùng cần tìm: ");
        User user = userController.findById(id);
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("Không tìm thấy người dùng với ID " + id);
        }
    }

    private static void findUsersByName() {
        System.out.println("\n--- TÌM NGƯỜI DÙNG THEO TÊN ---");
        String name = getStringInput("Nhập tên cần tìm: ");
        List<User> users = userController.findByName(name);
        displayUsers(users);
    }

    private static void findUsersByAddress() {
        System.out.println("\n--- TÌM NGƯỜI DÙNG THEO ĐỊA CHỈ ---");
        String address = getStringInput("Nhập địa chỉ cần tìm: ");
        List<User> users = userController.findByAddress(address);
        displayUsers(users);
    }

    private static void findAllUsers() {
        System.out.println("\n--- TẤT CẢ NGƯỜI DÙNG ---");
        List<User> users = userController.findAllSortedByName();
        displayUsers(users);
    }

    private static void displayUsers(List<User> users) {
        if (users.isEmpty()) {
            System.out.println("Không tìm thấy người dùng nào.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
            }
        }
    }
}