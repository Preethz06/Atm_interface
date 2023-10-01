import withdraw_package.*;
import fast_withdrawl_package.*;
import Deposit_package.*;
import Change_pin_package.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class main_screen{
    public main_screen(){
        JFrame j = new JFrame("WELCOME");
        j.setSize(1200, 800);
        j.setLayout(new BorderLayout(0,0));

        String url="jdbc:mysql://127.0.0.1:3306";
        String uname="root";
        String paswd="PRIPREETH26";
        String databaseName="bank";

        JPanel upperpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ImageIcon icon = new ImageIcon("C:\\Users\\preet\\IdeaProjects\\atm_interface\\pics\\b1png.png");



        JLabel l1 = new JLabel(icon);
        JLabel l2 = new JLabel("BANK OF INDIA");

        upperpanel.setBounds(0,0,580,30);
        l2.setFont(new Font("Arial", Font.BOLD, 31));
        l2.setPreferredSize(new Dimension(230,30));
        l1.setPreferredSize(new Dimension(200,200));
        upperpanel.add(l1);
        upperpanel.add(l2);
        upperpanel.setBackground(Color.gray);

        JPanel lowerpanel = new JPanel(new GridLayout(5,3,10,30));
        lowerpanel.setBounds(0,200,1200,600);
        lowerpanel.setBackground(Color.LIGHT_GRAY);
        JLabel l3,l4,l5,l6,l7,l8,l9;
        l3 = new JLabel("");
        l4 = new JLabel("WELCOME",JLabel.CENTER);
        l5 = new JLabel("");
        l6 = new JLabel("");
        l7 = new JLabel("");
        l8 = new JLabel("");
        l9 = new JLabel("");
        l4.setFont(new Font("Arial", Font.BOLD, 24));
        JButton b1,b2,b3,b4,b5;
        b1= new JButton("Deposit");
        b2= new JButton("Withdraw");
        b3= new JButton("Change pin");
        b4 = new JButton("Fast Withdraw");
        b5 = new JButton("Balance Enquiry");
        b1.setFont(new Font("Arial", Font.BOLD, 16));
        b2.setFont(new Font("Arial", Font.BOLD, 16));
        b3.setFont(new Font("Arial", Font.BOLD, 16));
        b4.setFont(new Font("Arial", Font.BOLD, 16));
        b5.setFont(new Font("Arial", Font.BOLD, 16));

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdraw w=new withdraw();
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fast_withdrawl f=new fast_withdrawl();
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Change_pin c=new Change_pin();
            }
        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deposit d=new Deposit();
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Enter_pin();

            }


            public void Enter_pin(){
                JFrame j = new JFrame("WELCOME");
                j.setSize(1200, 800);
                j.setLayout(new BorderLayout(0,0));

                JPanel upperpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                ImageIcon icon = new ImageIcon("C:\\Users\\preet\\IdeaProjects\\atm_interface\\pics\\b1png.png");

                JLabel l1 = new JLabel(icon);
                JLabel l2 = new JLabel("BANK OF INDIA");
                l2.setFont(new Font("Arial", Font.BOLD, 24));
                upperpanel.setBounds(0,0,1200,200);
                upperpanel.setBackground(Color.gray);

                l2.setPreferredSize(new Dimension(280,30));
                l1.setPreferredSize(new Dimension(200,200));
                upperpanel.add(l1);
                upperpanel.add(l2);

                JPanel lowerpanel = new JPanel(new GridLayout(5,3,10,30));
                lowerpanel.setBounds(0,300,1200,600);
                JLabel l3,l4,l5,l6,l7,l8,l9,l10;
                l3 = new JLabel("");
                l4 = new JLabel("ENTER YOUR PIN",JLabel.CENTER);
                l4.setFont(new Font("Arial",Font.BOLD,24));
                l5 = new JLabel("");
                l6 = new JLabel("");
                l7 = new JLabel("");
                l8 = new JLabel("");
                l9 = new JLabel("");
                l10 = new JLabel("ENTER YOUR PIN TO CONTINUE",JLabel.CENTER);
                l10.setFont(new Font("Arial", Font.BOLD, 18));
                lowerpanel.setBackground(Color.LIGHT_GRAY);
                JButton b1,b2,b3,b4,b5;

                JTextField t1= new JTextField();
                t1.setHorizontalAlignment(JTextField.CENTER);
                t1.setFont(new Font("Arial", Font.BOLD, 18));
                b2= new JButton("CONFIRM");

                b2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection(url, uname, paswd);
                            Statement st = con.createStatement();
                            String q1 = "use " + databaseName + ";";
                            String q2 = "select * from users where pin=" + t1.getText() + ";";
                            st.executeUpdate(q1);
                            ResultSet rs = st.executeQuery(q2);
                            rs.next();
                            JFrame j1 = new JFrame("BALANCE");
                            ImageIcon icon = new ImageIcon("C:\\Users\\preet\\IdeaProjects\\atm_interface\\pics\\b1png.png");
                            JPanel upperpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                            JLabel l1 = new JLabel(icon);
                            JLabel l2 = new JLabel("BANK OF INDIA");
                            l2.setFont(new Font("Arial", Font.BOLD, 24));
                            upperpanel.setBounds(0,0,1200,200);
                            upperpanel.setBackground(Color.gray);

                            l2.setPreferredSize(new Dimension(280,30));
                            l1.setPreferredSize(new Dimension(200,200));
                            upperpanel.add(l1);
                            upperpanel.add(l2);
                            j1.setLayout(new BorderLayout());
                            j1.setSize(1200, 800);
                            JButton b11= new JButton("CANCEL");
                            JLabel l123 = new JLabel("Your account Balance is Rs." + (Integer) rs.getObject(3));
                            l123.setFont(new Font("Arial", Font.BOLD, 30));

                            l123.setHorizontalAlignment(SwingConstants.CENTER);

                            l123.setVerticalAlignment(SwingConstants.CENTER);

                            b11.addActionListener(new ActionListener() {
                                @Override

                                    public void actionPerformed(ActionEvent exx) {
                                        System.exit(0);
                                    }

                            });
                            j1.add(upperpanel,BorderLayout.NORTH);
                            j1.setResizable(false);
                            j1.setBackground(Color.GRAY);
                            j1.add(b11,BorderLayout.SOUTH);
                            j1.add(l123, BorderLayout.CENTER);
                            j1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                            j1.setLocationRelativeTo(null);
                            j1.setVisible(true);

                        }
                    catch(Exception ex){
                            ex.printStackTrace();
                    }
                    }
                });

                b4 = new JButton("CANCEL");
                b2.setFont(new Font("Arial", Font.BOLD, 16));
                b4.setFont(new Font("Arial", Font.BOLD, 16));
                b4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });


                lowerpanel.add(l3); lowerpanel.add(l4);lowerpanel.add(l5);lowerpanel.add(l10);lowerpanel.add(t1); lowerpanel.add(b2);lowerpanel.add(l6);lowerpanel.add(l7);
                lowerpanel.add(b4);lowerpanel.add(l8);lowerpanel.add(l9);

                j.add(upperpanel,BorderLayout.NORTH);
                j.add(lowerpanel,BorderLayout.CENTER);



                j.setVisible(true);
                j.setLocationRelativeTo(null);
                j.setResizable(false);
                j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            }


        });

        lowerpanel.add(l3); lowerpanel.add(l4);lowerpanel.add(l5);lowerpanel.add(b1);lowerpanel.add(l6); lowerpanel.add(b2);lowerpanel.add(b3);lowerpanel.add(l7);
        lowerpanel.add(b4);lowerpanel.add(l8);lowerpanel.add(l9);lowerpanel.add(b5);

        j.add(upperpanel,BorderLayout.NORTH);
        j.add(lowerpanel,BorderLayout.CENTER);



        j.setVisible(true);
        j.setLocationRelativeTo(null);
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String args[]){
        main_screen m = new main_screen();
    }
}