package hello18.线程安全;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

public class T6 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        Vector<String> vector = new Vector<>();
        vector.add("hello!");
        vector.add("world!");
        HashMap<String, String> map = new HashMap<>();
        map.put("hello", "world");
        map.put("hello!", "world!");
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("hello", "world");
        hashtable.put("hello!", "world!");
    }
}
