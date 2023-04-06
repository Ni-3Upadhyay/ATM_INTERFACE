package AtmInterface;

import javax.swing.*;    // JFrame class is available in swing
import java.awt.*;       // Image class is available in awt


public class Login extends JFrame{  // JFrame is a class used to create a frame.

    Login(){
        setTitle("ATM Interface LogIn Page");   // a title at the top
        setLayout(null);                        // to create our own custom layout

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("SBI.jpg"));        // to load the image
        Image i2 = i1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);

        // to set the size of an ImageIcon we need Image but image directly can not be given to JLabel so it needed to be converted to ImageIcon

        ImageIcon i3 = new ImageIcon(i2);

        JLabel label = new JLabel(i3);                // image can not be given to JLabel

        label.setBounds(70,10,80,80);  // swing has its default layout so to custom layout we need to make default layout null
                                                            // and then setBounds accordingly
        add(label);

        setSize(800, 400);    // creates a frame but is not visible
        setVisible(true);                 // now the frame becomes visible
        setLocation(350,200);       // usually every frame starts from top-left corner so a location is to be set accordingly



    }

    public static void main(String[] args) {
        Login login = new Login();
    }

}
