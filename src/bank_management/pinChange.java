package bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.Date;

public class pinChange extends JFrame implements ActionListener {
    ImageIcon i1;
    JLabel image;
    JPasswordField pinTextField,confirmText;
    JLabel pinChange, repin;
    JButton change,back;
    String pinNumber;

    pinChange(String pinNumber) {
        this.pinNumber = pinNumber;

        setLayout(null);
        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 850, 850);
        add(image);

        JLabel text3= new JLabel("CHANGE YOUR PIN");
        text3.setBounds(180,300,400,23);
        text3.setForeground(Color.white);
        text3.setFont(new Font("System",Font.BOLD,18));
        image.add(text3);




        pinChange = new JLabel("New PIN :");
        pinChange.setForeground(Color.white);
        pinChange.setBounds(150, 350, 100, 23);
        image.add(pinChange);

        pinTextField = new JPasswordField();
        pinTextField.setFont(new Font("Arial", Font.BOLD, 17));
        pinTextField.setBounds(220, 350, 250, 20);
        pinTextField.addActionListener(this);
        image.add(pinTextField);

        repin = new JLabel("Confirm PIN :");
        repin.setForeground(Color.white);
        repin.setBounds(130, 400, 100, 23);
        image.add(repin);

        confirmText = new JPasswordField();
        confirmText.setFont(new Font("Arial", Font.BOLD, 17));
        confirmText.setBounds(220, 400, 250, 20);
        confirmText.addActionListener(this);
        image.add(confirmText);

        change = new JButton("Change");
        change.setBounds(150, 450, 100, 23);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(370, 450, 100, 23);
        back.addActionListener(this);
        image.add(back);

        setSize(850, 850);
        setLocation(300, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            String number=pinTextField.getText();
            Date date=new Date();



                try {
                    String npin=pinTextField.getText();
                    String cpin=confirmText.getText();
                    if(npin.equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"Please re enter new PIN");
                    }
                    if(!npin.equals(cpin))
                    {
                        JOptionPane.showMessageDialog(null,"Entered pin doesnt match");
                    }
                    Conn conn=new Conn();
                    String query1 = "UPDATE bank SET pin = '" + npin + "' WHERE pin = '" + pinNumber + "'";
                    String query2 = "UPDATE login SET pinNumber = '" + npin + "' WHERE pinNumber = '" + pinNumber + "'";
                    String query3 = "UPDATE signupthree SET pinNumber = '" + npin + "' WHERE pinNumber = '" + pinNumber + "'";

                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    conn.s.executeUpdate(query3);
                    JOptionPane.showMessageDialog(null,"PIN changed sucessfully");
                    setVisible(false);
                    new Transactions(npin);
                }
                catch (Exception e) {
                    System.out.println(e);
                }
            }
         else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber);


        }
    }
    public static void main (String args[]){
        new pinChange("");
    }
}
