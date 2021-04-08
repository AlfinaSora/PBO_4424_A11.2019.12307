package Praktikum5;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NilaiSiswa {
    public static void main(String[] args){
        Scanner jmlInput = new Scanner(System.in);
        System.out.println("Masukkan jumlah data : ");

        int angka = jmlInput.nextInt();

        ArrayList<Siswa> students = new ArrayList<Siswa>();
        for (int i=1; i<=angka; i++){
            Scanner nim = new Scanner(System.in);
            System.out.println("masukkan nim : ");
            String Nim = nim.nextLine();

            Scanner nama = new Scanner(System.in);
            System.out.println("masukkan nama : ");
            String Nama = nama.nextLine();

            Scanner nilaiteori = new Scanner(System.in);
            System.out.println("masukkan nilai teori : ");
            int NilaiTeori = nilaiteori.nextInt();

            Scanner nilaipraktek = new Scanner(System.in);
            System.out.println("masukkan nilai praktek : ");
            int NilaiPraktek = nilaipraktek.nextInt();

            Siswa items = new Siswa(Nim, Nama, NilaiTeori, NilaiPraktek);
            students.add(items);
        }

        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%10s %15s %10s %10s", "NIM", "NAMA", "NILAI TEORI", "NILAI PRAKTEK");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        for(Siswa student: students){
            System.out.format("%10s %15s %10d %10d",
                    student.getNim(), student.getNama(), student.getNilaiTeori(), student.getNilaiPraktek());
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------");
    }
}