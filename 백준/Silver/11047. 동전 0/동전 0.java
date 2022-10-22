import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main{
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.valueOf(br.readLine());
        }

        int cnt = 0;
        int idx = coins.length - 1;
        while (k > 0) {
//            if (coins[idx] == 0) {
//                idx--;
//                continue;
//            }
            cnt += k / coins[idx];
            k = k % coins[idx--];
        }

        System.out.println(cnt);

    }
}