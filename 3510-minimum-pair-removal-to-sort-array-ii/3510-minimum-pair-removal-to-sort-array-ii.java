class Solution {
    static class Node {
        long val;
        int idx;
        Node prev, next;
        boolean alive = true;

        Node(long val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    static class Pair {
        Node left, right;
        long sum;
        int idx;

        Pair(Node left, Node right) {
            this.left = left;
            this.right = right;
            this.sum = left.val + right.val;
            this.idx = left.idx;
        }
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(nums[i], i);
            if (i > 0) {
                nodes[i - 1].next = nodes[i];
                nodes[i].prev = nodes[i - 1];
            }
        }

        int bad = 0;
        for (int i = 1; i < n; i++) {
            if (nodes[i - 1].val > nodes[i].val) bad++;
        }
        if (bad == 0) return 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.sum != b.sum) return Long.compare(a.sum, b.sum);
            return Integer.compare(a.idx, b.idx);
        });

        for (int i = 0; i < n - 1; i++) {
            pq.offer(new Pair(nodes[i], nodes[i + 1]));
        }

        int operations = 0;

        while (bad > 0) {
            Pair cur = pq.poll();
            while (!isValid(cur)) {
                cur = pq.poll();
            }

            Node a = cur.left;
            Node b = cur.right;
            Node left = a.prev;
            Node right = b.next;

            // Remove old violation contributions
            if (left != null && left.val > a.val) bad--;
            if (a.val > b.val) bad--;
            if (right != null && b.val > right.val) bad--;

            // Merge b into a
            a.val += b.val;
            a.next = right;
            if (right != null) right.prev = a;
            b.alive = false;

            // Add new violation contributions
            if (left != null && left.val > a.val) bad++;
            if (right != null && a.val > right.val) bad++;

            // Push new neighboring pairs
            if (left != null) pq.offer(new Pair(left, a));
            if (right != null) pq.offer(new Pair(a, right));

            operations++;
        }

        return operations;
    }

    private boolean isValid(Pair p) {
        return p.left.alive
            && p.right.alive
            && p.left.next == p.right
            && p.sum == p.left.val + p.right.val;
    }
}