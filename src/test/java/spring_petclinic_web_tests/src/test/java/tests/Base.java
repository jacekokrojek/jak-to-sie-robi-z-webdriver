package spring_petclinic_web_tests.src.test.java.tests;

import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Base {

    protected WebDriver driver;

    @Rule
    public ExternalResource resource = new ExternalResource() {

        @Override
        protected void before() throws Throwable {
            if (Config.browser.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/vendor/geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (Config.browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/vendor/chromedriver.exe");
                driver = new ChromeDriver();
            }else if (Config.browser.equals("ie")) {
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/vendor/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }
        }

        @Override
        protected void after() {
            driver.quit();
        }

    };

    public Screenshot takeScreenshot(){
        return  new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
    }

    public void saveScreenshot(Screenshot screenshot) throws IOException {
        File imageFile = File.createTempFile("image_", ".png",  new File("."));
        ImageIO.write(screenshot.getImage(),"png", imageFile);
    }

    private static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public boolean imagesEqual(Screenshot currentScreenshot, String refScreenshotPath){
        ImageDiff diff = new ImageDiffer().makeDiff(currentScreenshot.getImage(), loadImage(refScreenshotPath));
        return !diff.hasDiff();
    }

}
