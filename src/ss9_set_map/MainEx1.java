package ss9_set_map;

import utils.InputCommonV3;
import utils.enums.CheckInputLimit;

import java.util.*;

public class MainEx1 {

    public static void main(String[] args) {
        try (InputCommonV3 ic = InputCommonV3.getInstance()) {
            System.out.print("Nhập số phần tử của mảng:");
            int n = ic.checkNumberInput(Integer.class, CheckInputLimit.MIN, 1);
            Integer[] arr = new Integer[n];
            System.out.println("Nhập vào 1 mảng số nguyên:");
            for (int i = 0; i < n; i++) {
                System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
                arr[i] = ic.checkNumberInput(Integer.class);
            }

            System.out.println("Mảng số nguyên vừa nhập:");
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }


            Set<Integer> treeSet = new TreeSet<>() {{
                for (int i = 0; i < n; i++) {
                    add(arr[i]);
                }
            }};

            System.out.print("\nCác phần tử trong set:");
            for (Integer i : treeSet) {
                System.out.print(i + " ");
            }

            List<Integer> list = new ArrayList<>(treeSet);

            System.out.println("\nTổng các phần tử trong set: " + list.stream().reduce(0, (integer, integer2) -> integer + integer2));
            System.out.println("Phần tử nhỏ nhất trong set: " + list.getFirst());
            System.out.println("Phần tử lớn nhất trong set: " + list.getLast());

            // tao 2 set
            Set<Integer> set1 = Set.of(1, 2, 3, 4, 5);
            Set<Integer> set2 = Set.of(4, 5, 6, 7, 8);

            // giao cua 2 set
            Set<Integer> intersection = new HashSet<>(set1);
            intersection.retainAll(set2);
            System.out.println("Giao của 2 set: " + intersection);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
