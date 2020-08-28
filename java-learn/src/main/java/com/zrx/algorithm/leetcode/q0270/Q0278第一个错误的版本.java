package com.zrx.algorithm.leetcode.q0270;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 第一个错误的版本
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0278第一个错误的版本 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0278第一个错误的版本.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1, true
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                true
        );
    }

    @Code(info = """
            你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。

            假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。

            你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。

            示例:

            给定 n = 5，并且 version = 4 是第一个错误的版本。

            调用 isBadVersion(3) -> false
            调用 isBadVersion(5) -> true
            调用 isBadVersion(4) -> true

            所以，4 是第一个错误的版本。 

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/first-bad-version
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean fun(boolean b) {
        return b;
    }


    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 1;
            int right = n;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (isBadVersion(mid)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }
    }

    public class VersionControl {
        boolean isBadVersion(int version) {


            return version >= 4;
        }
    }
}
