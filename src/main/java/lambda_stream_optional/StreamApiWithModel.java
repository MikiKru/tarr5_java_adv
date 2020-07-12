package lambda_stream_optional;

import oop.model.User;
import oop.model.enums.Gender;
import oop.model.enums.Role;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiWithModel {
    // metoda wypisująca zawartość listy users z InMemoryData
    public void getAllUsers() {
        InMemoryData.users.forEach(System.out::println);
    }

    // metoda wypisującą użytkowników posotrowanych po dacie rejestracji malejąco
    public void getAllUsersOrderByRegistrationDateDesc() {
        InMemoryData.users.stream()
                .sorted(Comparator.comparing(User::getRegistrationDateTime).reversed())
                .forEach(System.out::println);
    }

    // metoda do logowania -> loguje gdy email password się zgadzają oraz status jest true i removed jest false
    public boolean loginUser(String email, String password) {
        return InMemoryData.users.stream()
                .anyMatch(user -> user.getEmail().equals(email) && user.getPassword().equals(password) &&
                        user.isStatus() && !user.isRemoved());
    }

    // metoda zwracająca liczbę kobiet
    public long countAllWomen() {
        return InMemoryData.users.stream()
                .filter(user -> user.getGender().equals(Gender.WOMAN))
                .count();
    }

    // metoda zwracająca listę użytkowników zawierającą rolę podaną w argumencie metody
    public List<User> getAllUsersContainsRole(Role role) {
        return InMemoryData.users.stream()
                .filter(user -> user.getRoles().contains(role))
                .collect(Collectors.toList());
    }

    // metoda grupująca użytkowników po zbiorach ról
    public Map<Set<Role>, List<User>> groupUsersByRoleSet() {
        return InMemoryData.users.stream().collect(Collectors.groupingBy(User::getRoles));
    }

    // metoda do grupowania po płci
    public Map<Gender, List<User>> groupUsersByGender() {
        return InMemoryData.users.stream().collect(Collectors.groupingBy(o -> o.getGender()));
    }

    // metoda grupująca użytkowników po rolach występujących w zbiorach ról
    public Map<Role, List<User>> userRoleMapper() {
        Map<Role, List<User>> userRoleMap = new HashMap<>();
        for (Role role : Role.values()) {
            List<User> groupingUsers = new ArrayList<>();
            for (User user : InMemoryData.users) {
                if (user.getRoles().contains(role)) {
                    groupingUsers.add(user);
                    userRoleMap.put(role, groupingUsers);
                }
            }
        }
        return userRoleMap;
    }

    public static void main(String[] args) {
        StreamApiWithModel sapi = new StreamApiWithModel();
//        sapi.getAllUsers();
//        sapi.getAllUsersOrderByRegistrationDateDesc();
//        System.out.println("Wynik logowania: " + sapi.loginUser("hl@hl.pl","hl"));
//        System.out.println("Liczba kobiet: " + sapi.countAllWomen());
//        sapi.getAllUsersContainsRole(Role.ROLE_ADMIN).forEach(System.out::println);
//        sapi.groupUsersByGender().forEach((gender, users) -> System.out.printf("%30s | %30s\n", gender, users));
        sapi.userRoleMapper().forEach((role, user) -> System.out.println(role + " : " + user));
        System.out.println(sapi.userRoleMapper().get(Role.ROLE_ADMIN));
        System.out.println(sapi.userRoleMapper().get(Role.ROLE_USER));
    }
}
