import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int p1 = 0;
        int p2 = people.length - 1;
        int cnt = 0;
        while (p1 < p2) {
            if (people[p2] + people[p1] > limit) {
                p2--;
                cnt++;
            } else {
                p1++;
                p2--;
                cnt++;
            }
        }

        if (p1 == p2) {
            cnt++;
        }

        return cnt;
    }
}