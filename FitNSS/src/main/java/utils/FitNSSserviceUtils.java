package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class FitNSSserviceUtils {

    /**
     * Method to generate a random alphanumeric recipeId.
     * @return a String composed of an alphanumeric of length 5
     */
    public static String generateExerciseId() {
        return RandomStringUtils.randomAlphanumeric(5);
    }
}
