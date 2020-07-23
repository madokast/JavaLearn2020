package com.zrx.algorithm.leetcode.q0200;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 岛屿数量
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0200岛屿数量 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0200岛屿数量.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.createTwoDimensionsIntArray(
                        '1', '1', '1', '1', '0', null,
                        '1', '1', '0', '1', '0', null,
                        '1', '1', '0', '0', '0', null,
                        '0', '0', '0', '0', '0'
                ), ArrayFactory.createTwoDimensionsIntArray(
                        '1', '1', '0', '0', '0', null,
                        '1', '1', '0', '0', '0', null,
                        '0', '0', '1', '0', '0', null,
                        '0', '0', '0', '1', '1'
                )
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                1, 3
        );
    }

    @Code(info = """
            给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

            岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。

            此外，你可以假设该网格的四条边均被水包围。

             

            示例 1:

            输入:
            [
            ['1','1','1','1','0'],
            ['1','1','0','1','0'],
            ['1','1','0','0','0'],
            ['0','0','0','0','0']
            ]
            输出: 1
            示例 2:

            输入:
            [
            ['1','1','0','0','0'],
            ['1','1','0','0','0'],
            ['0','0','1','0','0'],
            ['0','0','0','1','1']
            ]
            输出: 3
            解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/number-of-islands
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0) return 0;

        UnionFind unionFind = new UnionFind(grid);

        if(unionFind.count==0) return 0;

        int row = grid.length;
        int col = grid[0].length;

        for (int c = 0; c < col; c++) {
            for (int r = 0; r < row; r++) {
                if (grid[r][c] == '1') {
                    int index = c * row + r;
                    if (r < row - 1 && grid[r + 1][c] == '1') {
                        int index2 = c * row + r + 1;
                        unionFind.union(index2, index);
                    }

                    if (c < col - 1 && grid[r][c + 1] == '1') {
                        int index2 = (c + 1) * row + r;
                        unionFind.union(index2, index);
                    }
                }
            }
        }

        return unionFind.count;
    }

    class UnionFind {
        int[] parent;
        int count;

        UnionFind(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;

            int len = row * col;
            count = 0;

            parent = new int[len];

            for (int c = 0; c < col; c++) {
                for (int r = 0; r < row; r++) {
                    int index = c * row + r;
                    parent[index] = index;

                    if (grid[r][c] == '1') {
                        count++;
                    }
                }
            }
        }


        UnionFind(int number) {
            parent = new int[number];
            for (int i = 0; i < number; i++) {
                parent[i] = i;
            }
        }

        int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }

            return p;
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP != rootQ) {
                parent[rootP] = rootQ;
                count--;
            }
        }
    }
}
