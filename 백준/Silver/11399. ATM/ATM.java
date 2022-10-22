import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] times = new int[n];
        int idx = 0;
        while (st.hasMoreTokens()) {
            times[idx++] = Integer.parseInt(st.nextToken()); 
        }

        Arrays.sort(times);
        int k = times.length;
        int result = 0;
        for (int i = 0; i < times.length; i++) {
            result += times[i] * (k--);
        }

        System.out.println(result);
    }
}