import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (num % 5 != 0 && num >= 0) {
            cnt++;
            num -= 3;
        }
        if (num < 0) {
            System.out.println(-1);
            return;
        }
        cnt += num / 5;

        System.out.println(cnt);
        
    }
}