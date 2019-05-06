package spring_petclinic_web_tests.src.test.java.tests;

public class Config {
    public static final String baseUrl = System.getProperty("baseUrl", "http://localhost:4200");
    public static final String apiUrl = System.getProperty("apiUrl", "http://localhost:9966");
    public static final String browser = System.getProperty("browser", "chrome");
}