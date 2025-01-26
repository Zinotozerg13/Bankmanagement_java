package bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    ImageIcon i1;
    JLabel image;
    JTextField amountTextField;
    JButton Withdraw, back;
    String pinNumber;

    Withdraw(String pinNumber) {
        this.pinNumber = pinNumber;

        setLayout(null);
        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 850, 850);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setBounds(170, 300, 400, 23);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 15));
        image.add(text);

        amountTextField = new JTextField();
        amountTextField.setFont(new Font("Arial", Font.BOLD, 22));
        amountTextField.setBounds(160, 350, 290, 25);
        amountTextField.addActionListener(this);
        image.add(amountTextField);

        Withdraw = new JButton("Withdraw");
        Withdraw.setBounds(150, 430, 100, 23);
        Withdraw.addActionListener(this);
        image.add(Withdraw);

        back = new JButton("Back");
        back.setBounds(320, 430, 100, 23);
        back.addActionListener(this);
        image.add(back);

        setSize(850, 850);
        setLocation(300, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

    }


    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = this.amountTextField.getText();
            Date date = new Date();
            if (ae.getSource() == Withdraw) {
                if (this.amountTextField.getText().equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "Please enter the Amount to you want to Withdraw");
                } else {
                    Conn c1 = new Conn();
                    ResultSet rs = c1.s.executeQuery("select * from bank where pin = '" + pinNumber + "'");
                    int balance = 0;

                    while(rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog((Component)null, "Insuffient Balance");
                        return;
                    }

                    c1.s.executeUpdate("insert into bank values('" + pinNumber + "', '" + date + "', 'Withdrawl', '" + amount + "')");
                    JOptionPane.showMessageDialog((Component)null, "Rs. " + amount + " Debited Successfully");
                    this.setVisible(false);
                    (new Transactions(pinNumber)).setVisible(true);
                }
            } else if (ae.getSource() == this.back) {
                this.setVisible(false);
                (new Transactions(pinNumber)).setVisible(true);
            }
        } catch (Exception var7) {
            Exception e = var7;
            e.printStackTrace();
            System.out.println("error: " + e);
        }

    }
    public static void main (String args[]){
        new Withdraw("");
    }
}
