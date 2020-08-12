package com.zrx.algorithm.leetcode.q0200;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * 课程表
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0207课程表 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0207课程表.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                2, ArrayFactory.createTwoDimensionsIntArray(1, 0),
                2, ArrayFactory.createTwoDimensionsIntArray(1, 0, null, 0, 1)

        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                true, false
        );
    }

    @Code(info = """
            你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。

            在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]

            给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？

             

            示例 1:

            输入: 2, [[1,0]]\040
            输出: true
            解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
            示例 2:

            输入: 2, [[1,0],[0,1]]
            输出: false
            解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
             

            提示：

            输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
            你可以假定输入的先决条件中没有重复的边。
            1 <= numCourses <= 10^5

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/course-schedule
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean canFinish(int numCourses, int[][] prerequisites){
        if (prerequisites == null || prerequisites.length == 0) return true;

        int len = prerequisites.length;

        Map<Integer, List<Integer>> map = new HashMap<>(len);

        int[] pointEnterNum = new int[numCourses];

        List<Integer> zeroEnterNumIndices = new LinkedList<>();

        for (int[] prerequisite : prerequisites) {
            int s = prerequisite[0];
            int e = prerequisite[1];
            List<Integer> list = map.getOrDefault(s, new ArrayList<>());
            list.add(e);
            map.put(s, list);

            pointEnterNum[e]++;
        }

        for (int i = 0; i < pointEnterNum.length; i++) {
            int s = pointEnterNum[i];
            if(s==0){
                zeroEnterNumIndices.add(i); // index
            }
        }

        while (!zeroEnterNumIndices.isEmpty()){
            Integer sIndex = zeroEnterNumIndices.remove(0);

            List<Integer> kList = map.get(sIndex);
            if (kList != null) {
                for (Integer ks : kList) {
                    pointEnterNum[ks]--;
                    if(pointEnterNum[ks]==0){
                        zeroEnterNumIndices.add(ks);
                    }
                }

                map.remove(sIndex);
            }
        }

        return map.isEmpty();
    }



    public boolean canFinish垃圾(int numCourses, int[][] prerequisites) {
        // 0 1 2 3 ... numCourses
        // [[1,0],[0,1]]
        // 1-0
        // 0-1

        if (prerequisites == null || prerequisites.length == 0) return true;

        int len = prerequisites.length;

        Map<Integer, List<Integer>> map = new HashMap<>(len);

        int[] pointEnterNum = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int s = prerequisite[0];
            int e = prerequisite[1];
            List<Integer> list = map.getOrDefault(s, new ArrayList<>());
            list.add(e);
            map.put(s, list);

            pointEnterNum[e]++;
        }

        for (; ; ) {
            /*
             * 三种情况
             * map empty 直接返回 true
             *
             * pointEnterNum 全 -1 返回 true
             *
             * pointEnterNum 没有 0 了
             *      返回 mao 是不是空
             *
             * pointEnterNum 还有 0 ，则取出，调整 map
             */

            int k = -1;
            for (int i = 0; i < pointEnterNum.length; i++) {
                if (pointEnterNum[i] == 0) {
                    k = i;
                    break;
                }
            }

            LOGGER.info("k = {}", k);
            LOGGER.info("map = {}", map);

            if (k == -1) return map.isEmpty();

            pointEnterNum[k] = -1;

            List<Integer> kList = map.get(k);
            if (kList != null) {
                for (Integer ks : kList) {
                    pointEnterNum[ks]--;
                }

                map.remove(k);
            }
        }
    }


}
