package com.nt.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
public static void main(String[] args) {
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	String str1 = encoder.encode("rani");
	String str2 = encoder.encode("hyd");
	System.out.println(str1);
	System.out.println(str2);
}
}
