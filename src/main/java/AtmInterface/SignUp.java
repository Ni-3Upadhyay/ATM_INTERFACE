package AtmInterface;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SignUp extends JFrame{

    SignUp(){
        setLayout(null);

        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("SBI.jpg"));
        Image i6 = i5.getImage().getScaledInstance(100,60,Image.SCALE_DEFAULT);

        ImageIcon i7 = new ImageIcon(i6);

        JLabel jLabel = new JLabel(i7);
        jLabel.setBounds(30, 20, 100, 60);
        add(jLabel);

        Random random = new Random();       // we need a random form no. for our file so we used math library
        long rand = (Math.abs(random.nextLong() % 9000) + 1000L);

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

        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(300, 150, 300, 25);
        add(nameTextField);

        JLabel fName = new JLabel("Father's Name:");
        fName.setFont(new Font("Railway", Font.PLAIN, 20));
        fName.setBounds(100, 190, 200, 25);
        add(fName);

        JTextField fNameTextField = new JTextField();
        fNameTextField.setBounds(300, 190, 300, 25);
        add(fNameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Railway", Font.PLAIN, 20));
        dob.setBounds(100, 230, 300, 25);
        add(dob);

//  to make a text field where we can choose date from calendar
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 230, 300, 25);
        add(dateChooser);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Railway", Font.PLAIN, 20));
        gender.setBounds(100, 270, 200, 25);
        add(gender);

//    for radio buttons
        JRadioButton male = new JRadioButton("Male");
        male.setBackground(Color.WHITE);
        male.setBounds(300, 270, 100, 25);
        add(male);

        JRadioButton female = new JRadioButton("Female");
        female.setBackground(Color.WHITE);
        female.setBounds(420, 270, 100, 25);
        add(female);

        ButtonGroup addButton = new ButtonGroup();
        addButton.add(male);
        addButton.add(female);

        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Railway", Font.PLAIN, 20));
        email.setBounds(100, 310, 200, 25);
        add(email);

        JTextField emailTextField = new JTextField();
        emailTextField.setBounds(300, 310, 300, 25);
        add(emailTextField);

        JLabel marriedStatus = new JLabel("Marital Status");
        marriedStatus.setFont(new Font("Railway", Font.PLAIN, 20));
        marriedStatus.setBounds(100, 350, 200, 25);
        add(marriedStatus);

        JRadioButton married = new JRadioButton("Married");
        married.setBackground(Color.WHITE);
        married.setBounds(300, 350, 100, 25);
        add(married);

        JRadioButton unmarried= new JRadioButton("Unmarried");
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

        JTextField addressTextField = new JTextField();
        addressTextField.setBounds(300, 390, 300, 25);
        add(addressTextField);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Railway", Font.PLAIN, 20));
        city.setBounds(100, 430, 200, 25);
        add(city);

        JTextField cityTextField = new JTextField();
        cityTextField.setBounds(300, 430, 300, 25);
        add(cityTextField);

        JLabel pinCode = new JLabel("Pin Code: ");
        pinCode.setFont(new Font("Railway", Font.PLAIN, 20));
        pinCode.setBounds(100, 470, 200, 25);
        add(pinCode);

        JTextField pinCodeTextField = new JTextField();
        pinCodeTextField.setBounds(300, 470, 300, 25);
        add(pinCodeTextField);

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Railway", Font.PLAIN, 20));
        state.setBounds(100, 510, 200, 25);
        add(state);

        JTextField stateTextField = new JTextField();
        stateTextField.setBounds(300, 510, 300, 25);
        add(stateTextField);

        JButton next = new JButton("NEXT");
        next.setBackground(Color.BLUE);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway", Font.ITALIC, 10));
        next.setBounds(520, 580, 80, 20);
        add(next);







//  Color of the form
        getContentPane().setBackground(Color.WHITE);

//  To Create a form
        setSize(800,780);
        setLocation(350, 20);
        setVisible(true);
    }

    public static void main(String[] args) {
        SignUp signUp = new SignUp();
    }
}
