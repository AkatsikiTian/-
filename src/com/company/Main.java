package com.company;

import java.net.URL;

public class Main {

    public static void main(String[] args) {
	// write your code here
        URL bodyURL = Image.class.getResource("/images");
        System.out.println(bodyURL);
    }
}
