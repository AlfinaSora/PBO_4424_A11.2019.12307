package kalkulator;

public class kalkulator {
    int angka1;
    int angka2;

    public kalkulator(int angka1, int angka2) {
        this.angka1 = angka1;
        this.angka2 = angka2;
    }
    public int plus() {
        return this.angka1 + this.angka2;
    }
    public int divide() {
        return this.angka1 / this.angka2;
    }
    public int minus() {
        return this.angka1 - this.angka2;
    }
    public int multiply() {
        return this.angka1 * this.angka2;
    }
    public int modulus() {
        return this.angka1 % this.angka2;
    }
}