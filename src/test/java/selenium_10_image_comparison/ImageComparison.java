package selenium_10_image_comparison;

import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import java.awt.image.BufferedImage;

public class ImageComparison {
    private static ImageDiffer imageDiffer = new ImageDiffer();

    public static boolean compareImages(Screenshot expected, Screenshot actual) {
        ImageDiff differ = imageDiffer.makeDiff(expected, actual);
        return differ.hasDiff();
    }

    public static boolean compareImages(BufferedImage expected, BufferedImage actual) {
        ImageDiff differ = imageDiffer.makeDiff(expected, actual);
        return differ.hasDiff();
    }
}
