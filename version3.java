package com.tejus;

import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Color;
import java.lang.Math;
import java.io.IOException;



import javax.imageio.ImageIO;

public class version3 {
	public static void main(String[]args) throws IOException {
		BufferedImage compare = ImageIO.read(new File("C:\\Users\\tejus\\eclipse-workspace\\CVProject\\leftcompare.jpg"));
		double avg_red = 0.0;
		
		for(int x = 1380; x<1388; x++) {
			int pixel1 = compare.getRGB(x, 273);
			Color color1 = new Color(pixel1, true);
			double r1 = color1.getRed()/255.0;
			avg_red += r1;
		}
		
		avg_red /= 9;
		System.out.println("right: " + avg_red);
		
		for(int x = 1020; x<1028; x++) {
			int pixel1 = compare.getRGB(x, 270);
			Color color1 = new Color(pixel1, true);
			double r1 = color1.getRed()/255.0;
			avg_red += r1;
		}
		
		avg_red /= 9;
		System.out.println("middle:" + avg_red);
	    //1028,220  middle
		//1388, 273 right
		//669,276 left
		
		
		for(int x = 661; x<669; x++) {
			int pixel1 = compare.getRGB(x, 276);
			Color color1 = new Color(pixel1, true);
			double r1 = color1.getRed()/255.0;
			avg_red += r1;
		}
		
		avg_red /= 9;
		System.out.println("left:" + avg_red);
	    //1028,220  middle
		//1388, 273 right
		//669,276 left
	}

}
