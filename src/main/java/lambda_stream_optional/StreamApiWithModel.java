package lambda_stream_optional;

import oop.model.User;
import oop.model.enums.Gender;
import oop.model.enums.Role;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    // metoda zwracająca liczbę kobiet
    public long countAllWomen(){
        return InMemoryData.users.stream()
                .filter(user -> user.getGender().equals(Gender.WOMAN))
                .count();
    }
    // metoda zwracająca listę użytkowników zawierającą rolę podaną w argumencie metody
    public List<User> getAllUsersContainsRole(Role role){
        return InMemoryData.users.stream()
                .filter(user -> user.getRoles().contains(role))
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        StreamApiWithModel sapi = new StreamApiWithModel();
//        sapi.getAllUsers();
        sapi.getAllUsersOrderByRegistrationDateDesc();
//        System.out.println("Wynik logowania: " + sapi.loginUser("hl@hl.pl","hl"));
        System.out.println("Liczba kobiet: " + sapi.countAllWomen());
        sapi.getAllUsersContainsRole(Role.ROLE_ADMIN).forEach(System.out::println);
    }
}
