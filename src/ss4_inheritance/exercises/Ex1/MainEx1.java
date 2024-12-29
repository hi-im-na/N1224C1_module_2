package ss4_inheritance.exercises.Ex1;

import utils.InputCommonV2;

import java.util.ArrayList;
import java.util.List;

public class MainEx1 {
    static InputCommonV2 ic = new InputCommonV2();
    static List<Phone> phoneList = new ArrayList<>();

    public static void main(String[] args) {
        Phone oldPhone = new OldPhone();
        Phone newPhone = new NewPhone();
        phoneList.add(oldPhone);
        phoneList.add(newPhone);

        try {
            displayMainMenu();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        ic.close();
    }

    public static boolean isIdFormat(String id) {
        return id.matches("DT[C|M]\\d{3}");
    }

    public static Phone getPhoneById(String id) {
        if (!isIdFormat(id)) {
            throw new IllegalArgumentException("Invalid phone ID format!");
        }
        for (Phone phone : phoneList) {
            if (phone.getId().equals(id)) {
                return phone;
            }
        }
        return null;
    }


    public static void displayMainMenu() {
        int choice;
        while (true) {
            System.out.println(" -- CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI -- ");
            System.out.println(" 1. Xem danh sách điện thoại");
            System.out.println(" 2. Thêm mới");
            System.out.println(" 3. Cập nhật");
            System.out.println(" 4. Xóa");
            System.out.println(" 5. Sắp xếp theo giá");
            System.out.println(" 6. Tìm kiếm");
            System.out.println(" 7. Tính tổng tiền");
            System.out.println(" 8. Giảm giá cho điện thoại cũ");
            System.out.println(" 9. Thoát");
            System.out.println("---------------------------------");
            System.out.print("Chọn chức năng: ");
            choice = ic.checkNumberInput(Integer.class, 1, 9);

            switch (choice) {
                case 1 -> displayMenu1();
                case 2 -> displayMenu2();
                case 3 -> displayMenu3();
                case 4 -> displayMenu4();
                case 5 -> displayMenu5();
                case 6 -> displayMenu6();
                case 7 -> System.out.println("Tính tổng tiền");
                case 8 -> System.out.println("Giảm giá cho điện thoại cũ");
                case 9 -> {
                    return;
                }

            }
        }
    }

    public static void displayMenu1() {
        int choice;
        while (true) {
            System.out.println(" -- XEM DANH SÁCH ĐIỆN THOẠI -- ");
            System.out.println("1. Xem tất cả");
            System.out.println("2. Xem điện thoại cũ");
            System.out.println("3. Xem điện thoại mới");
            System.out.println("4. Trở về menu chính");
            System.out.println("---------------------------------");
            System.out.print("Chọn chức năng: ");
            choice = ic.checkNumberInput(Integer.class, 1, 4);

            switch (choice) {
                case 1 -> {
                    System.out.println("Xem tất cả!");
                    System.out.printf("| %-10s | %-20s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |\n", "ID", "Tên", "Giá", "Bảo hành", "Hãng", "Số lượng", "TT pin", "Mô tả");
                    for (Phone phone : phoneList) {
                        phone.display();
                    }
                }
                case 2 -> {
                    System.out.println("Xem điện thoại cũ!");
                    System.out.printf("| %-10s | %-20s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |\n", "ID", "Tên", "Giá", "Bảo hành", "Hãng", "Số lượng", "TT pin", "Mô tả");
                    for (Phone phone : phoneList) {
                        if (phone instanceof OldPhone) {
                            phone.display();
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Xem điện thoại mới!");
                    System.out.printf("| %-10s | %-20s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |\n", "ID", "Tên", "Giá", "Bảo hành", "Hãng", "Số lượng", "TT pin", "Mô tả");
                    for (Phone phone : phoneList) {
                        if (phone instanceof NewPhone) {
                            phone.display();
                        }
                    }
                }
                case 4 -> {
                    return;
                }
            }
        }
    }

    public static void displayMenu2() {
        int choice;
        while (true) {
            System.out.println(" -- THÊM MỚI -- ");
            System.out.println("1. Thêm mới điện thoại cũ");
            System.out.println("2. Thêm mới điện thoại mới");
            System.out.println("3. Trở về menu chính");
            System.out.println("---------------------------------");
            System.out.print("Chọn chức năng: ");
            choice = ic.checkNumberInput(Integer.class, 1, 3);

            switch (choice) {
                case 1 -> {
                    System.out.println("Thêm mới điện thoại cũ!");
                    Phone oldPhone = new OldPhone();
                    oldPhone.editInfo(ic);
                    phoneList.add(oldPhone);
                }
                case 2 -> {
                    System.out.println("Thêm mới điện thoại mới!");
                    Phone newPhone = new NewPhone();
                    newPhone.editInfo(ic);
                    phoneList.add(newPhone);
                }
                case 3 -> {
                    return;
                }
            }
        }
    }

    public static void displayMenu3() {
        System.out.println("Cập nhật");
        try {
            System.out.print("Nhập ID điện thoại cần cập nhật: ");
            String id = ic.checkInputString();
            Phone phone = getPhoneById(id);
            if (phone == null) {
                throw new IllegalArgumentException("Phone not found!");
            }
            phone.editInfo(ic);
            System.out.println("Cập nhật thành công!");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void displayMenu4() {
        System.out.println("Xóa");
        try {
            System.out.print("Nhập ID điện thoại cần xóa: ");
            String id = ic.checkInputString();
            Phone phone = getPhoneById(id);
            if (phone == null) {
                throw new IllegalArgumentException("Phone not found!");
            }
            phoneList.remove(phone);
            System.out.println("Xóa thành công!");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void displayMenu5() {
        int choice;
        while (true) {
            System.out.println(" -- SẮP XẾP THEO GIÁ -- ");
            System.out.println("1. Tăng dần");
            System.out.println("2. Giảm dần");
            System.out.println("3. Trở về menu chính");
            System.out.println("---------------------------------");
            System.out.print("Chọn chức năng: ");
            choice = ic.checkNumberInput(Integer.class, 1, 3);

            switch (choice) {
                case 1 -> System.out.println("Sắp xếp tăng dần!");
                case 2 -> System.out.println("Sắp xếp giảm dần!");
                case 3 -> {
                    return;
                }
            }
        }
    }

    public static void displayMenu6() {
        int choice;
        while (true) {
            System.out.println(" -- TÌM KIẾM -- ");
            System.out.println("1. Tìm kiếm tất cả điện thoại");
            System.out.println("2. Tìm kiếm điện thoại cũ");
            System.out.println("3. Tìm kiếm điện thoại mới");
            System.out.println("4. Trở về menu chính");
            System.out.println("---------------------------------");
            System.out.print("Chọn chức năng: ");
            choice = ic.checkNumberInput(Integer.class, 1, 4);

            switch (choice) {
                case 1 -> {
                    System.out.println(" -- TÌM KIẾM TẤT CẢ ĐIỆN THOẠI -- ");
                    displayMenu6_sub();
                }
                case 2 -> {
                    System.out.println(" -- TÌM KIẾM ĐIỆN THOẠI CŨ -- ");
                    displayMenu6_sub();
                }
                case 3 -> {
                    System.out.println(" -- TÌM KIẾM ĐIỆN THOẠI MỚI -- ");
                    displayMenu6_sub();
                }
                case 4 -> {
                    return;
                }
            }
        }
    }

    public static void displayMenu6_sub() {
        int choice;
        while (true) {
            System.out.println("1. Tìm kiếm theo gíá (Nhập khoảng từ bao nhiêu đến bao nhiêu)");
            System.out.println("2. Tìm kiếm theo tên");
            System.out.println("3. Tìm kiếm theo hãng");
            System.out.println("4. Trở về menu tìm kiếm");
            System.out.println("---------------------------------");
            System.out.print("Chọn chức năng: ");
            choice = ic.checkNumberInput(Integer.class, 1, 4);

            switch (choice) {
                case 1 -> System.out.println("Tìm kiếm theo gíá!");
                case 2 -> System.out.println("Tìm kiếm theo tên!");
                case 3 -> System.out.println("Tìm kiếm theo hãng!");
                case 4 -> {
                    return;
                }
            }
        }
    }
}
