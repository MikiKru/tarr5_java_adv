package oop;

import oop.model.User;
import oop.model.enums.Gender;

public class Run {
    public static void main(String[] args) {
        User u1 = new User("Adam", "Kowalski", "ak@ak.pl", "ak", "123123123", Gender.MAN);
        User u2 = new User("Jan", "Nowak", "jn@jn.pl", "jn", "333123123", Gender.MAN);
        User u3 = new User("Anna", "Lis", "al@al.pl", "al", "444123123", Gender.WOMAN);
        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);

    }
}
