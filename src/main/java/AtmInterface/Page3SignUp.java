package AtmInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Page3SignUp extends JFrame implements ActionListener {

    JRadioButton savingAccount,fixedDepositAccount, recurringDepositAccount, currentAccount;
    JCheckBox atmCard, internetBanking, mobileBanking, emailAlerts, chequeBook, eStatement, declaration;

    JButton submit, cancel;
    String formNo;
    Page3SignUp(String formNo){

        setLayout(null);

        this.formNo = formNo;

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

        JLabel accType = new JLabel("Account Type :");
        accType.setFont(new Font("Railway", Font.BOLD, 20));
        accType.setBounds(80, 125, 300, 25);
        add(accType);

        savingAccount = new JRadioButton("Saving Account");
        savingAccount.setBackground(Color.WHITE);
        savingAccount.setBounds(80, 160, 200, 25);
        add(savingAccount);

        fixedDepositAccount = new JRadioButton("Fixed Deposit Account");
        fixedDepositAccount.setBackground(Color.WHITE);
        fixedDepositAccount.setBounds(300, 160, 200, 25);
        add(fixedDepositAccount);

        currentAccount = new JRadioButton("Current Account");
        currentAccount.setBackground(Color.WHITE);
        currentAccount.setBounds(80, 190, 200, 25);
        add(currentAccount);

        recurringDepositAccount = new JRadioButton("Recurring Deposit Account");
        recurringDepositAccount.setBackground(Color.WHITE);
        recurringDepositAccount.setBounds(300, 190, 200, 25);
        add(recurringDepositAccount);

        ButtonGroup typeAcc = new ButtonGroup();
        typeAcc.add(savingAccount);
        typeAcc.add(fixedDepositAccount);
        typeAcc.add(currentAccount);
        typeAcc.add(recurringDepositAccount);

        JLabel cardNo = new JLabel("Card Number");
        cardNo.setFont(new Font("Railway", Font.BOLD, 20));
        cardNo.setBounds(80, 240, 300, 25);
        add(cardNo);

        JLabel No = new JLabel("XXXX-XXXX-XXXX-4890");
        No.setFont(new Font("Railway", Font.BOLD, 20));
        No.setBounds(300, 250, 300, 25);
        add(No);

        JLabel cardComment = new JLabel("(Your 16 digit card number)");
        cardComment.setBounds(80, 260, 300, 20);
        add(cardComment);

        JLabel pinNo = new JLabel("Pin");
        pinNo.setFont(new Font("Railway", Font.BOLD, 20));
        pinNo.setBounds(80, 300, 300, 25);
        add(pinNo);

        JLabel pNo = new JLabel("XXXX");
        pNo.setFont(new Font("Railway", Font.BOLD, 20));
        pNo.setBounds(300, 310, 300, 25);
        add(pNo);

        JLabel pinComment = new JLabel("(Your 4 digit password)");
        pinComment.setBounds(80, 320, 300, 20);
        add(pinComment);

        JLabel servicesRequired = new JLabel("Services Required : ");
        servicesRequired.setFont(new Font("Railway", Font.BOLD, 20));
        servicesRequired.setBounds(80, 360, 300, 25);
        add(servicesRequired);

        atmCard = new JCheckBox("ATM card");
        atmCard.setFont(new Font("Railway", Font.PLAIN, 15));
        atmCard.setBounds(80, 400, 200, 25);
        atmCard.setBackground(Color.WHITE);
        add(atmCard);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setFont(new Font("Railway", Font.PLAIN, 15));
        internetBanking.setBounds(300, 400, 300, 25);
        internetBanking.setBackground(Color.WHITE);
        add(internetBanking);

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setFont(new Font("Railway", Font.PLAIN, 15));
        mobileBanking.setBounds(80, 435, 200, 25);
        mobileBanking.setBackground(Color.WHITE);
        add(mobileBanking);

        emailAlerts = new JCheckBox("Email Alerts");
        emailAlerts.setBackground(Color.WHITE);
        emailAlerts.setBounds(300, 435, 300, 25);
        emailAlerts.setFont(new Font("Railway", Font.PLAIN, 15));
        add(emailAlerts);

        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setFont(new Font("Railway", Font.PLAIN, 15));
        chequeBook.setBounds(80, 470, 200, 25);
        chequeBook.setBackground(Color.WHITE);
        add(chequeBook);

        eStatement = new JCheckBox("E-Statement");
        eStatement.setBackground(Color.WHITE);
        eStatement.setBounds(300, 470, 300, 25);
        eStatement.setFont(new Font("Railway", Font.PLAIN, 15));
        add(eStatement);

        declaration = new JCheckBox("I hereby declare that the above entered details correct to best of my knowledge.");
        declaration.setBounds(80, 510, 800, 30);
        declaration.setBackground(Color.WHITE);
        add(declaration);

        submit = new JButton("Submit");
        submit.setBackground(Color.blue);
        submit.setForeground(Color.white);
        submit.setBounds(250, 550, 100, 15);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.blue);
        cancel.setForeground(Color.white);
        cancel.setBounds(450, 550, 100, 15);
        cancel.addActionListener(this);
        add(cancel);




        getContentPane().setBackground(Color.WHITE);

        setSize(800, 700);
        setVisible(true);
        setLocation(350, 50);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
            String accountType = null;
            if(currentAccount.isSelected()){
                accountType = "Current Account";
            }
            else if(savingAccount.isSelected()){
                accountType = "Saving Account";
            }
            else if(fixedDepositAccount.isSelected()){
                accountType = "Fixed Deposit Account";
            }
            else if(recurringDepositAccount.isSelected()){
                accountType = "Recurring Deposit Account";
            }

            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() %90000000L) + 1122330000000000L);

            String pinNumber = "" + Math.abs((random.nextLong()%9000L) + 1000L);

            String facility = null;
            if(atmCard.isSelected()){
                facility = facility + " ATM Card";
            }
            if(internetBanking.isSelected()){
                facility = facility + " Internet Banking";
            }
            if(mobileBanking.isSelected()){
                facility = facility + " Mobile Banking";
            }
            if(emailAlerts.isSelected()){
                facility = facility + " Email Alerts";
            }
            if(chequeBook.isSelected()){
                facility = facility + " Cheque Book";
            }
            if(eStatement.isSelected()){
                facility = facility + " E-Statement";
            }

            String declared = null;
            if(declaration.isSelected()){
                declared = "True";
            }
            else {
                declared = "False";
            }

            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account type is required");
                }
                else if(declared.equals("False")){
                    JOptionPane.showMessageDialog(null, "declaration is required");
                }
                else{
                    Connection c = new Connection();
                    String query1 = "insert into signup3 values('"+formNo+ "', '"+accountType+ "','"+cardNumber+ "', '"+pinNumber+ "', '"+facility+ "') ";
                    String query2 = "insert into login values('"+formNo+ "','"+cardNumber+ "', '"+pinNumber+ "') ";

                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number : " + cardNumber + "\nPin Number : " + pinNumber);

                    setVisible(false);
                    new Deposit(pinNumber, cardNumber).setVisible(true);
                }
            }catch (Exception e){
                System.out.println("Exception ");
            }


        } else if (ae.getSource()== cancel) {
            setVisible(false);
            new Login(formNo).setVisible(true);
        }
    }


    public static void main(String[] args) {
        Page3SignUp page3 = new Page3SignUp("");
    }
}
