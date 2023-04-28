package AtmInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {

    JButton back;
    String pinNumber, cardNumber;
    MiniStatement (String pinNumber, String cardNumber){
        setLayout(null);

        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("black.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,700);
        add(image);

        JLabel title = new JLabel("Mini Statement");
        title.setBounds(260, 100, 200, 35);
        title.setFont(new Font("System", Font.BOLD, 25));
        title.setForeground(Color.white);
        image.add(title);

        JLabel card = new JLabel();
        card.setBounds(100, 200, 400, 30);
        card.setFont(new Font("System", Font.BOLD, 20));
        card.setForeground(Color.white);
        image.add(card);

        JLabel text = new JLabel();
        text.setBounds(100, 250, 600, 200);
        text.setFont(new Font("System", Font.BOLD, 15));
        text.setForeground(Color.white);
        image.add(text);


        JLabel bal = new JLabel();
        bal.setBounds(100, 480, 400, 30);
        bal.setFont(new Font("System", Font.BOLD, 20));
        bal.setForeground(Color.white);
        image.add(bal);



        try{
            Connection connection = new Connection();

            ResultSet rs = connection.s.executeQuery("select * from login where cardNumber = '"+cardNumber+"' ");

//            To set the data in the JLabel we use .setText()
            while (rs.next()) {
                card.setText("Card Number : " + rs.getString("cardNumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardNumber").substring(12));
            }
        }catch (Exception e){
            System.out.println("Exception ");
        }

        long balance = 0;
        try{
            Connection connection = new Connection();

            ResultSet rs = connection.s.executeQuery("select * from bank where cardNumber = '"+cardNumber+"' order by date DESC");

            while (rs.next()){
//                .getText inside is used to append
                text.setText(text.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("DepositOrWithdraw") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+"<br><html>");
            }

        }catch (Exception e){
            System.out.println("Ex");
        }

        try{
            Connection connection = new Connection();

            ResultSet rs = connection.s.executeQuery("select * from bank where cardNumber = '"+cardNumber+"'");

            while (rs.next()){
                if(rs.getString("DepositOrWithdraw").equals("deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            bal.setText("Available Balance in account is " + balance);
        }catch (Exception e){
            System.out.println("Excep");
        }

        back = new JButton("Back");
        back.setBounds(500, 500, 200, 40);
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
        if(ae.getSource().equals(back)){
            setVisible(false);
            new Transaction(pinNumber,cardNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        MiniStatement miniStatement = new MiniStatement("", "");
    }
}
