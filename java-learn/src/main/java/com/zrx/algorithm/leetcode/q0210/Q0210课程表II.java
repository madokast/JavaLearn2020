package com.zrx.algorithm.leetcode.q0210;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * Q0210课程表II
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0210课程表II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0210课程表II.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                2, ArrayFactory.createTwoDimensionsIntArray(1, 0),
                4, ArrayFactory.createTwoDimensionsIntArray(1, 0, null, 2, 0, null, 3, 1, null, 3, 2)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                ArrayFactory.create(0, 1),
                ArrayFactory.create(0, 1, 2, 3)
        );
    }

    @Code(info = """
            现在你总共有 n 门课需要选，记为 0 到 n-1。

            在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]

            给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。

            可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。

            示例 1:

            输入: 2, [[1,0]]\040
            输出: [0,1]
            解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
            示例 2:

            输入: 4, [[1,0],[2,0],[3,1],[3,2]]
            输出: [0,1,2,3] or [0,2,1,3]
            解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
                 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
            说明:

            输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
            你可以假定输入的先决条件中没有重复的边。
            提示:

            这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
            通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
            拓扑排序也可以通过 BFS 完成。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/course-schedule-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    @SuppressWarnings("unchecked")
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        stack = new LinkedList<>();

        map = new ArrayList[numCourses];

        colors = new int[numCourses];

        whiteNode = new LinkedList<Integer>();

        for (int i = 0; i < numCourses; i++) {
            whiteNode.add(i);
        }

        for (int[] p : prerequisites) {
            int s = p[0];
            int e = p[1];

            if (map[s] == null) {
                map[s] = new ArrayList<>();
            }

            map[s].add(e);
        }

        while (valid && (!whiteNode.isEmpty())) {
            Integer remove = whiteNode.remove(0);
            dps(remove);
        }

        if (valid) {
            int i = numCourses;
            for (Integer s : stack) {
                i--;
                colors[i] = s;
            }
            return colors;
        } else
            return new int[]{};


    }

    static final int WHITE = 0;

    static final int GREY = 1;

    static final int BLACK = 2;

    Deque<Integer> stack;

    boolean valid = true;

    ArrayList<Integer>[] map;

    int[] colors;

    List<Integer> whiteNode;

    void dps(int u) { // 0
        if (!valid) return;

        colors[u] = GREY;

        if (map[u] != null) {
            for (Integer v : map[u]) {
                switch (colors[v]) {
                    case WHITE:
                        dps(v);
                        if (!valid) return;
                        break;
                    case GREY:
                        valid = false;
                        return;
                    //case BLACK:
                    //    continue;
                }
            }
        }


        colors[u] = BLACK;
        stack.push(u);
        whiteNode.remove((Integer) u);
    }
}
