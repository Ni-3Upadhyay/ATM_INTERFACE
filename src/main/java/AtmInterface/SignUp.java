package AtmInterface;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUp extends JFrame implements ActionListener {

//    we need the local variables as global to make a connection b/w the java and sql
    long rand;
    JTextField nameTextField, fNameTextField, emailTextField, cityTextField, pinCodeTextField, addressTextField, stateTextField;
    JButton next;
    JRadioButton male, female, married, unmarried;
    JDateChooser dateChooser;

    SignUp(){
        setLayout(null);

        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("SBI.jpg"));
        Image i6 = i5.getImage().getScaledInstance(100,60,Image.SCALE_DEFAULT);

        ImageIcon i7 = new ImageIcon(i6);

        JLabel jLabel = new JLabel(i7);
        jLabel.setBounds(30, 20, 100, 60);
        add(jLabel);

        Random random = new Random();       // we need a random form no. for our file so we used math library
         rand = (Math.abs(random.nextLong() % 9000L) + 1000L);

        JLabel formTitle = new JLabel("Application Form No. " + rand );          // used to write a text
        formTitle.setFont(new Font("Railway", Font.BOLD, 40));
        formTitle.setBounds(160, 20, 600, 60);
        add(formTitle);          // this form will be in default layout so change setLayout to null

        JLabel formSubTitle = new JLabel("page 1 : Personal Details");          // used to write a text
        formSubTitle.setFont(new Font("Railway", Font.BOLD, 30));
        formSubTitle.setBounds(230, 70, 400, 40);
        add(formSubTitle);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Railway", Font.PLAIN, 20));
        name.setBounds(100, 150, 200, 25);
        add(name);

         nameTextField = new JTextField();
        nameTextField.setBounds(300, 150, 300, 25);
        add(nameTextField);

        JLabel fName = new JLabel("Father's Name:");
        fName.setFont(new Font("Railway", Font.PLAIN, 20));
        fName.setBounds(100, 190, 200, 25);
        add(fName);

         fNameTextField = new JTextField();
        fNameTextField.setBounds(300, 190, 300, 25);
        add(fNameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Railway", Font.PLAIN, 20));
        dob.setBounds(100, 230, 300, 25);
        add(dob);

//  to make a text field where we can choose date from calendar
         dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 230, 300, 25);
        add(dateChooser);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Railway", Font.PLAIN, 20));
        gender.setBounds(100, 270, 200, 25);
        add(gender);

//    for radio buttons
         male = new JRadioButton("Male");
        male.setBackground(Color.WHITE);
        male.setBounds(300, 270, 100, 25);
        add(male);

         female = new JRadioButton("Female");
        female.setBackground(Color.WHITE);
        female.setBounds(420, 270, 100, 25);
        add(female);

//  on clicking the radio buttons both button can be clicked at a time so we need to use buttonGroup to resolve the problem.
        ButtonGroup addButton = new ButtonGroup();
        addButton.add(male);
        addButton.add(female);

        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Railway", Font.PLAIN, 20));
        email.setBounds(100, 310, 200, 25);
        add(email);

         emailTextField = new JTextField();
        emailTextField.setBounds(300, 310, 300, 25);
        add(emailTextField);

        JLabel marriedStatus = new JLabel("Marital Status");
        marriedStatus.setFont(new Font("Railway", Font.PLAIN, 20));
        marriedStatus.setBounds(100, 350, 200, 25);
        add(marriedStatus);

         married = new JRadioButton("Married");
        married.setBackground(Color.WHITE);
        married.setBounds(300, 350, 100, 25);
        add(married);

         unmarried= new JRadioButton("Unmarried");
        unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(420, 350, 100, 25);
        add(unmarried);

        ButtonGroup addMaritalStatus = new ButtonGroup();
        addMaritalStatus.add(married);
        addMaritalStatus.add(unmarried);

        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Railway", Font.PLAIN, 20));
        address.setBounds(100, 390, 200, 25);
        add(address);

         addressTextField = new JTextField();
        addressTextField.setBounds(300, 390, 300, 25);
        add(addressTextField);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Railway", Font.PLAIN, 20));
        city.setBounds(100, 430, 200, 25);
        add(city);

         cityTextField = new JTextField();
        cityTextField.setBounds(300, 430, 300, 25);
        add(cityTextField);

        JLabel pinCode = new JLabel("Pin Code: ");
        pinCode.setFont(new Font("Railway", Font.PLAIN, 20));
        pinCode.setBounds(100, 470, 200, 25);
        add(pinCode);

         pinCodeTextField = new JTextField();
        pinCodeTextField.setBounds(300, 470, 300, 25);
        add(pinCodeTextField);

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Railway", Font.PLAIN, 20));
        state.setBounds(100, 510, 200, 25);
        add(state);

         stateTextField = new JTextField();
        stateTextField.setBounds(300, 510, 300, 25);
        add(stateTextField);

         next = new JButton("NEXT");             // button is created
        next.setBackground(Color.BLUE);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway", Font.ITALIC, 10));
        next.addActionListener(this);                  //is used in a button on clicking which action is performed
        next.setBounds(520, 580, 80, 20);
        add(next);







//  Color of the form
        getContentPane().setBackground(Color.WHITE);

//  To Create a form
        setSize(800,780);
        setLocation(350, 20);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String formNo = " " + rand;     // as rand is long so typeConversion
        String name = nameTextField.getText();    // getText is a function used to get the text from TextField
        String fname = fNameTextField.getText();  // same like setText which is used to set the text in TextField
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText(); // to get the date

        String gender = null;           // to get the output of radio buttons
        if(male.isSelected()){
            gender ="Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }

        String email = emailTextField.getText();
        String maritalStatus = null;
        if(married.isSelected()){
            maritalStatus = "Married";
        }
        else if(married.isSelected()){
            maritalStatus = "Unmarried";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinCodeTextField.getText();

//  Now as the data is to be stored in database which is an external entity so Exception Handling is used
        try{
            if(name.equals("")){        // to give validation on data
                JOptionPane.showMessageDialog(null, "Name is not Given");
            }
            else if(fname.equals("")){
                JOptionPane.showMessageDialog(null, "Father's Name is not Given");
            }
            else if(address.equals("")){
                JOptionPane.showMessageDialog(null, "address is not entered");
            }
            else if(city.equals("")){
                JOptionPane.showMessageDialog(null, "city is not entered");
            }
            else if(state.equals("")){
                JOptionPane.showMessageDialog(null, "state is not entered");
            }
            else if(pin.equals("")){
                JOptionPane.showMessageDialog(null, "pin is not entered");
            }

            else {                      // connection is created and then query is given
                Connection connection1 = new Connection(); // a table having name signup is to be created
                String query = "insert into signup values ('"+formNo+"', '"+name+"', '"+ fname +"', '"+dob+"', '"+gender+"', '"+email+"', '"+maritalStatus + "' , '"+address+"', '"+city+ "', '"+state+"','"+pin+"')";
                connection1.s.executeUpdate(query);         // update query is used so that every time data is inserted in next line

                setVisible(false);                              // on clicking next this page will disappear
                new Page2SignUp(formNo).setVisible(true);       // this page is visible on clicking next we need same form no in the next page so passing the form no.
            }
        }
        catch (Exception ea){
            System.out.println("Exception created");
        }
    }

    public static void main(String[] args) {
        SignUp signUp = new SignUp();
    }
}
