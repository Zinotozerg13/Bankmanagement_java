package bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit,withDrawl,fastCash1,miniStatement,pinChange,balanceInquiry,exit;
    String pinNumber;
    Transactions(String pinNumber)
    {
        this.pinNumber=pinNumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(850,850, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,850,850);
        add(image);

        JLabel text3= new JLabel("Please select your Transactions");
        text3.setBounds(180,300,400,23);
        text3.setForeground(Color.white);
        text3.setFont(new Font("System",Font.BOLD,18));
        image.add(text3);

         deposit=new JButton("Deposit");
        deposit.setBounds(150,400,150,23);
        deposit.addActionListener(this);
        image.add(deposit);

     withDrawl=new JButton("Cash Withdrawl");
        withDrawl.setBounds(330,400,150,23);
        withDrawl.addActionListener(this);
        image.add(withDrawl);



        miniStatement=new JButton("Mini Statement");
        miniStatement.setBounds(330,430,150,23);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        fastCash1=new JButton("Fast Cash");
        fastCash1.setBounds(150,430,150,23);
        fastCash1.addActionListener(this);
        image.add(fastCash1);

        pinChange=new JButton("Pin Change");
        pinChange.setBounds(150,460,150,23);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceInquiry=new JButton("Balance Inquiry");
        balanceInquiry.setBounds(330,460,150,23);
        balanceInquiry.addActionListener(this);
        image.add(balanceInquiry);

        exit=new JButton("Exit");
        exit.setBounds(255,490,130,23);
        exit.addActionListener(this);
        image.add(exit);


        setSize(850,850);
        setLocation(300,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);



    }
public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==exit)
    {
        System.exit(0);
    }
    else if(ae.getSource()==deposit)
    {
        new Deposit(pinNumber).setVisible(true);
    }
    else if(ae.getSource()==withDrawl)
    {   setVisible(false);
        new Withdraw(pinNumber).setVisible(true);
    }
    else if(ae.getSource()==fastCash1)
    {   setVisible(false);
        new fastCash(pinNumber).setVisible(true);
    }
    else if(ae.getSource()==pinChange)
    {   setVisible(false);
        new pinChange(pinNumber).setVisible(true);
    }
    else if(ae.getSource()==balanceInquiry)
    {   setVisible(false);
        new balanceEnquiry(pinNumber).setVisible(true);
    }
    else if(ae.getSource()==miniStatement)
    {   setVisible(false);
        new miniStatement(pinNumber).setVisible(true);
    }
    
}
public static void main(String[] args)
{
    new Transactions("");
}
}
