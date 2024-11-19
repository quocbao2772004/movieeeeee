/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package termproject.src.com.mycompany.movie; 

// settlekan seat
// full demo check`

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author muham
 */
public class Home extends javax.swing.JFrame {
    
    int checkAll = 0, ignore = 0;
    public static int[] seat1 = new int[25];
    public static int[] seat2 = new int[25];
    public static int[] seat3 = new int[25];
    public static int[] seat4 = new int[25];
    public static int[] seat5 = new int[25];
    public static int[] seat6 = new int[25];
    
    double allPrice = 0.0;
    
    int ds = 0;
    public static String[] displaySeat = new String[6];
    
    Receipt receipt = new Receipt();
    int cUser = 0;
   
    public static Movie mDetail[];
    
    int limitSeat = 0; int ticket = 0;
    String[] sSeat = new String[24];
    int limit = 0;
    int abc = 0;
    
    public static String[] zseat = new String[25];
    public static String[] zseat2 = new String[25];
    public static String[] zseat3 = new String[25];
    public static String[] xSeat = new String[25];
    String[] x2Seat = new String[25];
    String[] x3Seat = new String[25];
    int xCheck = 0;
    
    int checkDate = 0, checkCinema = 0;
    int checkConfirm = 0;
    int checkType = 0;
    int checkAgain = 0, checkAgain2 = 0;
    
    public static int quantity = 0;
    public static TicketPrice ticketPrice;
    double adultP = 0.0, childrenP = 0.0, OKUP = 0.0, seniorP = 0, studentP = 0;
    
    int cAdult = 0, cChildren = 0, cOKU = 0, cSenior = 0, cStudent = 0;
    int cAll = 0;
    
