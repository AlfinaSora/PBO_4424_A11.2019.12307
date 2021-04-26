package UTS;
import java.util.Scanner;
import java.util.Stack;

public class StackKu {
    Stack<Character> stackAngka = new Stack<>();
    Stack<Character> kiri = new Stack<>();
    Stack<Character> kanan = new Stack<>();
    public String Input_Stack() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan input :");
        String inputan = input.next();
        return inputan;
    }
    public String convStrToStack(String inputan){
        String cekInputan = "y";
        int index = inputan.indexOf("=");
        int index2 = inputan.indexOf("1");
        if (index == -1 || index2 == -1){
            System.out.println(inputan + " adalah persamaan yang tidak valid");
            cekInputan = "x";
        }
        String p = "+";
        char plus = p.charAt(0);
        String o = "=1";
        char equal = o.charAt(0);
        char one = o.charAt(1);
        for (int i = 0; i < inputan.length(); i ++){
            if (inputan.charAt(i) != plus){
                this.stackAngka.push(inputan.charAt(i));
                if (inputan.charAt(i) != one && inputan.charAt(i) != equal){
                    System.out.println(inputan + " tidak valid karena karakter yang diijinkan hanya 1,+,dan=");
                    cekInputan = "x";
                }

            }
        }
        return cekInputan;
    }
    public void cekInput(Stack stack,String inputan){
        String o = "=1";
        char equal = o.charAt(0);
        char one = o.charAt(1);
        int counter = 0;
        String cek = "t";
        kiri = stackAngka;
        for (int j = 0; j < stackAngka.size();j++){
            if (kiri.peek() == one){
                kanan.push(kiri.pop());
            }
            if (kiri.peek() == equal){
                kiri.pop();
                counter ++;
                if (counter == 2) {
                    System.out.println(inputan + " tidak valid karena hanya satu tanda sama dengan yang diijinkan.");
                    cek = "s";
                    break;
                }
            }
        }
        if (cek == "t"){
            if (kiri.size() == kanan.size()){
                System.out.println(inputan + " adalah persamaan yang valid");
            }
            if (kiri.size() != kanan.size()){
                System.out.println(inputan + " adalah persamaan yang tidak valid");
            }
        }
    }
}
