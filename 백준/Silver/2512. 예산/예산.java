import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int n = Integer.parseInt(s);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] requireList = new int[n];
        for (int i = 0; i < n; i++) {
            requireList[i] = Integer.parseInt(st.nextToken());
        }

        s = br.readLine();
        int totalBudget = Integer.parseInt(s);
        int a = 0;
        int left = 0;
        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(requireList[i], max);
            a += requireList[i];
        }

        if (a <= totalBudget) {
            System.out.println(max);
            return;
        }

        int right = max;
        //지방당 최대예산 mid인 경우에 총합이 토탈예산보다 크면 줄이고 작으면 늘리기
        int answer = 0; //answer는 1곳당 상한액이고 최대예산은 따로 계산해줘야함
        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;

            for (int i = 0; i < n; i++) {
                sum += Math.min(requireList[i], mid);
            }

            if (sum < totalBudget) {
                left = mid + 1;
                answer = Math.max(answer, mid);
            } else if (sum > totalBudget) {
                right = mid - 1;
            } else {
                System.out.println(mid);
                return;
            }
        }//while을 빠져나왓을때 answer에 상한액 저장되어있을듯


        System.out.println(answer);

    }
}


