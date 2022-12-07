import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] map;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N];

        backTracking(N, 0);
        System.out.println(cnt);
    }

    public static void backTracking(int N, int depth) {
        if (depth == N) {
            cnt++;
            return;
        }

        boolean can = true;

        for (int i = 0; i < N; i++) { //내가 y축 세로 depth번째 줄에 0~N-1개의 가로좌표들에 새 말을 놓으려할때

            can = true;
            for (int j = 0; j < depth; j++) { //윗줄에 이미 놓은말들 depth개만큼과 위치검증해야한다
                if (map[j] == i || Math.abs(map[j] - i) == depth - j) { //대각선에 있거나 같은 x좌표를 가진다면
                    can = false;                    //이자리에 올수없다
                    break;
                }
            }
            if (can == true) { //위의 반복문검증을 거쳤는데도 can이 true를 유지했다면 퀸이 들어올수있는 자리니까
                map[depth] = i;
                backTracking(N, depth + 1);
            }

        }

    }

}