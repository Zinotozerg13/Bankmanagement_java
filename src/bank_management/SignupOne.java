package bank_management;
import java.awt.*;
import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import javax.swing.JTextField;

public class SignupOne extends JFrame implements ActionListener{
    long random;
    JLabel formNo,personDetails,name,fatherName,dob,gender,email,martial,district,mobno,pinCode;
    JTextField nameTextField,FnameTextField,emailTextField,mobTextField,pinTextField;
    JDateChooser dateChooser;
    JRadioButton male_RadioButton,female_RadioButton,unmarried_RadioButton,married_RadioButton;
    JComboBox districtTextField;
    JButton next;
    SignupOne()
    {
        String[] districts_name = {"Achham", "Arghakhanchi", "Baglung", "Baitadi", "Bajhang", "Bajura", "Banke", "Bara", "Bardiya", "Bhaktapur", "Bhojpur", "Chitwan", "Dadeldhura", "Dailekh", "Dang", "Darchula", "Dhading", "Dhankuta", "Dhanusha", "Dolakha", "Dolpa", "Doti", "Gorkha", "Gulmi", "Humla", "Ilam", "Jajarkot", "Jhapa", "Jumla", "Kailali", "Kalikot", "Kanchanpur",
                "Kapilvastu", "Kaski", "Kathmandu", "Kavrepalanchok", "Khotang", "Lalitpur", "Lamjung", "Mahottari", "Makwanpur", "Manang", "Morang", "Mugu", "Mustang", "Myagdi", "Nawalparasi East", "Nawalparasi West", "Nuwakot", "Okhaldhunga", "Palpa", "Panchthar", "Parbat", "Parsa", "Pyuthan", "Ramechhap", "Rasuwa", "Rautahat", "Rolpa", "Rukum East", "Rukum West", "Rupandehi", "Salyan", "Sankhuwasabha", "Saptari", "Sarlahi", "Sindhuli", "Sindhupalchok", "Siraha", "Solukhumbu", "Sunsari", "Surkhet", "Syangja", "Tanahun", "Taplejung", "Terhathum", "Udayapur"};

        Random ran = new Random();
        random = Math.abs(ran.nextLong() % 10000);

         formNo=new JLabel("Application Form no :"+random);
        formNo.setFont(new Font("Osward",Font.BOLD,36));
        formNo.setBounds(170,20,600,40);

       personDetails=new JLabel("Page 1: Personal Details ");
        personDetails.setFont(new Font("Osward",Font.BOLD,26));
        personDetails.setBounds(220,70,400,40);

         name=new JLabel("Name :");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(170,150,200,23);

         nameTextField=new JTextField();
        nameTextField.setFont(new Font("Arial",Font.BOLD,15));
        nameTextField.setBounds(350,150,230,20);

         fatherName=new JLabel("Father's Name :");
        fatherName.setFont(new Font("Raleway",Font.BOLD,20));
        fatherName.setBounds(170,200,200,23);

         FnameTextField=new JTextField();
        FnameTextField.setFont(new Font("Arial",Font.BOLD,15));
        FnameTextField.setBounds(350,200,230,20);

         dob=new JLabel("Date of birth :");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(170,250,200,23);

          dateChooser=new JDateChooser();
        dateChooser.setBounds(350,250,230,23);

         gender=new JLabel("Gender :");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(170,300,200,23);

        ButtonGroup grp = new ButtonGroup();

         male_RadioButton=new JRadioButton("Male");
        male_RadioButton.setBounds(350,300,60,26);

         female_RadioButton=new JRadioButton("Female");
        female_RadioButton.setBounds(450,300,80,26);
        grp.add(male_RadioButton);
        grp.add(female_RadioButton);


        email=new JLabel("Email Adress :");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(170,350,200,23);

        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Arial",Font.BOLD,15));
        emailTextField.setBounds(350,350,230,20);

         martial=new JLabel("Martial Status :");
        martial.setFont(new Font("Raleway",Font.BOLD,20));
        martial.setBounds(170,400,200,23);

        ButtonGroup grp2=new ButtonGroup();
         married_RadioButton=new JRadioButton("Married");
        married_RadioButton.setBounds(350,400,80,26);

      unmarried_RadioButton=new JRadioButton("Single");
        unmarried_RadioButton.setBounds(450,400,100,26);
        grp2.add(married_RadioButton);
        grp2.add(unmarried_RadioButton);

         district=new JLabel("District :");
        district.setFont(new Font("Raleway",Font.BOLD,20));
        district.setBounds(170,450,200,23);

         districtTextField=new JComboBox(districts_name);
        districtTextField.setFont(new Font("Arial",Font.BOLD,15));
        districtTextField.setBounds(350,450,230,20);

        mobno=new JLabel("Mobile no :");
        mobno.setFont(new Font("Raleway",Font.BOLD,20));
        mobno.setBounds(170,500,200,23);

         mobTextField=new JTextField();
        mobTextField.setFont(new Font("Arial",Font.BOLD,15));
        mobTextField.setBounds(350,500,230,20);


         pinCode=new JLabel("Pin Code :");
       pinCode.setFont(new Font("Raleway",Font.BOLD,20));
        pinCode.setBounds(170,550,200,23);

         pinTextField=new JTextField();
        pinTextField.setFont(new Font("Arial",Font.BOLD,15));
        pinTextField.setBounds(350,550,230,20);

         next=new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(600,620,80,30);
        next.setFont(new Font("Arial",Font.BOLD,16));
        next.addActionListener(this);










        setLayout(null);
        add(formNo);
        add(dateChooser);
        add(nameTextField);
        add(personDetails);
        add(name);
        add(next);
        add(fatherName);
        add(dob);
        add(gender);
        add(email);
        add(FnameTextField);
        add(male_RadioButton);
        add(female_RadioButton);
        add(married_RadioButton);
        add(unmarried_RadioButton);
        add(district);
        add(pinCode);
        add(mobno);
        add(martial);
        add(emailTextField);
        add(mobTextField);
        add(pinTextField);
        add(districtTextField);

        getContentPane().setBackground(Color.white);
        setSize(800,700);
        setVisible(true);
        setLocation(350,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    public void actionPerformed(ActionEvent ae)
    {

        String formno=""+random;

        String name=nameTextField.getText();
        String fname=FnameTextField.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male_RadioButton.isSelected())
        {
            gender="Male";

        }
        else if(female_RadioButton.isSelected())
        {
            gender="Female";
        }
        String email=emailTextField.getText();
        String marital=null;
        if(married_RadioButton.isSelected())
        {
            marital="Married";
        }
        else if(unmarried_RadioButton.isSelected())
        {
            marital="Single";
        }
        String district = (String) districtTextField.getSelectedItem();
        String pin=pinTextField.getText();
        String mobile=mobTextField.getText();

        try
        {
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Name is Required");
            }
            else
            {
                Conn c=new Conn();
                String query = "INSERT INTO signup (formno, name, fname, dob, gender, email, marital, district, pin, mobile) " + "VALUES ('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "', '" +
                        gender + "', '" + email + "', " + "'" + marital + "', '" + district + "', '" + pin + "', '" + mobile + "')";
                c.s.executeUpdate(query);

            }
        }catch(Exception e) {
            System.out.println(e);
        }
        if(ae.getSource()==next)
        {
            setVisible(false);
            new SignupTwo(formno).setVisible(true);

        }
    }

    public static void main(String[] args)
    {
        new SignupOne();
    }
}
