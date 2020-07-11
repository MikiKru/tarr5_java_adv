package polymorphism;

public class Main {
    public static void main(String[] args) {
//        Company company = new Company();        // dostęp do wszystkich nieprywatnych składowych klasy Company
//        company.setCompanyName("Firma X");
//        company.setRoomsQuantity(100);
//        System.out.println(company.getCompanyName() + " (" + company.getRoomsQuantity() + " pomieszczeń)");
//        OpenSpace os1 = new OpenSpace();        // dostęp do wszystkich nieprywatnych składowych klasy OpenSpace i Company
//        os1.setCompanyName("ABC");
//        os1.setRoomsQuantity(10);
//        os1.setOpenSpaceName("Londyn");
//        os1.setOpenSpaceNo(1);
//        os1.setOpenSpaceCapacity(50);
//        System.out.printf("Firma: %s (ilość pomieszczeń: %d) Open space: %d - %s (pojemność: %d)",
//                os1.getCompanyName(), os1.getRoomsQuantity(),                               // metody z Company
//                os1.getOpenSpaceNo(), os1.getOpenSpaceName(), os1.getOpenSpaceCapacity());  // metody z OpenSpace
        Company company = new Company("ABC", 10);
        OpenSpace os1 = new OpenSpace(
                "QWERTY", 10, 1, "Londyn", 100);
//        System.out.println(company);
        OpenSpace os2 = new OpenSpace(
                os1.getCompanyName(), os1.calculateFreeRooms(), 2, "Rzym", 10);

        OpenSpace os3 = new OpenSpace(
                os1.getCompanyName(), os1.calculateFreeRooms(), 3, "Paryż", 25);
        System.out.println(os1);
        System.out.println(os2);
        System.out.println(os3);

    }
}
