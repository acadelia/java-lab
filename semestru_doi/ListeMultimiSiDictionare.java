package semestru_doi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class ListeMultimiSiDictionare {
  public static void main(String[] args) {
    // Listă de tip ArrayList
    List<String> arrayList = new ArrayList<>();
    arrayList.add("Obiect1");
    arrayList.add("Obiect2");
    arrayList.add("Obiect3");
    arrayList.add("Obiect4");
    arrayList.add("Obiect5");

    // Listă de tip LinkedList
    List<String> linkedList = new LinkedList<>(arrayList);

    // Sortare automată cu Comparator
    Collections.sort(arrayList, Comparator.reverseOrder());

    // Afisare utilizând Iterator
    System.out.println("ArrayList:");
    Iterator<String> arrayListIterator = arrayList.iterator();
    while (arrayListIterator.hasNext()) {
      System.out.println(arrayListIterator.next());
    }

    // Afisare utilizând for-each
    System.out.println("\nLinkedList:");
    for (String item : linkedList) {
      System.out.println(item);
    }

    // Utilizare Comparator pentru sortare
    TreeSet<String> treeSet = new TreeSet<>(Comparator.reverseOrder());
    treeSet.addAll(arrayList);

    // Utilizare HashSet
    HashSet<String> hashSet = new HashSet<>(arrayList);

    // Utilizare HashMap
    HashMap<Integer, String> hashMap = new HashMap<>();
    hashMap.put(1, "Valoare1");
    hashMap.put(2, "Valoare2");
    hashMap.put(3, "Valoare3");

    // Utilizare TreeMap
    TreeMap<Integer, String> treeMap = new TreeMap<>(hashMap);

    // Afisare HashMap
    System.out.println("\nHashMap:");
    for (Integer key : hashMap.keySet()) {
      System.out.println(key + ": " + hashMap.get(key));
    }

    // Afisare TreeMap
    System.out.println("\nTreeMap:");
    for (Integer key : treeMap.keySet()) {
      System.out.println(key + ": " + treeMap.get(key));
    }
  }
}
