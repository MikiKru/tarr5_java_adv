package lambda_stream_optional;

import oop.model.User;

import java.util.Comparator;

public class StreamApiWithModel {
    // metoda wypisująca zawartość listy users z InMemoryData
    public void getAllUsers(){
        InMemoryData.users.forEach(System.out::println);
    }
    // metoda wypisującą użytkowników posotrowanych po dacie rejestracji malejąco
    public void getAllUsersOrderByRegistrationDateDesc(){
        InMemoryData.users.stream()
                .sorted(Comparator.comparing(User::getRegistrationDateTime).reversed())
                .forEach(System.out::println);
    }
    // metoda do logowania -> loguje gdy email password się zgadzają oraz status jest true i removed jest false
    public boolean loginUser(String email, String password){
        return InMemoryData.users.stream()
                .anyMatch(user -> user.getEmail().equals(email) && user.getPassword().equals(password) &&
                        user.isStatus() && !user.isRemoved());
    }

    public static void main(String[] args) {
        StreamApiWithModel sapi = new StreamApiWithModel();
//        sapi.getAllUsers();
        sapi.getAllUsersOrderByRegistrationDateDesc();
        System.out.println("Wynik logowania: " + sapi.loginUser("hl@hl.pl","hl"));
    }
}
