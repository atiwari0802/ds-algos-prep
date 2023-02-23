package prep.ds.algo.graphs.topological.sort;

import java.util.*;

public class AlienDictionary {

    /**
     * There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.
     *
     * You are given a list of strings words from the alien language's dictionary, where the strings in words are
     * sorted lexicographically
     *  by the rules of this new language.
     *
     * Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.
     * @param words
     * @return
     */
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adjacencyList = new HashMap<>();
        Map<Character, Integer> edgeCount = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                edgeCount.putIfAbsent(word.charAt(i), 0);
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            String wordOne = words[i];
            String wordTwo = words[i + 1];

            for (int j = 0; j < Math.min(wordOne.length(), wordTwo.length()); j++) {
                if (wordOne.length() > wordTwo.length() && wordOne.startsWith(wordTwo)) {
                    return "";
                }

                if (wordOne.charAt(j) != wordTwo.charAt(j)) {
                    adjacencyList.computeIfAbsent(wordOne.charAt(j), v ->  new ArrayList<>()).add(wordTwo.charAt(j));
                    edgeCount.merge(wordTwo.charAt(j), 1, Integer::sum);
                    break;
                }
            }
        }

        Deque<Character> queue = new ArrayDeque<>();
        for (Character ch : edgeCount.keySet()) {
            if (edgeCount.getOrDefault(ch, 0) == 0) {
                queue.add(ch);
            }
        }

        while (!queue.isEmpty()) {
            Character ch = queue.removeFirst();
            answer.append(ch);

            if (adjacencyList.containsKey(ch)) {
                for (Character adjacentChar : adjacencyList.get(ch)) {
                    int count = edgeCount.merge(adjacentChar, -1, Integer::sum);
                    if (count == 0) {
                        queue.addLast(adjacentChar);
                    }
                }
            }
        }

        if (answer.length() < edgeCount.size()) {
            return "";
        }

        return answer.toString();
    }
}
