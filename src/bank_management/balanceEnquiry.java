package bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.util.Date;

public class balanceEnquiry extends JFrame implements ActionListener {
    ImageIcon i1;
    JLabel image;
    JPasswordField pinTextField,confirmText;
    JLabel balanceEnquiry, repin;
    JButton change,back;
    String pinNumber;

    balanceEnquiry(String pinNumber) {
        this.pinNumber = pinNumber;

        setLayout(null);
        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 850, 850);
        add(image);







        back = new JButton("Back");
        back.setBounds(260, 450, 100, 25);
        back.addActionListener(this);
        image.add(back);
        int balance=0;
        Conn c=new Conn();
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinNumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt((rs.getString("amount")));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e)
            {
                System.out.println(e);
            }
        JLabel text3= new JLabel("Your current Account balance is Rs "+balance);
        text3.setBounds(140,300,400,20);
        text3.setForeground(Color.white);
        text3.setFont(new Font("System",Font.BOLD,16));
        image.add(text3);


        setSize(850, 850);
        setLocation(300, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

    }


        public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()==back)
       {
           setVisible(false);
           new Transactions(pinNumber);
       }
    }
    public static void main (String args[]){
        new balanceEnquiry("");
    }
}
