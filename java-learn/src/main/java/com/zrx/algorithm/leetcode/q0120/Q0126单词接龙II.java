package com.zrx.algorithm.leetcode.q0120;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.ToString;
import com.zrx.algorithm.leetcode.object.ListNode;
import com.zrx.algorithm.leetcode.object.RepeatableSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description
 * 单词接龙 II
 * <p>
 * Data
 * 2020/6/13-19:14
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0126单词接龙II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0126单词接龙II.class);

    @Override
    public List<Input> getInputs() {

        //"qa"
        //"sq"
        //["si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"]

        return InputFactory.create(
                3,
                "hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog"),
                "hit", "cog", List.of("hot", "dot", "dog", "lot", "log")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                RepeatableSet.of(
                        List.of("hit", "hot", "dot", "dog", "cog"),
                        List.of("hit", "hot", "lot", "log", "cog")
                ),
                List.of()
        );
    }

    @Code(info = """
            给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：

            每次转换只能改变一个字母。
            转换后得到的单词必须是字典中的单词。
            说明:

            如果不存在这样的转换序列，返回一个空列表。
            所有单词具有相同的长度。
            所有单词只由小写字母组成。
            字典中不存在重复的单词。
            你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
            示例 1:

            输入:
            beginWord = "hit",
            endWord = "cog",
            wordList = ["hot","dot","dog","lot","log","cog"]

            输出:
            [
              ["hit","hot","dot","dog","cog"],
              ["hit","hot","lot","log","cog"]
            ]
            示例 2:

            输入:
            beginWord = "hit"
            endWord = "cog"
            wordList = ["hot","dot","dog","lot","log"]

            输出: []

            解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/word-ladder-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return Collections.emptyList();
        }

        // 制作数据结构

        Map<String, Integer> indexString = new HashMap<>(wordList.size() + 1);
        List<String> words = new ArrayList<>(wordList.size() + 1);
        Set<String> wordSet = new HashSet<>(wordList.size() + 1);

        wordSet.add(beginWord);
        words.add(beginWord);
        indexString.put(beginWord, 0);

        int i = 1;
        for (String word : wordList) {
            if (!wordSet.contains(word)) {
                wordSet.add(word);
                words.add(word);
                indexString.put(word, i);
                i++;
            }
        }

        // 制作临接矩阵
        int size = wordSet.size();
        boolean[][] tab = new boolean[size][size];
        for (i = 0; i < words.size(); i++) {
            String word = words.get(i);
            for (int j = 0; j < wordList.size(); j++) {
                String w2 = words.get(j);
                if (canConvert(word, w2)) {
                    tab[i][j] = tab[j][i] = true;
                }
            }
        }

        //LOGGER.info("tab = {}", ToString.arrayToFormatString(tab));

        // 每个单词的 cost
        int[] costs = new int[size];
        Arrays.fill(costs, Integer.MAX_VALUE);
        Deque<Integer> queue = new ArrayDeque<>(size);
        queue.addLast(0);
        costs[0] = 0;
        Integer endId = indexString.get(endWord);

        while (!queue.isEmpty()) {
            Deque<Integer> nextQueue = new ArrayDeque<>(size);

            while (!queue.isEmpty()) {
                Integer first = queue.removeFirst();
                int firstCost = costs[first];
                for (int j = 0; j < size; j++) {
                    if (tab[first][j] && costs[j] >= firstCost + 1) {
                        nextQueue.addLast(j);
                        costs[j] = firstCost + 1;
                    }
                }
            }

            if (costs[endId] != Integer.MAX_VALUE) break;

            queue = nextQueue;
        }

        if (costs[endId] == Integer.MAX_VALUE) return Collections.emptyList();

        //LOGGER.info("costs = {}", costs);
        //LOGGER.info("words = {}", words);


        int endCost = costs[endId];
        List<List<String>> ans = new ArrayList<>();
        LinkedList<String> l = new LinkedList<>();
        l.addLast(endWord);
        ans.add(l);

        endCost--;
        while (endCost >= 0) {
            List<List<String>> ansTemp = new ArrayList<>();
            while (!ans.isEmpty()) {
                LinkedList<String> one = (LinkedList<String>) ans.remove(0);
                String first = one.getFirst();
                Integer lastId = indexString.get(first);
                //LOGGER.info("first = {}", first);
                for (int j = 0; j < costs.length; j++) {
                    if (costs[j] == endCost && tab[lastId][j]) {
                        LinkedList<String> ll = new LinkedList<>(one);
                        ll.addFirst(words.get(j));
                        ansTemp.add(ll);
                    }
                }
            }

            ans = ansTemp;
            endCost--;
            //LOGGER.info("ansTemp = {}", ansTemp);
            //LOGGER.info("endCost = {}", endCost);
        }

        return ans;
    }

    public List<List<String>> findLadders速度慢(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return Collections.emptyList();
        }

        // 制作数据结构

        Map<String, Integer> indexString = new HashMap<>(wordList.size() + 1);
        List<String> words = new ArrayList<>(wordList.size() + 1);
        Set<String> wordSet = new HashSet<>(wordList.size() + 1);

        wordSet.add(beginWord);
        words.add(beginWord);
        indexString.put(beginWord, 0);

        int i = 1;
        for (String word : wordList) {
            if (!wordSet.contains(word)) {
                wordSet.add(word);
                words.add(word);
                indexString.put(word, i);
                i++;
            }
        }

        // 制作临接矩阵
        int size = wordSet.size();
        boolean[][] tab = new boolean[size][size];
        for (i = 0; i < words.size(); i++) {
            String word = words.get(i);
            for (int j = 0; j < wordList.size(); j++) {
                String w2 = words.get(j);
                if (canConvert(word, w2)) {
                    tab[i][j] = tab[j][i] = true;
                }
            }
        }

        // 开始广度优先搜索
        boolean[] visited = new boolean[size];
        Deque<List<String>> pathQueue = new LinkedList<>();
        List<String> begin = new ArrayList<>();
        begin.add(beginWord);
        pathQueue.addLast(begin);
        visited[0] = true;
        boolean[] subVisited = new boolean[size];
        List<List<String>> ans = new ArrayList<>();

        while (!pathQueue.isEmpty()) {
            Deque<List<String>> pathQueueTemp = new LinkedList<>();
            boolean find = false;
            Arrays.fill(subVisited, false);

            while (!pathQueue.isEmpty()) {
                List<String> first = pathQueue.removeFirst();
                String lastWord = first.get(first.size() - 1);
                Integer lastWordId = indexString.get(lastWord);


                for (int j = 0; j < size; j++) {
                    if (tab[lastWordId][j]) {
                        String next = words.get(j);
                        if (!visited[j]) {
                            subVisited[j] = true;
                            //LOGGER.info("next = {}", next);
                            if (next.equals(endWord)) {
                                first.add(next);
                                List<String> newPath = new ArrayList<>(first);
                                ans.add(newPath);
                                first.remove(first.size() - 1);
                                find = true;
                            } else {
                                if (!first.contains(next)) {
                                    first.add(next);
                                    List<String> newPath = new ArrayList<>(first);
                                    pathQueueTemp.addFirst(newPath);
                                    first.remove(first.size() - 1);
                                }
                            }

                        }
                    }
                }
            }

            for (int j = 0; j < subVisited.length; j++) {
                if (subVisited[j]) {
                    visited[j] = true;
                }
            }

            if (find) {
                return ans;
            }

            pathQueue = pathQueueTemp;
        }

        return Collections.emptyList();
    }


    public List<List<String>> findLadders错误(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return Collections.emptyList();
        }

        List<List<String>> ans = new ArrayList<>();

        class Node {
            String data;
            List<String> nextWords = new ArrayList<>();
            int cost = Integer.MAX_VALUE;

            public Node(String data) {
                this.data = data;
            }

            public void addNext(String word) {
                nextWords.add(word);
            }

            @Override
            public String toString() {
                return "Node{" +
                        "data='" + data + '\'' +
                        ", nextWords=" + nextWords +
                        ", cost=" + cost +
                        '}';
            }
        }

        ArrayList<String> list = new ArrayList<>(wordList);
        list.add(beginWord);

        Map<String, Node> stringNodeMap = new HashMap<>();

        for (String word : list) {
            Node node = new Node(word);
            for (String w : list) {
                if (!w.equals(word)) {
                    if (canConvert(w, word)) {
                        node.addNext(w);
                    }
                }
            }
            stringNodeMap.put(word, node);
        }

        Node start = stringNodeMap.get(beginWord);
        start.cost = 0;

        Deque<Node> deque = new LinkedList<>();
        deque.addLast(start);

        while (!deque.isEmpty()) {
            Node first = deque.removeFirst();

            int cost = first.cost;
            for (String nextWord : first.nextWords) {
                Node node = stringNodeMap.get(nextWord);
                if (node.cost > cost + 1) {
                    node.cost = cost + 1;
                    deque.addLast(node);
                }
            }
        }

        Collection<Node> values = stringNodeMap.values();
        values.forEach(n -> LOGGER.info("n = {}", n));

        Node endNode = stringNodeMap.get(endWord);
        int endCost = endNode.cost;
        if (endCost > wordList.size() + 1) {
            return Collections.emptyList();
        } else {
            List<String> l = new ArrayList<>();
            l.add(endWord);

            ans.add(l);

            endCost--;
            while (endCost > 0) {
                List<List<String>> newAns = new ArrayList<>();
                for (Node value : values) {
                    if (value.cost == endCost && value.nextWords.contains(endWord)) {
                        for (List<String> an : ans) {
                            ArrayList<String> ll = new ArrayList<>(an);
                            ll.add(value.data);
                            newAns.add(ll);
                        }
                    }
                }

                ans = newAns;
                endCost--;
            }

            return ans.stream().peek(ll -> ll.add(endWord)).peek(Collections::reverse).collect(Collectors.toList());
        }
    }


    public List<List<String>> findLadders继续超时(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return Collections.emptyList();
        }

        List<List<String>> ans = new ArrayList<>();

        class Node {
            String data;
            List<String> nextWords = new ArrayList<>();
            //int cost = Integer.MAX_VALUE;

            public Node(String data) {
                this.data = data;
            }

            public void addNext(String word) {
                nextWords.add(word);
            }

            @Override
            public String toString() {
                return "Node{" +
                        "data='" + data + '\'' +
                        ", nextWords=" + nextWords +
                        '}';
            }
        }

        ArrayList<String> list = new ArrayList<>(wordList);
        list.add(beginWord);

        Map<String, Node> stringNodeMap = new HashMap<>();

        for (String word : list) {
            Node node = new Node(word);
            for (String w : list) {
                if (!w.equals(word)) {
                    if (canConvert(w, word)) {
                        node.addNext(w);
                    }
                }
            }
            stringNodeMap.put(word, node);

            LOGGER.info("node = {}", node);
        }

        // 图构成
        Deque<List<String>> queue = new LinkedList<>();
        List<String> start = new ArrayList<>();
        start.add(beginWord);
        queue.addLast(start);

        while (!queue.isEmpty()) {
            Deque<List<String>> tempQueue = new LinkedList<>();
            boolean hasAns = false;
            while (!queue.isEmpty()) {
                List<String> trace = queue.removeFirst();
                if (trace.size() > wordList.size() + 1) return Collections.emptyList();

                String last = trace.get(trace.size() - 1);
                Node node = stringNodeMap.get(last);

                for (String nextWord : node.nextWords) {
                    ArrayList<String> newTrace = new ArrayList<>(trace);
                    newTrace.add(nextWord);
                    tempQueue.addLast(newTrace);

                    if (endWord.equals(nextWord)) {
                        ans.add(newTrace);
                        hasAns = true;
                    }
                }

            }

            if (hasAns) return ans;

            queue = tempQueue;
        }

        return Collections.emptyList();
    }

    private boolean canConvert(String w1, String w2) {
        int l1 = w1.length();
        int l2 = w2.length();

        if (l1 != l2) return false;

        int diff = 0;

        for (int i = 0; i < l1; i++) {
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(i);

            if (c1 != c2) {
                diff++;
                if (diff > 1) return false;
            }
        }

        return diff == 1;
    }

    public List<List<String>> findLadders方法超时(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return Collections.emptyList();

        List<List<String>> ans = new ArrayList<>();
        Deque<String> trace = new LinkedList<>();
        trace.push(beginWord);

        back(trace, endWord, wordList, ans);

        return ans;
    }

    private void back(Deque<String> trace, String endWord, List<String> wordList, List<List<String>> ans) {
        int size = wordList.size();
        int min = ans.stream().mapToInt(List::size).min().orElse(Integer.MAX_VALUE);
        int tSize = trace.size();
        if (tSize > size || tSize > min || tSize > Math.pow(2, endWord.length())) return;
        if (trace.peek().equals(endWord)) {
            if (tSize <= min) {
                if (tSize < min) ans.clear();
                ArrayList<String> t = new ArrayList<>(trace);
                Collections.reverse(t);
                ans.add(t);
            }
        } else {
            for (String s : wordList) {
                if (!trace.contains(s) && canConvert(s, trace.peek())) {
                    trace.push(s);
                    back(trace, endWord, wordList, ans);
                    trace.pop();
                }
            }
        }
    }


}
