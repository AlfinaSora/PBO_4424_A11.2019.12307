package praktikum4.Matrix;

public class MatrixAksi {
    public static void main(String[] args) {
        System.out.println();
        Matrix A = Matrix.random(3,3);
        System.out.println("Matriks Random A");
        A.show();

        System.out.println();
        Matrix B = A.transpose();
        System.out.println("Matriks Random B (transpose dari matriks A)");
        B.show();

        System.out.println();
        Matrix C = Matrix.identity(3);
        System.out.println("Matriks Identitas C (3x3)");
        C.show();

        System.out.println();
        Matrix penjumlahanAB = A.plus(B);
        System.out.println("Penjumlahan Matriks A dan B");
        penjumlahanAB.show();

        System.out.println();
        Matrix perkalianBA = B.times(A);
        System.out.println("Perkalian Matriks B dan A");
        perkalianBA.show();
    }
}