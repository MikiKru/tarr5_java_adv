package collections;

import java.util.*;

public class JavaCollectionsExample {
    // pola globalne
    private List<String> names = new ArrayList<>(Arrays.asList("Jan","Ala","Ola","Ela","Ala"));

    public void arrayOperations(){
        try {       // między nawiasami wprowadzamy kod, który może generować wyjątek
            // utworzenie tablicy 10-cio elementowej
            String[] names = new String[10];
            int[] numbers = {1, 2, 3, 4};
            System.out.println("Tablica nazw:");
            Arrays.stream(names)                      // zamiana tablicy na stream
                    .forEach(s -> System.out.print(s + ", ")); // dla każdego elementu wykonaj predykat (CTRL + Space)
            System.out.println("\nTablica liczb:");
            Arrays.stream(numbers).forEach(n -> System.out.print(n + ", "));
            System.out.println("Modyfikacja wartości na indeksie");
            names[5] = "Anna";
            names[names.length - 1] = "Adam";
//            names[100] = "Jan";         // może zgłaszać - > ArrayIndexOutOfBoundsException
            Arrays.stream(names).forEach(s -> System.out.print(s + ", "));
        } catch (ArrayIndexOutOfBoundsException e){     // obsługa wyjątku włączana gdy wyjątek danego typu wystąpi
            System.out.println("Błąd indeksowania tablicy");
        }
        System.out.println("\nPoza try-catch");
    }
    public void listOperations(){
        // utworzenie pustej listy
        List<String> names = new ArrayList<>();
        // utowrzenie listy zainicjowanej wartościami
        List<Double> params = new ArrayList<>(Arrays.asList(1.2,1.44,1.11,4.));
        System.out.println(names);
        System.out.println(params);
    }
    public boolean findElement(List<String> names, String name){
        return names.contains(name);
    }

    public void removeElement(String name){
        System.out.println(names);
        names.remove(name);     // usunięcie obiektu o wartości name podanej w argumencie metody
        System.out.println(names);
    }
    public void removeAllTheSameElements(String name){
        System.out.println(names);
        names.removeAll(Arrays.asList(name));     // usunięcie obiektu o wartości name podanej w argumencie metody
        System.out.println(names);
    }
    // zmień piewrszy i ostatni element na Adam w liście names
    public void updateFirstAndLastElement(String name){
        names.set(0, name);
        names.set(names.size() - 1, name);
        System.out.println(names);
    }
    // wypisz wszystkie elementy znajdujące się na parzystych indeksach listy names
    public void getAllElementsWithOddIndex(){
        for(int i = 0; i < names.size(); i = i + 2){
            System.out.print(names.get(i) + " ");
        }
    }
    private Set<String> roles1 = new HashSet<>(Arrays.asList("ADMIN", "USER"));
    private Set<String> roles2 = new HashSet<>(Arrays.asList("USER", "VIEWER", "MODERATOR"));
    // jakie mamy wszystkie role w serwisie www
    public Set<String> getAllRoles(){
        // utworzenie pustego podręczngo zbioru ról z widocznością tylko w obrębie metody
        Set<String> allRoles = new TreeSet<>();
        // dodanie ról do tego zbioru pochodzących z zbiorów roles1 i roles2
        allRoles.addAll(roles1);
        allRoles.addAll(roles2);
        return allRoles;
    }
    // jakie role się powtarzają w obu zbiorach
    public Set<String> getNonUiqueRoles(){
        Set<String> nonUniqueRoles = new TreeSet<>();
        nonUniqueRoles.addAll(roles1);
        nonUniqueRoles.retainAll(roles2);
        return nonUniqueRoles;
    }
    // wypisz wszystkie unikatowe elementy obu zbiorów
    public Set<String> getUniqueRoles(){
        Set<String> uniqueRoles = getAllRoles();
        uniqueRoles.removeAll(getNonUiqueRoles());
        return uniqueRoles;
    }
    private Map<Integer, String> decimalToRoman = new HashMap<>();
    private Map<String, Integer> romanToDecimal = new HashMap<>();
    public void generateValuesIntoMap(){
        decimalToRoman.put(0, "0");
        decimalToRoman.put(1, "I");
        decimalToRoman.put(2, "II");
        decimalToRoman.put(3, "III");
        decimalToRoman.put(4, "IV");
        decimalToRoman.put(5, "V");
        System.out.println(decimalToRoman);
    }
    public void generateMapRomanToDecimal(){
        for(Integer key : decimalToRoman.keySet()){
            romanToDecimal.put(decimalToRoman.get(key), key);
        }
        System.out.println(romanToDecimal);
    }
    public static void main(String[] args) {
        JavaCollectionsExample ex = new JavaCollectionsExample();
//        ex.arrayOperations();
//        ex.listOperations();
//        System.out.println("Wynik: " +
//                ex.findElement(new ArrayList<>(Arrays.asList("Jan","Ala","Ola","Ela","Ala")), "Ala"));
//    ex.removeAllTheSameElements("Ala");
        ex.updateFirstAndLastElement("X");
        ex.getAllElementsWithOddIndex();
        System.out.println("\nAll roles: " + ex.getAllRoles());
        System.out.println("Non-unique roles: " + ex.getNonUiqueRoles());
        System.out.println("Unique roles: " + ex.getUniqueRoles());
        ex.generateValuesIntoMap();
        ex.generateMapRomanToDecimal();
        System.out.println("5 dziesiętna to: " + ex.decimalToRoman.get(5));
        System.out.println("II rzymska to: " + ex.romanToDecimal.get("II"));
    }
}








