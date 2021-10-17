package com.tejus;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public class SSID_test {
	//TO DO:
	//COMPARE QUADRANTS
	//BLANK IMAGE
	//WHICHEVER QUADRANT HAS THE LOWEST SCORE WINS

	public static void main(String[] args) throws IOException {
		 BufferedImage compare = ImageIO.read(new File("C:\\Users\\tejus\\eclipse-workspace\\CVProject\\rightcompare.jpg"));
	     BufferedImage img2 = ImageIO.read(new File("C:\\Users\\tejus\\eclipse-workspace\\CVProject\\right.jpg"));
	     BufferedImage img3 = ImageIO.read(new File("C:\\Users\\tejus\\eclipse-workspace\\CVProject\\middle.jpg"));
	     BufferedImage img4 = ImageIO.read(new File("C:\\Users\\tejus\\eclipse-workspace\\CVProject\\left.jpg"));
	      int w1 = compare.getWidth()/2;
	      int w2 = img2.getWidth()/2;
	      int w3 = img3.getWidth();
	      int w4 = img4.getWidth();
	      
	      
	      int h1 = compare.getHeight();
	      int h2 = img2.getHeight();
	      int h3 = img3.getHeight();
	      int h4 = img4.getHeight();
	      if ((w1!=w2)||(h1!=h2)) {
	         System.out.println("Both images should have same dimwnsions");
	      } else {
	         long rightdiff = 0;
	         long middlediff = 0;
	         long leftdiff = 0;
	         for (int j = 100; j < h1; j++) {
	            for (int i = 560; i < 770; i++) {
	               //Getting the RGB values of a pixel
	               int pixel1 = compare.getRGB(i, j);
	               Color color1 = new Color(pixel1, true);
	               int r1 = color1.getRed();
	               int g1 = color1.getGreen();
	               int b1 = color1.getBlue();
	              
	              
	               
	               
	               int pixel4 = img2.getRGB(i, j);
	               Color color4 = new Color(pixel4, true);
	               int r4 = color4.getRed();
	               int g4 = color4.getGreen();
	               int b4= color4.getBlue();
	               
	               
	                leftdiff = Math.abs(r4-r1)+Math.abs(g4-g1);

	               
	               //sum of differences of RGB values of the two images
	             
	              
	            }
	         }
	         for (int j = 100; j < h1; j++) {
		            for (int i = 900; i < 1130; i++) {
		               //Getting the RGB values of a pixel
		               int pixel1 = compare.getRGB(i, j);
		               Color color1 = new Color(pixel1, true);
		               int r1 = color1.getRed();
		               int g1 = color1.getGreen();
		               int b1 = color1.getBlue();
		              
		             
		               
		               
		               int pixel4 = img2.getRGB(i, j);
		               Color color4 = new Color(pixel4, true);
		               int r4 = color4.getRed();
		               int g4 = color4.getGreen();
		               int b4= color4.getBlue();
		               
		               
		               
		               
		               //sum of differences of RGB values of the two images
		                middlediff = Math.abs(r4-r1)+Math.abs(g4-g1);

		            }
		         }
	         for (int j = 100; j < h1; j++) {
		            for (int i = 120; i < 1440; i++) {
		               //Getting the RGB values of a pixel
		               int pixel1 = compare.getRGB(i, j);
		               Color color1 = new Color(pixel1, true);
		               int r1 = color1.getRed();
		               int g1 = color1.getGreen();
		               int b1 = color1.getBlue();
		              
		              
		               
		               int pixel4 = img4.getRGB(i, j);
		               Color color4 = new Color(pixel4, true);
		               int r4 = color4.getRed();
		               int g4 = color4.getGreen();
		               int b4= color4.getBlue();
		               
		               
		               
		               
		               //sum of differences of RGB values of the two images
		                rightdiff = Math.abs(r4-r1)+Math.abs(g4-g1);

		            }
		         }
	         
	         
	         
	         
	         
	         
	         System.out.println("Left:" + leftdiff);
	         System.out.println("right:" + rightdiff);
	         System.out.println("middle:" + middlediff);
	         
	         
	         
	         
	         
	         
	         }


	}
	      
}
