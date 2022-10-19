import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] homes = new int[n];

        for (int i = 0; i < n; i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(homes);

        //공유기 사이의 최대거리를 mid로 조절해가면서 mid가 최대한 꽉차도록 집들 간격을 집어넣으면된다

        int left = 0;
        int right = homes[homes.length - 1];
        //upper
        int mid = 0;
        int prev = 0; //이전 공유기를 설치한집 좌표
        int cnt = 0; //설치한 공유기의 개수
        while (left < right) {
            mid = (left + right) / 2;
            //첫번째 집에는 무조건 공유기설치
            prev = homes[0];
            cnt = 1;
            for (int i = 1; i < homes.length; i++) {
                if (homes[i] - prev >= mid) {
                    prev = homes[i];
                    cnt++;
                }
            }

            if (cnt >= c) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left - 1);


    }
}
