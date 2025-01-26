package bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class miniStatement extends JFrame {
    String pinNumber;

    miniStatement(String pinNumber) {
        this.pinNumber = pinNumber;

        setTitle("Mini Statement");
        setLayout(null);

        JLabel miniStatementLabel = new JLabel("Mini Statement");
        miniStatementLabel.setFont(new Font("System", Font.BOLD, 18));
        miniStatementLabel.setBounds(150, 20, 200, 20);
        add(miniStatementLabel);

        JLabel bankLabel = new JLabel("GARIBI BANK");
        bankLabel.setFont(new Font("System", Font.BOLD, 16));
        bankLabel.setBounds(150, 80, 150, 20);
        add(bankLabel);

        JLabel cardLabel = new JLabel();
        cardLabel.setBounds(20, 140, 400, 20);
        add(cardLabel);

        JLabel balanceLabel = new JLabel();
        balanceLabel.setBounds(20, 400, 400, 20);
        add(balanceLabel);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM login WHERE pinNumber = '" + pinNumber + "'");
            while (rs.next()) {
                cardLabel.setText("Card Number: " + rs.getString("cardNumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardNumber").substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinNumber + "' ORDER BY date DESC LIMIT 5");
            int y = 160;
            while (rs.next()) {
                JLabel transaction = new JLabel(rs.getString("date") + " " + rs.getString("type") + " " + rs.getString("amount"));
                transaction.setBounds(20, y, 400, 20);
                add(transaction);
                y += 20;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int balance = 0;
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinNumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balanceLabel.setText("Current Balance: Rs " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(400, 600);
        setLocation(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new miniStatement("");
    }
}
