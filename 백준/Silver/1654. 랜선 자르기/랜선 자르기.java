import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int require = Integer.parseInt(st.nextToken());

        long[] lan = new long[num];

        for (int i = 0; i < num; i++) {
            lan[i] = Long.parseLong(br.readLine());
        }

        long min = Long.MAX_VALUE;
        long max = -1;
        for (int i = 0; i < num; i++) {
            max = lan[i] > max ? lan[i] : max;
            min = lan[i] < min ? lan[i] : min;
        }
        
        long left = 1;
        long right = max + 1;
        long mid = 0;
        long cnt = 0;
        
        while (left < right) {
            mid = (left + right) / 2;
            cnt = 0;

            for (int i = 0; i < lan.length; i++) {
                cnt += lan[i] / mid;
            }

            if (cnt < require) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left - 1);
    }
}