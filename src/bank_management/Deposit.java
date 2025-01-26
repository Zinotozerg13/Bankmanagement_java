package bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    ImageIcon i1;
    JLabel image;
    JTextField amountTextField;
    JButton deposit, back;
    String pinNumber;

    Deposit(String pinNumber) {
        this.pinNumber = pinNumber;

        setLayout(null);
        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 850, 850);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(170, 300, 400, 23);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 15));
        image.add(text);

        amountTextField = new JTextField();
        amountTextField.setFont(new Font("Arial", Font.BOLD, 22));
        amountTextField.setBounds(160, 350, 290, 25);
        amountTextField.addActionListener(this);
        image.add(amountTextField);

        deposit = new JButton("Deposit");
        deposit.setBounds(150, 430, 100, 23);
        deposit.addActionListener(this);
        image.add(deposit);

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
        if (ae.getSource() == deposit) {
            String number=amountTextField.getText();
            Date date=new Date();
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
            }
            else{
                Conn conn=new Conn();
                String query = "INSERT INTO bank (pin, date, type, amount) VALUES ('" + pinNumber + "', '" + date + "', 'Deposit', '" + number + "')";
                try {
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
                catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber);


        }
    }
        public static void main (String args[]){
            new Deposit("");
        }
    }
