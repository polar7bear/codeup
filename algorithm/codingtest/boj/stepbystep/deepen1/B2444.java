package algorithm.codingtest.boj.stepbystep.deepen1;

import java.io.*;

public class B2444 {
    public static void main(String[] args) throws IOException {
        //별 찍기 - 7
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < n - i; j++) {
                bw.write(" ");
            }
            for(int j = 0; j < i * 2 - 1; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }

        for(int i = n - 1; i >= 0; i--) {
            for(int j = 0; j < n - i; j++) {
                bw.write(" ");
            }
            for(int j = 0; j < i * 2 - 1; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
