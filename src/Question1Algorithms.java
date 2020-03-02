/*
// Code by: C2C Manuel Riolo
// Explanation: The reason that you would want to use these algorithms over the given
// definition is because these algorithms have a lower runtime complexity.
*/
public class Question1Algorithms {

    public static void main(String[] args) {
        long [][] Times = new long[2][21];
        for (int i = 10; i <= 30; i++) {
            long startTime = System.nanoTime();
            bin(i,i/2);
            long timeAfter1 = System.nanoTime();
            bin2(i,i/2);
            long timeAfter2 = System.nanoTime();
            Times[0][i-10] = timeAfter1-startTime;
            Times[1][i-10] = timeAfter2-timeAfter1;
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 21; j++) {
                System.out.print(Times[i][j] + ", ");
            }
            System.out.print("\n");
        }
    }

    public static int bin(int n, int k) {
        if(k == 0 || n == k){
            return 1;
        }
        else {
            return bin(n - 1, k - 1) + bin(n - 1, k);
        }
    }

    public static int bin2(int n, int k){
        int[][] B = new int[n+1][k+1];

        for(int i = 0; i <= n; i++){
            for (int j = 0; j <= Math.min(i,k); j++) {
                if(j == 0 || j == i){
                    B[i][j] = 1;
                }
                else{
                    B[i][j] = B[i-1][j-1] + B[i-1][j];
                }
            }
        }
        return B[n][k];
    }
}

