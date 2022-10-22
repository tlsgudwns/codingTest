import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer("");
        int[][] times = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, (x, y) -> x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]);

        int cnt = 1;   //times[a][a] 처럼 같은 시간내에 끝나는것들은 제일 마지막에 배정되어야 +1 더받을수 잇을거다
        int i = 0;
        int next = 1;
//        while (i < times.length) {
//            next = i + 1;
//            if (next > times.length - 1) {
//                System.out.println(cnt);
//                return;
//            }
//            while (times[i][1] > times[next][0]) {
//                next++;
//                if (next > times.length - 1) {
//                    System.out.println(cnt);
//                    return;
//                }
//            }//빠져나오면 next에는 진입가능한 회의의 인덱스가 저장되어있다
//            cnt++;
//            i = next;
//        }

        while (i < times.length - 1) {
            next = i + 1;
            while (next <= times.length - 1 && times[i][1] > times[next][0]) {
                next++;
            }
            if (next == times.length) {//next가 배열의 인덱스를 넘어섬 더 들어갈수있는 회의가 없다
                break;
            }
            //같지않다면 next는 배열의 범위 이내이고 더 회의가 들어갈수있다는뜻이니까 + 1
            cnt++;
            i = next;
        }

        System.out.println(cnt);
    }
}