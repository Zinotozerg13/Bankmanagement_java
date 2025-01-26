package bank_management;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class SignupTwo extends JFrame implements ActionListener{
JLabel religion,category,educationQ,occupation,income,citizenship,senior_citizen,existing_acc;
JComboBox religion_list,category_list,edu_list,income_list;
    JTextField citizenship_TField;
    JRadioButton yes_RadioButton,no_RadioButton,yes_RadioButton1,no_RadioButton1;
    JButton next1;
    String formno;

    SignupTwo(String formno)
    {
    this.formno=formno;
        String rlist[]={"Hindu","Muslim","Buddhist","Chrisitan"};
        String elist[]={"High School Diploma", "Associate Degree", "Bachelor's Degree",
                "Master's Degree", "Doctoral Degree (PhD)", "Professional Degree (e.g., JD, MD)"};
        String[] clist={"General Banking", "Business Banking", "Investment Banking",
                "Wealth Management", "Mortgage and Loans", "Online Banking", "Credit Cards", "Insurance"};
        String[] ilist={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000 or more"};


        setTitle("NEW ACCOUNT APPLICATION FORM -PAGE 2");
        JLabel text1=new JLabel("Page 2 : Additional Details ");
        text1.setFont(new Font("Osward",Font.BOLD,32));
        text1.setBounds(200,40,500,40);

          religion=new JLabel("Religion :");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(170,120,200,23);



         category=new JLabel("Category :");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(170,170,200,23);

        income=new JLabel("Income :");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(170,220,200,23);

         educationQ=new JLabel("Education :");
        educationQ.setFont(new Font("Raleway",Font.BOLD,20));
        educationQ.setBounds(170,270,240,23);




         citizenship=new JLabel("Citizenship No :");
       citizenship.setFont(new Font("Raleway",Font.BOLD,20));
        citizenship.setBounds(170,320,200,23);

         senior_citizen=new JLabel("Senior Citizen :");
        senior_citizen.setFont(new Font("Raleway",Font.BOLD,20));
        senior_citizen.setBounds(170,370,200,23);

         existing_acc=new JLabel("Existing account :");
        existing_acc.setFont(new Font("Raleway",Font.BOLD,20));
        existing_acc.setBounds(170,420,200,23);

        next1=new JButton("Next");
        next1.setBackground(Color.black);
        next1.setForeground(Color.white);
        next1.setBounds(600,540,130,30);
        next1.setFont(new Font("Arial",Font.BOLD,16));
            next1.addActionListener(this);

         religion_list=new JComboBox(rlist);
        religion_list.setBounds(350,120,200,26);


         category_list=new JComboBox(clist);
        category_list.setBounds(350,170,200,26);

        income_list=new JComboBox(ilist);
        income_list.setBounds(350,220,200,26);

        edu_list=new JComboBox(elist);
        edu_list.setBounds(350,270,200,26);

         citizenship_TField=new JTextField();
        citizenship_TField.setFont(new Font("Arial",Font.BOLD,15));
        citizenship_TField.setBounds(350,320,200,26);

        ButtonGroup grp = new ButtonGroup();


         yes_RadioButton=new JRadioButton("Yes");
        yes_RadioButton.setBounds(350,370,60,26);

         no_RadioButton=new JRadioButton("No");
        no_RadioButton.setBounds(490,370,60,26);
        grp.add(yes_RadioButton);
        grp.add(no_RadioButton);


         yes_RadioButton1=new JRadioButton("Yes");
        yes_RadioButton1.setBounds(350,420,60,26);
         no_RadioButton1=new JRadioButton("No");
        no_RadioButton1.setBounds(490,420,60,26);
        ButtonGroup grp2 = new ButtonGroup();
        grp2.add(yes_RadioButton1);
        grp2.add(no_RadioButton1);





        setLayout(null);
        add(religion_list);
        add(yes_RadioButton1);
        add(no_RadioButton1);
        add(yes_RadioButton);
        add(no_RadioButton);
        add(citizenship_TField);
        add(income_list);
        add(category_list);
        add(income_list);
        add(edu_list);
        add(text1);
        add(religion);
        add(category);
        add(income);
        add(educationQ);
        add(next1);
        add(citizenship);
        add(senior_citizen);
        add(existing_acc);

        getContentPane().setBackground(Color.white);
        setSize(800,700);
        setVisible(true);
        setLocation(350,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    public void actionPerformed(ActionEvent ae)
    {

        String sreligion=(String) religion_list.getSelectedItem();
        String scategory=(String) category_list.getSelectedItem();
        String sincome=(String) income_list.getSelectedItem();
        String seducation=(String) edu_list.getSelectedItem();
        String scitizenship=(String)citizenship_TField.getText();
        String sSenior=null;
        String existing=null;

            if(yes_RadioButton.isSelected())
            {
                sSenior="Yes";
            }
            else if(no_RadioButton.isSelected())
            {
                sSenior="No";
            }

            if(yes_RadioButton1.isSelected())
            {
                existing="Yes";
            }
            else if(no_RadioButton1.isSelected())
            {
                existing="No";
            }
        try
        {


            Conn c=new Conn();
            String query1 = "INSERT INTO signuptwo (formno, religion, category, income, education, citizenship, senior, existing) " + "VALUES ('" + formno + "', '"
                    + sreligion + "', '" + scategory + "', '" + sincome + "', '" + seducation + "', '" + scitizenship + "', '" + sSenior + "', '" + existing + "')";
            c.s.executeUpdate(query1);

        }catch(Exception e) {
            System.out.println(e);
        }
        if(ae.getSource()==next1)
        {
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        }
    }
    public static void main(String[] args)
    {
        new SignupTwo("");
    }
}
