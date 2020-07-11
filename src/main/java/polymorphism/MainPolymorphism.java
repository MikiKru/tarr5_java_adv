package polymorphism;

public class MainPolymorphism {
    public static void hasModeRooms(Company c1, Company c2){
        if(c1.getRoomsQuantity() > c2.getRoomsQuantity()){
            System.out.println("Firma: " + c1.getCompanyName() + " posiada więcej pokoi");
        } else if(c1.getRoomsQuantity() == c2.getRoomsQuantity()) {
            System.out.println("Obie firmy mają tyle samo pokoi");
        } else {
            System.out.println("Firma: " + c2.getCompanyName() + " posiada więcej pokoi");
        }
    }
    public static void main(String[] args) {
        // polimorfizm -> przypisanie typu nadrzędnego do obiektu pochodzącego z klasy potomnej
        Object openSpaceObject = new OpenSpace("O1", 5, 1, "XXX", 100);
        Company openSpace1 = new OpenSpace("X", 3, 1, "A", 10);
        System.out.println("obiekt openSpaceObject jest reprezentantem klasy: " + openSpaceObject.getClass().getName());
        System.out.println(openSpaceObject);
        System.out.println("obiekt openSpace1 jest reprezentantem klasy: " + openSpace1.getClass().getName());
        System.out.println(openSpace1);
        // ==================================================
        

    }
}
