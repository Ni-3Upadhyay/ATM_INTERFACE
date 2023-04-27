package AtmInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit, balanceEnquiry, cashWithdrawl, fastCash, pinChange, miniStatement, exit;
    String pinNumber;
    Transaction (String pinNumber){

        setLayout(null);

        this.pinNumber = pinNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("spotlight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 800, 700);
        add(image);

        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(180, 60, 600, 35);
        text.setFont(new Font("System", Font.BOLD ,30 ));
        text.setForeground(Color.WHITE);
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(80, 250, 250, 40);
        deposit.setFont(new Font("System", Font.BOLD, 20));
        deposit.setForeground(Color.BLACK);
        deposit.addActionListener(this);
        image.add(deposit);

        cashWithdrawl = new JButton("Cash Withdrawl");
        cashWithdrawl.setBounds(460, 250, 250, 40);
        cashWithdrawl.setFont(new Font("System", Font.BOLD, 20));
        cashWithdrawl.setForeground(Color.BLACK);
        cashWithdrawl.addActionListener(this);
        image.add(cashWithdrawl);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(80, 340, 250, 40);
        fastCash.setFont(new Font("System", Font.BOLD, 15));
        fastCash.setForeground(Color.BLACK);
        fastCash.addActionListener(this);
        image.add(fastCash);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(460, 340, 250, 40);
        pinChange.setFont(new Font("System", Font.PLAIN, 15));
        pinChange.setForeground(Color.BLACK);
        pinChange.addActionListener(this);
        image.add(pinChange);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(80, 430, 250, 40);
        miniStatement.setFont(new Font("System", Font.PLAIN, 15));
        miniStatement.setForeground(Color.BLACK);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(460, 430, 250, 40);
        balanceEnquiry.setFont(new Font("System", Font.PLAIN, 15));
        balanceEnquiry.setForeground(Color.BLACK);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.setBounds(460, 530, 250, 40);
        exit.setFont(new Font("System", Font.BOLD, 15));
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        image.add(exit);





        setLocation(400,30);
        setSize(800,700);
        setUndecorated(true);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }
    }

    public static void main(String [] args){
        Transaction transaction = new Transaction("");
    }
}
