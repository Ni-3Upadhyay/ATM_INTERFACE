package AtmInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePin extends JFrame implements ActionListener {

    JPasswordField pinTextBox, repinTextBox;
    JButton change, back;

    String pinNumber, cardNumber;


    ChangePin(String pinNumber, String cardNumber){

        setLayout(null);

        this.pinNumber = pinNumber;
        this.cardNumber = cardNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("black.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 800, 700);
        add(image);

        JLabel title = new JLabel("Change your PIN ");
        title.setFont(new Font("System", Font.BOLD, 35));
        title.setBounds(250, 100, 700, 43);
        title.setForeground(Color.WHITE);
        image.add(title);

        JLabel newPin = new JLabel("Enter 4 digit New PIN : ");
        newPin.setFont(new Font("System", Font.BOLD, 25));
        newPin.setBounds(100, 200, 350, 30);
        newPin.setForeground(Color.WHITE);
        image.add(newPin);

         pinTextBox = new JPasswordField();
        pinTextBox.setBounds(500, 200, 200, 40);
        pinTextBox.setFont(new Font("System", Font.BOLD, 20));
        pinTextBox.setForeground(Color.BLACK);
        image.add(pinTextBox);

        JLabel rePin = new JLabel("Re-Enter New PIN : ");
        rePin.setFont(new Font("System", Font.BOLD, 25));
        rePin.setBounds(100, 270, 350, 30);
        rePin.setForeground(Color.WHITE);
        image.add(rePin);

         repinTextBox = new JPasswordField();
        repinTextBox.setBounds(500, 270, 200, 40);
        repinTextBox.setFont(new Font("System", Font.BOLD, 20));
        repinTextBox.setForeground(Color.BLACK);
        image.add(repinTextBox);

        change = new JButton("Change");
        change.setBounds(500, 440, 200, 40);
        change.setFont(new Font("System", Font.BOLD, 20));
        change.setForeground(Color.black);
        change.addActionListener(this);
        image.add(change);

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

        if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinNumber, cardNumber).setVisible(true);
        }
        else if(ae.getSource() == change){
            try{
                String pin = pinTextBox.getText();
                String repin = repinTextBox.getText();



                if(!pin.equals(repin)){
                    JOptionPane.showMessageDialog(null, "Entered pin does not match.");
                    return;
                }
                if(pin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter a pin");
                    return;
                }
                if(repin.equals("")){
                    JOptionPane.showMessageDialog(null, "Re-enter pin is Empty");
                    return;
                }

                Connection connection = new Connection();

                String query1 = "update bank set pinNumber = '"+repin+"' where cardNumber = '"+cardNumber+"'";
                String query2 = "update login set pinNumber = '"+repin+"' where cardNumber = '"+cardNumber+"'";
                String query3 = "update signup3 set pinNumber = '"+repin+"' where cardNumber = '"+cardNumber+"'";

                connection.s.executeUpdate(query1);
                connection.s.executeUpdate(query2);
                connection.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "Pin Changed Successfully");

                setVisible(false);
                new Transaction(repin, cardNumber).setVisible(true);
            }
            catch (Exception e){
                System.out.println("Exception");
            }
        }

    }

    public static void main(String[] args) {
        ChangePin changePin = new ChangePin("","");
    }
}
