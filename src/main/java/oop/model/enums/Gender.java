package oop.model.enums;
public enum Gender {
    MAN("meżczyzna"), WOMAN("kobieta");
    private final String genderName;
    Gender(String genderName) {             // konstruktor typu wyliczeniowego
        this.genderName = genderName;
    }
}
