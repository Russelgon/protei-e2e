package ru.protei.e2e.core.data;

public enum Gender {

    MALE,
    FEMALE;

    public String getVisibleText() {
        return switch (this) {
            case MALE -> "Мужской";
            case FEMALE -> "Женский";
        };
    }
}
