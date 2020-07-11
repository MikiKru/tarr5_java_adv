package lambda_stream_optional;

import java.util.*;
import java.util.stream.Collectors;

public class SimpleStreamApi {
    List<Double> numbers = new ArrayList<>(
            Arrays.asList(13.11, 4.333, 6.43, -7., 1.11, 7.66, 9.99999)
//          Arrays.asList(13.11, 4.33, 6.43, 7.00, 1.11, 7.60, 9.999908)
    );
    // metoda wypisująca wszystkie liczby jedna pod drugą
    public void getAllNumbers(){
        numbers.stream().forEach(number -> System.out.println(number));
    }
    // metoda wypisujące wszystkie liczby oddzielone znakiem podanym w argumencie
    public void getAllNumbersCSV(String separator){
        System.out.println(numbers.stream()
                .map(number -> String.valueOf(number))          // konwersja liczby na napis
                .collect(Collectors.joining(separator)));       // zapisanie wyniku do napisu połączonego separatorem
    }
    // metoda wypisująca liczby zaokrąglone do określonej w argumencie liczby miejsc do przecinku
    public void getAllRoundedNumbers(int precision){
        try {
            numbers.stream().forEach(number -> System.out.printf("%." + precision + "f\t", number));
        } catch(UnknownFormatConversionException e){
            System.out.println("Błędny zakres precyzji zaokrąglenia");
        }
    }
    // metoda zwracająca sumę wszystkich wartości w liście
    public double getSumOfAllNumbers(){
        return numbers.stream().mapToDouble(value -> Double.valueOf(value)).sum();
    }
    // metoda zwracająca wartość min w liście
    public double getMin(){
        if (numbers.stream().mapToDouble(value -> Double.valueOf(value)).min().isPresent()){
            return numbers.stream().mapToDouble(value -> Double.valueOf(value)).min().getAsDouble();
        } else {
            System.out.println("Lista jest pusta");
            return 0.0;
        }
    }
    // metoda zwracająca wartość max w liście
    public double getMax(){
        if (numbers.stream().mapToDouble(value -> Double.valueOf(value)).max().isPresent()){
            return numbers.stream().mapToDouble(value -> Double.valueOf(value)).max().getAsDouble();
        } else {
            System.out.println("Lista jest pusta");
            return 0.0;
        }
    }
    // metoda zwracająca średnią wartość w liście
    public double getAvg(){
        if(numbers.stream().mapToDouble(value -> Double.valueOf(value)).average().isPresent()){
            return numbers.stream().mapToDouble(value -> Double.valueOf(value)).average().getAsDouble();
        }
        System.out.println("Lista jest pusta");
        return 0.0;
    }
    // metoda wypisująca liczby większe niż wartość w argumencie
    public void getNumbersGreatherThan(double treshold){
        numbers.stream()
                .filter(number -> number > treshold)    // filtrowanie na podstawie warunku
                .forEach(number -> System.out.print(number + " "));
    }

    public static void main(String[] args) {
        SimpleStreamApi ssa = new SimpleStreamApi();
//        ssa.getAllNumbers();
//        ssa.getAllNumbersCSV("; ");
//        ssa.getAllRoundedNumbers(1);
//        System.out.println("Suma liczb: " + ssa.getSumOfAllNumbers());
//        System.out.println("MIN: " + ssa.getMin());
//        System.out.println("MAX: " + ssa.getMax());
//        System.out.println("AVG: " + ssa.getAvg());
        ssa.getNumbersGreatherThan(5);
    }
}
