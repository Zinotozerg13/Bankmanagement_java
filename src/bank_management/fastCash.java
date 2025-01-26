package bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.util.Date;


public class fastCash extends JFrame implements ActionListener {
    JButton deposit,withDrawl,fastCash,miniStatement,pinChange,balanceInquiry,exit;
    String pinNumber;
    fastCash(String pinNumber)
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

        deposit=new JButton(" Rs 1000");
        deposit.setBounds(150,400,150,23);
        deposit.addActionListener(this);
        image.add(deposit);

        withDrawl=new JButton(" Rs 2000");
        withDrawl.setBounds(330,400,150,23);
        withDrawl.addActionListener(this);
        image.add(withDrawl);

        fastCash=new JButton(" Rs 5000");
        fastCash.setBounds(150,430,150,23);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement=new JButton(" Rs 10000");
        miniStatement.setBounds(330,430,150,23);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        fastCash=new JButton(" Rs 12000");
        fastCash.setBounds(150,430,150,23);
        fastCash.addActionListener(this);
        image.add(fastCash);

        pinChange=new JButton(" Rs 15000");
        pinChange.setBounds(150,460,150,23);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceInquiry=new JButton(" Rs 20000");
        balanceInquiry.setBounds(330,460,150,23);
        balanceInquiry.addActionListener(this);
        image.add(balanceInquiry);

        exit=new JButton("Back");
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
           setVisible(false);
           new Transactions(pinNumber).setVisible(true);
        }
        else
        {
            String amount=((JButton)ae.getSource()).getText().substring(4);
            Conn c=new Conn();
            try
            {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinNumber + "'");
                int balance=0;
                while(rs.next())
                {
                    if(rs.getString("type").equals("Deposit"))
                    {
                        balance+=Integer.parseInt((rs.getString("amount")));
                    }else {
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
               if(ae.getSource()!=exit && balance<Integer.parseInt(amount))
               {
                   JOptionPane.showMessageDialog(null,"Insufficient Balance");
                   return;
               }
               Date date=new Date();
                String query = "insert into bank values('" + pinNumber + "', '" + date + "', 'Withdraw', '" + amount + "')";
                ; c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }

    }
    public static void main(String[] args)
    {
        new fastCash("");
    }
}
