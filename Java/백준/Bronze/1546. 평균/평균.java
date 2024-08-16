import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = Arrays.stream(arr).max().getAsInt();
        double sum = 0.0;

        for (int i = 0; i < arr.length; i++) {
            sum += (double) arr[i] / max * 100;
        }
        System.out.println(sum / arr.length);
    }
}