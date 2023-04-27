package AtmInterface;

import javax.swing.*;    // JFrame class is available in swing
import java.awt.*;       // Image class is available in awt
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {  // JFrame is a class used to create a frame.
                                                // ActionListener is an interface which is used to make our buttons perform action

    JButton signIn, clear, signUp;          // these buttons were locally defined so to access them we defined them globally
    JTextField cardTextField, pinTextField;

    String formNo;
//    login page
    Login(String formNo){

        this.formNo = formNo;

        setTitle("ATM Interface LogIn Page");   // a title at the top
        setLayout(null);                        // to create our own custom layout

//  to give image icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("SBI.jpg"));        // to load the image
        Image i2 = i1.getImage().getScaledInstance(100,60,Image.SCALE_DEFAULT);

        // to set the size of an ImageIcon we need Image but image directly can not be given to JLabel so it needed to be converted to ImageIcon

        ImageIcon i3 = new ImageIcon(i2);

        JLabel label = new JLabel(i3);                // image can not be given to JLabel

        label.setBounds(200,20,100,60);  // swing has its default layout so to custom layout we need to make default layout null
                                                            // and then setBounds accordingly
        add(label);


//  heading in front of logo
        JLabel title = new JLabel("Bank Sign In");                  // to load a text
        title.setBounds(300, 30, 300, 50);             // to set the location and boundaries of text
        title.setForeground(Color.BLACK);                                 // to give color to a text
//        title.setBackground(Color.BLUE);
        title.setFont(new Font("Railway", Font.BOLD, 40));    // to give font style type size
        add(title);                                                     // to print a text

//  content
        JLabel cardno = new JLabel("Card No.");
        cardno.setFont(new Font("Railway", Font.BOLD, 20));
        cardno.setBounds(150, 130, 100, 30);
        add(cardno);

         cardTextField = new JTextField();                    // for text field
        cardTextField.setBounds(280, 130, 200, 30);
        add(cardTextField);

        JLabel pinNo = new JLabel("Pin No.");
        pinNo.setFont(new Font("Railway", Font.BOLD, 20));
        pinNo.setBounds(150, 180, 100, 30);
        add(pinNo);

//      pinTextField = new JTextField();        // things written in text field are visible to user
        pinTextField = new JPasswordField();            // password field hides the things written
        pinTextField.setBounds(280, 180, 200, 30);
        add(pinTextField);

//  sign in button
         signIn = new JButton("SIGN IN");                // for button
        signIn.setBounds(280, 250, 80, 20);
        signIn.setForeground(Color.WHITE);
        signIn.setBackground(Color.BLUE);
        signIn.addActionListener(this);   // function checks which action if performed
        add(signIn);

         clear = new JButton("CLEAR");                // for button
        clear.setBounds(380, 250, 80, 20);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        clear.setBackground(Color.BLUE);
        add(clear);

         signUp = new JButton("SIGN UP");                // for button
        signUp.setBounds(290, 290, 160, 20);
        signUp.setForeground(Color.WHITE);
        signUp.setBackground(Color.BLUE);
        signUp.addActionListener(this);
        add(signUp);

        setSize(800, 400);    // creates a frame but is not visible
        setVisible(true);                 // now the frame becomes visible
        setLocation(350,200);       // usually every frame starts from top-left corner so a location is to be set accordingly

        getContentPane().setBackground(Color.WHITE);

    }

    public void actionPerformed(ActionEvent event){         // ActionListener InterFace's undefined function which helps to tell which action is to be performed on click.
        if(event.getSource() == clear){
            cardTextField.setText("");          // is used to set some value manually right now its empty so if something is
            pinTextField.setText("");           // is written in it. It will be cleared
        }
        else if(event.getSource()== signIn){
            Connection connection = new Connection();

            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where cardNumber = '"+cardNumber+"' and pinNumber = '"+pinNumber+"'";

            try{
                ResultSet resultSet = connection.s.executeQuery(query);

                if(resultSet.next()){
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Card number or pin is incorrect");
                }
            }
            catch (Exception e){
                System.out.println("Exception");
            }

        }
        else if(event.getSource() == signUp){
            setVisible(false);
            SignUp sign = new SignUp();
            sign.setVisible(true);
        }
    }

    public static void main(String[] args) {
        Login login = new Login("");
    }

}
