package oop.model.enums;
public enum Gender {
    MAN("meżczyzna"),
    WOMAN("kobieta");

    private final String genderName;
    public String getGenderName() {         // getter pobierający nazwę płci
        return genderName;
    }
    Gender(String genderName) {             // konstruktor typu wyliczeniowego
        this.genderName = genderName;
    }
}
