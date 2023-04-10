package AtmInterface;

import javax.swing.*;
import java.awt.*;

public class Page3SignUp extends JFrame {

    Page3SignUp(String formNo){
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("SBI.jpg"));
        Image i2 = i1.getImage().getScaledInstance(80, 50, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel im = new JLabel(i3);
        im.setBounds(50, 20, 100, 60);
        add(im);

        JLabel title = new JLabel("Page 3: Account Details");
        title.setFont(new Font("Railway",Font.BOLD , 40));
        title.setBounds(150,20, 600, 50 );
        add(title);

        JLabel accType = new JLabel("Account Type");
        accType.setFont(new Font("Railway", Font.BOLD, 25));
        accType.setBounds(80, 120, 300, 30);
        add(accType);

        JRadioButton savingAccount = new JRadioButton("Saving Account");
        savingAccount.setBackground(Color.WHITE);
        savingAccount.setBounds(80, 170, 200, 30);
        add(savingAccount);

        JRadioButton fixedDepositAccount = new JRadioButton("Fixed Deposit Account");
        fixedDepositAccount.setBackground(Color.WHITE);
        fixedDepositAccount.setBounds(300, 170, 200, 30);
        add(fixedDepositAccount);

        JRadioButton currentAccount = new JRadioButton("Current Account");
        currentAccount.setBackground(Color.WHITE);
        currentAccount.setBounds(80, 210, 200, 30);
        add(currentAccount);

        JRadioButton recurringDepositAccount = new JRadioButton("Recurring Deposit Account");
        recurringDepositAccount.setBackground(Color.WHITE);
        recurringDepositAccount.setBounds(300, 210, 200, 30);
        add(recurringDepositAccount);

        ButtonGroup typeAcc = new ButtonGroup();
        typeAcc.add(savingAccount);
        typeAcc.add(fixedDepositAccount);
        typeAcc.add(currentAccount);
        typeAcc.add(recurringDepositAccount);

        JLabel cardNo = new JLabel("Card Number");
        cardNo.setFont(new Font("Railway", Font.BOLD, 25));
        cardNo.setBounds(80, 260, 300, 30);
        add(cardNo);

        JLabel cardComment = new JLabel("Your 16 digit card number");
        cardComment.setBounds(80, 295, 300, 20);
        add(cardComment);

        JLabel pinNo = new JLabel("Pin");
        pinNo.setFont(new Font("Railway", Font.BOLD, 25));
        pinNo.setBounds(80, 330, 300, 30);
        add(pinNo);

        JLabel pinComment = new JLabel("Your 4 digit password");
        pinComment.setBounds(80, 365, 300, 20);
        add(pinComment);

        JLabel servicesRequired = new JLabel("Services Required");
        servicesRequired.setFont(new Font("Railway", Font.BOLD, 25));
        servicesRequired.setBounds(80, 400, 300, 30);
        add(servicesRequired);


        getContentPane().setBackground(Color.WHITE);

        setSize(800, 700);
        setVisible(true);
        setLocation(350, 50);
    }

    public static void main(String[] args) {
        Page3SignUp page3 = new Page3SignUp("");
    }
}
