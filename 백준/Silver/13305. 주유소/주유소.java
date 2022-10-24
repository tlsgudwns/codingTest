import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[] road = new int[n - 1];
        int[] prices = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n-1; i++) {
            road[i] = Integer.valueOf(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.valueOf(st.nextToken());
        }

        //price에서 그 보다 작은 값이 나올때까지 인덱스를 증가시킨다
        //그 인덱스값 이전까지의 거리길이에 price를 곱하고 다음 작은값 price에서 과정을 반복한다
        int curPrice = prices[0];
        long curRoad = 0;
        long total = 0;
        for (int i = 1; i < n; i++) {
            if (curPrice <= prices[i]) {
                curRoad += road[i - 1];
                continue;
            }
            //curPrice보다 더 싼 가격이 생겼다면
            curRoad += road[i - 1];
            total += curRoad * curPrice;
            curPrice = prices[i];
            curRoad = 0;
        }
        total += curRoad * curPrice;
        System.out.println(total);
    }
}