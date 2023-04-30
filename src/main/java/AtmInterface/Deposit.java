package AtmInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class Deposit extends JFrame implements ActionListener {

    JTextField amount;
    JButton back, deposit;
    String cardNumber, pinNumber=null;
    Deposit( String pinNumber, String cardNumber){

        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("black.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 800,700);
        add(image);

        JLabel title = new JLabel("Enter the amount you want to deposit : ");
        title.setFont(new Font("System", Font.BOLD, 30));
        title.setBounds(70, 80, 600, 30);
        title.setForeground(Color.WHITE);
        image.add(title);

        amount = new JTextField();
        amount.setBounds(500, 200, 200, 40);
        amount.setFont(new Font("System", Font.BOLD, 20));
        amount.setForeground(Color.BLACK);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(500, 400, 200, 40);
        deposit.setFont(new Font("System", Font.BOLD, 20));
        deposit.setForeground(Color.black);
        deposit.addActionListener(this);
        image.add(deposit);

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

        if(ae.getSource()==back){
            if(pinNumber.equals("")){
                System.exit(0);
            }
            setVisible(false);
            new Transaction(pinNumber, cardNumber).setVisible(true);
        }
        else if (ae.getSource() == deposit){
                String deposited = amount.getText();
                Date date = new Date();

                if(deposited.equals("")){
                    JOptionPane.showMessageDialog(null, "the amount must be multiple of 100");
                }
                else{

                    try {
                        Connection connection = new Connection();

                        String query = "insert into bank values('" + cardNumber + "', '" + pinNumber + "', '" + date + "', 'deposit', '" + deposited + "')";
                        connection.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "The amount " + deposited+ " Deposited Successfully");
                        setVisible(false);
                        if(pinNumber.equals("")){
                            System.exit(0);
                        }else {
                            new Transaction(pinNumber, cardNumber).setVisible(true);
                        }
                    }catch (Exception e){
                        System.out.println("Exception");
                    }

                }
        }
    }

    public static void main(String[] args) {
        Deposit deposit = new Deposit("", "");
    }
}
