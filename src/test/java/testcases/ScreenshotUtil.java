package testcases;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import java.util.Base64;

public class ScreenshotUtil {

    public static void captureAndResize(WebDriver driver, ExtentTest test) {
        if (driver instanceof TakesScreenshot) {
            try {
                String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
                byte[] imageBytes = Base64.getDecoder().decode(base64);
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));

                int newW = image.getWidth() / 2, newH = image.getHeight() / 2;
                Image scaled = image.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
                BufferedImage resized = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g = resized.createGraphics();
                g.drawImage(scaled, 0, 0, null);
                g.dispose();

                ByteArrayOutputStream os = new ByteArrayOutputStream();
                ImageIO.write(resized, "png", os);
                String resizedBase64 = Base64.getEncoder().encodeToString(os.toByteArray());

                test.log(LogStatus.INFO, "Screenshot:", test.addBase64ScreenShot("data:image/png;base64," + resizedBase64));
            } catch (Exception e) {
                System.err.println("Screenshot capture failed: " + e.getMessage());
            }
        }
    }
}

