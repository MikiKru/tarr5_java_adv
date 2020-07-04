package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaCollectionsExample {
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
        List<String> names = new ArrayList<>(Arrays.asList("Jan","Ala","Ola","Ela","Ala"));
        System.out.println(names);
        names.remove(name);     // usunięcie obiektu o wartości name podanej w argumencie metody
        System.out.println(names);
    }

    public static void main(String[] args) {
        JavaCollectionsExample ex = new JavaCollectionsExample();
//        ex.arrayOperations();
//        ex.listOperations();
//        System.out.println("Wynik: " +
//                ex.findElement(new ArrayList<>(Arrays.asList("Jan","Ala","Ola","Ela","Ala")), "Ala"));
    ex.removeElement("Ala");
    }
}








