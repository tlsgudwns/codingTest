class Solution {
    public static long solution(int n, int[] times) {
        long answer = 0;
        int slow = Integer.MAX_VALUE;
        int fast = Integer.MIN_VALUE;

        for (int i = 0; i < times.length; i++) {
            slow = Math.max(times[i], slow);
            fast = Math.min(times[i], fast);
        }
        long right = (long)(n / times.length + 1) * slow;
        long left = (long)(n / times.length) * fast;


        while (left <= right) {
            long mid = (left + right) / 2;
            long total = 0;

            for (int i = 0; i < times.length; i++) {
                total += mid / times[i];
            }

            if (total < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }


        for (long i = left; i >= right ; i--) {
            long total = 0;
            for (int j = 0; j < times.length; j++) {
                total += i / times[j];
            }
            if (total >= n) {
                return i;
            }
        }


        
        return left;
    }
}