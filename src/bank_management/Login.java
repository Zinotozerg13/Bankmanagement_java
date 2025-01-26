package bank_management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLOutput;

public class Login extends JFrame implements ActionListener{
    JButton sign_up,sign_in,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(String formno)
    {
        setTitle("AUTOMATED TELLER MACHINE");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2=i1.getImage().getScaledInstance(60,60, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        label.setBounds(60,10,100,100);
        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,32));
        text.setBounds(200,40,400,40);

        JLabel cardno=new JLabel("Card No :");
        cardno.setFont(new Font("Raleway",Font.BOLD,24));
        cardno.setBounds(170,120,200,20);
         cardTextField=new JTextField();
         cardTextField.setFont(new Font("Arial",Font.BOLD,15));
        cardTextField.setBounds(300,120,230,20);

        JLabel pin=new JLabel("PIN :");
        pin.setFont(new Font("Raleway",Font.BOLD,24));
        pin.setBounds(170,170,200,20);
         pinTextField=new JPasswordField();
        pinTextField.setFont(new Font("Arial",Font.BOLD,15));
        pinTextField.setBounds(300,170,230,20);

        sign_in=new JButton("Login ");
        sign_in.setBounds(300,230,100,20);
        sign_in.setBackground(Color.black);
        sign_in.setForeground(Color.white);

        sign_in.addActionListener(this);

         clear=new JButton("Clear ");
        clear.setBounds(430,230,100,20);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);

         sign_up=new JButton("Sign up ");
        sign_up.setBounds(300,260,230,20);
        sign_up.setBackground(Color.black);
        sign_up.setForeground(Color.white);
        sign_up.addActionListener(this);







        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        add(cardTextField);
        add(pinTextField);
        add(sign_up);
        add(sign_in);
        add(text);
        add(label);
        add(clear);
        add(cardno);
        add(pin);


        setSize(800,420);
        setVisible(true);
        setLocation(350,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);


    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()==sign_up) {
            setVisible(false);
            new SignupOne().setVisible(true);

        }else if(ae.getSource()==sign_in) {
            Conn conn = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "SELECT * FROM login WHERE cardNumber = '" + cardNumber + "' AND pinNumber = '" + pinNumber + "'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }


    }

    public static void main(String[] args)
    {
        new Login("");
    }
}

