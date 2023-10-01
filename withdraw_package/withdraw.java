package withdraw_package;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class withdraw extends Component {
    public withdraw(){
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
        l4 = new JLabel("WITHDRAW",JLabel.CENTER);
        l4.setFont(new Font("Arial", Font.BOLD, 24));

        l5 = new JLabel("");
        l6 = new JLabel("");
        l7 = new JLabel("");
        l8 = new JLabel("");
        l9 = new JLabel("");
        l10 = new JLabel("ENTER THE AMOUNT TO WITHDRAW",JLabel.CENTER);
        l10.setFont(new Font("Arial", Font.BOLD, 18));
        lowerpanel.setBackground(Color.LIGHT_GRAY);
        JButton b1,b2,b3,b4,b5;

        JTextField t1= new JTextField();
        t1.setHorizontalAlignment(JTextField.CENTER);
        t1.setFont(new Font("Arial", Font.BOLD, 18));

        b2= new JButton("CONFIRM");
        b4 = new JButton("CANCEL");
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });




        b2.setFont(new Font("Arial", Font.BOLD, 16));
        b4.setFont(new Font("Arial", Font.BOLD, 16));
        b2.addActionListener(new ActionListener() {
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
                l4 = new JLabel("");
                l5 = new JLabel("");
                l6 = new JLabel("ENTER YOUR PIN TO CONTINUE",JLabel.CENTER);
                l7 = new JLabel("");
                l8 = new JLabel("");
                l9 = new JLabel("");
                l10 = new JLabel("THE ENTERED AMOUNT IS",JLabel.CENTER);
                l10.setFont(new Font("Arial", Font.BOLD, 18));
                l6.setFont(new Font("Arial", Font.BOLD, 18));
                lowerpanel.setBackground(Color.LIGHT_GRAY);
                JButton b1,b2,b3,b4,b5;

                JTextField t11,t2;
                t11= new JTextField();
                t11.setHorizontalAlignment(JTextField.CENTER);
                t11.setFont(new Font("Arial", Font.BOLD, 18));
                t2= new JTextField();
                t2.setHorizontalAlignment(JTextField.CENTER);
                t2.setFont(new Font("Arial", Font.BOLD, 18));
                b2= new JButton("CONFIRM");
                b4 = new JButton("CANCEL");

                b2.setFont(new Font("Arial", Font.BOLD, 16));
                b4.setFont(new Font("Arial", Font.BOLD, 16));
                t11.setText(t1.getText());
                t11.setEditable(false);

                b4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });

                b2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection(url, uname, paswd);
                            Statement st = con.createStatement();
                            String q1 = "use " + databaseName + ";";
                            String q2 = "select * from users where pin=" + t2.getText() + ";";
                            st.executeUpdate(q1);
                            ResultSet rs = st.executeQuery(q2);
                            rs.next();
                            int i= Integer.parseInt(t11.getText());

                            if ((Integer)rs.getObject(3) > i) {
                                int j = (Integer) rs.getObject(3) - i;
                                String q3 = "UPDATE users SET balance = " + j + " WHERE account = '" + rs.getObject(4) + "';";
                                st.executeUpdate(q3);
                                JOptionPane.showMessageDialog(withdraw.this, "Please collect your card and cash", "Success", JOptionPane.INFORMATION_MESSAGE);
                            }
                            else {
                                JOptionPane.showMessageDialog(withdraw.this, "Insufficient Balance", "Alert", JOptionPane.ERROR_MESSAGE);
                            }
                            System.exit(0); // Move this line outside of the else block


                            con.close();
                            st.close();
                            rs.close();

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                ;
                lowerpanel.add(l3); lowerpanel.add(l4);lowerpanel.add(l5);lowerpanel.add(l10);lowerpanel.add(t11); lowerpanel.add(b2);lowerpanel.add(l6);lowerpanel.add(t2);
                lowerpanel.add(b4);lowerpanel.add(l8);lowerpanel.add(l9);

                j.add(upperpanel,BorderLayout.NORTH);
                j.add(lowerpanel,BorderLayout.CENTER);



                j.setVisible(true);
                j.setLocationRelativeTo(null);
                j.setResizable(false);
                j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

    public static void main(String args[]){
        withdraw m = new withdraw();
    }
}