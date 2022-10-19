import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        //int target = Integer.parseInt(st.nextToken()); //만드려고하는 래넛ㄴ개수
        int target = Integer.parseInt(st.nextToken());
        long[] prev = new long[n]; //기존의 랜선 배열

        long max = -1;
        for (int i = 0; i < n; i++) {
            prev[i] = Integer.parseInt(br.readLine());
            max = prev[i] > max ? prev[i] : max;
        }
        
        

        long lo = 0;
        long hi = max + 1;

        while (lo < hi) {
            long mid = (lo + hi) / 2;
            long total = 0;
            for (int i = 0; i < prev.length; i++) {
                total += prev[i] / mid;
            }

            if (total < target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }


        System.out.println(lo - 1);

    }
}