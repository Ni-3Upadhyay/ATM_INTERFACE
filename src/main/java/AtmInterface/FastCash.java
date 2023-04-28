package AtmInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton rs100, rs500, rs1000, rs5000, rs10000, back;
    String cardNumber, pinNumber;
    FastCash(String pinNumber, String cardNumber){

        setLayout(null);

        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("black.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 800, 700);
        add(image);

        JLabel title = new JLabel("Select the amount you want to withdraw ");
        title.setFont(new Font("System", Font.BOLD, 30));
        title.setBounds(100, 100, 700, 30);
        title.setForeground(Color.WHITE);
        image.add(title);

        rs100 = new JButton("Rs 100");
        rs100.setFont(new Font("System", Font.BOLD, 20));
        rs100.setBounds(80,250,250,40);
        rs100.setForeground(Color.BLACK);
        rs100.addActionListener(this);
        image.add(rs100);

        rs500 = new JButton("Rs 500");
        rs500.setFont(new Font("System", Font.BOLD, 20));
        rs500.setBounds(460,250,250,40);
        rs500.setForeground(Color.BLACK);
        rs500.addActionListener(this);
        image.add(rs500);

        rs1000 = new JButton("Rs 1000");
        rs1000.setFont(new Font("System", Font.BOLD, 20));
        rs1000.setBounds(80,350,250,40);
        rs1000.setForeground(Color.BLACK);
        rs1000.addActionListener(this);
        image.add(rs1000);

        rs5000 = new JButton("Rs 5000");
        rs5000.setFont(new Font("System", Font.BOLD, 20));
        rs5000.setBounds(460,350,250,40);
        rs5000.setForeground(Color.BLACK);
        rs5000.addActionListener(this);
        image.add(rs5000);

        rs10000 = new JButton("Rs 10000");
        rs10000.setFont(new Font("System", Font.BOLD, 20));
        rs10000.setBounds(80,450,250,40);
        rs10000.setForeground(Color.BLACK);
        rs10000.addActionListener(this);
        image.add(rs10000);

        back = new JButton("Back");
        back.setFont(new Font("System", Font.BOLD, 20));
        back.setBounds(460,450,250,40);
        back.setForeground(Color.BLACK);
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
            new Transaction(pinNumber, cardNumber).setVisible(true);
        }
        else{
                                                                                         //  to get the amount written on the buttons we use this method
            String amount = ((JButton)ae.getSource()).getText().substring(3);  // ae.getSource returns object so typecast to button
                                                                                        // to remove rs we took the substring

            try{
                Connection connection = new Connection();
                ResultSet rs = connection.s.executeQuery("Select * from bank where cardNumber = '"+cardNumber+"'");
                int balance = 0;

                while (rs.next()){
                    if(rs.getString("DepositOrWithdraw").equals("deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                    return;
                }
                Date date = new Date();

                String query = "insert into bank values( '"+cardNumber+"', '"+pinNumber+"', '"+date+"', 'withdraw', '"+amount+"')";

                connection.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "please collect your money");

                setVisible(false);
                new Transaction(pinNumber, cardNumber).setVisible(true);

            }catch(Exception e){
                System.out.println("exc");
            }
        }
    }

    public static void main(String[] args) {
        FastCash fastCash = new FastCash("","");
    }
}
