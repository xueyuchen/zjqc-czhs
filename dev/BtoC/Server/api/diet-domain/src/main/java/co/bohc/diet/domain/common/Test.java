package co.bohc.diet.domain.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import javax.imageio.ImageIO;

import org.joda.time.DateTime;

public class Test {

    public static void main(String[] args) {
        Date date = new Date();
        if (date != null) {
            DateTime time = new DateTime(date.getTime());
            System.out.println(new DateTime(time.getYear(), time.getMonthOfYear(), 1, 0, 0, 0).toDate());
            System.out.println(Integer.valueOf("5041022".substring(3)));
        }
    }
}
