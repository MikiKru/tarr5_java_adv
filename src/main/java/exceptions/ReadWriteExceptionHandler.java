package exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadWriteExceptionHandler {
    private static String path =
            Paths.get("").toAbsolutePath().toString()+ "\\src\\main\\java\\exceptions\\data.txt";
    private static File file = new File(path);
    public static void appendDataToFile(){
        FileWriter fileWriter = null;
        while (true) {
            try {
                fileWriter = new FileWriter(file, true);
                Scanner scanner = new Scanner(System.in);
                System.out.println("Wprowadź liczbę (Q - wyjście)");
                String data = scanner.nextLine();
                if(data.toUpperCase().equals("Q")){
                    break;
                }
                double number = Double.valueOf(data);
                if(number == 0){
                    throw new ArithmeticException();    // sztuczne zgłoszenie wyjątku -> musi być obsłużony
                }
                fileWriter.append(String.valueOf(number)+"\n");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Błąd pliku");
            } catch (InputMismatchException | NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Błąd typu danych");
            } catch (ArithmeticException e){            // obsługa wyjątku wyrzuconego za pomocą klauzuli throw
                System.out.println("Wprowadzona liczba nie może być 0.0");
            } finally {     // klauzula ta wykonuje się zawsze po bloku try lub dowolnym bloku catch
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } } } }
    public static void readDataFromFile(){
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
         appendDataToFile();
         readDataFromFile();
    }
}
