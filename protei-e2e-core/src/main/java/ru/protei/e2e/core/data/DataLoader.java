package ru.protei.e2e.core.data;

import static ru.protei.e2e.core.tech.RandomString.Eng;
import static ru.protei.e2e.core.tech.RandomString.randomLengthString;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataLoader {

    static Properties properties = new Properties();
    private static final String FILE_NAME = "C:\\Users\\Alex\\IdeaProjects\\protei-e2e\\data\\configuration.properties";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";


    public static User projectPositiveUser() {
        return new User()
                .setMail(readMail())
                .setPassword(readPassword())
                .setGender(Gender.FEMALE);
    }

    public static User projectNegativeUser() {
        return new User()
                .setMail(randomLengthString(5, 10, Eng))
                .setPassword((randomLengthString(5, 10, Eng)));
    }

//********************************CONFIGURATION*****************************************************

    private static String readMail() {
        try (FileInputStream fileInputStream = new FileInputStream(FILE_NAME)) {
            properties.load(fileInputStream);
            if (!properties.containsKey(EMAIL)) {
                throw new RuntimeException(
                        EMAIL + " property not found in " + FILE_NAME
                                + " file");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read " + FILE_NAME + " file", e);
        }
        return properties.getProperty(EMAIL);
    }

    private static String readPassword() {
        try (FileInputStream fileInputStream = new FileInputStream(FILE_NAME)) {
            properties.load(fileInputStream);
            if (!properties.containsKey(PASSWORD)) {
                throw new RuntimeException(
                        PASSWORD + " property not found in " + FILE_NAME
                                + " file");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read " + FILE_NAME + " file", e);
        }
        return properties.getProperty(PASSWORD);
    }
}
