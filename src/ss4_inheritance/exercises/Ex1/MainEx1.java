package ss4_inheritance.exercises.Ex1;

import utils.InputCommonV2;
import utils.enums.CheckInputLimit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainEx1 {
    static InputCommonV2 ic = new InputCommonV2();
    static List<Phone> phoneList = new ArrayList<>();

    static {
        OldPhone oldPhone = new OldPhone("Samsung Galaxy S10", 1000, 1, Phone.Brand.SAMSUNG);
        NewPhone newPhone = new NewPhone("Samsung Galaxy S20", 2000, 2, Phone.Brand.SAMSUNG);
        newPhone.setQuantity(2);
        phoneList.add(oldPhone);
        phoneList.add(newPhone);
    }

    public static void main(String[] args) {
        try {
            displayMainMenu();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        ic.close();
    }

    public static boolean isIdFormat(String id) {
        return id.matches("(?i)DT[C|M]\\d{3}");
    }

    public static Phone getPhoneById(String id) {
        if (!isIdFormat(id)) {
            throw new IllegalArgumentException("Sai định dạng ID!");
        }
        for (Phone phone : phoneList) {
            if (phone.getId().equalsIgnoreCase(id)) {
                return phone;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy điện thoại với ID đã nhập!");
    }


    public static void displayMainMenu() {
        int choice;
        while (true) {
            System.out.println("\n -- CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI -- ");
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
                case 7 -> displayMenu7();
                case 8 -> displayMenu8();
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
                case 1 -> {
                    System.out.println("Sắp xếp tăng dần!");
                    phoneList.sort(Comparator.comparingDouble(Phone::getPrice));
//                    Collections.sort(phoneList);
                }
                case 2 -> {
                    System.out.println("Sắp xếp giảm dần!");
                    phoneList.sort((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice()));
//                    phoneList.sort(Collections.reverseOrder());
                }
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
                    displayMenu6_sub(choice);
                }
                case 2 -> {
                    System.out.println(" -- TÌM KIẾM ĐIỆN THOẠI CŨ -- ");
                    displayMenu6_sub(choice);
                }
                case 3 -> {
                    System.out.println(" -- TÌM KIẾM ĐIỆN THOẠI MỚI -- ");
                    displayMenu6_sub(choice);
                }
                case 4 -> {
                    return;
                }
            }
        }
    }

    public static void displayMenu6_sub(int choiceOfParent) {
        List<Phone> listToSearch = new ArrayList<>();
        switch (choiceOfParent) {
            case 1 -> listToSearch.addAll(phoneList);
            case 2 -> phoneList.forEach(p -> {
                if (p instanceof OldPhone) listToSearch.add(p);
            });
            case 3 -> phoneList.forEach(p -> {
                if (p instanceof NewPhone) listToSearch.add(p);
            });
        }

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
                case 1 -> {
                    System.out.println("Tìm kiếm theo gíá!");
                    System.out.print("Nhập giá từ: ");
                    double from = ic.checkNumberInput(Double.class, CheckInputLimit.MIN, 0D);
                    System.out.print("Nhập giá đến: ");
                    double to = ic.checkNumberInput(Double.class, CheckInputLimit.MIN, 0D);

                    List<Phone> result = new ArrayList<>();
                    for (Phone phone : listToSearch) {
                        if (phone.getPrice() >= from && phone.getPrice() <= to) {
                            result.add(phone);
                        }
                    }
                    System.out.println("Kết quả tìm kiếm: ");
                    result.forEach(Phone::display);
                }
                case 2 -> {
                    System.out.println("Tìm kiếm theo tên!");
                    System.out.print("Nhập tên điện thoại cần tìm: ");
                    String name = ic.checkInputString();
                    List<Phone> result = new ArrayList<>();
                    for (Phone phone : listToSearch) {
                        if (phone.getName().contains(name)) {
                            result.add(phone);
                        }
                    }
                    System.out.println("Kết quả tìm kiếm: ");
                    result.forEach(Phone::display);
                }
                case 3 -> {
                    System.out.println("Tìm kiếm theo hãng!");
                    System.out.println("Nhập hãng điện thoại cần tìm: ");
                    String brand = ic.checkInputString();
                    List<Phone> result = new ArrayList<>();
                    for (Phone phone : listToSearch) {
                        if (phone.getBrand().name().contains(brand)) {
                            result.add(phone);
                        }
                    }
                    System.out.println("Kết quả tìm kiếm: ");
                    result.forEach(Phone::display);
                }
                case 4 -> {
                    return;
                }
            }
        }
    }

    public static void displayMenu7() {
        double total = 0;
        for (Phone phone : phoneList) {
            total += phone.calculateTotalPrice();
        }
        System.out.println("Tổng tiền: " + total);
    }

    public static void displayMenu8() {
        System.out.println("Giảm giá cho điện thoại cũ!");
        try {
            System.out.print("Nhập ID điện thoại cần giảm giá: ");
            String id = ic.checkInputString();
            Phone phone = getPhoneById(id);
            if (phone instanceof OldPhone) {
                System.out.print("Nhập phần trăm giảm giá: ");
                double discountPercent = ic.checkNumberInput(Double.class, CheckInputLimit.MIN, 0D);
                ((OldPhone) phone).promotion(discountPercent);
                System.out.println("Giảm giá thành công!");
            } else {
                throw new IllegalArgumentException("ID đã nhập không phải của điện thoại cũ");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
