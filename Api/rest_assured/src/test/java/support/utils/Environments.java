package support.utils;

public class Environments {
    public static String getEnvironments() {
        String environments = System.getProperty("environments");
        if ( environments == null) {
            environments = "local";
        }

        return environments;
    }
}
