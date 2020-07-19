package anonymousClasses;
// KLASA ANONIMOWA
// 1. nie posiada nazwy
// 2. można utworzyć dokładnie jedną instancję tej klasy
public class Main {

    public static void main(String[] args) {
        Object object = new EventController() {         // utworzenie obiektu poprzez wywołanie kontruktora EventController
            @Override
            public void printEvent() {
                System.out.println("-- nowe wydarzenie --");
                EventController.formattedEventDate();
            }
        };
        ((EventController) object).printEvent();


    }
}
