package kalkulator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	int angka_1, angka_2;
    	Scanner input = new Scanner(System.in);
    	System.out.print("Masukkan angka pertama :");
    	angka_1 = input.nextInt();
    	System.out.print("Masukkan angka kedua :");
    	angka_2 = input.nextInt();
    	
    	kalkulator hasil = new kalkulator(angka_1,angka_2);
    	
    	System.out.println(angka_1 + " + " + angka_2 + " = " + hasil.plus());
    	System.out.println(angka_1 + " - " + angka_2 + " = " + hasil.minus());
    	System.out.println(angka_1 + " * " + angka_2 + " = " + hasil.multiply());
    	System.out.println(angka_1 + " / " + angka_2 + " = " + hasil.divide());
    	System.out.println(angka_1 + " % " + angka_2 + " = " + hasil.modulus());
    }
}