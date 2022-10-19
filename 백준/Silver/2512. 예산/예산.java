import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] require = new int[n];

        for (int i = 0; i < n; i++) {
            require[i] = Integer.parseInt(st.nextToken());
        }

        int totalLimit = Integer.parseInt(br.readLine());

        //상한액을 left right mid로 두고 조종해가면서 그합이 totalLimit를 넘지않는 선에서 가장큰값을 구해야한다
        //upperbound

        int max = -1;
        for (int i = 0; i < require.length; i++) {
            max = require[i] > max ? require[i] : max;
        }
        int left = 0;
        int right = max + 1;
        int mid = 0;
        int cnt = 0;

        while (left < right) {
            mid = (left + right) / 2;
            cnt = 0;

            for (int i = 0; i < require.length; i++) {
                cnt += Math.min(require[i], mid);
            }

            if (cnt > totalLimit) { //이 상한액으로 했을때 총예산을 넘어가면 상한액 줄이기
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left - 1);
    }
}
