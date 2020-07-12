package pizzaExercises;

import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class PizzaController {
    // metoda zwracającą cenę pizzy na podstawie cen składowych wszystkich jej składników
    public int calculatePizzaPrice(Pizza pizza){
        return pizza.getIngredients().stream()
                .mapToInt(p -> p.getPrice())
                .sum();
    }
    // metoda zwracająca tylko pizze ostre
    public List<Pizza> getAllSpicy(){
        return Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().stream().anyMatch(ingredient -> ingredient.isSpicy()))
                .collect(Collectors.toList());
    }

    // metoda zwracająca obiekt Pizza dla najtańszej i ostrej pizzy
    public Pizza findCheapestSpicy(){
        Optional<Pizza> pizzaOpt = Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().stream().anyMatch(ingredient -> ingredient.isSpicy()))
                .sorted(Comparator.comparing(pizza -> calculatePizzaPrice(pizza)))      // sortowanie MIN-MAX
                .findFirst();                                                           // pobranie pierwszej wartości -> Optional
        if(pizzaOpt.isPresent()){               // sprawdzenie czy optional zawiera wartość
            return pizzaOpt.get();              // wydobycie wartości z optionala
        }
        System.out.println("Brak danych do pobrania");
        return null;
    }
    // metoda wypisująca pizze wraz z cenami
    public void getAllPizzasWithPrices(){
        Arrays.stream(Pizza.values())
                .forEach(pizza -> System.out.println(pizza.getName() + " - " + calculatePizzaPrice(pizza) + " PLN"));
    }
    // metoda zwracająca najdroższą pizze wegetariańską
    Pizza findMostExpensiveVegetarian(){
        return null;
    }

    public static void main(String[] args) {
        PizzaController pc = new PizzaController();
        System.out.println("CENA: " + pc.calculatePizzaPrice(Pizza.MARGHERITA));
        System.out.println("OSTRE");
        pc.getAllSpicy().forEach(System.out::println);
        System.out.println("PIZZE Z CENAMI");
        pc.getAllPizzasWithPrices();
        System.out.println("NAJTANSZA PIZZA OSTRA");
        System.out.println(pc.findCheapestSpicy());

    }
}
