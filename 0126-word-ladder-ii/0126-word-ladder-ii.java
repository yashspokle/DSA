class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!dict.contains(endWord)) return res;
        Map<String, List<String>> parents = new HashMap<>();
        Set<String> curr = new HashSet<>();
        curr.add(beginWord);
        Set<String> visited = new HashSet<>();
        boolean found = false;
        while (!curr.isEmpty() && !found) {
            Set<String> next = new HashSet<>();
            visited.addAll(curr);
            for (String word : curr) {
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String nei = new String(arr);

                        if (!dict.contains(nei) || visited.contains(nei)) continue;

                        if (nei.equals(endWord)) found = true;
                        next.add(nei);
                        parents.computeIfAbsent(nei, k -> new ArrayList<>()).add(word);
                    }
                    arr[i] = old;
                }
            }
            curr = next;
        }
        if (!found) return res;
        List<String> path = new ArrayList<>();
        path.add(endWord);
        backtrack(endWord, beginWord, parents, path, res);
        return res;
    }
    void backtrack(String word, String beginWord, Map<String, List<String>> parents,
                   List<String> path, List<List<String>> res) {
        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            res.add(temp);
            return;
        }
        if (!parents.containsKey(word)) return;
        for (String p : parents.get(word)) {
            path.add(p);
            backtrack(p, beginWord, parents, path, res);
            path.remove(path.size() - 1);
        }
    }
}