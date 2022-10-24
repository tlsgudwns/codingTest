import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.valueOf(br.readLine());
            int[][] scores = new int[n][2];
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                scores[j][0] = Integer.valueOf(st.nextToken());
                scores[j][1] = Integer.valueOf(st.nextToken());
            }
            Arrays.sort(scores, (x,y) -> x[0] - y[0]); // 0열 등수를 기준으로 오름차순정렬
                                    //성적좋은사람이 위에있음
            int cnt = n;
            int min = scores[0][1];
            for (int j = 1; j < n; j++) {
                if (scores[j][1] > min) {
                    cnt--;
                } else {
                    min = scores[j][1];
                }
            }
            System.out.println(cnt);
        }
    }
}