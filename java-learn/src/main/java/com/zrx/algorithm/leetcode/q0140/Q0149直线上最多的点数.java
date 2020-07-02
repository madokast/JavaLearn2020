package com.zrx.algorithm.leetcode.q0140;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Description
 * 直线上最多的点数
 * <p>
 * Data
 * 2020/6/27-0:02
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0149直线上最多的点数 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0149直线上最多的点数.class);

    @Override
    public List<Input> getInputs() {
        //[[-54,-297],[-36,-222],[3,-2],[30,53],[-5,1],[-36,-222],[0,2],[1,3],[6,-47],[0,4],[2,3],[5,0],[48,128],
        // [24,28],[0,-5],[48,128],[-12,-122],[-54,-297],[-42,-247],[-5,0],[2,4],[0,0],[54,153],[-30,-197],[4,5],
        // [4,3],[-42,-247],[6,-47],[-60,-322],[-4,-2],[-18,-147],[6,-47],[60,178],[30,53],[-5,3],[-42,-247],[2,-2],
        // [12,-22],[24,28],[0,-72],[3,-4],[-60,-322],[48,128],[0,-72],[-5,3],[5,5],[-24,-172],[-48,-272],[36,78],[-3,3]]
        //[[0,0],[1,65536],[65536,0]]
        return InputFactory.create(
                1,
                ArrayFactory.createTwoDimensionsIntArray(
                        1, 1, null,
                        2, 2, null,
                        3, 3
                ),
                ArrayFactory.createTwoDimensionsIntArray(
                        1, 1, null,
                        3, 2, null,
                        5, 3, null,
                        4, 1, null,
                        2, 3, null,
                        1, 4
                ), ArrayFactory.createTwoDimensionsIntArray(
                        0, 0, null,
                        1, 1, null,
                        0, 0
                ), ArrayFactory.createTwoDimensionsIntArray(
                        0, 0, null,
                        1, 65536, null,
                        65536, 0
                )
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                3,
                4,
                3,
                2
        );
    }

    @Code(info = """
            给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。

            示例 1:

            输入: [[1,1],[2,2],[3,3]]
            输出: 3
            解释:
            ^
            |
            |        o
            |     o
            |  o  
            +------------->
            0  1  2  3  4
            示例 2:

            输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
            输出: 4
            解释:
            ^
            |
            |  o
            |     o        o
            |        o
            |  o        o
            +------------------->
            0  1  2  3  4  5  6

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/max-points-on-a-line
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        int res = 0;
        //遍历每个点
        for (int i = 0; i < points.length; i++) {
            int duplicate = 0;
            int max = 0;//保存经过当前点的直线中，最多的点
            HashMap<Long, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                //求出分子分母
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if (x == 0 && y == 0) {
                    duplicate++;
                    continue;
                }
                //进行约分
                int gcd = gcd(x, y);
                x = x / gcd;
                y = y / gcd;
                Long key = (((long) x) << 32) + (long)y;
                LOGGER.info("key = {}", key);
                LOGGER.info("x+y = {}", x +"@"+ y);
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            //1 代表当前考虑的点，duplicate 代表和当前的点重复的点
            res = Math.max(res, max + duplicate + 1);
        }
        return res;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public int maxPointsXXX(int[][] points) {
        if (points == null) return 0;

        int lengthOld = points.length;

        // 去重
//        List<int[]> pointList = new ArrayList<>(length);
        HashMap<Point, Integer> pointMap = new HashMap<>();


        ff:
        for (int[] ints : points) {
            Point curP = new Point(ints);
            for (Point point : pointMap.keySet()) {
                if (Objects.equals(curP, point)) {
                    pointMap.put(point, pointMap.get(point) + 1);
                    continue ff;
                }
            }

            pointMap.put(curP, 1);
        }

        List<Point> pointList = new ArrayList<>(pointMap.keySet());

        int length = pointList.size();

        LOGGER.info("pointMap = {}", pointMap);


        if (length < 3) return lengthOld;

        Set<Line> lines = new HashSet<>(length);

        LOGGER.info("pointList = {}", pointList);
        for (int i = 0; i < length; i++) {
            Point curP = pointList.get(i);

            Set<Point> curOnLine = null;

            for (Line line : lines) {
                if (line.isOnLine(curP)) {
                    curOnLine = line.points;
                    curOnLine.add(curP);
                    break;
                }
            }

            for (int j = 0; j < i; j++) {
                Point preP = pointList.get(j);
                if (curOnLine == null || !curOnLine.contains(preP)) {
                    lines.add(new Line(curP, preP));
                }
            }
        }

        LOGGER.info("lines = {}", lines);

        return lines.stream().mapToInt(l -> {
            Set<Point> ps = l.points;
            return ps.stream().mapToInt(pointMap::get).sum();
        }).max().getAsInt();
    }

    private static class Line {
        final int x0;
        final int y0;
        final int px;
        final int py;

        Set<Point> points = new HashSet<>(16);


//        public Line(int[] p1, int[] p2) {
//            x0 = p1[0];
//            y0 = p1[1];
//
//            px = p2[0] - x0;
//            py = p2[1] - y0;
//
//            points.add(p1);
//            points.add(p2);
//        }

        public Line(Point p1, Point p2) {
            LOGGER.info("p1 = {}, p2 = {}", p1, p2);
            x0 = p1.x;
            y0 = p1.y;

            px = p2.x - x0;
            py = p2.y - y0;

            points.add(p1);
            points.add(p2);
            LOGGER.info("this = {}", this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Line line = (Line) o;

            for (Point point : line.points) {
                if (!this.isOnLine(point)) return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public String toString() {
            return "Line{" +
                    "x0=" + x0 +
                    ", y0=" + y0 +
                    ", px=" + px +
                    ", py=" + py +
                    ", points=" + points +
                    '}';
        }

        public boolean isOnLine(int[] p) {
            int ppx = p[0] - x0;

            if (px == 0) return ppx == 0;

            int ppy = p[1] - y0;

            if (py == 0) return ppy == 0;

            return ((long) (px)) * ppy == ((long) py) * ppx;

        }

        public boolean isOnLine(Point p) {
            int ppx = p.x - x0;

//            if (px == 0) return ppx == 0;

            int ppy = p.y - y0;

//            if (py == 0) return ppy == 0;

            return ((long) (px)) * ppy == ((long) py) * ppx;

        }
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int[] p) {
            this(p[0], p[1]);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "[" +
                    "" + x +
                    ", " + y +
                    ']';
        }
    }
}
