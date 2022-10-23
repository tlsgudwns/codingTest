import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(br.readLine());
        }
        Arrays.sort(arr);
        //Arrays.sort(arr, (x, y) -> y - x);
        int[] arrReverse = new int[n];
        for (int i = 0; i < n; i++) {
            arrReverse[i] = arr[n - 1 - i];
        }

        int max = -1;

        for (int i = 0; i < n; i++) {
            max = arrReverse[i] * (i + 1) > max ? arrReverse[i] * (i + 1) : max;
        }

        System.out.println(max);
    }
}