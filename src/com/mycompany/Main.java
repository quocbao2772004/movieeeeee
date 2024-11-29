
package com.mycompany;
import com.mycompany.UI.*;
import com.mycompany.movie.*;
import com.mycompany.database.*;
import java.io.IOException;
import com.mycompany.UI.process_functions.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
public class Main 
{
    public static void main(String[] args) throws IOException 
    {
          Login li = new Login();
          li.Login_Interface();    
          
//          SeatsDatabase sdtb = new SeatsDatabase();
//          String mvname = "The Substance: Than duoc / 18 / Penang - Queensbay Mall / 05:50 PM";
//          ArrayList<Seats> arl_seats = new ArrayList<>(sdtb.getSeats(mvname));
//          Collections.sort(arl_seats);
//          for(Seats i: arl_seats)
//          {
//              System.out.println(i.getSeat());
//          }
//        process_functions pf = new process_functions();
//        Utils utils = new Utils();
//        System.out.println(utils.sendEmail("baodz", "venom", "11/9", "5:50PM", "H05", "k100iltqbao@gmail.com"));
//        System.out.println(utils.chat("I wanna see action movie"));
//        System.out.println(utils.classifyFeedback("1+1=2"));
//        System.out.println(utils.checkTicketExists("User1MovietstdIDYUJATRS"));
//        System.out.println(utils.checkTicketExists("hehe"));
//        BufferedImage i = pf.croppedImage("qrcode//qr_code.png", "thu.png", 83, 85, 376, 376);

    }
}
