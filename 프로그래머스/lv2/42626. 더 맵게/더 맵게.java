import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> x - y);
        for (int i = 0; i < scoville.length; i++) {
            if (scoville[i] < K) {
                cnt++;
            }
            pq.offer(scoville[i]);
        } //cnt에는 K보다 작은것들의 개수 저장

        while (!pq.isEmpty()) {
            int a = pq.poll();
            int b = pq.poll();

            if (a + 2 * b < K) {
                cnt -= 1;
            } else {
                break;
            }
            if (pq.isEmpty()) {
                return -1;
            }
            answer += 1;
            pq.offer(a + 2 * b);
        }

        answer = answer + (cnt + 1) / 2;

        return answer;
    }
}