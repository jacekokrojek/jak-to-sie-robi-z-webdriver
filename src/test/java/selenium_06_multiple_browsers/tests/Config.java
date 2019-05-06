package selenium_06_multiple_browsers.tests;

public class Config {
    public static final String baseUrl = System.getProperty("baseUrl", "http://the-internet.herokuapp.com");
    public static final String browser = System.getProperty("browser", "firefox");
}