    File C = new File("D:\\JAVA PTIT\\hung"); 
    int ln;
    String Username="", Password="", Email="";
    String userN="";
    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
    }
    
    void createFolder() {
        
        if(!C.exists()) {
            C.mkdirs();
        }
    }
    
    void readFile() {
        
        try {
            
            FileReader fr = new FileReader(C+"\\logins.txt");
            System.out.println("File exists!");
        } catch (FileNotFoundException ex) {
            
            try {
                FileWriter fw = new FileWriter(C+"\\logins.txt");
                System.out.println("File created");
            } catch (IOException ex1) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    void addData(String usr,String pswd, String mail) {
        
        try {
            RandomAccessFile raf = new RandomAccessFile(C+"\\logins.txt","rw");
            
            for(int i=0; i<ln; i++) {
                
                raf.readLine();
            }
            
            raf.writeBytes("\r\n");
            raf.writeBytes("\r\n");
            raf.writeBytes("Username:"+usr+"\r\n");
            raf.writeBytes("Password:"+pswd+"\r\n");
            raf.writeBytes("Email:"+mail);
            
            JOptionPane.showMessageDialog(null, "Account created successfully! You can login now :)");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void CheckData(String usern, String pswd) {
        int c=0;
        try {
            RandomAccessFile raf = new RandomAccessFile(C+"\\logins.txt","rw");
            for(int i=0; i<ln; i+=4) { System.out.println("Count: "+i);
                String Username = raf.readLine().substring(9);
                String Password = raf.readLine().substring(9);
                //String Username = raf.readLine().substring(9);

                if(usern.equals(Username) && pswd.equals(Password)) {
                    c++;
                    login.setVisible(false);
                    signup.setVisible(false);
                    switchInside.setVisible(false);
                    seat.setVisible(false);
                    overall.setVisible(true);
                    newInside.setVisible(true);
                    userN = Username;
                    System.out.println("User: "+Username);
                    break;
                }
                else if(i==(ln-3)) {

                    JOptionPane.showMessageDialog(null,"Wrong username or password!");
                    user.requestFocus();
                    break;
                }
                
                for(int k=1; k<=2; k++) {
                    raf.readLine();
                }
            }
            if(c==1) {
                System.out.println("Counted!");
            }
            else {
                JOptionPane.showMessageDialog(null,"Wrong username or password!");
                clearTextLogin();
                user.requestFocus();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void countLines() {
        
        try {
            ln=1;
            RandomAccessFile raf = new RandomAccessFile(C+"//logins.txt","rw");
            
            for(int i=0; raf.readLine() != null; i++) {
                
                ln++;
            }
            System.out.println("Number of lines: "+ln);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clearTextLogin() {
        user.setText("");
        password.setText("");
    }
    public void clearTextSignUp() {
        userF.setText("");
        mailF.setText("");
        passF.setText("");
    }
    public void clearChoice() {
        b18.setBackground(new Color(255,255,255));
        b19.setBackground(new Color(255,255,255));
        b20.setBackground(new Color(255,255,255));
        penangQ1.setBackground(new Color(255,255,255));
        penangQ5.setBackground(new Color(255,255,255));
        penangQ8.setBackground(new Color(255,255,255));
        penangS1.setBackground(new Color(255,255,255));
        penangS4.setBackground(new Color(255,255,255));
        penangS8.setBackground(new Color(255,255,255));
        alorS1.setBackground(new Color(255,255,255));
        alorS8.setBackground(new Color(255,255,255));
    }
    public void clearSeat() {
        seatH01.setEnabled(true);
        seatH02.setEnabled(true);
        seatH03.setEnabled(true);
        seatH04.setEnabled(true);
        seatH05.setEnabled(true);
        seatH06.setEnabled(true);
        seatH07.setEnabled(true);
        seatH08.setEnabled(true);
        seatH09.setEnabled(true);
        seatH10.setEnabled(true);
        seatH11.setEnabled(true);
        seatH12.setEnabled(true);
        
        seatG01.setEnabled(true);
        seatG02.setEnabled(true);
        seatG03.setEnabled(true);
        seatG04.setEnabled(true);
        seatG05.setEnabled(true);
        seatG06.setEnabled(true);
        seatG07.setEnabled(true);
        seatG08.setEnabled(true);
        seatG09.setEnabled(true);
        seatG10.setEnabled(true);
        seatG11.setEnabled(true);
        seatG12.setEnabled(true);
        
        seatH01.setBackground(new Color(255,255,255));
        seatH02.setBackground(new Color(255,255,255));
        seatH03.setBackground(new Color(255,255,255));
        seatH04.setBackground(new Color(255,255,255));
        seatH05.setBackground(new Color(255,255,255));
        seatH06.setBackground(new Color(255,255,255));
        seatH07.setBackground(new Color(255,255,255));
        seatH08.setBackground(new Color(255,255,255));
        seatH09.setBackground(new Color(255,255,255));
        seatH10.setBackground(new Color(255,255,255));
        seatH11.setBackground(new Color(255,255,255));
        seatH12.setBackground(new Color(255,255,255));
        
        seatG01.setBackground(new Color(255,255,255));
        seatG02.setBackground(new Color(255,255,255));
        seatG03.setBackground(new Color(255,255,255));
        seatG04.setBackground(new Color(255,255,255));
        seatG05.setBackground(new Color(255,255,255));
        seatG06.setBackground(new Color(255,255,255));
        seatG07.setBackground(new Color(255,255,255));
        seatG08.setBackground(new Color(255,255,255));
        seatG09.setBackground(new Color(255,255,255));
        seatG10.setBackground(new Color(255,255,255));
        seatG11.setBackground(new Color(255,255,255));
        seatG12.setBackground(new Color(255,255,255));
    }
    
    public void clearDisplaySeat() {
        for(int i=0; i<12; i++) {
            displaySeat[i] = "";
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        damaged2 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        jButton110 = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jButton117 = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        login = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        Login = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        signup = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        userF = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        mailF = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        passF = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        Signup = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        backFromSignUp = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        overall = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        switchInside = new javax.swing.JPanel();
        movieImage = new javax.swing.JLabel();
        movieName = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        b20 = new javax.swing.JButton();
        b18 = new javax.swing.JButton();
        b19 = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        penangQ1 = new javax.swing.JButton();
        penangQ5 = new javax.swing.JButton();
        jSeparator13 = new javax.swing.JSeparator();
        penangQ8 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        penangS1 = new javax.swing.JButton();
        penangS4 = new javax.swing.JButton();
        penangS8 = new javax.swing.JButton();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        alorS1 = new javax.swing.JButton();
        alorS8 = new javax.swing.JButton();
        selectSeat = new javax.swing.JButton();
        jSeparator20 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        movieLayeredPane = new javax.swing.JLayeredPane();
        jumanjiImage = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        birdsImage3 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        dolittleImage = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        backFromSwitch = new javax.swing.JLabel();
        seat = new javax.swing.JPanel();
        confirmSeat = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        seatH01 = new javax.swing.JToggleButton();
        seatH02 = new javax.swing.JToggleButton();
        seatG01 = new javax.swing.JToggleButton();
        seatG02 = new javax.swing.JToggleButton();
        seatH03 = new javax.swing.JToggleButton();
        seatH04 = new javax.swing.JToggleButton();
        seatG03 = new javax.swing.JToggleButton();
        seatG04 = new javax.swing.JToggleButton();
        seatH05 = new javax.swing.JToggleButton();
        seatG06 = new javax.swing.JToggleButton();
        seatH06 = new javax.swing.JToggleButton();
        seatG05 = new javax.swing.JToggleButton();
        seatG08 = new javax.swing.JToggleButton();
        seatH08 = new javax.swing.JToggleButton();
        seatH07 = new javax.swing.JToggleButton();
        seatG07 = new javax.swing.JToggleButton();
        seatH10 = new javax.swing.JToggleButton();
        seatG10 = new javax.swing.JToggleButton();
        seatG09 = new javax.swing.JToggleButton();
        seatH09 = new javax.swing.JToggleButton();
        seatH12 = new javax.swing.JToggleButton();
        seatH11 = new javax.swing.JToggleButton();
        seatG12 = new javax.swing.JToggleButton();
        seatG11 = new javax.swing.JToggleButton();
        displayTicNum = new javax.swing.JLabel();
        backFromSeat = new javax.swing.JLabel();
        newInside = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel76 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jButton113 = new javax.swing.JButton();
        ticketType = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        seatType = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        confirmType = new javax.swing.JButton();
        minusAdult = new javax.swing.JButton();
        plusOKU = new javax.swing.JButton();
        plusChildren = new javax.swing.JButton();
        plusSenior = new javax.swing.JButton();
        plusStudent = new javax.swing.JButton();
        plusAdult = new javax.swing.JButton();
        minusChildren = new javax.swing.JButton();
        minusOKU = new javax.swing.JButton();
        minusSenior = new javax.swing.JButton();
        minusStudent = new javax.swing.JButton();
        adultM = new javax.swing.JLabel();
        childrenM = new javax.swing.JLabel();
        OKUM = new javax.swing.JLabel();
        seniorM = new javax.swing.JLabel();
        studentM = new javax.swing.JLabel();
        adultPrice = new javax.swing.JLabel();
        childrenPrice = new javax.swing.JLabel();
        OKUPrice = new javax.swing.JLabel();
        seniorPrice = new javax.swing.JLabel();
        studentPrice = new javax.swing.JLabel();
        countAdult = new javax.swing.JLabel();
        countChildren = new javax.swing.JLabel();
        countOKU = new javax.swing.JLabel();
        countSenior = new javax.swing.JLabel();
        countStudent = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        backFromType = new javax.swing.JLabel();
        jButton118 = new javax.swing.JButton();
        jButton119 = new javax.swing.JButton();
        Feedback = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        userFinside = new javax.swing.JLabel();

        damaged2.setBackground(new java.awt.Color(32, 33, 35));
        damaged2.setPreferredSize(new java.awt.Dimension(111, 164));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Movies");

        jButton110.setBackground(new java.awt.Color(255, 255, 0));
        jButton110.setText("BUY NOW");
        jButton110.setBorder(null);
        jButton110.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton110ActionPerformed(evt);
            }
        });

        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Jumanji: The Next Level");

        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Star Wars: The Rise of Skywalker");

        jButton117.setBackground(new java.awt.Color(255, 255, 0));
        jButton117.setText("BUY NOW");
        jButton117.setBorder(null);

        javax.swing.GroupLayout damaged2Layout = new javax.swing.GroupLayout(damaged2);
        damaged2.setLayout(damaged2Layout);
        damaged2Layout.setHorizontalGroup(
            damaged2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(damaged2Layout.createSequentialGroup()
                .addGroup(damaged2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(damaged2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jButton110, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jButton117, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(damaged2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(damaged2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addGroup(damaged2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(damaged2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel53)
                                    .addComponent(jLabel52))
                                .addGap(32, 32, 32)
                                .addGroup(damaged2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        damaged2Layout.setVerticalGroup(
            damaged2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(damaged2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(damaged2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(damaged2Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel55))
                    .addGroup(damaged2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(damaged2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                            .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16)
                        .addGroup(damaged2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton110, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton117, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(239, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setMinimumSize(new java.awt.Dimension(1000, 530));
        jLayeredPane1.setLayout(new java.awt.CardLayout());

        login.setPreferredSize(new java.awt.Dimension(1000, 530));
        login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(550, 530));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Password");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(57, 113, 177));
        jLabel9.setText("Username");

        user.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        user.setBorder(null);
        user.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userFocusGained(evt);
            }
        });

        Login.setBackground(new java.awt.Color(0, 153, 153));
        Login.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Login.setForeground(new java.awt.Color(255, 255, 255));
        Login.setText("Login");
        Login.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Login.setBorderPainted(false);
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        password.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        password.setBorder(null);
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFocusGained(evt);
            }
        });

        jLabel28.setIcon(new javax.swing.ImageIcon("C:\\Users\\muham\\Desktop\\Final Project CSC238\\ticket.png")); // NOI18N

        jLabel29.setFont(new java.awt.Font("MV Boli", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 102, 102));
        jLabel29.setText("Movie Ticket System");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setText("Don't have an account?");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 153, 153));
        jLabel33.setText("Sign up here");
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel33)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel33))
                .addContainerGap())
        );

        login.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 0, 550, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\muham\\Desktop\\Final Project CSC238\\movieSkin.png")); // NOI18N
        login.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 530));

        jLayeredPane1.add(login, "card4");

        signup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(57, 113, 177));
        jLabel1.setText("Username");

        userF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        userF.setBorder(null);
        userF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userFFocusGained(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Email");

        mailF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mailF.setBorder(null);
        mailF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mailFFocusGained(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Password");

        passF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        passF.setBorder(null);
        passF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passFFocusGained(evt);
            }
        });

        Signup.setBackground(new java.awt.Color(0, 153, 153));
        Signup.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Signup.setForeground(new java.awt.Color(255, 255, 255));
        Signup.setText("Sign up");
        Signup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 87, 194)));
        Signup.setBorderPainted(false);
        Signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignupActionPerformed(evt);
            }
        });

        backFromSignUp.setIcon(new javax.swing.ImageIcon("C:\\Users\\muham\\Desktop\\Final Project CSC238\\backblue.png")); // NOI18N
        backFromSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backFromSignUpMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(backFromSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Signup, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                        .addComponent(jSeparator3)
                        .addComponent(jLabel3)
                        .addComponent(jSeparator2)
                        .addComponent(mailF)
                        .addComponent(jSeparator1)
                        .addComponent(userF)
                        .addComponent(passF)
                        .addComponent(jLabel2))
                    .addComponent(jLabel1))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(userF, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(mailF, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(passF, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(Signup, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(54, 54, 54)
                .addComponent(backFromSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        signup.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 550, 530));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\muham\\Desktop\\Final Project CSC238\\movieSkin.png")); // NOI18N
        signup.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 530));

        jLayeredPane1.add(signup, "card3");

        overall.setBackground(new java.awt.Color(255, 255, 255));
        overall.setPreferredSize(new java.awt.Dimension(1000, 530));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setMinimumSize(new java.awt.Dimension(1000, 530));

        jLayeredPane2.setLayout(new java.awt.CardLayout());

        switchInside.setBackground(new java.awt.Color(32, 33, 35));
        switchInside.setPreferredSize(new java.awt.Dimension(869, 510));

        movieName.setForeground(new java.awt.Color(255, 255, 255));
        movieName.setText("Jumanji: The Next Level");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Monday");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Tuesday");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Wednesday");

        b20.setBackground(new java.awt.Color(255, 255, 255));
        b20.setText("20");
        b20.setBorderPainted(false);
        b20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b20ActionPerformed(evt);
            }
        });

        b18.setBackground(new java.awt.Color(255, 255, 255));
        b18.setText("18");
        b18.setBorderPainted(false);
        b18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b18ActionPerformed(evt);
            }
        });

        b19.setBackground(new java.awt.Color(255, 255, 255));
        b19.setText("19");
        b19.setBorderPainted(false);
        b19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b19ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Penang - Queensbay Mall");

        penangQ1.setBackground(new java.awt.Color(255, 255, 255));
        penangQ1.setText("01:40 PM");
        penangQ1.setBorderPainted(false);
        penangQ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penangQ1ActionPerformed(evt);
            }
        });

        penangQ5.setBackground(new java.awt.Color(255, 255, 255));
        penangQ5.setText("05:50 PM");
        penangQ5.setBorderPainted(false);
        penangQ5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penangQ5ActionPerformed(evt);
            }
        });

        penangQ8.setBackground(new java.awt.Color(255, 255, 255));
        penangQ8.setText("08:10 PM");
        penangQ8.setActionCommand("");
        penangQ8.setBorderPainted(false);
        penangQ8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penangQ8ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Penang - Sunway Carnival");

        penangS1.setBackground(new java.awt.Color(255, 255, 255));
        penangS1.setText("01:40 PM");
        penangS1.setBorderPainted(false);
        penangS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penangS1ActionPerformed(evt);
            }
        });

        penangS4.setBackground(new java.awt.Color(255, 255, 255));
        penangS4.setText("04:30 PM");
        penangS4.setBorderPainted(false);
        penangS4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penangS4ActionPerformed(evt);
            }
        });

        penangS8.setBackground(new java.awt.Color(255, 255, 255));
        penangS8.setText("08:10 PM");
        penangS8.setActionCommand("");
        penangS8.setBorderPainted(false);
        penangS8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penangS8ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Alor Setar -  Aman Central");

        alorS1.setBackground(new java.awt.Color(255, 255, 255));
        alorS1.setText("01:40 PM");
        alorS1.setBorderPainted(false);
        alorS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alorS1ActionPerformed(evt);
            }
        });

        alorS8.setBackground(new java.awt.Color(255, 255, 255));
        alorS8.setText("08:10 PM");
        alorS8.setActionCommand("");
        alorS8.setBorderPainted(false);
        alorS8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alorS8ActionPerformed(evt);
            }
        });

        selectSeat.setBackground(new java.awt.Color(255, 255, 0));
        selectSeat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        selectSeat.setText("SELECT SEAT");
        selectSeat.setBorderPainted(false);
        selectSeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectSeatActionPerformed(evt);
            }
        });

        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        movieLayeredPane.setPreferredSize(new java.awt.Dimension(111, 164));

        jumanjiImage.setBackground(new java.awt.Color(32, 33, 35));
        jumanjiImage.setMinimumSize(new java.awt.Dimension(111, 164));

        jLabel27.setIcon(new javax.swing.ImageIcon("C:\\Users\\muham\\Desktop\\Final Project CSC238\\jumanji.png")); // NOI18N

        javax.swing.GroupLayout jumanjiImageLayout = new javax.swing.GroupLayout(jumanjiImage);
        jumanjiImage.setLayout(jumanjiImageLayout);
        jumanjiImageLayout.setHorizontalGroup(
            jumanjiImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jumanjiImageLayout.createSequentialGroup()
                .addComponent(jLabel27)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jumanjiImageLayout.setVerticalGroup(
            jumanjiImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jumanjiImageLayout.createSequentialGroup()
                .addComponent(jLabel27)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        birdsImage3.setMinimumSize(new java.awt.Dimension(111, 164));

        jLabel31.setIcon(new javax.swing.ImageIcon("C:\\Users\\muham\\Desktop\\Final Project CSC238\\birdsofprey.png")); // NOI18N

        javax.swing.GroupLayout birdsImage3Layout = new javax.swing.GroupLayout(birdsImage3);
        birdsImage3.setLayout(birdsImage3Layout);
        birdsImage3Layout.setHorizontalGroup(
            birdsImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31)
        );
        birdsImage3Layout.setVerticalGroup(
            birdsImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31)
        );

        dolittleImage.setMinimumSize(new java.awt.Dimension(111, 164));

        jLabel32.setIcon(new javax.swing.ImageIcon("C:\\Users\\muham\\Desktop\\Final Project CSC238\\dolittle.png")); // NOI18N

        javax.swing.GroupLayout dolittleImageLayout = new javax.swing.GroupLayout(dolittleImage);
        dolittleImage.setLayout(dolittleImageLayout);
        dolittleImageLayout.setHorizontalGroup(
            dolittleImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32)
        );
        dolittleImageLayout.setVerticalGroup(
            dolittleImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32)
        );

        movieLayeredPane.setLayer(jumanjiImage, javax.swing.JLayeredPane.DEFAULT_LAYER);
        movieLayeredPane.setLayer(birdsImage3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        movieLayeredPane.setLayer(dolittleImage, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout movieLayeredPaneLayout = new javax.swing.GroupLayout(movieLayeredPane);
        movieLayeredPane.setLayout(movieLayeredPaneLayout);
        movieLayeredPaneLayout.setHorizontalGroup(
            movieLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jumanjiImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(movieLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(movieLayeredPaneLayout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(birdsImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(movieLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(movieLayeredPaneLayout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(dolittleImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        movieLayeredPaneLayout.setVerticalGroup(
            movieLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jumanjiImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(movieLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(movieLayeredPaneLayout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(birdsImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(movieLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(movieLayeredPaneLayout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(dolittleImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        backFromSwitch.setIcon(new javax.swing.ImageIcon("C:\\Users\\muham\\Desktop\\Final Project CSC238\\back.png")); // NOI18N
        backFromSwitch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backFromSwitchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout switchInsideLayout = new javax.swing.GroupLayout(switchInside);
        switchInside.setLayout(switchInsideLayout);
        switchInsideLayout.setHorizontalGroup(
            switchInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(switchInsideLayout.createSequentialGroup()
                .addGroup(switchInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(switchInsideLayout.createSequentialGroup()
                        .addGroup(switchInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(switchInsideLayout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(movieImage))
                            .addGroup(switchInsideLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(backFromSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(switchInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(movieName)
                            .addComponent(movieLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(switchInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(switchInsideLayout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addGroup(switchInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(switchInsideLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addGroup(switchInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel25)
                                    .addGroup(switchInsideLayout.createSequentialGroup()
                                        .addComponent(penangQ1)
                                        .addGap(18, 18, 18)
                                        .addComponent(penangQ5)
                                        .addGap(18, 18, 18)
                                        .addComponent(penangQ8))
                                    .addGroup(switchInsideLayout.createSequentialGroup()
                                        .addComponent(penangS1)
                                        .addGap(18, 18, 18)
                                        .addComponent(penangS4)
                                        .addGap(18, 18, 18)
                                        .addComponent(penangS8))
                                    .addComponent(jLabel13)
                                    .addGroup(switchInsideLayout.createSequentialGroup()
                                        .addComponent(alorS1)
                                        .addGap(18, 18, 18)
                                        .addComponent(alorS8))))
                            .addGroup(switchInsideLayout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addGroup(switchInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(switchInsideLayout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(switchInsideLayout.createSequentialGroup()
                                        .addComponent(b18)
                                        .addGap(18, 18, 18)
                                        .addComponent(b19)))
                                .addGap(18, 18, 18)
                                .addGroup(switchInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(b20)
                                    .addComponent(jLabel23)))))
                    .addGroup(switchInsideLayout.createSequentialGroup()
                        .addGap(381, 381, 381)
                        .addComponent(selectSeat)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        switchInsideLayout.setVerticalGroup(
            switchInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(switchInsideLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(switchInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(switchInsideLayout.createSequentialGroup()
                        .addGroup(switchInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(switchInsideLayout.createSequentialGroup()
                                .addGroup(switchInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(switchInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(b19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(b18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(b20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(switchInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(penangQ1)
                                    .addComponent(penangQ5)
                                    .addComponent(penangQ8))
                                .addGap(22, 22, 22)
                                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(switchInsideLayout.createSequentialGroup()
                                .addComponent(movieImage)
                                .addGap(35, 35, 35))
                            .addGroup(switchInsideLayout.createSequentialGroup()
                                .addGroup(switchInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(backFromSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(129, 129, 129)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25))
                    .addGroup(switchInsideLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(movieLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(switchInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(penangS1)
                    .addComponent(penangS4)
                    .addComponent(penangS8)
                    .addComponent(movieName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(switchInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alorS1)
                    .addComponent(alorS8))
                .addGap(18, 18, 18)
                .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(selectSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jLayeredPane2.add(switchInside, "card3");

        seat.setBackground(new java.awt.Color(32, 33, 35));
        seat.setPreferredSize(new java.awt.Dimension(869, 510));

        confirmSeat.setBackground(new java.awt.Color(255, 255, 0));
        confirmSeat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        confirmSeat.setText("CONFIRM");
        confirmSeat.setBorderPainted(false);
        confirmSeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmSeatActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("ticket(s)");

        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setIcon(new javax.swing.ImageIcon("C:\\Users\\muham\\Desktop\\Final Project CSC238\\curvewhite.png")); // NOI18N

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Screen");

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("H");

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("G");

        seatH01.setText("H01");
        seatH01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatH01ActionPerformed(evt);
            }
        });

        seatH02.setText("H02");
        seatH02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatH02ActionPerformed(evt);
            }
        });

        seatG01.setText("G01");
        seatG01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatG01ActionPerformed(evt);
            }
        });

        seatG02.setText("G02");
        seatG02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatG02ActionPerformed(evt);
            }
        });

        seatH03.setText("H03");
        seatH03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatH03ActionPerformed(evt);
            }
        });

        seatH04.setText("H04");
        seatH04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatH04ActionPerformed(evt);
            }
        });

        seatG03.setText("G03");
        seatG03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatG03ActionPerformed(evt);
            }
        });

        seatG04.setText("G04");
        seatG04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatG04ActionPerformed(evt);
            }
        });

        seatH05.setText("H05");
        seatH05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatH05ActionPerformed(evt);
            }
        });

        seatG06.setText("G06");
        seatG06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatG06ActionPerformed(evt);
            }
        });

        seatH06.setText("H06");
        seatH06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatH06ActionPerformed(evt);
            }
        });

        seatG05.setText("G05");
        seatG05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatG05ActionPerformed(evt);
            }
        });

        seatG08.setText("G08");
        seatG08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatG08ActionPerformed(evt);
            }
        });

        seatH08.setText("H08");
        seatH08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatH08ActionPerformed(evt);
            }
        });

        seatH07.setText("H07");
        seatH07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatH07ActionPerformed(evt);
            }
        });

        seatG07.setText("G07");
        seatG07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatG07ActionPerformed(evt);
            }
        });

        seatH10.setText("H10");
        seatH10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatH10ActionPerformed(evt);
            }
        });

        seatG10.setText("G10");
        seatG10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatG10ActionPerformed(evt);
            }
        });

        seatG09.setText("G09");
        seatG09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatG09ActionPerformed(evt);
            }
        });

        seatH09.setText("H09");
        seatH09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatH09ActionPerformed(evt);
            }
        });

        seatH12.setText("H12");
        seatH12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatH12ActionPerformed(evt);
            }
        });

        seatH11.setText("H11");
        seatH11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatH11ActionPerformed(evt);
            }
        });

        seatG12.setText("G12");
        seatG12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatG12ActionPerformed(evt);
            }
        });

        seatG11.setText("G11");
        seatG11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatG11ActionPerformed(evt);
            }
        });

        displayTicNum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        displayTicNum.setForeground(new java.awt.Color(255, 255, 0));
        displayTicNum.setText("0");

        backFromSeat.setIcon(new javax.swing.ImageIcon("C:\\Users\\muham\\Desktop\\Final Project CSC238\\back.png")); // NOI18N
        backFromSeat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backFromSeatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout seatLayout = new javax.swing.GroupLayout(seat);
        seat.setLayout(seatLayout);
        seatLayout.setHorizontalGroup(
            seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seatLayout.createSequentialGroup()
                .addGroup(seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(seatLayout.createSequentialGroup()
                        .addGap(411, 411, 411)
                        .addComponent(jLabel49))
                    .addGroup(seatLayout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(confirmSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(displayTicNum, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel45)))
                .addContainerGap(315, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, seatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(seatLayout.createSequentialGroup()
                        .addComponent(backFromSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, seatLayout.createSequentialGroup()
                        .addGroup(seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50)
                            .addComponent(jLabel51))
                        .addGap(35, 35, 35)
                        .addGroup(seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(seatLayout.createSequentialGroup()
                                .addComponent(seatH01)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seatH02))
                            .addGroup(seatLayout.createSequentialGroup()
                                .addComponent(seatG01)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seatG02)))
                        .addGap(42, 42, 42)
                        .addGroup(seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(seatLayout.createSequentialGroup()
                                .addComponent(seatH03)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seatH04))
                            .addGroup(seatLayout.createSequentialGroup()
                                .addComponent(seatG03)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seatG04)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(seatLayout.createSequentialGroup()
                                .addComponent(seatH05)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seatH06))
                            .addGroup(seatLayout.createSequentialGroup()
                                .addComponent(seatG05)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seatG06)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(seatLayout.createSequentialGroup()
                                .addComponent(seatH07)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seatH08))
                            .addGroup(seatLayout.createSequentialGroup()
                                .addComponent(seatG07)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seatG08)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(seatLayout.createSequentialGroup()
                                .addComponent(seatH09)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seatH10))
                            .addGroup(seatLayout.createSequentialGroup()
                                .addComponent(seatG09)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seatG10)))
                        .addGap(40, 40, 40)
                        .addGroup(seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(seatLayout.createSequentialGroup()
                                .addComponent(seatH11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seatH12))
                            .addGroup(seatLayout.createSequentialGroup()
                                .addComponent(seatG11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seatG12)))
                        .addGap(58, 58, 58))))
        );
        seatLayout.setVerticalGroup(
            seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, seatLayout.createSequentialGroup()
                .addGroup(seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(seatLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel48)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, seatLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backFromSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addComponent(jLabel49)
                .addGap(7, 7, 7)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(seatLayout.createSequentialGroup()
                        .addGroup(seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seatH03, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seatH04, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seatG03, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seatG04, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(seatLayout.createSequentialGroup()
                        .addGroup(seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(seatH01, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seatH02, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seatG01, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seatG02, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51)))
                    .addGroup(seatLayout.createSequentialGroup()
                        .addGroup(seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seatH05, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seatH06, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seatG05, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seatG06, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(seatLayout.createSequentialGroup()
                        .addGroup(seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seatH07, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seatH08, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seatG07, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seatG08, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(seatLayout.createSequentialGroup()
                        .addGroup(seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seatH09, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seatH10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seatG09, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seatG10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(seatLayout.createSequentialGroup()
                        .addGroup(seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seatH11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seatH12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seatG11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seatG12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(206, 206, 206)
                .addGroup(seatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(displayTicNum))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jLayeredPane2.add(seat, "card6");

        newInside.setBackground(new java.awt.Color(32, 33, 35));

        jLabel64.setIcon(new javax.swing.ImageIcon("C:\\Users\\muham\\Desktop\\Final Project CSC238\\dolittle.png")); // NOI18N

        jLabel65.setIcon(new javax.swing.ImageIcon("C:\\Users\\muham\\Desktop\\Final Project CSC238\\jumanji.png")); // NOI18N

        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("Jumaji: The Next Level");

        jButton7.setBackground(new java.awt.Color(255, 255, 0));
        jButton7.setText("Buy Now");
        jButton7.setBorderPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("Dolittle");

        jButton10.setBackground(new java.awt.Color(255, 255, 0));
        jButton10.setText("Buy Now");
        jButton10.setBorderPainted(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel76.setIcon(new javax.swing.ImageIcon("C:\\Users\\muham\\Desktop\\Final Project CSC238\\birdsofprey.png")); // NOI18N

        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setText("Birds Of Prey");

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setText("Movies");

        jButton113.setBackground(new java.awt.Color(255, 255, 0));
        jButton113.setText("Buy Now");
        jButton113.setBorderPainted(false);
        jButton113.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton113ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout newInsideLayout = new javax.swing.GroupLayout(newInside);
        newInside.setLayout(newInsideLayout);
        newInsideLayout.setHorizontalGroup(
            newInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newInsideLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(newInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newInsideLayout.createSequentialGroup()
                        .addComponent(jLabel68)
                        .addGap(92, 92, 92)
                        .addComponent(jLabel79))
                    .addGroup(newInsideLayout.createSequentialGroup()
                        .addGroup(newInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65)
                            .addComponent(jLabel83)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68)
                        .addGroup(newInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton113, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel76))))
                .addGroup(newInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newInsideLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel71))
                    .addGroup(newInsideLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(newInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(366, Short.MAX_VALUE))
        );
        newInsideLayout.setVerticalGroup(
            newInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newInsideLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(newInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(newInsideLayout.createSequentialGroup()
                        .addComponent(jLabel83)
                        .addGap(18, 18, 18)
                        .addGroup(newInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel65)
                            .addComponent(jLabel76)))
                    .addComponent(jLabel64))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(newInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(newInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton113)
                    .addComponent(jButton10))
                .addContainerGap(246, Short.MAX_VALUE))
        );

        jLayeredPane2.add(newInside, "card7");

        ticketType.setBackground(new java.awt.Color(32, 33, 35));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Confirm Ticket Type");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 0));
        jLabel10.setText("SEATS");

        seatType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        seatType.setForeground(new java.awt.Color(255, 255, 255));
        seatType.setText("H01,H02,H03,H04,H05,H06,H07,H08,H09,H10,H11,H12");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 0));
        jLabel12.setText("TICKETS");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Student");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Children");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("OKU");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Senior");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Adult");

        confirmType.setBackground(new java.awt.Color(255, 255, 0));
        confirmType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        confirmType.setText("CONFIRM");
        confirmType.setBorderPainted(false);
        confirmType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmTypeActionPerformed(evt);
            }
        });

        minusAdult.setBackground(new java.awt.Color(102, 102, 102));
        minusAdult.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        minusAdult.setForeground(new java.awt.Color(255, 255, 255));
        minusAdult.setText("-");
        minusAdult.setBorderPainted(false);
        minusAdult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusAdultActionPerformed(evt);
            }
        });

        plusOKU.setBackground(new java.awt.Color(255, 255, 0));
        plusOKU.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        plusOKU.setText("+");
        plusOKU.setBorderPainted(false);
        plusOKU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusOKUActionPerformed(evt);
            }
        });

        plusChildren.setBackground(new java.awt.Color(255, 255, 0));
        plusChildren.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        plusChildren.setText("+");
        plusChildren.setBorderPainted(false);
        plusChildren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusChildrenActionPerformed(evt);
            }
        });

        plusSenior.setBackground(new java.awt.Color(255, 255, 0));
        plusSenior.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        plusSenior.setText("+");
        plusSenior.setBorderPainted(false);
        plusSenior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusSeniorActionPerformed(evt);
            }
        });

        plusStudent.setBackground(new java.awt.Color(255, 255, 0));
        plusStudent.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        plusStudent.setText("+");
        plusStudent.setBorderPainted(false);
        plusStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusStudentActionPerformed(evt);
            }
        });

        plusAdult.setBackground(new java.awt.Color(255, 255, 0));
        plusAdult.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        plusAdult.setText("+");
        plusAdult.setBorderPainted(false);
        plusAdult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusAdultActionPerformed(evt);
            }
        });

        minusChildren.setBackground(new java.awt.Color(102, 102, 102));
        minusChildren.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        minusChildren.setForeground(new java.awt.Color(255, 255, 255));
        minusChildren.setText("-");
        minusChildren.setBorderPainted(false);
        minusChildren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusChildrenActionPerformed(evt);
            }
        });

        minusOKU.setBackground(new java.awt.Color(102, 102, 102));
        minusOKU.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        minusOKU.setForeground(new java.awt.Color(255, 255, 255));
        minusOKU.setText("-");
        minusOKU.setBorderPainted(false);
        minusOKU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusOKUActionPerformed(evt);
            }
        });

        minusSenior.setBackground(new java.awt.Color(102, 102, 102));
        minusSenior.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        minusSenior.setForeground(new java.awt.Color(255, 255, 255));
        minusSenior.setText("-");
        minusSenior.setBorderPainted(false);
        minusSenior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusSeniorActionPerformed(evt);
            }
        });

        minusStudent.setBackground(new java.awt.Color(102, 102, 102));
        minusStudent.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        minusStudent.setForeground(new java.awt.Color(255, 255, 255));
        minusStudent.setText("-");
        minusStudent.setBorderPainted(false);
        minusStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusStudentActionPerformed(evt);
            }
        });

        adultM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        adultM.setForeground(new java.awt.Color(255, 255, 255));
        adultM.setText("Adult");

        childrenM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        childrenM.setForeground(new java.awt.Color(255, 255, 255));
        childrenM.setText("Children");

        OKUM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        OKUM.setForeground(new java.awt.Color(255, 255, 255));
        OKUM.setText("OKU");

        seniorM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        seniorM.setForeground(new java.awt.Color(255, 255, 255));
        seniorM.setText("Senior");

        studentM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        studentM.setForeground(new java.awt.Color(255, 255, 255));
        studentM.setText("Student");

        adultPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        adultPrice.setForeground(new java.awt.Color(255, 255, 255));
        adultPrice.setText(" ");

        childrenPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        childrenPrice.setForeground(new java.awt.Color(255, 255, 255));
        childrenPrice.setText(" ");

        OKUPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        OKUPrice.setForeground(new java.awt.Color(255, 255, 255));
        OKUPrice.setText(" ");

        seniorPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        seniorPrice.setForeground(new java.awt.Color(255, 255, 255));
        seniorPrice.setText(" ");

        studentPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        studentPrice.setForeground(new java.awt.Color(255, 255, 255));
        studentPrice.setText(" ");

        countAdult.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        countAdult.setForeground(new java.awt.Color(255, 255, 255));
        countAdult.setText("0");

        countChildren.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        countChildren.setForeground(new java.awt.Color(255, 255, 255));
        countChildren.setText("0");

        countOKU.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        countOKU.setForeground(new java.awt.Color(255, 255, 255));
        countOKU.setText("0");

        countSenior.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        countSenior.setForeground(new java.awt.Color(255, 255, 255));
        countSenior.setText("0");

        countStudent.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        countStudent.setForeground(new java.awt.Color(255, 255, 255));
        countStudent.setText("0");

        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel34MouseClicked(evt);
            }
        });

        backFromType.setIcon(new javax.swing.ImageIcon("C:\\Users\\muham\\Desktop\\Final Project CSC238\\back.png")); // NOI18N
        backFromType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backFromTypeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ticketTypeLayout = new javax.swing.GroupLayout(ticketType);
        ticketType.setLayout(ticketTypeLayout);
        ticketTypeLayout.setHorizontalGroup(
            ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ticketTypeLayout.createSequentialGroup()
                .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ticketTypeLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ticketTypeLayout.createSequentialGroup()
                                .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ticketTypeLayout.createSequentialGroup()
                                        .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(studentM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(seniorM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(OKUM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(childrenM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(adultM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(132, 132, 132)
                                        .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(adultPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(childrenPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(OKUPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(seniorPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(studentPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel10))
                                .addGap(94, 105, Short.MAX_VALUE)
                                .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(96, 96, 96)
                                .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(minusStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(minusSenior, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(minusAdult, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minusChildren, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minusOKU, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(countAdult, javax.swing.GroupLayout.DEFAULT_SIZE, 13, Short.MAX_VALUE)
                                    .addComponent(countChildren, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(countOKU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(countSenior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(countStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(plusChildren)
                                    .addComponent(plusAdult, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(plusSenior)
                                    .addComponent(plusOKU)
                                    .addComponent(plusStudent)))
                            .addGroup(ticketTypeLayout.createSequentialGroup()
                                .addComponent(seatType)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(ticketTypeLayout.createSequentialGroup()
                        .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ticketTypeLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(backFromType, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7))
                            .addGroup(ticketTypeLayout.createSequentialGroup()
                                .addGap(363, 363, 363)
                                .addComponent(confirmType, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 32, Short.MAX_VALUE)))
                .addGap(93, 93, 93))
        );
        ticketTypeLayout.setVerticalGroup(
            ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ticketTypeLayout.createSequentialGroup()
                .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ticketTypeLayout.createSequentialGroup()
                            .addGap(57, 57, 57)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ticketTypeLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(backFromType, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ticketTypeLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel7)))
                .addGap(58, 58, 58)
                .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ticketTypeLayout.createSequentialGroup()
                        .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ticketTypeLayout.createSequentialGroup()
                                .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(plusAdult)
                                    .addComponent(countAdult))
                                .addGap(18, 18, 18)
                                .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(plusChildren)
                                    .addComponent(countChildren)))
                            .addGroup(ticketTypeLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(seatType)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(plusOKU)
                            .addComponent(adultM)
                            .addComponent(adultPrice)
                            .addComponent(countOKU))
                        .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ticketTypeLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(plusSenior)
                                    .addComponent(countSenior)))
                            .addGroup(ticketTypeLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(childrenM)
                                    .addComponent(childrenPrice))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(OKUM)
                                    .addComponent(OKUPrice))))
                        .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ticketTypeLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(seniorM)
                                    .addComponent(seniorPrice))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(studentM)
                                    .addComponent(studentPrice)))
                            .addGroup(ticketTypeLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(plusStudent)
                                    .addComponent(minusStudent)
                                    .addComponent(jLabel14)
                                    .addComponent(countStudent))))
                        .addGap(189, 189, 189))
                    .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(ticketTypeLayout.createSequentialGroup()
                            .addComponent(jLabel20)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(confirmType, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51))
                        .addGroup(ticketTypeLayout.createSequentialGroup()
                            .addComponent(minusAdult)
                            .addGap(18, 18, 18)
                            .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(minusChildren)
                                .addComponent(jLabel15))
                            .addGap(19, 19, 19)
                            .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(minusOKU)
                                .addComponent(jLabel18))
                            .addGap(18, 18, 18)
                            .addGroup(ticketTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(minusSenior)
                                .addComponent(jLabel19))
                            .addGap(243, 243, 243)))))
        );

        jLayeredPane2.add(ticketType, "card5");

        jButton118.setBackground(new java.awt.Color(32, 33, 35));
        jButton118.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton118.setForeground(new java.awt.Color(255, 255, 255));
        jButton118.setText("Logout");
        jButton118.setBorderPainted(false);
        jButton118.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton118ActionPerformed(evt);
            }
        });

        jButton119.setBackground(new java.awt.Color(32, 33, 35));
        jButton119.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton119.setForeground(new java.awt.Color(255, 255, 255));
        jButton119.setText("Menu");
        jButton119.setBorderPainted(false);
        jButton119.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton119ActionPerformed(evt);
            }
        });

        Feedback.setBackground(new java.awt.Color(32, 33, 35));
        Feedback.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Feedback.setForeground(new java.awt.Color(255, 255, 255));
        Feedback.setText("Send feedback");
        Feedback.setBorderPainted(false);
        Feedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeedbackActionPerformed(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Users\\muham\\Desktop\\Final Project CSC238\\user.png")); // NOI18N
        jLabel16.setText("User icon");

        userFinside.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        userFinside.setForeground(new java.awt.Color(255, 255, 255));
        userFinside.setText("   Anas");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton119, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton118, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Feedback, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(userFinside, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userFinside)
                .addGap(18, 18, 18)
                .addComponent(jButton119)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Feedback)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton118)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout overallLayout = new javax.swing.GroupLayout(overall);
        overall.setLayout(overallLayout);
        overallLayout.setHorizontalGroup(
            overallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(overallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        overallLayout.setVerticalGroup(
            overallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
            .addGroup(overallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane1.add(overall, "card5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton118ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton118ActionPerformed
        // TODO add your handling code here:
        
        //LOGOUT
        setDisplayEmpty();
        cUser++;
        limitSeat=0;
        ticket=0;
        displayTicNum.setText("0");
        clearSeat();
        clearType();
        checkDate=0;
        checkCinema=0;
        
        overall.setVisible(false);
        newInside.setVisible(false);
        switchInside.setVisible(false);
        seat.setVisible(false);
        ticketType.setVisible(false);
        login.setVisible(true);
        
        jLabel9.setBackground(new Color(57,113,177));
        user.requestFocus();
        
        clearTextLogin();
        clearTextSignUp();
    }//GEN-LAST:event_jButton118ActionPerformed

    public void setTaken(int a,int b,int c) {
        for(int i=0; i<25; i++) {
            System.out.println("Seat1["+i+"]="+seat1[i]);
        }
        
        if(a==1) { // set for jumanji
            if(b==1 && c==1) { // 18 & p1
                for(int i=0; i<25; i++) {
                    if(seat1[i] == 1)
                        seatH01.setEnabled(false);
                    if(seat1[i] == 2)
                        seatH02.setEnabled(false);
                    if(seat1[i] == 3)
                        seatH03.setEnabled(false);
                    if(seat1[i] == 4)
                        seatH04.setEnabled(false);
                    if(seat1[i] == 5)
                        seatH05.setEnabled(false);
                    if(seat1[i] == 6)
                        seatH06.setEnabled(false);
                    if(seat1[i] == 7)
                        seatH07.setEnabled(false);
                    if(seat1[i] == 8)
                        seatH08.setEnabled(false);
                    if(seat1[i] == 9)
                        seatH09.setEnabled(false);
                    if(seat1[i] == 10)
                        seatH10.setEnabled(false);
                    if(seat1[i] == 11)
                        seatH11.setEnabled(false);
                    if(seat1[i] == 12)
                        seatH12.setEnabled(false);
                    if(seat1[i] == 13)
                        seatG01.setEnabled(false);
                    if(seat1[i] == 14)
                        seatG02.setEnabled(false);
                    if(seat1[i] == 15)
                        seatG03.setEnabled(false);
                    if(seat1[i] == 16)
                        seatG04.setEnabled(false);
                    if(seat1[i] == 17)
                        seatG05.setEnabled(false);
                    if(seat1[i] == 18)
                        seatG06.setEnabled(false);
                    if(seat1[i] == 19)
                        seatG07.setEnabled(false);
                    if(seat1[i] == 20)
                        seatG08.setEnabled(false);
                    if(seat1[i] == 21)
                        seatG09.setEnabled(false);
                    if(seat1[i] == 22)
                        seatG10.setEnabled(false);
                    if(seat1[i] == 23)
                        seatG11.setEnabled(false);
                    if(seat1[i] == 24)
                        seatG12.setEnabled(false);
                }
            }
            if(b==1 && c==2) { // 18 & p2
                for(int i=0; i<25; i++) {
                    if(seat2[i] == 1)
                        seatH01.setEnabled(false);
                    if(seat2[i] == 2)
                        seatH02.setEnabled(false);
                    if(seat2[i] == 3)
                        seatH03.setEnabled(false);
                    if(seat2[i] == 4)
                        seatH04.setEnabled(false);
                    if(seat2[i] == 5)
                        seatH05.setEnabled(false);
                    if(seat2[i] == 6)
                        seatH06.setEnabled(false);
                    if(seat2[i] == 7)
                        seatH07.setEnabled(false);
                    if(seat2[i] == 8)
                        seatH08.setEnabled(false);
                    if(seat2[i] == 9)
                        seatH09.setEnabled(false);
                    if(seat2[i] == 10)
                        seatH10.setEnabled(false);
                    if(seat2[i] == 11)
                        seatH11.setEnabled(false);
                    if(seat2[i] == 12)
                        seatH12.setEnabled(false);
                    if(seat2[i] == 13)
                        seatG01.setEnabled(false);
                    if(seat2[i] == 14)
                        seatG02.setEnabled(false);
                    if(seat2[i] == 15)
                        seatG03.setEnabled(false);
                    if(seat2[i] == 16)
                        seatG04.setEnabled(false);
                    if(seat2[i] == 17)
                        seatG05.setEnabled(false);
                    if(seat2[i] == 18)
                        seatG06.setEnabled(false);
                    if(seat2[i] == 19)
                        seatG07.setEnabled(false);
                    if(seat2[i] == 20)
                        seatG08.setEnabled(false);
                    if(seat2[i] == 21)
                        seatG09.setEnabled(false);
                    if(seat2[i] == 22)
                        seatG10.setEnabled(false);
                    if(seat2[i] == 23)
                        seatG11.setEnabled(false);
                    if(seat2[i] == 24)
                        seatG12.setEnabled(false);
                }
            }
        }
        if(a==2) { // set for birdsofprey
            if(b==1 && c==1) { // 18 & p1
                for(int i=0; i<25; i++) {
                    if(seat2[i] == 1)
                        seatH01.setEnabled(false);
                    if(seat2[i] == 2)
                        seatH02.setEnabled(false);
                    if(seat2[i] == 3)
                        seatH03.setEnabled(false);
                }
            }
            if(b==1 && c==2) { // 18 & p2
                for(int i=0; i<25; i++) {
                    if(seat2[i] == 1)
                        seatH01.setEnabled(false);
                    if(seat2[i] == 2)
                        seatH02.setEnabled(false);
                    if(seat2[i] == 3)
                        seatH03.setEnabled(false);
                }
            }
        }
        if(a==3) { // set for dolittle
            if(b==1 && c==1) { // 18 & p1
                for(int i=0; i<25; i++) {
                    if(seat2[i] == 1)
                        seatH01.setEnabled(false);
                    if(seat2[i] == 2)
                        seatH02.setEnabled(false);
                    if(seat2[i] == 3)
                        seatH03.setEnabled(false);
                }
            }
            if(b==1 && c==2) { // 18 & p2
                for(int i=0; i<25; i++) {
                    if(seat2[i] == 1)
                        seatH01.setEnabled(false);
                    if(seat2[i] == 2)
                        seatH02.setEnabled(false);
                    if(seat2[i] == 3)
                        seatH03.setEnabled(false);
                }
            }
        }
    }
    
    private void selectSeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectSeatActionPerformed
        // TODO add your handling code here:
        
        // SELECT SEAT
        
        if(ignore>0) {
            if(xCheck == 1) {
                if(checkAgain == 1 && checkAgain2 == 1) {
                    setTaken(1,1,1);
                }
                if(checkAgain == 1 && checkAgain2 == 2) {
                    setTaken(1,1,2);
                }
            }
        }
        
        clearChoice();
        
        newInside.setVisible(false);
        switchInside.setVisible(false);
        seat.setVisible(true); 
        confirmSeat.setVisible(false);
    }//GEN-LAST:event_selectSeatActionPerformed

    private void jButton110ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton110ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton110ActionPerformed

    public void enableButton() {
        if(checkDate>0 && checkCinema>0) {
            selectSeat.setVisible(true);
        }
    }
    
    private void b18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b18ActionPerformed
        // TODO add your handling code here:
        checkAgain = 1;
        checkDate++;
        enableButton();
            
        b18.setBackground(new Color(255,255,0));
        b19.setBackground(new Color(255,255,255));
        b20.setBackground(new Color(255,255,255));
        
        mDetail[cUser].setMovieDate("18/12/2019");
    }//GEN-LAST:event_b18ActionPerformed

    private void b19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b19ActionPerformed
        // TODO add your handling code here:
        checkAgain = 2;
        checkDate++;
        enableButton();
        
        b18.setBackground(new Color(255,255,255));
        b19.setBackground(new Color(255,255,0));
        b20.setBackground(new Color(255,255,255));
        
        mDetail[cUser].setMovieDate("19/12/2019");
    }//GEN-LAST:event_b19ActionPerformed

    private void b20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b20ActionPerformed
        // TODO add your handling code here:
        checkAgain = 3;
        checkDate++;
        enableButton();
        
        b18.setBackground(new Color(255,255,255));
        b19.setBackground(new Color(255,255,255));
        b20.setBackground(new Color(255,255,0));
        
        mDetail[cUser].setMovieDate("20/12/2019");
    }//GEN-LAST:event_b20ActionPerformed

    private void penangQ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penangQ1ActionPerformed
        // TODO add your handling code here
        checkAgain2 = 1;
        checkCinema++;
        enableButton();
        
        penangQ1.setBackground(new Color(255,255,0));
        penangQ5.setBackground(new Color(255,255,255));
        penangQ8.setBackground(new Color(255,255,255));
        penangS1.setBackground(new Color(255,255,255));
        penangS4.setBackground(new Color(255,255,255));
        penangS8.setBackground(new Color(255,255,255));
        alorS1.setBackground(new Color(255,255,255));
        alorS8.setBackground(new Color(255,255,255));
        
        mDetail[cUser].setCinema("Penang - Queensday Mall");
        mDetail[cUser].setMovieTime("01:40 PM");
    }//GEN-LAST:event_penangQ1ActionPerformed

    private void penangQ5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penangQ5ActionPerformed
        // TODO add your handling code here:
        checkAgain2 = 2;
        checkCinema++;
        enableButton();
        
        penangQ1.setBackground(new Color(255,255,255));
        penangQ5.setBackground(new Color(255,255,0));
        penangQ8.setBackground(new Color(255,255,255));
        penangS1.setBackground(new Color(255,255,255));
        penangS4.setBackground(new Color(255,255,255));
        penangS8.setBackground(new Color(255,255,255));
        alorS1.setBackground(new Color(255,255,255));
        alorS8.setBackground(new Color(255,255,255));
        
        mDetail[cUser].setCinema("Penang - Queensday Mall");
        mDetail[cUser].setMovieTime("05:50 PM");
    }//GEN-LAST:event_penangQ5ActionPerformed

    private void penangQ8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penangQ8ActionPerformed
        // TODO add your handling code here:
        checkAgain2 = 3;
        checkCinema++;
        enableButton();
        
        penangQ1.setBackground(new Color(255,255,255));
        penangQ5.setBackground(new Color(255,255,255));
        penangQ8.setBackground(new Color(255,255,0));
        penangS1.setBackground(new Color(255,255,255));
        penangS4.setBackground(new Color(255,255,255));
        penangS8.setBackground(new Color(255,255,255));
        alorS1.setBackground(new Color(255,255,255));
        alorS8.setBackground(new Color(255,255,255));
        
        mDetail[cUser].setCinema("Penang - Queensday Mall");
        mDetail[cUser].setMovieTime("08:10 PM");
    }//GEN-LAST:event_penangQ8ActionPerformed

    private void penangS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penangS1ActionPerformed
        // TODO add your handling code here:
        checkAgain2 = 4;
        checkCinema++;
        enableButton();
        
        penangQ1.setBackground(new Color(255,255,255));
        penangQ5.setBackground(new Color(255,255,255));
        penangQ8.setBackground(new Color(255,255,255));
        penangS1.setBackground(new Color(255,255,0));
        penangS4.setBackground(new Color(255,255,255));
        penangS8.setBackground(new Color(255,255,255));
        alorS1.setBackground(new Color(255,255,255));
        alorS8.setBackground(new Color(255,255,255));
        
        mDetail[cUser].setCinema("Penang - Sunway Carnival");
        mDetail[cUser].setMovieTime("01:40 PM");
    }//GEN-LAST:event_penangS1ActionPerformed

    private void penangS4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penangS4ActionPerformed
        // TODO add your handling code here:
        checkAgain2 = 5;
        checkCinema++;
        enableButton();
        
        penangQ1.setBackground(new Color(255,255,255));
        penangQ5.setBackground(new Color(255,255,255));
        penangQ8.setBackground(new Color(255,255,255));
        penangS1.setBackground(new Color(255,255,255));
        penangS4.setBackground(new Color(255,255,0));
        penangS8.setBackground(new Color(255,255,255));
        alorS1.setBackground(new Color(255,255,255));
        alorS8.setBackground(new Color(255,255,255));
        
        mDetail[cUser].setCinema("Penang - Sunway Carnival");
        mDetail[cUser].setMovieTime("04:30 PM");
    }//GEN-LAST:event_penangS4ActionPerformed

    private void penangS8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penangS8ActionPerformed
        // TODO add your handling code here:
        checkAgain2 = 6;
        checkCinema++;
        enableButton();
        
        penangQ1.setBackground(new Color(255,255,255));
        penangQ5.setBackground(new Color(255,255,255));
        penangQ8.setBackground(new Color(255,255,255));
        penangS1.setBackground(new Color(255,255,255));
        penangS4.setBackground(new Color(255,255,255));
        penangS8.setBackground(new Color(255,255,0));
        alorS1.setBackground(new Color(255,255,255));
        alorS8.setBackground(new Color(255,255,255));
        
        mDetail[cUser].setCinema("Penang - Sunway Carnival");
        mDetail[cUser].setMovieTime("08:10 PM");
    }//GEN-LAST:event_penangS8ActionPerformed

    private void alorS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alorS1ActionPerformed
        // TODO add your handling code here:
        checkAgain2 = 7;
        checkCinema++;
        enableButton();
        
        penangQ1.setBackground(new Color(255,255,255));
        penangQ5.setBackground(new Color(255,255,255));
        penangQ8.setBackground(new Color(255,255,255));
        penangS1.setBackground(new Color(255,255,255));
        penangS4.setBackground(new Color(255,255,255));
        penangS8.setBackground(new Color(255,255,255));
        alorS1.setBackground(new Color(255,255,0));
        alorS8.setBackground(new Color(255,255,255));
        
        mDetail[cUser].setCinema("Alor Setar - Aman Central");
        mDetail[cUser].setMovieTime("01:40 PM");
    }//GEN-LAST:event_alorS1ActionPerformed

    private void alorS8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alorS8ActionPerformed
        // TODO add your hand
        checkAgain2 = 8;
        checkCinema++;
        enableButton();
        
        penangQ1.setBackground(new Color(255,255,255));
        penangQ5.setBackground(new Color(255,255,255));
        penangQ8.setBackground(new Color(255,255,255));
        penangS1.setBackground(new Color(255,255,255));
        penangS4.setBackground(new Color(255,255,255));
        penangS8.setBackground(new Color(255,255,255));
        alorS1.setBackground(new Color(255,255,255));
        alorS8.setBackground(new Color(255,255,0));
        
        mDetail[cUser].setCinema("Alor Setar - Aman Central");
        mDetail[cUser].setMovieTime("08:10 PM");
    }//GEN-LAST:event_alorS8ActionPerformed

    public void keyInSeat(int type) {
        if(type==1) {
            for(int i=0; i<25; i++) {
                if(seat1[i] == 0) {
                    seat1[i] = abc;
                    System.out.println("Key in seat 1 seat");
                    break;
                }
            }
        }
        if(type==2) {
            for(int i=0; i<25; i++) {
                if(seat2[i] == 0) {
                    seat2[i] = abc;
                    System.out.println("Key in seat 2 seat");
                    break;
                }
            }
        }
        if(type==3) {
            for(int i=0; i<25; i++) {
                if(seat3[i] == 0) {
                    seat3[i] = abc;
                    System.out.println("Key in seat 3 seat");
                    break;
                }
            }
        }
    }
    
    public void RemoveKeyInSeat(int type) {
        if(type==1) {
            for(int i=0; i<25; i++) {
                if(seat1[i] == abc) {
                    seat1[i] = 0;
                    System.out.println("Remove key in seat 1 seat");
                    break;
                }
            }
        }
        if(type==2) {
            for(int i=0; i<25; i++) {
                if(seat2[i] == abc) {
                    seat2[i] = 0;
                    System.out.println("Remove key in seat 2 seat");
                    break;
                }
            }
        }
        if(type==3) {
            for(int i=0; i<25; i++) {
                if(seat3[i] == abc) {
                    seat3[i] = 0;
                    System.out.println("Remove key in seat 3 seat");
                    break;
                }
            }
        }
    }
    
    public void checkSelected() {
        checkConfirm++;
        if(checkConfirm>0) {
            confirmSeat.setVisible(true);
        }
       
        if(xCheck == 1) {
            if(checkAgain == 1 && checkAgain2 == 1) { // 18 and P1
                checkAll = 1;
                keyInSeat(checkAll);
            }
            if(checkAgain == 1 && checkAgain2 == 2) { // 18 and P2
                checkAll = 2;
                keyInSeat(checkAll);
            }
            if(checkAgain == 1 && checkAgain2 == 3) { // 18 and P3
                checkAll = 3;
                keyInSeat(checkAll);
            }
        }
        
        if(ds<6) {
            if(xCheck == 1) {
                displaySeat[ds] = zseat[abc-1];
                ds++;
            }
            if(xCheck == 2) {
                displaySeat[ds] = zseat2[abc-1];
                ds++;
            }
            if(xCheck == 3) {
                displaySeat[ds] = zseat3[abc-1];
                ds++;
            }
        }
    }
    public void removeSelected() {
        checkConfirm--;
        if(checkConfirm==0) {
            confirmSeat.setVisible(false);
        }
        
        if(xCheck == 1) {
            if(checkAgain == 1 && checkAgain2 == 1) { // 18 and P1
                checkAll = 1;
                RemoveKeyInSeat(checkAll);
            }
            if(checkAgain == 1 && checkAgain2 == 2) { // 18 and P2
                checkAll = 2;
                RemoveKeyInSeat(checkAll);
            }
            if(checkAgain == 1 && checkAgain2 == 3) { // 18 and P3
                checkAll = 3;
                RemoveKeyInSeat(checkAll);
            }
        }
        
        if(ds<6) {
            if(xCheck == 1) {
                displaySeat[ds] = "";
                ds--;
            }
            if(xCheck == 2) {
                displaySeat[ds] = "";
                ds--;
            }
            if(xCheck == 3) {
                displaySeat[ds] = "";
                ds--;
            }
        }
    }
    
    private void seatH01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatH01ActionPerformed
        // TODO add your handling code here:
        if(limitSeat>5 && seatH01.isSelected()) {
            seatH01.setSelected(false);
            JOptionPane.showMessageDialog(null,"You have reached maximum seat!");
        }
        else if(limitSeat<6 && seatH01.isSelected()) {
            seatH01.setBackground(Color.YELLOW);
            System.out.println(seatH01.getText());
            limitSeat++;
            ticket++;
            displayTicNum.setText(String.valueOf(ticket));
            abc=1;
            checkSelected();
        }
        else {
            seatH01.setSelected(false);
            seatH01.setBackground(new Color(240,240,240));
            limitSeat--;
            ticket--;
            displayTicNum.setText(String.valueOf(ticket));
            abc=1;
            removeSelected();
        }
    }//GEN-LAST:event_seatH01ActionPerformed

    private void seatH02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatH02ActionPerformed
        // TODO add your handling code here:
        if(limitSeat>5 && seatH02.isSelected()) {
            seatH02.setSelected(false);
            JOptionPane.showMessageDialog(null,"You have reached maximum seat!");
        }
        else if(limitSeat<6 && seatH02.isSelected()) {
            seatH02.setBackground(Color.YELLOW);
            System.out.println(seatH02.getText());
            limitSeat++;
            ticket++;
            displayTicNum.setText(String.valueOf(ticket));
            abc=2;
            checkSelected();
        }
        else {
            seatH02.setSelected(false);
            seatH02.setBackground(new Color(240,240,240));
            limitSeat--;
            ticket--;
            displayTicNum.setText(String.valueOf(ticket));
            abc=2;
            removeSelected();
        }
    }//GEN-LAST:event_seatH02ActionPerformed

    private void seatH03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatH03ActionPerformed
        // TODO add your handling code here:
        if(limitSeat>5 && seatH03.isSelected()) {
            seatH03.setSelected(false);
            JOptionPane.showMessageDialog(null,"You have reached maximum seat!");
        }
        else if(limitSeat<6 && seatH03.isSelected()) {
            seatH03.setBackground(Color.YELLOW);
            System.out.println(seatH03.getText());
            limitSeat++;
            ticket++;
            displayTicNum.setText(String.valueOf(ticket));
            abc=3;
            checkSelected();
        }
        else {
            seatH03.setSelected(false);
            seatH03.setBackground(new Color(240,240,240));
            limitSeat--;
            ticket--;
            displayTicNum.setText(String.valueOf(ticket));
            abc=3;
            removeSelected();
        }
    }//GEN-LAST:event_seatH03ActionPerformed

    private void seatH04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatH04ActionPerformed
        // TODO add your handling code here:
        if(limitSeat>5 && seatH04.isSelected()) {
            seatH04.setSelected(false);
            JOptionPane.showMessageDialog(null,"You have reached maximum seat!");
        }
        else if(limitSeat<6 && seatH04.isSelected()) {
            seatH04.setBackground(Color.YELLOW);
            System.out.println(seatH04.getText());
            limitSeat++;
            ticket++;
            displayTicNum.setText(String.valueOf(ticket));
            abc=4;
            checkSelected();
        }
        else {
            seatH04.setSelected(false);
            seatH04.setBackground(new Color(240,240,240));
            limitSeat--;
            ticket--;
            displayTicNum.setText(String.valueOf(ticket));
            abc=4;
            removeSelected();
        }
    }//GEN-LAST:event_seatH04ActionPerformed

    private void seatH05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatH05ActionPerformed
        // TODO add your handling code here:
        if(limitSeat>5 && seatH05.isSelected()) {
            seatH05.setSelected(false);
            JOptionPane.showMessageDialog(null,"You have reached maximum seat!");
        }
        else if(limitSeat<6 && seatH05.isSelected()) {
            seatH05.setBackground(Color.YELLOW);
            System.out.println(seatH05.getText());
            limitSeat++;
            ticket++;
            displayTicNum.setText(String.valueOf(ticket));
            abc=5;
            checkSelected();
        }
        else {
            seatH05.setSelected(false);
            seatH05.setBackground(new Color(240,240,240));
            limitSeat--;
            ticket--;
            displayTicNum.setText(String.valueOf(ticket));
            abc=5;
            removeSelected();
        }
    }//GEN-LAST:event_seatH05ActionPerformed

    private void seatH06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatH06ActionPerformed
        // TODO add your handling code here:
        if(limitSeat>5 && seatH06.isSelected()) {
            seatH06.setSelected(false);
            JOptionPane.showMessageDialog(null,"You have reached maximum seat!");
        }
        else if(limitSeat<6 && seatH06.isSelected()) {
            seatH06.setBackground(Color.YELLOW);
            System.out.println(seatH06.getText());
            limitSeat++;
            ticket++;
            displayTicNum.setText(String.valueOf(ticket));
            abc=6;
            checkSelected();
        }
        else {
            seatH06.setSelected(false);
            seatH06.setBackground(new Color(240,240,240));
            limitSeat--;
            ticket--;
            displayTicNum.setText(String.valueOf(ticket));
            abc=6;
            removeSelected();
        }
    }//GEN-LAST:event_seatH06ActionPerformed

    private void seatH07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatH07ActionPerformed
        // TODO add your handling code here:
        if(limitSeat>5 && seatH07.isSelected()) {
            seatH07.setSelected(false);
            JOptionPane.showMessageDialog(null,"You have reached maximum seat!");
        }
        else if(limitSeat<6 && seatH07.isSelected()) {
            seatH07.setBackground(Color.YELLOW);
            System.out.println(seatH07.getText());
            limitSeat++;
            ticket++;
            displayTicNum.setText(String.valueOf(ticket));
            abc=7;
            checkSelected();
        }
        else {
            seatH07.setSelected(false);
            seatH07.setBackground(new Color(240,240,240));
            limitSeat--;
            ticket--;
            displayTicNum.setText(String.valueOf(ticket));
            abc=7;
            removeSelected();
        }
    }//GEN-LAST:event_seatH07ActionPerformed

    private void seatH08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatH08ActionPerformed
        // TODO add your handling code here:
        if(limitSeat>5 && seatH08.isSelected()) {
            seatH08.setSelected(false);
            JOptionPane.showMessageDialog(null,"You have reached maximum seat!");
        }
        else if(limitSeat<6 && seatH08.isSelected()) {
            seatH08.setBackground(Color.YELLOW);
            System.out.println(seatH08.getText());
            limitSeat++;
            ticket++;
            displayTicNum.setText(String.valueOf(ticket));
            abc=8;
            checkSelected();
        }
        else {
            seatH08.setSelected(false);
            seatH08.setBackground(new Color(240,240,240));
            limitSeat--;
            ticket--;
            displayTicNum.setText(String.valueOf(ticket));
            abc=8;
            removeSelected();
        }
    }//GEN-LAST:event_seatH08ActionPerformed

    private void seatH09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatH09ActionPerformed
        // TODO add your handling code here:
        if(limitSeat>5 && seatH09.isSelected()) {
            seatH09.setSelected(false);
            JOptionPane.showMessageDialog(null,"You have reached maximum seat!");
        }
        else if(limitSeat<6 && seatH09.isSelected()) {
            seatH09.setBackground(Color.YELLOW);
            System.out.println(seatH09.getText());
            limitSeat++;
            ticket++;
            displayTicNum.setText(String.valueOf(ticket));
            abc=9;
            checkSelected();
        }
        else {
            seatH09.setSelected(false);
            seatH09.setBackground(new Color(240,240,240));
            limitSeat--;
            ticket--;
            displayTicNum.setText(String.valueOf(ticket));
            abc=9;
            removeSelected();
        }
    }//GEN-LAST:event_seatH09ActionPerformed

    private void seatH10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatH10ActionPerformed
        // TODO add your handling code here:
        if(limitSeat>5 && seatH10.isSelected()) {
            seatH10.setSelected(false);
            JOptionPane.showMessageDialog(null,"You have reached maximum seat!");
        }
        else if(limitSeat<6 && seatH10.isSelected()) {
            seatH10.setBackground(Color.YELLOW);
            System.out.println(seatH10.getText());
            limitSeat++;
            ticket++;
            displayTicNum.setText(String.valueOf(ticket));
            abc=10;
            checkSelected();
        }
        else {
            seatH10.setSelected(false);
            seatH10.setBackground(new Color(240,240,240));
            limitSeat--;
            ticket--;
            displayTicNum.setText(String.valueOf(ticket));
            abc=10;
            removeSelected();
        }
    }//GEN-LAST:event_seatH10ActionPerformed

    private void seatH11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatH11ActionPerformed
        // TODO add your handling code here:
        if(limitSeat>5 && seatH11.isSelected()) {
            seatH11.setSelected(false);
            JOptionPane.showMessageDialog(null,"You have reached maximum seat!");
        }
        else if(limitSeat<6 && seatH11.isSelected()) {
            seatH11.setBackground(Color.YELLOW);
            System.out.println(seatH11.getText());
            limitSeat++;
            ticket++;
            displayTicNum.setText(String.valueOf(ticket));
            abc=11;
            checkSelected();
        }
        else {
            seatH11.setSelected(false);
            seatH11.setBackground(new Color(240,240,240));
            limitSeat--;
            ticket--;
            displayTicNum.setText(String.valueOf(ticket));
            abc=11;
            removeSelected();
        }
    }//GEN-LAST:event_seatH11ActionPerformed

    private void seatH12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatH12ActionPerformed
        // TODO add your handling code here:
        if(limitSeat>5 && seatH12.isSelected()) {
            seatH12.setSelected(false);
            JOptionPane.showMessageDialog(null,"You have reached maximum seat!");
        }
        else if(limitSeat<6 && seatH12.isSelected()) {
            seatH12.setBackground(Color.YELLOW);
            System.out.println(seatH12.getText());
            limitSeat++;
            ticket++;
            displayTicNum.setText(String.valueOf(ticket));
            abc=12;
            checkSelected();
        }
        else {
            seatH12.setSelected(false);
            seatH12.setBackground(new Color(240,240,240));
            limitSeat--;
            ticket--;
            displayTicNum.setText(String.valueOf(ticket));
            abc=12;
            removeSelected();
        }
    }//GEN-LAST:event_seatH12ActionPerformed

    private void seatG01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatG01ActionPerformed
        // TODO add your handling code here:
        if(limitSeat>5 && seatG01.isSelected()) {
            seatG01.setSelected(false);
            JOptionPane.showMessageDialog(null,"You have reached maximum seat!");
        }
        else if(limitSeat<6 && seatG01.isSelected()) {
            seatG01.setBackground(Color.YELLOW);
            System.out.println(seatG01.getText());
            limitSeat++;
            ticket++;
            displayTicNum.setText(String.valueOf(ticket));
            abc=13;
            checkSelected();
        }
        else {
            seatG01.setSelected(false);
            seatG01.setBackground(new Color(240,240,240));
            limitSeat--;
            ticket--;
            displayTicNum.setText(String.valueOf(ticket));
            abc=13;
            removeSelected();
        }
    }//GEN-LAST:event_seatG01ActionPerformed

    private void seatG02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatG02ActionPerformed
        // TODO add your handling code here:
        if(limitSeat>5 && seatG02.isSelected()) {
            seatG02.setSelected(false);
            JOptionPane.showMessageDialog(null,"You have reached maximum seat!");
        }
        else if(limitSeat<6 && seatG02.isSelected()) {
            seatG02.setBackground(Color.YELLOW);
            System.out.println(seatG02.getText());
            limitSeat++;
            ticket++;
            displayTicNum.setText(String.valueOf(ticket));
            abc=14;
            checkSelected();
        }
        else {
            seatG02.setSelected(false);
            seatG02.setBackground(new Color(240,240,240));
            limitSeat--;
            ticket--;
            displayTicNum.setText(String.valueOf(ticket));
            abc=14;
            removeSelected();
        }
    }//GEN-LAST:event_seatG02ActionPerformed

    private void seatG03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatG03ActionPerformed
        // TODO add your handling code here:
        if(limitSeat>5 && seatG03.isSelected()) {
            seatG03.setSelected(false);
            JOptionPane.showMessageDialog(null,"You have reached maximum seat!");
        }
        else if(limitSeat<6 && seatG03.isSelected()) {
            seatG03.setBackground(Color.YELLOW);
            System.out.println(seatG03.getText());
            limitSeat++;
            ticket++;
            displayTicNum.setText(String.valueOf(ticket));
            abc=15;
            checkSelected();
        }
        else {
            seatG03.setSelected(false);
            seatG03.setBackground(new Color(240,240,240));
            limitSeat--;
            ticket--;
            displayTicNum.setText(String.valueOf(ticket));
            abc=15;
            removeSelected();
        }
    }//GEN-LAST:event_seatG03ActionPerformed

    private void seatG04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatG04ActionPerformed
        // TODO add your handling code here:
        if(limitSeat>5 && seatG04.isSelected()) {
            seatG04.setSelected(false);
            JOptionPane.showMessageDialog(null,"You have reached maximum seat!");
        }
        else if(limitSeat<6 && seatG04.isSelected()) {
            seatG04.setBackground(Color.YELLOW);
            System.out.println(seatG04.getText());
            limitSeat++;
            ticket++;
            displayTicNum.setText(String.valueOf(ticket));
            abc=16;
            checkSelected();
        }
        else {
            seatG04.setSelected(false);
            seatG04.setBackground(new Color(240,240,240));
            limitSeat--;
            ticket--;
            displayTicNum.setText(String.valueOf(ticket));
            abc=16;
            removeSelected();
        }
    }//GEN-LAST:event_seatG04ActionPerformed

    private void seatG05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatG05ActionPerformed
        // TODO add your handling code here:
        if(limitSeat>5 && seatG05.isSelected()) {
            seatG05.setSelected(false);
            JOptionPane.showMessageDialog(null,"You have reached maximum seat!");
        }
        else if(limitSeat<6 && seatG05.isSelected()) {
            seatG05.setBackground(Color.YELLOW);
            System.out.println(seatG05.getText());
            limitSeat++;
            ticket++;
            displayTicNum.setText(String.valueOf(ticket));
            abc=17;
            checkSelected();
        }
        else {
            seatG05.setSelected(false);
            seatG05.setBackground(new Color(240,240,240));
            limitSeat--;
            ticket--;
            displayTicNum.setText(String.valueOf(ticket));
            abc=17;
            removeSelected();
        }
    }//GEN-LAST:event_seatG05ActionPerformed

    private void seatG06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatG06ActionPerformed
        // TODO add your handling code here:
        if(limitSeat>5 && seatG06.isSelected()) {
            seatG06.setSelected(false);
            JOptionPane.showMessageDialog(null,"You have reached maximum seat!");
        }
        else if(limitSeat<6 && seatG06.isSelected()) {
            seatG06.setBackground(Color.YELLOW);
            System.out.println(seatG06.getText());
            limitSeat++;
            ticket++;
            displayTicNum.setText(String.valueOf(ticket));
            abc=18;
            checkSelected();
        }
        else {
            seatG06.setSelected(false);
            seatG06.setBackground(new Color(240,240,240));
            limitSeat--;
            ticket--;
            displayTicNum.setText(String.valueOf(ticket));
            abc=18;
            removeSelected();
        }
    }//GEN-LAST:event_seatG06ActionPerformed

    private void seatG07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatG07ActionPerformed
        // TODO add your handling code here:
        if(limitSeat>5 && seatG07.isSelected()) {
            seatG07.setSelected(false);
            JOptionPane.showMessageDialog(null,"You have reached maximum seat!");
        }
        else if(limitSeat<6 && seatG07.isSelected()) {
            seatG07.setBackground(Color.YELLOW);
            System.out.println(seatG07.getText());
            limitSeat++;
            ticket++;
            displayTicNum.setText(String.valueOf(ticket));
            abc=19;
            checkSelected();
        }
        else {
            seatG07.setSelected(false);
            seatG07.setBackground(new Color(240,240,240));
            limitSeat--;
            ticket--;
            displayTicNum.setText(String.valueOf(ticket));
            abc=19;
            removeSelected();
        }
    }//GEN-LAST:event_seatG07ActionPerformed

    private void seatG08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatG08ActionPerformed
        // TODO add your handling code here:
        if(limitSeat>5 && seatG08.isSelected()) {
            seatG08.setSelected(false);
            JOptionPane.showMessageDialog(null,"You have reached maximum seat!");
        }
        else if(limitSeat<6 && seatG08.isSelected()) {
            seatG08.setBackground(Color.YELLOW);
            System.out.println(seatG08.getText());
            limitSeat++;
            ticket++;
            displayTicNum.setText(String.valueOf(ticket));
            abc=20;
            checkSelected();
        }
        else {
            seatG08.setSelected(false);
            seatG08.setBackground(new Color(240,240,240));
            limitSeat--;
            ticket--;
            displayTicNum.setText(String.valueOf(ticket));
            abc=20;
            removeSelected();
        }
    }//GEN-LAST:event_seatG08ActionPerformed

    private void seatG09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatG09ActionPerformed
        // TODO add your handling code here:
        if(limitSeat>5 && seatG09.isSelected()) {
            seatG09.setSelected(false);
            JOptionPane.showMessageDialog(null,"You have reached maximum seat!");
        }
        else if(limitSeat<6 && seatG09.isSelected()) {
            seatG09.setBackground(Color.YELLOW);
            System.out.println(seatG09.getText());
            limitSeat++;
            ticket++;
            displayTicNum.setText(String.valueOf(ticket));
            abc=21;
            checkSelected();
        }
        else {
            seatG09.setSelected(false);
            seatG09.setBackground(new Color(240,240,240));
            limitSeat--;
            ticket--;
            displayTicNum.setText(String.valueOf(ticket));
            abc=21;
            removeSelected();
        }
    }//GEN-LAST:event_seatG09ActionPerformed

    private void seatG10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatG10ActionPerformed
        // TODO add your handling code here:
        if(limitSeat>5 && seatG10.isSelected()) {
            seatG10.setSelected(false);
            JOptionPane.showMessageDialog(null,"You have reached maximum seat!");
        }
        else if(limitSeat<6 && seatG10.isSelected()) {
            seatG10.setBackground(Color.YELLOW);
            System.out.println(seatG10.getText());
            limitSeat++;
            ticket++;
            displayTicNum.setText(String.valueOf(ticket));
            abc=22;
            checkSelected();
        }
        else {
            seatG10.setSelected(false);
            seatG10.setBackground(new Color(240,240,240));
            limitSeat--;
            ticket--;
            displayTicNum.setText(String.valueOf(ticket));
            abc=22;
            removeSelected();
        }
    }//GEN-LAST:event_seatG10ActionPerformed

    private void seatG11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatG11ActionPerformed
        // TODO add your handling code here:
        if(limitSeat>5 && seatG11.isSelected()) {
            seatG11.setSelected(false);
            JOptionPane.showMessageDialog(null,"You have reached maximum seat!");
        }
        else if(limitSeat<6 && seatG11.isSelected()) {
            seatG11.setBackground(Color.YELLOW);
            System.out.println(seatG11.getText());
            limitSeat++;
            ticket++;
            displayTicNum.setText(String.valueOf(ticket));
            abc=23;
            checkSelected();
        }
        else {
            seatG11.setSelected(false);
            seatG11.setBackground(new Color(240,240,240));
            limitSeat--;
            ticket--;
            displayTicNum.setText(String.valueOf(ticket));
            abc=23;
            removeSelected();
        }
    }//GEN-LAST:event_seatG11ActionPerformed

    private void seatG12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatG12ActionPerformed
        // TODO add your handling code here:
        if(limitSeat>5 && seatG12.isSelected()) {
            seatG12.setSelected(false);
            JOptionPane.showMessageDialog(null,"You have reached maximum seat!");
        }
        else if(limitSeat<6 && seatG12.isSelected()) {
            seatG12.setBackground(Color.YELLOW);
            System.out.println(seatG12.getText());
            limitSeat++;
            ticket++;
            displayTicNum.setText(String.valueOf(ticket));
            abc=24;
            checkSelected();
        }
        else {
            seatG12.setSelected(false);
            seatG12.setBackground(new Color(240,240,240));
            limitSeat--;
            ticket--;
            displayTicNum.setText(String.valueOf(ticket));
            abc=24;
            removeSelected();
        }
    }//GEN-LAST:event_seatG12ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        // BUY 1
        clearSeat();
        xCheck = 1;
        
        //checkSeatHx();
        //checkSeatGx();
        
        selectSeat.setVisible(false);
        
        newInside.setVisible(false);
        switchInside.setVisible(true);
        seat.setVisible(false);
        
        jumanjiImage.setVisible(true);
        birdsImage3.setVisible(false);
        dolittleImage.setVisible(false);
        
        movieName.setText(jLabel68.getText());
        mDetail[cUser].setMovieName("Jumanji: The Next Level");
       
    }//GEN-LAST:event_jButton7ActionPerformed
    
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        // BUY 3
        clearSeat();
        xCheck = 3;
        //checkSeatHx3();
        //checkSeatGx3();
        
        selectSeat.setVisible(false);
        
        newInside.setVisible(false);
        switchInside.setVisible(true);
        seat.setVisible(false);
        
        dolittleImage.setVisible(true);
        jumanjiImage.setVisible(false);
        birdsImage3.setVisible(false);

        movieName.setText("Dolittle");
        mDetail[cUser].setMovieName("Dolittle");
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton113ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton113ActionPerformed
        // TODO add your handling code here:
        // BUY 2
        clearSeat();
        xCheck = 2;
        checkSeatHx2();
        checkSeatGx2();
        
        selectSeat.setVisible(false);
        
        newInside.setVisible(false);
        switchInside.setVisible(true);
        seat.setVisible(false);
        
        birdsImage3.setVisible(true);
        jumanjiImage.setVisible(false);
        dolittleImage.setVisible(false);
        
        movieName.setText("Birds Of Prey");
        mDetail[cUser].setMovieName("Birds Of Prey");
    }//GEN-LAST:event_jButton113ActionPerformed

    public void checkSeatHx() {
        for(int i=1; i<13; i++) {
            if(i<10) {
                String p = Integer.toString(i);
                for(int k=0; k<24; k++) {
                    if(("H0"+p).equals(xSeat[k])) {
                        if(xSeat[k].equals("H01")) {
                            seatH01.setEnabled(false);
                        }
                    }
                    if(("H0"+p).equals(xSeat[k])) {
                        if(xSeat[k].equals("H02")) {
                            seatH02.setEnabled(false);
                        }
                    }
                    if(("H0"+p).equals(xSeat[k])) {
                        if(xSeat[k].equals("H03")) {
                            seatH03.setEnabled(false);
                        }
                    } 
                    if(("H0"+p).equals(xSeat[k])) {
                        if(xSeat[k].equals("H04")) {
                            seatH04.setEnabled(false);
                        }
                    } 
                    if(("H0"+p).equals(xSeat[k])) {
                        if(xSeat[k].equals("H05")) {
                            seatH05.setEnabled(false);
                        }
                    } 
                    if(("H0"+p).equals(xSeat[k])) {
                        if(xSeat[k].equals("H06")) {
                            seatH06.setEnabled(false);
                        }
                    }
                    if(("H0"+p).equals(xSeat[k])) {
                        if(xSeat[k].equals("H07")) {
                            seatH07.setEnabled(false);
                        }
                    }
                    if(("H0"+p).equals(xSeat[k])) {
                        if(xSeat[k].equals("H08")) {
                            seatH08.setEnabled(false);
                        }
                    }
                    if(("H0"+p).equals(xSeat[k])) {
                        if(xSeat[k].equals("H09")) {
                            seatH09.setEnabled(false);
                        }
                    }
                }
            }
            if(i>9) {
                String c = Integer.toString(i);
                for(int m=0; m<24; m++) {
                    if(("H"+c).equals(xSeat[m])) {
                        if(xSeat[m].equals("H10")) {
                            seatH10.setEnabled(false);
                        }
                    }
                    if(("H"+c).equals(xSeat[m])) {
                        if(xSeat[m].equals("H11")) {
                            seatH11.setEnabled(false);
                        }
                    }
                    if(("H"+c).equals(xSeat[m])) {
                        if(xSeat[m].equals("H12")) {
                            seatH12.setEnabled(false);
                        }
                    }
                }
            }
        }
    }
    public void checkSeatGx() {
        for(int i=1; i<13; i++) {
            if(i<10) {
                String p = Integer.toString(i);
                for(int k=0; k<24; k++) {
                    if(("G0"+p).equals(xSeat[k])) {
                        if(xSeat[k].equals("G01")) {
                            seatG01.setEnabled(false);
                        }
                    }
                    if(("G0"+p).equals(xSeat[k])) {
                        if(xSeat[k].equals("G02")) {
                            seatG02.setEnabled(false);
                        }
                    }
                    if(("G0"+p).equals(xSeat[k])) {
                        if(xSeat[k].equals("G03")) {
                            seatG03.setEnabled(false);
                        }
                    } 
                    if(("G0"+p).equals(xSeat[k])) {
                        if(xSeat[k].equals("G04")) {
                            seatG04.setEnabled(false);
                        }
                    } 
                    if(("G0"+p).equals(xSeat[k])) {
                        if(xSeat[k].equals("G05")) {
                            seatH05.setEnabled(false);
                        }
                    } 
                    if(("G0"+p).equals(xSeat[k])) {
                        if(xSeat[k].equals("G06")) {
                            seatG06.setEnabled(false);
                        }
                    }
                    if(("G0"+p).equals(xSeat[k])) {
                        if(xSeat[k].equals("G07")) {
                            seatG07.setEnabled(false);
                        }
                    }
                    if(("G0"+p).equals(xSeat[k])) {
                        if(xSeat[k].equals("G08")) {
                            seatG08.setEnabled(false);
                        }
                    }
                    if(("G0"+p).equals(xSeat[k])) {
                        if(xSeat[k].equals("G09")) {
                            seatG09.setEnabled(false);
                        }
                    }
                }
            }
            if(i>9) {
                String c = Integer.toString(i);
                for(int m=0; m<24; m++) {
                    if(("G"+c).equals(xSeat[m])) {
                        if(xSeat[m].equals("G10")) {
                            seatG10.setEnabled(false);
                        }
                    }
                    if(("G"+c).equals(xSeat[m])) {
                        if(xSeat[m].equals("G11")) {
                            seatG11.setEnabled(false);
                        }
                    }
                    if(("G"+c).equals(xSeat[m])) {
                        if(xSeat[m].equals("G12")) {
                            seatG12.setEnabled(false);
                        }
                    }
                }
            }
        }
    }
    
    public void checkSeatHx2() {
        for(int i=1; i<13; i++) {
            if(i<10) {
                String p = Integer.toString(i);
                for(int k=0; k<24; k++) {
                    if(("H0"+p).equals(x2Seat[k])) {
                        if(x2Seat[k].equals("H01")) {
                            seatH01.setEnabled(false);
                        }
                    }
                    if(("H0"+p).equals(x2Seat[k])) {
                        if(x2Seat[k].equals("H02")) {
                            seatH02.setEnabled(false);
                        }
                    }
                    if(("H0"+p).equals(x2Seat[k])) {
                        if(x2Seat[k].equals("H03")) {
                            seatH03.setEnabled(false);
                        }
                    } 
                    if(("H0"+p).equals(x2Seat[k])) {
                        if(x2Seat[k].equals("H04")) {
                            seatH04.setEnabled(false);
                        }
                    } 
                    if(("H0"+p).equals(x2Seat[k])) {
                        if(x2Seat[k].equals("H05")) {
                            seatH05.setEnabled(false);
                        }
                    } 
                    if(("H0"+p).equals(x2Seat[k])) {
                        if(x2Seat[k].equals("H06")) {
                            seatH06.setEnabled(false);
                        }
                    }
                    if(("H0"+p).equals(x2Seat[k])) {
                        if(x2Seat[k].equals("H07")) {
                            seatH07.setEnabled(false);
                        }
                    }
                    if(("H0"+p).equals(x2Seat[k])) {
                        if(x2Seat[k].equals("H08")) {
                            seatH08.setEnabled(false);
                        }
                    }
                    if(("H0"+p).equals(x2Seat[k])) {
                        if(x2Seat[k].equals("H09")) {
                            seatH09.setEnabled(false);
                        }
                    }
                }
            }
            if(i>9) {
                String c = Integer.toString(i);
                for(int m=0; m<24; m++) {
                    if(("H"+c).equals(x2Seat[m])) {
                        if(x2Seat[m].equals("H10")) {
                            seatH10.setEnabled(false);
                        }
                    }
                    if(("H"+c).equals(x2Seat[m])) {
                        if(x2Seat[m].equals("H11")) {
                            seatH11.setEnabled(false);
                        }
                    }
                    if(("H"+c).equals(x2Seat[m])) {
                        if(x2Seat[m].equals("H12")) {
                            seatH12.setEnabled(false);
                        }
                    }
                }
            }
        }
    }
    public void checkSeatGx2() {
        for(int i=1; i<13; i++) {
            if(i<10) {
                String p = Integer.toString(i);
                for(int k=0; k<24; k++) {
                    if(("G0"+p).equals(x2Seat[k])) {
                        if(x2Seat[k].equals("G01")) {
                            seatG01.setEnabled(false);
                        }
                    }
                    if(("G0"+p).equals(x2Seat[k])) {
                        if(x2Seat[k].equals("G02")) {
                            seatG02.setEnabled(false);
                        }
                    }
                    if(("G0"+p).equals(x2Seat[k])) {
                        if(x2Seat[k].equals("G03")) {
                            seatG03.setEnabled(false);
                        }
                    } 
                    if(("G0"+p).equals(x2Seat[k])) {
                        if(x2Seat[k].equals("G04")) {
                            seatG04.setEnabled(false);
                        }
                    } 
                    if(("G0"+p).equals(x2Seat[k])) {
                        if(x2Seat[k].equals("G05")) {
                            seatH05.setEnabled(false);
                        }
                    } 
                    if(("G0"+p).equals(x2Seat[k])) {
                        if(x2Seat[k].equals("G06")) {
                            seatG06.setEnabled(false);
                        }
                    }
                    if(("G0"+p).equals(x2Seat[k])) {
                        if(x2Seat[k].equals("G07")) {
                            seatG07.setEnabled(false);
                        }
                    }
                    if(("G0"+p).equals(x2Seat[k])) {
                        if(x2Seat[k].equals("G08")) {
                            seatG08.setEnabled(false);
                        }
                    }
                    if(("G0"+p).equals(x2Seat[k])) {
                        if(x2Seat[k].equals("G09")) {
                            seatG09.setEnabled(false);
                        }
                    }
                }
            }
            if(i>9) {
                String c = Integer.toString(i);
                for(int m=0; m<24; m++) {
                    if(("G"+c).equals(x2Seat[m])) {
                        if(x2Seat[m].equals("G10")) {
                            seatG10.setEnabled(false);
                        }
                    }
                    if(("G"+c).equals(x2Seat[m])) {
                        if(x2Seat[m].equals("G11")) {
                            seatG11.setEnabled(false);
                        }
                    }
                    if(("G"+c).equals(x2Seat[m])) {
                        if(x2Seat[m].equals("G12")) {
                            seatG12.setEnabled(false);
                        }
                    }
                }
            }
        }
    }
    
    public void checkSeatHx3() {
        for(int i=1; i<13; i++) {
            if(i<10) {
                String p = Integer.toString(i);
                for(int k=0; k<24; k++) {
                    if(("H0"+p).equals(x3Seat[k])) {
                        if(x3Seat[k].equals("H01")) {
                            seatH01.setEnabled(false);
                        }
                    }
                    if(("H0"+p).equals(x3Seat[k])) {
                        if(x3Seat[k].equals("H02")) {
                            seatH02.setEnabled(false);
                        }
                    }
                    if(("H0"+p).equals(x3Seat[k])) {
                        if(x3Seat[k].equals("H03")) {
                            seatH03.setEnabled(false);
                        }
                    } 
                    if(("H0"+p).equals(x3Seat[k])) {
                        if(x3Seat[k].equals("H04")) {
                            seatH04.setEnabled(false);
                        }
                    } 
                    if(("H0"+p).equals(x3Seat[k])) {
                        if(x3Seat[k].equals("H05")) {
                            seatH05.setEnabled(false);
                        }
                    } 
                    if(("H0"+p).equals(x3Seat[k])) {
                        if(x3Seat[k].equals("H06")) {
                            seatH06.setEnabled(false);
                        }
                    }
                    if(("H0"+p).equals(x3Seat[k])) {
                        if(x3Seat[k].equals("H07")) {
                            seatH07.setEnabled(false);
                        }
                    }
                    if(("H0"+p).equals(x3Seat[k])) {
                        if(x3Seat[k].equals("H08")) {
                            seatH08.setEnabled(false);
                        }
                    }
                    if(("H0"+p).equals(x3Seat[k])) {
                        if(x3Seat[k].equals("H09")) {
                            seatH09.setEnabled(false);
                        }
                    }
                }
            }
            if(i>9) {
                String c = Integer.toString(i);
                for(int m=0; m<24; m++) {
                    if(("H"+c).equals(x3Seat[m])) {
                        if(x3Seat[m].equals("H10")) {
                            seatH10.setEnabled(false);
                        }
                    }
                    if(("H"+c).equals(x3Seat[m])) {
                        if(x3Seat[m].equals("H11")) {
                            seatH11.setEnabled(false);
                        }
                    }
                    if(("H"+c).equals(x3Seat[m])) {
                        if(x3Seat[m].equals("H12")) {
                            seatH12.setEnabled(false);
                        }
                    }
                }
            }
        }
    }
    public void checkSeatGx3() {
        for(int i=1; i<13; i++) {
            if(i<10) {
                String p = Integer.toString(i);
                for(int k=0; k<24; k++) {
                    if(("G0"+p).equals(x3Seat[k])) {
                        if(x3Seat[k].equals("G01")) {
                            seatG01.setEnabled(false);
                        }
                    }
                    if(("G0"+p).equals(x3Seat[k])) {
                        if(x3Seat[k].equals("G02")) {
                            seatG02.setEnabled(false);
                        }
                    }
                    if(("G0"+p).equals(x3Seat[k])) {
                        if(x3Seat[k].equals("G03")) {
                            seatG03.setEnabled(false);
                        }
                    } 
                    if(("G0"+p).equals(x3Seat[k])) {
                        if(x3Seat[k].equals("G04")) {
                            seatG04.setEnabled(false);
                        }
                    } 
                    if(("G0"+p).equals(x3Seat[k])) {
                        if(x3Seat[k].equals("G05")) {
                            seatH05.setEnabled(false);
                        }
                    } 
                    if(("G0"+p).equals(x3Seat[k])) {
                        if(x3Seat[k].equals("G06")) {
                            seatG06.setEnabled(false);
                        }
                    }
                    if(("G0"+p).equals(x3Seat[k])) {
                        if(x3Seat[k].equals("G07")) {
                            seatG07.setEnabled(false);
                        }
                    }
                    if(("G0"+p).equals(x3Seat[k])) {
                        if(x3Seat[k].equals("G08")) {
                            seatG08.setEnabled(false);
                        }
                    }
                    if(("G0"+p).equals(x3Seat[k])) {
                        if(x3Seat[k].equals("G09")) {
                            seatG09.setEnabled(false);
                        }
                    }
                }
            }
            if(i>9) {
                String c = Integer.toString(i);
                for(int m=0; m<24; m++) {
                    if(("G"+c).equals(x3Seat[m])) {
                        if(x3Seat[m].equals("G10")) {
                            seatG10.setEnabled(false);
                        }
                    }
                    if(("G"+c).equals(x3Seat[m])) {
                        if(x3Seat[m].equals("G11")) {
                            seatG11.setEnabled(false);
                        }
                    }
                    if(("G"+c).equals(x3Seat[m])) {
                        if(x3Seat[m].equals("G12")) {
                            seatG12.setEnabled(false);
                        }
                    }
                }
            }
        }
    }
    
    private void confirmSeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmSeatActionPerformed
        // TODO add your handling code here:
        // CONFIRM
        
        clearSeat();
        confirmType.setVisible(false);
        
        String m1="", m2="" , m3="", m4="", m5="", m6="";
        
        for(int i=0; i<13; i++) {
            if(i==0) {
                m1 = displaySeat[i]; 
            }
            if(i==1) {
                m2 = displaySeat[i];
            }
            if(i==2) {
                m3 = displaySeat[i];
            }
            if(i==3) {
                m4 = displaySeat[i];
            }
            if(i==4) {
                m5 = displaySeat[i];
            }
            if(i==5) {
                m6 = displaySeat[i];
            }
        }
        
        System.out.println("Display seat [0] = " + displaySeat[0]);
        System.out.println("Display seat [1] = " + displaySeat[1]);
        System.out.println("Display seat [2] = " + displaySeat[2]);
        System.out.println("Display seat [3] = " + displaySeat[3]);
        System.out.println("Display seat [4] = " + displaySeat[4]);
        System.out.println("Display seat [5] = " + displaySeat[5]);
        
        mDetail[cUser].setSeat(m1+" "+m2+" "+m3+" "+m4+" "+m5+" "+m6);
        seatType.setText(mDetail[cUser].getSeat());
        
        overall.setVisible(true);
        ticketType.setVisible(true);
        newInside.setVisible(false);
        switchInside.setVisible(false);
        seat.setVisible(false);
        login.setVisible(false);
    }//GEN-LAST:event_confirmSeatActionPerformed

    private void jButton119ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton119ActionPerformed
        // TODO add your handling code here:
        newInside.setVisible(true);
        switchInside.setVisible(false);
        seat.setVisible(false);
        ticketType.setVisible(false);
    }//GEN-LAST:event_jButton119ActionPerformed

    private void FeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeedbackActionPerformed
        // TODO add your handling code here:
        
        Feedback fb = new Feedback();
        fb.setVisible(true);
    }//GEN-LAST:event_FeedbackActionPerformed

    private void userFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userFFocusGained
        // TODO add your handling code here:
        jLabel1.setForeground(new Color(57,113,177));
        jLabel2.setForeground(new Color(102,102,102));
        jLabel3.setForeground(new Color(102,102,102));
    }//GEN-LAST:event_userFFocusGained

    private void mailFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mailFFocusGained
        // TODO add your handling code here:
        jLabel1.setForeground(new Color(102,102,102)); // kelabu
        jLabel2.setForeground(new Color(57,113,177)); // biru
    }//GEN-LAST:event_mailFFocusGained

    private void passFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passFFocusGained
        // TODO add your handling code here:
        jLabel1.setForeground(new Color(102,102,102));
        jLabel2.setForeground(new Color(102,102,102));
        jLabel3.setForeground(new Color(57,113,177));
    }//GEN-LAST:event_passFFocusGained

    private void userFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userFocusGained
        // TODO add your handling code here:
        jLabel9.setForeground(new Color(57,113,177));
        jLabel8.setForeground(new Color(102,102,102));
    }//GEN-LAST:event_userFocusGained

    private void passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusGained
        // TODO add your handling code here:
        jLabel8.setForeground(new Color(57,113,177));
        jLabel9.setForeground(new Color(102,102,102));
    }//GEN-LAST:event_passwordFocusGained

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        // TODO add your handling code here:
        createFolder();
        readFile();
        countLines();
        CheckData(user.getText(),password.getText());
        System.out.println("Username: "+user.getText());
        System.out.println("Password: "+password.getText());
        userFinside.setText(userN);
    }//GEN-LAST:event_LoginActionPerformed

    private void SignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignupActionPerformed
        // TODO add your handling code here:
        createFolder();
        readFile();
        countLines();
        addData(userF.getText(),passF.getText(),mailF.getText());
        clearTextSignUp();
    }//GEN-LAST:event_SignupActionPerformed

    public void checkToEnableButton() {
        if(checkType==ticket) {
            confirmType.setVisible(true);
        }
        
        if(checkType<ticket) {
            confirmType.setVisible(false);
        }
    }
    
    private void plusAdultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusAdultActionPerformed
        // TODO add your handling code here:
        if(cAll<ticket) {
            cAll++;
            cAdult++;
            countAdult.setText(""+cAdult);
            adultM.setText("Adult x "+cAdult);
            ticketPrice = new Adult(cAdult);
            adultP = ticketPrice.calTicketPrice();
            System.out.println("Adult price: RM"+adultP);
            adultPrice.setText("RM"+adultP+"0");
            checkType++;
            checkToEnableButton();
        }
        System.out.println("Ticket: "+ticket);
    }//GEN-LAST:event_plusAdultActionPerformed

    private void plusChildrenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusChildrenActionPerformed
        // TODO add your handling code here:
        if(cAll<ticket) {
            cAll++;
            cChildren++;
            countChildren.setText(""+cChildren);
            childrenM.setText("Children x "+cChildren);
            ticketPrice = new Children(cChildren);
            childrenP = ticketPrice.calTicketPrice();
            System.out.println("Children price: RM"+childrenP);
            childrenPrice.setText("RM"+childrenP+"0");
            checkType++;
            checkToEnableButton();
        }
        System.out.println("Ticket: "+ticket);
    }//GEN-LAST:event_plusChildrenActionPerformed

    private void plusOKUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusOKUActionPerformed
        // TODO add your handling code here:
        if(cAll<ticket) {
            cAll++;
            cOKU++;
            countOKU.setText(""+cOKU);
            OKUM.setText("OKU x "+cOKU);
            ticketPrice = new OKU(cOKU);
            OKUP = ticketPrice.calTicketPrice();
            System.out.println("OKU price: RM"+OKUP);
            OKUPrice.setText("RM"+OKUP+"0");
            checkType++;
            checkToEnableButton();
        }
    }//GEN-LAST:event_plusOKUActionPerformed

    private void plusSeniorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusSeniorActionPerformed
        // TODO add your handling code here:
        if(cAll<ticket) {
            cAll++;
            cSenior++;
            countSenior.setText(""+cSenior);
            seniorM.setText("Senior x "+cSenior);
            ticketPrice = new Senior(cSenior);
            seniorP = ticketPrice.calTicketPrice();
            System.out.println("Senior price: RM"+seniorP);
            seniorPrice.setText("RM"+seniorP+"0");
            checkType++;
            checkToEnableButton();
        }
    }//GEN-LAST:event_plusSeniorActionPerformed

    private void plusStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusStudentActionPerformed
        // TODO add your handling code here:
        if(cAll<ticket) {
            cAll++;
            cStudent++;
            countStudent.setText(""+cStudent);
            studentM.setText("Student x "+cStudent);
            ticketPrice = new Student(cStudent);
            studentP = ticketPrice.calTicketPrice();
            System.out.println("Student price: RM"+studentP);
            studentPrice.setText("RM"+studentP+"0");
            checkType++;
            checkToEnableButton();
        }
    }//GEN-LAST:event_plusStudentActionPerformed

    private void minusAdultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusAdultActionPerformed
        // TODO add your handling code here:
        if(cAdult>0) {
            cAll--;
            cAdult--;
            countAdult.setText(""+cAdult);
            ticketPrice = new Adult(cAdult);
            adultP = ticketPrice.calTicketPrice();
            System.out.println("Adult price: RM"+adultP);
            adultPrice.setText("RM"+adultP+"0");
            checkType--;
            checkToEnableButton();
        }
        if(cAdult==0) {
            adultM.setText("Adult");
            adultPrice.setText("       ");
        }
    }//GEN-LAST:event_minusAdultActionPerformed

    private void minusChildrenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusChildrenActionPerformed
        // TODO add your handling code here:
        if(cChildren>0) {
            cAll--;
            cChildren--;
            countChildren.setText(""+cChildren);
            childrenM.setText("Children x "+cChildren);
            ticketPrice = new Children(cChildren);
            childrenP = ticketPrice.calTicketPrice();
            System.out.println("Children price: RM"+childrenP);
            childrenPrice.setText("RM"+childrenP+"0");
            checkType--;
            checkToEnableButton();
            childrenP = ticketPrice.calTicketPrice();
        }
        if(cChildren==0) {
            childrenM.setText("Children");
            childrenPrice.setText("       ");
        }
    }//GEN-LAST:event_minusChildrenActionPerformed

    private void minusOKUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusOKUActionPerformed
        // TODO add your handling code here:
        if(cOKU>0) {
            cAll--;
            cOKU--;
            countOKU.setText(""+cOKU);
            OKUM.setText("OKU x "+cOKU);
            ticketPrice = new OKU(cOKU);
            OKUP = ticketPrice.calTicketPrice();
            System.out.println("OKU price: RM"+OKUP);
            OKUPrice.setText("RM"+OKUP+"0");
            checkType--;
            checkToEnableButton();
            OKUP = ticketPrice.calTicketPrice();
        }
        if(cOKU==0) {
            OKUM.setText("OKU");
            OKUPrice.setText("       ");
        }
    }//GEN-LAST:event_minusOKUActionPerformed

    private void minusSeniorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusSeniorActionPerformed
        // TODO add your handling code here:
        if(cSenior>0) {
            cAll--;
            cSenior--;
            countSenior.setText(""+cSenior);
            seniorM.setText("Senior x "+cSenior);
            ticketPrice = new Senior(cSenior);
            seniorP = ticketPrice.calTicketPrice();
            System.out.println("Senior price: RM"+seniorP);
            seniorPrice.setText("RM"+seniorP+"0");
            checkType--;
            checkToEnableButton();
            seniorP = ticketPrice.calTicketPrice();
        }
        if(cSenior==0) {
            seniorM.setText("Senior");
            seniorPrice.setText("       ");
        }
    }//GEN-LAST:event_minusSeniorActionPerformed

    private void minusStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusStudentActionPerformed
        // TODO add your handling code here:
        if(cStudent>0) {
            cAll--;
            cStudent--;
            countStudent.setText(""+cStudent);
            studentM.setText("Student x "+cStudent);
            ticketPrice = new Student(cStudent);
            studentP = ticketPrice.calTicketPrice();
            System.out.println("Student price: RM"+studentP);
            studentPrice.setText("RM"+studentP+"0");
            checkType--;
            checkToEnableButton();
            studentP = ticketPrice.calTicketPrice();
        }
        if(cStudent==0) {
            studentM.setText("Student");
            studentPrice.setText("       ");
        }
    }//GEN-LAST:event_minusStudentActionPerformed

    private void confirmTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmTypeActionPerformed
        // TODO add your handling code here:
        ignore=1;
        allPrice = adultP+childrenP+OKUP+seniorP+studentP; 
        System.out.println("All Price: RM"+adultP+childrenP+OKUP+seniorP+studentP+"0");
        System.out.println("All Price: RM"+allPrice);
        String price = Double.toString(allPrice);
        mDetail[cUser].setPrice("RM"+price+"0");
        mDetail[cUser].setHall("1");
        
        receipt.setData(mDetail[cUser].getMovieName(),mDetail[cUser].getCinema(),
                mDetail[cUser].getMovieTime(),mDetail[cUser].getHall(),
                mDetail[cUser].getSeat(),mDetail[cUser].getPrice(),mDetail[cUser].getMovieDate());
        System.out.println("Movie: "+mDetail[cUser].getMovieName());
        System.out.println("Cinema: "+mDetail[cUser].getCinema());
        System.out.println("Time: "+mDetail[cUser].getMovieTime());
        
        setDisplayEmpty();
        cUser++;
        ticketType.setVisible(false);
        receipt.setVisible(true);
        newInside.setVisible(true);
        limitSeat=0;
        ticket=0;
        displayTicNum.setText("0");
        clearSeat();
        clearType();
        checkDate=0;
        checkCinema=0;
    }//GEN-LAST:event_confirmTypeActionPerformed

    public void clearType() {
        cAll=0;cAdult=0;cChildren=0;cOKU=0;cSenior=0;cSenior=0;checkType=0;
        adultP=0.0;childrenP=0.0;OKUP=0.0;seniorP=0.0;studentP=0.0;
        
        seatType.setText("                                                   ");
        adultM.setText("Adult");
        childrenM.setText("Children");
        OKUM.setText("OKU");
        seniorM.setText("Senior");
        studentM.setText("Student");
        
        adultPrice.setText("       ");
        childrenPrice.setText("       ");
        OKUPrice.setText("       ");
        seniorPrice.setText("       ");
        studentPrice.setText("       ");
        
        countAdult.setText("0");
        countChildren.setText("0");
        countOKU.setText("0");
        countSenior.setText("0");
        countStudent.setText("0");
    }
    
    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        clearChoice();
        switchInside.setVisible(false);
        newInside.setVisible(true);
        selectSeat.setVisible(false);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseClicked
        // TODO add your handling code here:
        ticketType.setVisible(false);
        seat.setVisible(true);
        displayTicNum.setText("0");
    }//GEN-LAST:event_jLabel34MouseClicked

    private void backFromSwitchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backFromSwitchMouseClicked
        // TODO add your handling code here:
        switchInside.setVisible(false);
        newInside.setVisible(true);
        clearChoice();
    }//GEN-LAST:event_backFromSwitchMouseClicked

    private void backFromSeatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backFromSeatMouseClicked
        // TODO add your handling code here:
        seat.setVisible(false);
        switchInside.setVisible(true);
        ticket=0;
        clearSeat();
    }//GEN-LAST:event_backFromSeatMouseClicked

    private void backFromTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backFromTypeMouseClicked
        // TODO add your handling code here:
        ticketType.setVisible(false);
        seat.setVisible(true);
        clearType();
    }//GEN-LAST:event_backFromTypeMouseClicked

    private void backFromSignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backFromSignUpMouseClicked
        // TODO add your handling code here:
        signup.setVisible(false);
        login.setVisible(true);
        user.requestFocus(true);
    }//GEN-LAST:event_backFromSignUpMouseClicked

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        // TODO add your handling code here:
        login.setVisible(false);
        signup.setVisible(true);
        userF.requestFocus();
    }//GEN-LAST:event_jLabel33MouseClicked

    public static void setAllEmpty() {
        
        for(int i=0; i<100; i++) {
            mDetail[i] = new Movie();
            
            mDetail[i].setCinema(" ");
            mDetail[i].setMovieName(" ");
            mDetail[i].setMovieDate(" ");
            mDetail[i].setMovieTime(" ");
            mDetail[i].setHall(" ");
            mDetail[i].setSeat(" ");
        }
    }
    
    public static void setSeat1() {
        int a=0;
        for(int i=1; i<13; i++) {
            if(i<10) {
                zseat[a] = "H0"+i;
                a++;
            }
            if(i>9) {
                zseat[a] = "H"+i;
                a++;
            }
        }
        for(int i=1; i<13; i++) {
            if(i<10) {
                zseat[a] = "G0"+i;
                a++;
            }
            if(i>9) {
                zseat[a] = "G"+i;
                a++;
            }
        }
    }
    public static void setSeat2() {
        int a=0;
        for(int i=1; i<13; i++) {
            if(i<10) {
                zseat2[a] = "H0"+i;
                a++;
            }
            if(i>9) {
                zseat2[a] = "H"+i;
                a++;
            }
        }
        for(int i=1; i<13; i++) {
            if(i<10) {
                zseat2[a] = "G0"+i;
                a++;
            }
            if(i>9) {
                zseat2[a] = "G"+i;
                a++;
            }
        }
    }
    public static void setSeat3() {
        int a=0;
        for(int i=1; i<13; i++) {
            if(i<10) {
                zseat3[a] = "H0"+i;
                a++;
            }
            if(i>9) {
                zseat3[a] = "H"+i;
                a++;
            }
        }
        for(int i=1; i<13; i++) {
            if(i<10) {
                zseat3[a] = "G0"+i;
                a++;
            }
            if(i>9) {
                zseat3[a] = "G"+i;
                a++;
            }
        }
    }
   
    public static void setDisplayEmpty() {
        for(int i=0; i<6; i++) {
            displaySeat[i] = "";
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        mDetail = new Movie[100];
        
        ticketPrice = new Adult(quantity);
        ticketPrice = new Children(quantity);
        ticketPrice = new OKU(quantity);
        ticketPrice = new Senior(quantity);
        ticketPrice = new Student(quantity);
        
        int one = 1;
        if(one==1) {
            setAllEmpty();
        
            setDisplayEmpty();
            
            setSeat1();
            setSeat2();
            setSeat3();
            
            for(int i=0; i<25; i++) {
                seat1[i] = 0;
                seat2[i] = 0;
            }
            
            one++;
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Feedback;
    private javax.swing.JButton Login;
    private javax.swing.JLabel OKUM;
    private javax.swing.JLabel OKUPrice;
    private javax.swing.JButton Signup;
    private javax.swing.JLabel adultM;
    private javax.swing.JLabel adultPrice;
    private javax.swing.JButton alorS1;
    private javax.swing.JButton alorS8;
    private javax.swing.JButton b18;
    private javax.swing.JButton b19;
    private javax.swing.JButton b20;
    private javax.swing.JLabel backFromSeat;
    private javax.swing.JLabel backFromSignUp;
    private javax.swing.JLabel backFromSwitch;
    private javax.swing.JLabel backFromType;
    private javax.swing.JPanel birdsImage3;
    private javax.swing.JLabel childrenM;
    private javax.swing.JLabel childrenPrice;
    private javax.swing.JButton confirmSeat;
    private javax.swing.JButton confirmType;
    private javax.swing.JLabel countAdult;
    private javax.swing.JLabel countChildren;
    private javax.swing.JLabel countOKU;
    private javax.swing.JLabel countSenior;
    private javax.swing.JLabel countStudent;
    private javax.swing.JPanel damaged2;
    private javax.swing.JLabel displayTicNum;
    private javax.swing.JPanel dolittleImage;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton110;
    private javax.swing.JButton jButton113;
    private javax.swing.JButton jButton117;
    private javax.swing.JButton jButton118;
    private javax.swing.JButton jButton119;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JPanel jumanjiImage;
    private javax.swing.JPanel login;
    private javax.swing.JTextField mailF;
    private javax.swing.JButton minusAdult;
    private javax.swing.JButton minusChildren;
    private javax.swing.JButton minusOKU;
    private javax.swing.JButton minusSenior;
    private javax.swing.JButton minusStudent;
    private javax.swing.JLabel movieImage;
    private javax.swing.JLayeredPane movieLayeredPane;
    private javax.swing.JLabel movieName;
    private javax.swing.JPanel newInside;
    private javax.swing.JPanel overall;
    private javax.swing.JPasswordField passF;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton penangQ1;
    private javax.swing.JButton penangQ5;
    private javax.swing.JButton penangQ8;
    private javax.swing.JButton penangS1;
    private javax.swing.JButton penangS4;
    private javax.swing.JButton penangS8;
    private javax.swing.JButton plusAdult;
    private javax.swing.JButton plusChildren;
    private javax.swing.JButton plusOKU;
    private javax.swing.JButton plusSenior;
    private javax.swing.JButton plusStudent;
    private javax.swing.JPanel seat;
    private javax.swing.JToggleButton seatG01;
    private javax.swing.JToggleButton seatG02;
    private javax.swing.JToggleButton seatG03;
    private javax.swing.JToggleButton seatG04;
    private javax.swing.JToggleButton seatG05;
    private javax.swing.JToggleButton seatG06;
    private javax.swing.JToggleButton seatG07;
    private javax.swing.JToggleButton seatG08;
    private javax.swing.JToggleButton seatG09;
    private javax.swing.JToggleButton seatG10;
    private javax.swing.JToggleButton seatG11;
    private javax.swing.JToggleButton seatG12;
    private javax.swing.JToggleButton seatH01;
    private javax.swing.JToggleButton seatH02;
    private javax.swing.JToggleButton seatH03;
    private javax.swing.JToggleButton seatH04;
    private javax.swing.JToggleButton seatH05;
    private javax.swing.JToggleButton seatH06;
    private javax.swing.JToggleButton seatH07;
    private javax.swing.JToggleButton seatH08;
    private javax.swing.JToggleButton seatH09;
    private javax.swing.JToggleButton seatH10;
    private javax.swing.JToggleButton seatH11;
    private javax.swing.JToggleButton seatH12;
    private javax.swing.JLabel seatType;
    private javax.swing.JButton selectSeat;
    private javax.swing.JLabel seniorM;
    private javax.swing.JLabel seniorPrice;
    private javax.swing.JPanel signup;
    private javax.swing.JLabel studentM;
    private javax.swing.JLabel studentPrice;
    private javax.swing.JPanel switchInside;
    private javax.swing.JPanel ticketType;
    private javax.swing.JTextField user;
    private javax.swing.JTextField userF;
    private javax.swing.JLabel userFinside;
    // End of variables declaration//GEN-END:variables
}
