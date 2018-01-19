package org.shilshar;

import java.util.NavigableMap;
import java.util.TreeMap;

public class Contacts {

    private static TreeMap<String, String> contacts = new TreeMap<>();

    public static void add(String name, String number) {
        contacts.put(name, number);
    }

    public static int find(String partial) {
        int count = 0;
        NavigableMap<String, String> contactsSubMap = contacts;
        while (contactsSubMap != null) {
            String match = contactsSubMap.ceilingKey(partial);
            if (match.startsWith(partial)) {
                count++;
                contactsSubMap = contactsSubMap.subMap(match, false, contactsSubMap.lastKey(), true);
            }
            else break;
        }
        return count;
    }

    public static void main(String args[]) {
        add("Shilpa", "1234");
        add("Varun", "5678");
        add("Shi", "5678");
        System.out.println("Count of partial matches: " + find("Shi"));
    }

}
