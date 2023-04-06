package AtmInterface;

import javax.swing.*;    // JFrame class is available in swing

public class Login extends JFrame{  // JFrame is a class used to create a frame.

    Login(){
        setSize(800, 400);    // creates a frame but is not visible
        setVisible(true);                 // now the frame becomes visible
        setLocation(350,200);       // usually every frame starts from top-left corner so a location is to be set accordingly

        

    }

    public static void main(String[] args) {
        Login login = new Login();
    }

}
