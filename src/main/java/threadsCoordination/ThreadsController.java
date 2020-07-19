package threadsCoordination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// ZADANIE
// 1. Utwórz dwa wątki o nazwach producer 1 i producer 2
// 2. Producer 1 wypisuje ne ekran zawartość List<String>
// 3. Producer 2 wypisuje na ekran zawartość Array<Integer>
// --------------------------------------------------------
public class ThreadsController {
    List<String> names = new ArrayList<>(Arrays.asList("Adam","Jan","Anna", "Ola", "Iga"));
    int [] numbers = {22,12,34,54,3,2,1,1,1,1,0,0,1};

    public void printNames(){

    }
    public void printNumbers(){

    }
    public static void main(String[] args) {

    }
}
