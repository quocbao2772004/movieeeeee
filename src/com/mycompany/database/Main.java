/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.database;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.*;
public class Main {
    public static void showImage(BufferedImage image) {
        if (image != null) {
            int newWidth = 300;
            int newHeight = 300;
            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, image.getType());
            Graphics2D g = resizedImage.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(image, 0, 0, newWidth, newHeight, null);
            g.dispose();

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(newWidth, newHeight);
            JLabel label = new JLabel(new ImageIcon(resizedImage));
            frame.add(label);
            frame.pack(); // Adjusts frame size to fit the image
            frame.setVisible(true);
        } else {
            System.err.println("No image to display");
        }
    }
    public static void main(String[] args) {
        // MovieDatabase movieDb = new MovieDatabase();
        // movieDb.addMovie("Inception", "Sci-Fi", 148, "2010-07-16", "Available");
        // movieDb.updateMovie("Inception", "Science Fiction", 148, "2010-07-16", "Available");
        // //movieDb.deleteMovie("Inception");

        // AccountManager accountManager = new AccountManager();
        // accountManager.createAccount("dmhung1508", "hung1234", "admin@hacker2k4.com");
        // System.out.println(accountManager.check_correct("dmhung1508", "hung12334"));
        // System.out.println(accountManager.getEmail("dmhung1508"));
        //accountManager.deleteAccount("user1");

        // TransactionHistory history = new TransactionHistory();
        // history.generateFakeTransactions(10);
        // history.updatePaymentStatus("user0", false);
        // history.getAllTransactions();

        // show ảnh QR
        // BufferedImage image = Utils.getQR(10000, "dmhung1508");
        // showImage(image);


        
    }
}
