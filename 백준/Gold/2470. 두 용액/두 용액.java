import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(arr);

        int p1 = 0;
        int p2 = arr.length - 1;
        int p1Answer = -1;
        int p2Answer = -1;
        int min = Integer.MAX_VALUE;

        while (p1 < p2) {
            int mix = arr[p1] + arr[p2];
            if (Math.abs(mix) < min) {
                min = Math.abs(mix);
                p1Answer = p1;
                p2Answer = p2;
            }

            if (mix < 0) {
                p1++;
            } else {
                p2--;
            }
        }

        System.out.print(arr[p1Answer] + " " + arr[p2Answer]);

    }
}