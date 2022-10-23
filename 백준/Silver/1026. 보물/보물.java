import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 0;
        while (st.hasMoreTokens()) {
            a[idx++] = Integer.valueOf(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        idx = 0;
        while (st.hasMoreTokens()) {
            b[idx++] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(a);

        Arrays.sort(b);
        idx = n - 1;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += a[i] * b[idx - i];
        }
        System.out.println(result);
    }
}