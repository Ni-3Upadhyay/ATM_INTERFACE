package AtmInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page2SignUp extends JFrame implements ActionListener {
    JTextField religionTextField,occupationTextField,panTextField, aadharTextField;
    JComboBox categoryBox,incomeBox,educationBox;
    JRadioButton seniorYes, seniorNo,existingYes,existingNo;
    String formNo;


    Page2SignUp(String formNo){
        setLayout(null);

        this.formNo = formNo;                // to assign the value to formNo of this table

        ImageIcon i8 = new ImageIcon(ClassLoader.getSystemResource("SBI.jpg"));
        Image i9 = i8.getImage().getScaledInstance(80,50, Image.SCALE_DEFAULT);

        ImageIcon i10 = new ImageIcon(i9);
        JLabel image = new JLabel(i10);
        image.setBounds(200, 20, 100, 60);
        add(image);

        JLabel title2 = new JLabel("Page 2: Additional Details");
        title2.setFont(new Font("Railway", Font.PLAIN, 30));
        title2.setBounds(300, 20, 500, 60);
        add(title2);

        JLabel religion = new JLabel("Religion");
        religion.setFont(new Font("Railway", Font.PLAIN, 20));
        religion.setBounds(100, 130, 200, 30);
        add(religion);

         religionTextField = new JTextField();
        religionTextField.setBounds(400, 130, 300, 30);
        add(religionTextField);

        JLabel category = new JLabel("Category");
        category.setFont(new Font("Railway", Font.PLAIN, 20));
        category.setBounds(100, 180, 200, 30);
        add(category);

//  Drop Down box is created using JComboBox and another mathod is using choice class
        String [] categoryNames = {"General", "OBC", "SC", "ST"};
         categoryBox = new JComboBox(categoryNames);
        categoryBox.setBackground(Color.WHITE);
        categoryBox.setForeground(Color.BLUE);
        categoryBox.setBounds(400, 180, 300, 30);
        add(categoryBox);

        JLabel income = new JLabel("Income");
        income.setFont(new Font("Railway", Font.PLAIN, 20));
        income.setBounds(100, 230, 200, 30);
        add(income);

        String [] incomeString = {"null", "<5lakh", "5 to 10Lakh", "10 to 50Lakh", ">50Lakh"};
         incomeBox = new JComboBox(incomeString);
        incomeBox.setForeground(Color.BLUE);
        incomeBox.setBackground(Color.WHITE);
        incomeBox.setBounds(400, 230, 300, 30);
        add(incomeBox);

        JLabel education = new JLabel("Educational \nQualification:");
        education.setFont(new Font("Railway", Font.PLAIN, 20) );
        education.setBounds(100, 280, 300, 30);
        add(education);

        String [] qualification = {"High School", "Intermediate", "Graduation", "PostGraduate"};
         educationBox = new JComboBox(qualification);
        educationBox.setForeground(Color.BLUE);
        educationBox.setBackground(Color.WHITE);
        educationBox.setBounds(400, 280, 300, 30);
        add(educationBox);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Railway", Font.PLAIN, 20) );
        occupation.setBounds(100, 330, 300, 30);
        add(occupation);

        occupationTextField = new JTextField();
//        occupationTextField.setFont(new Font("Railway", Font.PLAIN, 20));
        occupationTextField.setBounds(400, 330, 300, 30);
        add(occupationTextField);

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Railway", Font.PLAIN, 20) );
        pan.setBounds(100, 380, 300, 30);
        add(pan);

         panTextField = new JTextField();
        panTextField.setBounds(400, 380, 300, 30);
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Railway", Font.PLAIN, 20) );
        aadhar.setBounds(100, 430, 300, 30);
        add(aadhar);

         aadharTextField = new JTextField();
        aadharTextField.setBounds(400, 430, 300, 30);
        add(aadharTextField);

        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Railway", Font.PLAIN, 20) );
        seniorCitizen.setBounds(100, 480, 300, 30);
        add(seniorCitizen);

         seniorYes = new JRadioButton("Yes");
        seniorYes.setBackground(Color.WHITE);
        seniorYes.setBounds(400, 480, 100, 30);
        add(seniorYes);

         seniorNo = new JRadioButton("No");
        seniorNo.setBackground(Color.WHITE);
        seniorNo.setBounds(500, 480, 100, 30);
        add(seniorNo);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(seniorYes);
        seniorGroup.add(seniorNo);


        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Railway", Font.PLAIN, 20) );
        existingAccount.setBounds(100, 530, 300, 30);
        add(existingAccount);

         existingYes = new JRadioButton("Yes");
        existingYes.setBackground(Color.WHITE);
        existingYes.setBounds(400, 530, 100, 30);
        add(existingYes);

         existingNo = new JRadioButton("No");
        existingNo.setBackground(Color.WHITE);
        existingNo.setBounds(500, 530, 100, 30);
        add(existingNo);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(existingYes);
        accountGroup.add(existingNo);


        JButton nextButton = new JButton("NEXT");
        nextButton.setForeground(Color.WHITE);
        nextButton.setBackground(Color.BLUE);
        nextButton.addActionListener(this);
        nextButton.setFont(new Font("Railway", Font.PLAIN, 10));
        nextButton.setBounds(600, 630, 80, 20);
        add(nextButton);

        setSize(800,750);
        setLocation(300,30);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent e){                     // first assign all the attributes of table a value according to their type
        String religion = religionTextField.getText();              // for text field   -->  .getText is used
        String occupation =occupationTextField.getText();
        String aadhar = aadharTextField.getText();
        String pan = panTextField.getText();

        String existingAccount = null;                              // for radiobutton   --> if , else if is used
        if(existingNo.isSelected()){
            existingAccount = "no";
        }
        else if(existingYes.isSelected()){
            existingAccount = "yes";
        }

        String seniorCitizen = null;
        if(seniorYes.isSelected()){
            seniorCitizen = "yes";
        }
        else if(seniorNo.isSelected()){
            seniorCitizen = "no";
        }

        String category = (String) categoryBox.getSelectedItem();               // .getSelectedItem() function is used for combo box
        String income = (String) incomeBox.getSelectedItem();                   // but this function returns the object type we need to type cast it in String form
        String education = (String) educationBox.getSelectedItem();

        try{
                Connection connection = new Connection();
                String query = "insert into signup2 values('" + formNo + "', '"+ religion +"', '"+ occupation +"' ,'"+ aadhar +"', '"+ pan +"', '"+existingAccount +"' , '"+seniorCitizen +  "', '" + category + "' , '" + income +"', '" +education +"')";
                connection.s.executeUpdate(query);          // query to insert
        }
        catch (Exception e1){
            System.out.println("Error in page 2");
        }


    }

    public static void main(String[] args) {
        Page2SignUp page2SignUp = new Page2SignUp("");
    }

}
