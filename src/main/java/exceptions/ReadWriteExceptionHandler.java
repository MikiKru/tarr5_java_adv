package exceptions;

import java.io.File;
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
//                    fileWriter.close();
                    break;
                }
                String s;
                double number = Double.valueOf(data);
                fileWriter.append(String.valueOf(number)+"\n");
//                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Błąd pliku");
            } catch (InputMismatchException | NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Błąd typu danych");
            } finally {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } } } }
    public static void readDataFromFile(){ }
    public static void main(String[] args) {
         appendDataToFile();
    }
}
