package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class CommonMethods {

	public static String generateNewEmail() {
		return new Date().toString().replaceAll("\\s", "").replaceAll("\\:","")+"@gmail.com";
	}
	
	public boolean compareScreenshots(String actulaImagePath,String expectedImagePath) throws IOException {
		//Reading Image as buffer image
				BufferedImage actualBImg = ImageIO.read(new File(actulaImagePath));
				BufferedImage expectedBImg = ImageIO.read(new File(expectedImagePath));
				
				//Checking the difference
				ImageDiffer imgDiffer = new ImageDiffer();
				ImageDiff imgDifference = imgDiffer.makeDiff(expectedBImg, actualBImg);
				
				//Verify it is coming as false
				boolean b = imgDifference.hasDiff();
				System.out.println(b);
				
				//comparing the value
				return imgDifference.hasDiff();
	}
}
