

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char t : tasks) {
            freq[t - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) {
                maxHeap.add(f);
            }
        }

        Queue<int[]> cooldownQueue = new LinkedList<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            time++;

            if (!cooldownQueue.isEmpty() && cooldownQueue.peek()[1] == time) {
                maxHeap.add(cooldownQueue.poll()[0]);
            }

            if (!maxHeap.isEmpty()) {
                int remainingFreq = maxHeap.poll() - 1;
                if (remainingFreq > 0) {
                    cooldownQueue.add(new int[] { remainingFreq, time + n + 1 });
                }
            }
        }

        return time;
    }
}