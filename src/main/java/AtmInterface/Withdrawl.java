package AtmInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Withdrawl extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdraw, back;

    String pinNumber, cardNumber;

    Withdrawl(String pinNumber, String cardNumber){

        setLayout(null);

        this.pinNumber = pinNumber;
        this.cardNumber = cardNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("black.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 800,700);
        add(image);

        JLabel title = new JLabel("Enter the amount you want to withdraw : ");
        title.setFont(new Font("System", Font.BOLD, 30));
        title.setBounds(70, 80, 600, 30);
        title.setForeground(Color.WHITE);
        image.add(title);

        amount = new JTextField();
        amount.setBounds(500, 200, 200, 40);
        amount.setFont(new Font("System", Font.BOLD, 20));
        amount.setForeground(Color.BLACK);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(500, 400, 200, 40);
        withdraw.setFont(new Font("System", Font.BOLD, 20));
        withdraw.setForeground(Color.black);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(500, 480, 200, 40);
        back.setFont(new Font("System", Font.BOLD, 20));
        back.setForeground(Color.black);
        back.addActionListener(this);
        image.add(back);



        setLocation(400,30);
        setSize(800,700);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinNumber, cardNumber);
        }
        else if(ae.getSource() == withdraw){

        }
    }

    public static void main(String[] args) {
        Withdrawl withdrawl = new Withdrawl("", "");
    }
}
