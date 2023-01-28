package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class FitNSSserviceUtils {

    public static String generateExerciseId() {
        return RandomStringUtils.randomAlphanumeric(5);
    }
}
