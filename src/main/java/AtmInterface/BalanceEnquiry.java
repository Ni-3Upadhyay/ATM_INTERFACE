package AtmInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String pinNumber, cardNumber;

    JButton back;
    BalanceEnquiry(String pinNumber, String cardNumber) {

        this.pinNumber = pinNumber;
        this.cardNumber = cardNumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("black.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,700);
        add(image);


        long balance = 0;

        try{
            Connection c = new Connection();

            ResultSet rs = c.s.executeQuery("select * from bank where cardNumber = '"+cardNumber+"'");
            while (rs.next()){
                if(rs.getString("DepositOrWithdraw").equals("deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println("Exception");
        }

        JLabel text = new JLabel("Total Balance in your account is : " + balance);
        text.setBounds(100, 200, 700, 40);
        text.setFont(new Font("System", Font.BOLD, 30));
        text.setForeground(Color.white);
        image.add(text);

        back = new JButton("Back");
        back.setBounds(500, 500, 200, 40);
        back.setFont(new Font("System", Font.BOLD, 20));
        back.setForeground(Color.black);
        back.addActionListener(this);
        image.add(back);


        setLocation(400, 30);
        setSize(800, 700);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinNumber, cardNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        BalanceEnquiry balanceEnquiry = new BalanceEnquiry("","");
    }
}

