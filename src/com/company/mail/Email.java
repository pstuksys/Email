package com.company.mail;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int defaultPasswordLength = 10;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "fieldcompany.com";

    //our constructor
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.println("EMAIL CREATED: " +this.firstName + " " + this.lastName);

        //call method asking for a department - return department
        this.department = setDepartment();
        //System.out.println("Department: " + this.department);

        //call a method that returns random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        //combine elements to generate email
        email = firstName.toLowerCase() + "."+lastName.toLowerCase()+"@"+department +"."+companySuffix;
        //System.out.println("Your email is: " +email);
    }
    //ask for department
        private String setDepartment(){
            System.out.print("New worker: " + firstName +". DEPARTMENT CODES:\n1 for sales\n2 for Development\n3 for accounting\n0 for none\nEnter department code: ");
            Scanner in = new Scanner(System.in);
            int departmentChoice = in.nextInt();
            if(departmentChoice ==1){
                return "sales";
            }else if (departmentChoice==2){
                return "dev";
            }else if (departmentChoice ==3){
                return "accounting";
            }else{
                return "";
            }
        }

        //generate a random password
        private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for(int i=0;i<length;i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
        }

        //set the mailbox capacity /incapsulation for hidding properties oop
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //set alternative email -setter
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    //change the password -setter
    public void changePassword(String password){
        this.password = password;
    }

    //our getter
    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }
    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName +" " + lastName +"\nCOMPANY EMAIL: " + email +
               "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
