package HomeWork.bai1;

import java.util.HashMap;

public class HashMapDictionary {
    private HashMap<String, String> dictionary;

    public HashMapDictionary() {
        dictionary = new HashMap<>();
    }

    public void add(String word, String meaning) {
        dictionary.put(word, meaning);
    }

    public String get(String word) {
        return dictionary.get(word);
    }

    public void remove(String word) {
        dictionary.remove(word);
    }

    public void print() {
        for (String key : dictionary.keySet()) {
            System.out.println(key + ": " + dictionary.get(key));
        }
    }

    public boolean checkContain(String word) {
        return dictionary.containsKey(word);
    }

    public void printWord(String word) {
        System.out.println(word + ": " + dictionary.get(word));
    }

    
}
