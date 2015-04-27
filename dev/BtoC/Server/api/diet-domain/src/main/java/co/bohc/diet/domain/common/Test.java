package co.bohc.diet.domain.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

public class Test {

    public static void main(String[] args) {
        try {
            BufferedImage buffImage = ImageIO.read(new File("d:/czhdb.jpg"));
            Graphics g = buffImage.getGraphics();
            Font font = new Font("黑体", Font.ITALIC, 20);
            g.setFont(font);
            g.setColor(Color.RED);
            g.drawString("504010010001", 606, 94);
            font = new Font("黑体", Font.ITALIC, 20);
            g.setFont(font);
            g.setColor(Color.BLACK);
            g.drawString("123456789", 206, 164);
            font = new Font("黑体", Font.ITALIC, 20);
            g.setFont(font);
            g.setColor(Color.BLACK);
            g.drawString("川A12345", 206, 201);
            font = new Font("黑体", Font.ITALIC, 20);
            g.setFont(font);
            g.setColor(Color.BLACK);
            g.drawString("12", 206, 233);
            font = new Font("黑体", Font.ITALIC, 20);
            g.setFont(font);
            g.setColor(Color.BLACK);
            g.drawString("2015-04-27 12:12", 206, 264);

            FileOutputStream outImg = new FileOutputStream(new File("d:/test.jpg"));
            ImageIO.write(buffImage, "jpg", outImg);
            outImg.flush();
            outImg.close();
        } catch (Exception e) {

        }
    }
}
