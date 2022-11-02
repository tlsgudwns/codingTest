import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static boolean[] visit;

    static int Min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.valueOf(br.readLine());

        map = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        
         combi(0, 0);
        System.out.println(Min);
        
    }

    static void combi(int idx, int count) {
        if (count == N / 2) {
            diff();
            return;
        }

        for (int i = idx; i < N; i++) {
            //if (!visit[i]) { //이거 없어도 되나 실험하기
                visit[i] = true;
                combi(i + 1, count + 1);
                visit[i] = false;
            //}
        }
    }
    
    static void diff() {
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] == true && visit[j] == true) {
                    team_start += map[i][j] + map[j][i];
                } else if (visit[i] == false && visit[j] == false) {
                    team_link += map[i][j] + map[j][i];
                }
            }
        }

        int val = Math.abs(team_link - team_start);

        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }

        Min = Math.min(val, Min);
        
    }
    

}