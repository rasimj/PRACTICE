class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];

        // Step 1: Fill buckets
        for (int c : citations) {
            if (c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }

        // Step 2: Cumulative count from back
        int count = 0;
        for (int h = n; h >= 0; h--) {
            count += buckets[h];
            if (count >= h) {
                return h;
            }
        }

        return 0;
    }
}