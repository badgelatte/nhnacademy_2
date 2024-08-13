package hash_0813;

import java.util.HashMap;
import java.util.Map;

public class Exam6_1 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        System.out.println("count =" + map.size());
        map.put("Tag", "day");
        System.out.println("count =" + map.size());

        map.put("Hut", "hat");
        map.put("Uhr", "clock");
        map.put("Rad", "wheel");
        map.put("Ohr", "ear");
        map.put("Tor", "gate");
        System.out.println("map =" + map);
        System.out.println("count =" + map.size());
        System.out.println("map.keySet()=" + map.keySet());
        System.out.println("map.values()=" + map.values());
        System.out.println("map.get(\"Uhr\")=" + map.get("Uhr"));
        System.out.println("map.get(\"Rad\")=" + map.get("Rad"));
        System.out.println("map.remove(\"Rad\")=" + map.remove("Rad"));
        System.out.println("map.get(\"Rad\")=" + map.get("Rad"));
        System.out.println("map=" + map);
        System.out.println("map.size()=" + map.size());
        map.put("Uhr", "uhr");
        System.out.println("map=" + map);
        System.out.println("map.size()=" + map.size());
    }
}
