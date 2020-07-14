package com.zrx.algorithm.leetcode.q0170;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.ToString;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Description
 * 地下城游戏
 * <p>
 * Data
 * 2020/7/6-9:22
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0174地下城游戏 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0174地下城游戏.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.createTwoDimensionsIntArray(
                        -2, -3, 3, null,
                        -5, -10, 1, null,
                        10, 30, -5
                ), ArrayFactory.createTwoDimensionsIntArray(
                        1, -3, 3, null,
                        0, -2, 0, null,
                        -3, -3, -3
                )
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(7, 3);
    }

    @Code(info = """
            一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。

            骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。

            有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。

            为了尽快到达公主，骑士决定每次只向右或向下移动一步。

             

            编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。

            例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。

            -2 (K)	-3	3
            -5	-10	1
            10	30	-5 (P)
             

            说明:

            骑士的健康点数没有上限。

            任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/dungeon-game
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int calculateMinimumHP(int[][] dungeon) {
        int r = dungeon.length;
        int c = dungeon[0].length;
        int[][] dp = new int[r][c];
        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                int d = dungeon[i][j];
                Integer down = i == r - 1 ? null : dp[i + 1][j];
                Integer right = j == c - 1 ? null : dp[i][j + 1];

                int min;
                if (down == null) min = right == null ? 1 : right;
                else min = right == null ? down : Math.min(down, right);

                dp[i][j] = Math.max(min - d, 1);
            }
        }


        LOGGER.info("dp = {}", ToString.arrayToFormatString(dp));

        return Math.max(dp[0][0], 1);
    }


    public int calculateMinimumHP从起点走是不行的(int[][] dungeon) {
        int r = dungeon.length;
        int c = dungeon[0].length;
        int[][] needHealth = new int[r][c];
        int[][] curHealth = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int d = dungeon[i][j];

                if (i == 0) {
                    if (j == 0) {
                        int need = 1 - d;
                        needHealth[i][j] = need <= 0 ? 1 : need;
                        curHealth[i][j] = needHealth[i][j] + d;
                    } else {
                        int needLeft = needHealth[i][j - 1];
                        int curLeft = curHealth[i][j - 1];

                        int cur = curLeft + d;
                        if (cur <= 0) {
                            needHealth[i][j] = needLeft + (1 - cur);
                            curHealth[i][j] = 1;
                        } else {
                            needHealth[i][j] = needLeft;
                            curHealth[i][j] = cur;
                        }
                    }
                } else {
                    if (j == 0) {
                        int needUp = needHealth[i - 1][j];
                        int curUp = curHealth[i - 1][j];

                        int cur = curUp + d;
                        if (cur <= 0) {
                            needHealth[i][j] = needUp + (1 - cur);
                            curHealth[i][j] = 1;
                        } else {
                            needHealth[i][j] = needUp;
                            curHealth[i][j] = cur;
                        }
                    } else {
                        int needLeft = needHealth[i][j - 1];
                        int curLeft = curHealth[i][j - 1];

                        int needUp = needHealth[i - 1][j];
                        int curUp = curHealth[i - 1][j];

                        int needHealth1;
                        int curHealth1;

                        int needHealth2;
                        int curHealth2;

                        int cur1 = curLeft + d;
                        if (cur1 <= 0) {
                            needHealth1 = needLeft + (1 - cur1);
                            curHealth1 = 1;
                        } else {
                            needHealth1 = needLeft;
                            curHealth1 = cur1;
                        }

                        int cur2 = curUp + d;
                        if (cur2 <= 0) {
                            needHealth2 = needUp + (1 - cur2);
                            curHealth2 = 1;
                        } else {
                            needHealth2 = needUp;
                            curHealth2 = cur2;
                        }

                        if (needHealth1 <= needHealth2) {
                            needHealth[i][j] = needHealth1;
                            curHealth[i][j] = curHealth1;
                        } else {
                            needHealth[i][j] = needHealth2;
                            curHealth[i][j] = curHealth2;
                        }
                    }
                }
            }
        }

        LOGGER.info("curHealth = {}", ToString.arrayToFormatString(curHealth));

        LOGGER.info("needHealth = {}", ToString.arrayToFormatString(needHealth));


        return needHealth[r - 1][c - 1];
    }
}
