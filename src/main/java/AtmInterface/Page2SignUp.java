package AtmInterface;

import javax.swing.*;
import java.awt.*;

public class Page2SignUp extends JFrame {

    Page2SignUp(){
        setLayout(null);

        ImageIcon i8 = new ImageIcon(ClassLoader.getSystemResource("SBI.jpg"));
        Image i9 = i8.getImage().getScaledInstance(80,50, Image.SCALE_DEFAULT);

        ImageIcon i10 = new ImageIcon(i9);
        JLabel image = new JLabel(i10);
        image.setBounds(200, 20, 100, 60);
        add(image);

        JLabel title2 = new JLabel("Page 2: Additional Details");
        title2.setFont(new Font("Railway", Font.BOLD, 30));
        title2.setBounds(300, 20, 500, 60);
        add(title2);



        setSize(900,800);
        setLocation(150,20);
        setVisible(true);


    }

    public static void main(String[] args) {
        Page2SignUp page2SignUp = new Page2SignUp();
    }

}
