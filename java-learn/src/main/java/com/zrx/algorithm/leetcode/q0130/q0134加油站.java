package com.zrx.algorithm.leetcode.q0130;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 加油站
 * <pre>
 *     优质答案：背后原理就是a要是到不了b但是能到a和b之间的点，那么a和b之间的所有点都到不了b，所以可以直接从b开始重新计算能到哪
 *
 *     public int canCompleteCircuit(int[] gas, int[] cost) {
 *     int totalCost=0,startIndex=0,startToCurrentCost=0;
 *     for(int i=0;i<gas.length;i++){
 *         //tmpCost表示从当前加油站到达下一个加油站至少需要汽车已有油多少升
 *         int tmpCost=cost[i]-gas[i];
 *         totalCost+=tmpCost;
 *         startToCurrentCost+=tmpCost;
 *
 *         //如果该值大于零，则重置始发站为下一站点，重置startToCurrentCost为0
 *         if (startToCurrentCost > 0) {
 *             startIndex = i + 1;
 *             startToCurrentCost = 0;
 *         }
 *     }
 *     if(totalCost<=0)
 *         return startIndex;
 *     else
 *         return -1;
 * }
 *
 * 作者：wallace4ever
 * 链接：https://leetcode-cn.com/problems/gas-station/solution/gao-xiao-yi-ci-bian-li-si-lu-tong-su-bu-yong-fan-z/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 解题思路
 * 暴力法直接遍历从每个加油站出发，查看能不能行得通，就不赘述了。
 *
 * 个人感觉官方的反证法不是很好理解，下面给出我的思路。考虑从每个加油站出发，要到达下一个加油站至少需要车子已有油多少升。以示例为例：
 *
 *
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * 记tmpCost[i]=cost[i]-gas[i]，那么我们就能得到
 *
 *
 * tmpCost=[2,2,2,-3,-3]
 * 其中负数表示加油站能额外提供给车子的油量，显然当tmpCost的总和小于等于0时有解，否则无解（因为整个过程中车子自己不能变出油来）。在一遍扫描的过程中使用一个变量totalCost存储tmpCost[i]的和就可以了（并不需要建立该O(n)大小的数组，上面的数组只是为了便于说明）。
 *
 * 下面要找到开始出发点，假设出发点为startIndex，当前位置为i，则一旦[startIndex,i]区间中所有的tmpCost之和大于0，说明汽车走不下去了。使用一个变量startToCurrentCost来保存这个值，当汽车走到当前位置走不下去时，重置startIndex为i+1、startToCurrentCost为0。
 *
 * 当最终遍历完，并且totalCost<0时，startIndex就是始发加油站，否则无解返回-1。
 *
 * 作者：wallace4ever
 * 链接：https://leetcode-cn.com/problems/gas-station/solution/gao-xiao-yi-ci-bian-li-si-lu-tong-su-bu-yong-fan-z/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * </pre>
 * <p>
 * Data
 * 2020/6/21-17:20
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class q0134加油站 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(q0134加油站.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                ArrayFactory.create(1, 2, 3, 4, 5), ArrayFactory.create(3, 4, 5, 1, 2),
                ArrayFactory.create(2, 3, 4), ArrayFactory.create(3, 4, 3)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                3, -1
        );
    }

    @Code(info = """
            在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

            你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。

            如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。

            说明: 

            如果题目有解，该答案即为唯一答案。
            输入数组均为非空数组，且长度相同。
            输入数组中的元素均为非负数。
            示例 1:

            输入:\040
            gas  = [1,2,3,4,5]
            cost = [3,4,5,1,2]

            输出: 3

            解释:
            从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
            开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
            开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
            开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
            开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
            开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
            因此，3 可为起始索引。
            示例 2:

            输入:\040
            gas  = [2,3,4]
            cost = [3,4,3]

            输出: -1

            解释:
            你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
            我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
            开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
            开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
            你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
            因此，无论怎样，你都不可能绕环路行驶一周。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/gas-station
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;

        int totalCost = 0;
        int start = 0;
        int remainFromStart = 0;

        for (int i = 0; i < len; i++) {
            int remain = gas[i] - cost[i]; // -2  -2  -2  3  3
            totalCost += remain;

            remainFromStart += remain;
            if (remainFromStart < 0) {
                remainFromStart = 0;
                start = (i + 1) % len;
            }
        }

        if (totalCost < 0) return -1;
        else return start;
    }


    public int canCompleteCircuit暴力搜索(int[] gas, int[] cost) {
        int len = gas.length;

        for (int start = 0; start < len; start++) {
            int curGas = gas[start];
            boolean success = true;
            for (int cur = start; cur < start + len; cur++) {
                LOGGER.info("cur = {}, curGas = {}", cur, curGas);
                if (curGas >= cost[cur % len]) {
                    // 可以走到下一个节点
                    curGas -= cost[cur % len];
                    curGas += gas[(cur + 1) % len];
                } else {
                    success = false;
                    break;
                }
            }
            LOGGER.info("success = {}", success);
            if (success) return start;
        }

        return -1;
    }

}
