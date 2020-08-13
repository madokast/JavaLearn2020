package com.zrx.algorithm.leetcode.q0210;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.info.InfoProperties;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description
 * 天际线问题
 *
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0218天际线问题 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0218天际线问题.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.createTwoDimensionsIntArray(
                        2, 9, 10, null,
                        3, 7, 15, null,
                        5, 12, 12, null,
                        15, 20, 10, null,
                        19, 24, 8
                ),
                ArrayFactory.createTwoDimensionsIntArray(
                        1, 2, 1
                ),
                ArrayFactory.createTwoDimensionsIntArray(
                        1, 2, 1, null,
                        3, 4, 2
                ), ArrayFactory.createTwoDimensionsIntArray(
                        1, 3, 1, null,
                        2, 3, 2
                ), ArrayFactory.createTwoDimensionsIntArray(
                        0, 2, 1, null,
                        1, 3, 2
                ), ArrayFactory.createTwoDimensionsIntArray(
                        0, 3, 1, null,
                        1, 2, 2
                ), ArrayFactory.createTwoDimensionsIntArray(
                        0, 2, 2, null,
                        1, 3, 1
                ), ArrayFactory.createTwoDimensionsIntArray(
                        0, 4, 1, null,
                        1, 3, 3, null,
                        2, 5, 2
                ), ArrayFactory.createTwoDimensionsIntArray(
                        2, 4, 5, null,
                        2, 4, 7, null,
                        2, 4, 6
                ), ArrayFactory.createTwoDimensionsIntArray(
                        0, 3, 3, null,
                        1, 5, 3, null,
                        2, 4, 3, null,
                        3, 7, 3
                )
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                List.of(
                        List.of(2, 10),
                        List.of(3, 15),
                        List.of(7, 12),
                        List.of(12, 0),
                        List.of(15, 10),
                        List.of(20, 8),
                        List.of(24, 0)
                ), List.of(
                        List.of(1, 1),
                        List.of(2, 0)
                ), List.of(
                        List.of(1, 1),
                        List.of(2, 0),
                        List.of(3, 2),
                        List.of(4, 0)
                ), List.of(
                        List.of(1, 1),
                        List.of(2, 2),
                        List.of(3, 0)
                ), List.of(
                        List.of(0, 1),
                        List.of(1, 2),
                        List.of(3, 0)
                ), List.of(
                        List.of(0, 1),
                        List.of(1, 2),
                        List.of(2, 1),
                        List.of(3, 0)
                ), List.of(
                        List.of(0, 2),
                        List.of(2, 1),
                        List.of(3, 0)
                ), List.of(
                        List.of(0, 1),
                        List.of(1, 3),
                        List.of(3, 2),
                        List.of(5, 0)
                ), List.of(
                        List.of(2, 7),
                        List.of(4, 0)
                ), List.of(
                        List.of(0, 3),
                        List.of(7, 0)
                )
        );
    }

    @Code(info = """
            城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。现在，假设您获得了城市风光照片（图A）上显示的所有建筑物的位置和高度，请编写一个程序以输出由这些建筑物形成的天际线（图B）。

            \040

            每个建筑物的几何信息用三元组 [Li，Ri，Hi] 表示，其中 Li 和 Ri 分别是第 i 座建筑物左右边缘的 x 坐标，Hi 是其高度。可以保证 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX 和 Ri - Li > 0。您可以假设所有建筑物都是在绝对平坦且高度为 0 的表面上的完美矩形。

            例如，图A中所有建筑物的尺寸记录为：[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] 。

            输出是以 [ [x1,y1], [x2, y2], [x3, y3], ... ] 格式的“关键点”（图B中的红点）的列表，它们唯一地定义了天际线。关键点是水平线段的左端点。请注意，最右侧建筑物的最后一个关键点仅用于标记天际线的终点，并始终为零高度。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。

            例如，图B中的天际线应该表示为：[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]。

            说明:

            任何输入列表中的建筑物数量保证在 [0, 10000] 范围内。
            输入列表已经按左 x 坐标 Li  进行升序排列。
            输出列表必须按 x 位排序。
            输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/the-skyline-problem
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<List<Integer>> getSkyline(int[][] buildings) {
        class Point implements Comparable<Point> {
            int location;
            boolean left;
            int height;

            public Point(int location, boolean left, int height) {
                this.location = location;
                this.left = left;
                this.height = height;
            }

            @Override
            public int compareTo(@NotNull Point o) {
                int c = Integer.compare(this.location, o.location);
                if (c != 0) return c;
                else return Integer.compare(this.height, o.height);
            }

            @Override
            public String toString() {
                return String.format("L%dH%d%s", location, height, left ? "左" : "右");
            }
        }

        PriorityQueue<Point> priorityQueue = new PriorityQueue<>();

        Map<Point, Point> map = new HashMap<>();

        for (int[] building : buildings) {
            int left = building[0];
            int right = building[1];
            int height = building[2];

            Point leftPoint = new Point(left, true, height);
            Point rightPoint = new Point(right, false, height);
            priorityQueue.add(leftPoint);
            priorityQueue.add(rightPoint);
            map.put(rightPoint, leftPoint);
        }

        LOGGER.info("priorityQueue = {}", priorityQueue);

        int lastHeight = -1;

        List<List<Integer>> ans = new ArrayList<>();

        TreeMap<Point, Integer> scan = new TreeMap<>((p1, p2) -> Integer.compare(p2.height, p1.height));

        while (!priorityQueue.isEmpty()) {
            Point poll = priorityQueue.poll();

            if (poll.left) {
                scan.put(poll, scan.getOrDefault(poll, 0) + 1);
            } else {
                Point m = map.get(poll);
                Integer t = scan.get(m);
                if (t == 1) scan.remove(m);
                else scan.put(poll, t - 1);
            }

            while (!priorityQueue.isEmpty() && priorityQueue.peek().location == poll.location) {
                poll = priorityQueue.poll();

                if (poll.left) {
                    scan.put(poll, scan.getOrDefault(poll, 0) + 1);
                } else {
                    Point m = map.get(poll);
                    Integer t = scan.get(m);
                    if (t == 1) scan.remove(m);
                    else scan.put(poll, t - 1);
                }
            }

            LOGGER.info("scan = {}", scan);

            if (scan.isEmpty()) {
                ans.add(List.of(poll.location, 0));
                lastHeight = 0;
            } else {
                int height = scan.firstKey().height;
                if (lastHeight != height) {
                    ans.add(List.of(poll.location, height));
                }

                lastHeight = height;
            }
        }

        return ans;
    }

    public List<List<Integer>> getSkyline大神的用于学习(int[][] buildings) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int[] building : buildings) {
            pq.offer(new int[]{building[0], -building[2]});
            pq.offer(new int[]{building[1], building[2]});
        }

        List<List<Integer>> res = new ArrayList<>();

        TreeMap<Integer, Integer> heights = new TreeMap<>((a, b) -> b - a);
        heights.put(0, 1);
        int left = 0, height = 0;
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            if (arr[1] < 0) {
                heights.put(-arr[1], heights.getOrDefault(-arr[1], 0) + 1);
            } else {
                heights.put(arr[1], heights.get(arr[1]) - 1);
                if (heights.get(arr[1]) == 0) heights.remove(arr[1]); // 终于看懂了一点点
            }
            int maxHeight = heights.keySet().iterator().next();
            if (maxHeight != height) {
                left = arr[0];
                height = maxHeight;
                res.add(Arrays.asList(left, height));
            }
        }

        return res;
    }


    public List<List<Integer>> getSkyline自己写的(int[][] buildings) {
        if (buildings.length == 0) return Collections.emptyList();


//        Map<Integer, Integer> leftHeightMap = new HashMap<>();
//        Map<Integer, Integer> rightHeightMap = new HashMap<>();

        LinkedList<List<Integer>> leftList = new LinkedList<>();
        List<List<Integer>> rightList = new ArrayList<>();

        for (int[] building : buildings) {
            int left = building[0];
            int right = building[1];
            int height = building[2];

            leftList.add(List.of(left, height));
            rightList.add(List.of(right, height));

//            leftHeightMap.put(left, Math.max(height, leftHeightMap.getOrDefault(left, 0)));
//            rightHeightMap.put(right, Math.max(height, rightHeightMap.getOrDefault(right, 0)));
        }

        rightList.sort((e1, e2) -> {
            int c = Integer.compare(e1.get(0), e2.get(0));
            if (c != 0) return c;
            else return Integer.compare(e1.get(1), e2.get(1));
        });

        Deque<List<Integer>> leftStack = leftList;
        Deque<List<Integer>> rightStack = new LinkedList<>(rightList);


//        Deque<Map.Entry<Integer, Integer>> leftEntryStack = leftHeightMap.entrySet()
//                .stream().sorted(Comparator.comparingInt(Map.Entry::getKey)).collect(Collectors.toCollection(LinkedList::new));
//
//        Deque<Map.Entry<Integer, Integer>> rightEntryStack = rightHeightMap.entrySet()
//                .stream().sorted(Comparator.comparingInt(Map.Entry::getKey)).collect(Collectors.toCollection(LinkedList::new));

        // LOGGER.info("leftEntryStack = {}", leftStack);
        //LOGGER.info("rightEntryStack = {}", rightStack);

        List<List<Integer>> ans = new ArrayList<>();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        Integer last = null;

        while (!rightStack.isEmpty()) {
            List<Integer> leftPeek = leftStack.peek();

            List<Integer> rightPeek = rightStack.peek();


            Integer leftKey = leftPeek == null ? null : leftPeek.get(0);

            Integer rightKey = rightPeek.get(0);

            Integer removedKey = null;
            boolean right;

            if (leftKey != null && leftKey <= rightKey) {
                leftStack.pop();
                priorityQueue.add(leftPeek.get(1));

                removedKey = leftKey;
                right = true;
            } else {
                rightStack.pop();
                priorityQueue.remove(rightPeek.get(1));

                removedKey = rightKey;
                right = false;
            }

            Integer peek = priorityQueue.peek();
            if (peek == null) peek = 0;
            if (!Objects.equals(last, peek)) {

                if (ans.isEmpty()) {
                    ans.add(List.of(removedKey, peek));
                } else {
                    List<Integer> lastOne = ans.get(ans.size() - 1);
                    if (!lastOne.get(0).equals(removedKey)) {
                        ans.add(List.of(removedKey, peek));
                    } else {
                        Integer oldH = lastOne.get(1);
                        if (right) {
                            if (oldH < peek) {
                                ans.remove(lastOne);
                                ans.add(List.of(removedKey, peek));
                            }
                        } else {
                            if (oldH > peek) {
                                ans.remove(lastOne);
                                ans.add(List.of(removedKey, peek));
                            }
                        }
                    }
                }

                last = peek;
            }
        }


        return ans;

    }

    List<List<Integer>> getSkylineXX(int[][] buildings) {
        if (buildings.length == 0) return Collections.emptyList();

        Map<Integer, Integer> heightMap = new HashMap<>();


        for (int[] building : buildings) {
            int left = building[0];
            int right = building[1];
            int height = building[2];

            Integer preHeight = heightMap.getOrDefault(left, 0);
            if (height > preHeight) {
                heightMap.put(left, height);
            }


            preHeight = heightMap.getOrDefault(right, 0);
            if (height > preHeight) {
                heightMap.put(right, height);
            }

        }


        List<Map.Entry<Integer, Integer>> entryList = heightMap.entrySet()
                .stream().sorted(Comparator.comparingInt(Map.Entry::getKey)).collect(Collectors.toList());

        List<List<Integer>> ans = new ArrayList<>();

        Map.Entry<Integer, Integer> pre = entryList.get(0);
        ans.add(List.of(pre.getKey(), pre.getValue()));

        int size = entryList.size();
        for (int i = 1; i < size - 1; i++) {
            Map.Entry<Integer, Integer> entry = entryList.get(i);
            Integer key = entry.getKey();
            Integer height = entry.getValue();

            Integer preHeight = pre.getValue();
            Integer postHeight = entryList.get(i + 1).getValue();

            if (height < preHeight && height < postHeight) continue;

            if (height.equals(preHeight)) {

                ans.add(List.of(key, postHeight > height ? 0 : postHeight));
            } else {
                ans.add(List.of(key, height));
            }

            pre = entry;
        }

        ans.add(List.of(entryList.get(size - 1).getKey(), 0));

        return ans;
    }
}
