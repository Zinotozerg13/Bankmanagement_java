package bank_management;
import jdk.jfr.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {
    JLabel text3,accType,cardNum,number,pin1,pinNumber,pinDetail,numDetail,sRequired;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit1,cancel;
    String formNo;
    SignupThree(String formNo)
    {
        this.formNo=formNo;
        setTitle("SignupThree");
         text3=new JLabel("Page 3  : Additional Details ");
        text3.setFont(new Font("Osward",Font.BOLD,32));
        text3.setBounds(200,40,500,40);

        accType=new JLabel("Account Type :");
        accType.setFont(new Font("Raleway",Font.BOLD,20));
        accType.setBounds(170,120,200,23);

        ButtonGroup grp3 =new ButtonGroup();

        r1=new JRadioButton("Saving Account");
        r1.setBackground(Color.white);
        r1.setBounds(250,170,120,23);

        r2=new JRadioButton("Fixed Deposit Account");

        r2.setBackground(Color.white);
        r2.setBounds(400,170,200,23);

        r3=new JRadioButton("Current Account");
        r3.setBackground(Color.white);
        r3.setBounds(250,200,120,23);

        r4=new JRadioButton("Recurring Deposit Account");
        r4.setBackground(Color.white);
        r4.setBounds(400,200,200,23);

        cardNum=new JLabel("Card Number :");
        cardNum.setFont(new Font("Raleway",Font.BOLD,20));
        cardNum.setBounds(170,270,140,23);

        numDetail=new JLabel("Your 16 digit Card Number");
        numDetail.setFont(new Font("Raleway",Font.BOLD,10));
        numDetail.setBounds(170,290,140,23);

        number=new JLabel("XXXX-XXXX-XXXX-4139");
        number.setFont(new Font("Arial",Font.BOLD,16));
        number.setBounds(330,270,300,23);





        pin1=new JLabel("Pin :");
        pin1.setFont(new Font("Raleway",Font.BOLD,20));
        pin1.setBounds(170,320,140,23);

        pinDetail=new JLabel("Your 4 digit password");
        pinDetail.setFont(new Font("Raleway",Font.BOLD,10));
        pinDetail.setBounds(170,340,140,23);

        pinNumber=new JLabel("XXXX");
        pinNumber.setFont(new Font("Arial",Font.BOLD,16));
        pinNumber.setBounds(330,320,300,23);


        sRequired=new JLabel("Service Required :");
        sRequired.setFont(new Font("Raleway",Font.BOLD,20));
        sRequired.setBounds(170,390,200,23);

        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setBounds(200,440,130,23);


        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setBounds(370,440,130,23);

        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setBounds(200,470,130,23);

        c4=new JCheckBox("EMAIL & SMS Alert");
        c4.setBackground(Color.white);
        c4.setBounds(370,470,170,23);

        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setBounds(200,500,130,23);

        c6=new JCheckBox("E-statement ");
        c6.setBackground(Color.white);
        c6.setBounds(370,500,130,23);

        c7=new JCheckBox("I hereby declare that the above details are correct to the best of my knowledge");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,16));
        c7.setBounds(100,550,800,23);

        submit1=new JButton("Submit");
        submit1.setBackground(Color.black);
        submit1.setForeground(Color.white);
        submit1.setBounds(500,600,130,30);
        submit1.setFont(new Font("Arial",Font.BOLD,16));
        submit1.addActionListener(this);

        cancel=new JButton("Cancel");
        cancel.setBackground(Color.red);
        cancel.setForeground(Color.BLACK);
        cancel.setBounds(100,600,130,30);
        cancel.setFont(new Font("Arial",Font.BOLD,16));
        cancel.addActionListener(this);


        grp3.add(r1);
        grp3.add(r2);
        grp3.add(r3);
        grp3.add(r4);



        setLayout(null);
        add(c1);
        add(c2);
        add(c3);
        add(c4);
        add(c4);
        add(c5);
        add(c6);
        add(c7);
        add(submit1);
        add(cancel);
        add(sRequired);
        add(text3);
        add(accType);
        add(numDetail);
        add(pinDetail);
        add(r1);
        add(r2);
        add(number);
        add(r3);
        add(r4);
        add(cardNum);
        add(pin1);
        add(pinNumber);
        getContentPane().setBackground(Color.white);
        setSize(800,700);
        setVisible(true);
        setLocation(350,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit1)
        {
            String accType=null;
            if(r1.isSelected())
            {
                accType="Saving Account";
            }
            else if(r2.isSelected())
            {
                accType="Fixed Deposit Account";
            }
            else if(r4.isSelected())
            {
                accType="Recurring Deposit Account";
            }
            else if(r3.isSelected())
            {
                accType="Saving Account";
            }
            Random random1=new Random();
            long prefix = 5048960000000000L; long suffix = Math.abs(random1.nextLong() % 1000000000L);
            String cardno = String.format("%016d", prefix + suffix);
            String pinno = String.format("%04d", Math.abs(random1.nextInt(10000)));
            String facility="";
            if(c1.isSelected())
            {
                facility=facility+"ATM card";
            }

            if(c2.isSelected())
            {
                facility=facility+"Internet Banking";
            }
            if(c3.isSelected())
            {
                facility=facility+"Email & SMS alert";
            }
            if(c4.isSelected())
            {
                facility=facility+"Cheque Book";
            }
            if(c5.isSelected())
            {
                facility=facility+"E-statement";
            }
            try {
                if (accType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else if (c7.isSelected()) {
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree (formno,accountType, cardNumber, pinNumber, facility) values ('" + formNo + "','" + accType + "', '" + cardno + "', '" + pinno + "', '" + facility + "')";
                    String query2 = "insert into login (formno, cardNumber, pinNumber) values ('" + formNo + "', '" + cardno + "', '" + pinno + "')";

                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number :" + cardno + "\n PIN :" + pinno);
                    setVisible(false);
                    new Deposit(pinno).setVisible(true);
                }

            }catch(Exception e)
            {
                System.out.println(e);
            }
            setVisible(false);
            new Login(formNo).setVisible(true);

        }else if(ae.getSource()==cancel)
        {
            setVisible(false);
            new Login(formNo).setVisible(true);
        }
    }
    public static void main(String[] args)
    {
        new SignupThree("");
    }
}
