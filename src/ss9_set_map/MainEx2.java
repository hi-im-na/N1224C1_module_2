package ss9_set_map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainEx2 {
    private static final String TEXT = "đây là văn bản đếm số lần xuất hiện của các từ trong văn bản";

    private static void cauA() {
        Map<String, Integer> map = new HashMap<>();
        String[] words = TEXT.split(" ");
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        System.out.println(map);
    }

    private static void cauB() {
        List<String> list = List.of(TEXT.split(" "));
        Map<String, Integer> map = new HashMap<>();
        for (String word : list) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        System.out.println("unique words: ");
        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                System.out.println(key);
            }
        }

        System.out.println("words appear more than once: ");
        for (String key : map.keySet()) {
            if (map.get(key) > 1) {
                System.out.println(key);
            }
        }
    }

    public static void main(String[] args) {
        cauA();
        cauB();
    }
}
