package Enter_pin_package;
import javax.swing.*;
import java.awt.*;

public class Enter_pin{
    public Enter_pin(){
        JFrame j = new JFrame("WELCOME");
        j.setSize(1200, 800);
        j.setLayout(new BorderLayout(0,0));

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
        l4 = new JLabel("ENTER YOUR PIN",JLabel.CENTER);
        l4.setFont(new Font("Arial", Font.BOLD, 24));
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

        JTextField t1,t2;
        t1= new JTextField();
        t1.setHorizontalAlignment(JTextField.CENTER);
        t1.setFont(new Font("Arial", Font.BOLD, 18));
        t2= new JTextField();
        t2.setHorizontalAlignment(JTextField.CENTER);
        t2.setFont(new Font("Arial", Font.BOLD, 18));
        b2= new JButton("CONFIRM");
        b4 = new JButton("CANCEL");
        b2.setFont(new Font("Arial", Font.BOLD, 16));
        b4.setFont(new Font("Arial", Font.BOLD, 16));

        t1.setEditable(false);
        lowerpanel.add(l3); lowerpanel.add(l4);lowerpanel.add(l5);lowerpanel.add(l10);lowerpanel.add(t1); lowerpanel.add(b2);lowerpanel.add(l6);lowerpanel.add(t2);
        lowerpanel.add(b4);lowerpanel.add(l8);lowerpanel.add(l9);

        j.add(upperpanel,BorderLayout.NORTH);
        j.add(lowerpanel,BorderLayout.CENTER);



        j.setVisible(true);
        j.setLocationRelativeTo(null);
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String args[]){
        Enter_pin m = new Enter_pin();
    }
}
