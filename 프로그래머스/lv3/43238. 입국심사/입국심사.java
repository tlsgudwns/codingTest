import java.util.Arrays;

class Solution {
   public static long solution(int n, int[] times) {

        //가장 느린사람이 기준으로 모든 심사대를 채웠을때 걸리는 시간을 right

        int max = -1;
        int min = Integer.MAX_VALUE;
//        for (int item : times) {
//            max = item > max ? item : max;
//            min = item < min ? item : min;
//        }
//
//        long right = (n / times.length + 1) * max;
//        long left = (n / times.length) * min;
        Arrays.sort(times);

        long left = times[0];
        long right = (long)times[times.length - 1] * n;
        
        long mid = 0;

        while (left < right) {
            mid = left + (right - left) / 2;
            long cnt = 0;

            for (int time : times) {
                cnt += mid / time; //각 심사대별로 mid라는 시간동안 통과시킬수있는 사람의 수를 cnt에 더한다
            }
            //최소시간 구하기니까 lower bound 
            if (cnt >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }


        return left;
    }
}