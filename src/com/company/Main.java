package com.company;

import com.company.mail.Email;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Email email1 = new Email("Petras","Petraitis");

        System.out.println(email1.showInfo());

    }
}
