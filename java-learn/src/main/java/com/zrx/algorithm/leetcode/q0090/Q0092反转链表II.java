package com.zrx.algorithm.leetcode.q0090;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.ListNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 反转链表 II
 * <p>
 * Data
 * 2020/6/6-16:28
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0092反转链表II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0092反转链表II.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                3,
                ListNode.of("1->2->3->4->5"), 2, 4
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                ListNode.of("1->4->3->2->5")
        );
    }

    @Code(info = """
            反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

            说明:
            1 ≤ m ≤ n ≤ 链表长度。

            示例:

            输入: 1->2->3->4->5->NULL, m = 2, n = 4
            输出: 1->4->3->2->5->NULL

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode preHead = new ListNode(0);
        preHead.next = head;

        ListNode startPre = null;
        ListNode start = null;

        ListNode pre = preHead;
        ListNode cur = head;
        ListNode next = null;

        while (true) {
            next = cur.next;

            if (m == 1) {
                startPre = pre;
                start = cur;
                //LOGGER.info("startPre = {}", startPre);
                //LOGGER.info("start = {}", start);
            }

            if (m < 1) {
                cur.next = pre;
            }

            if (n == 1) {
                startPre.next = cur;
                start.next = next;
                break;
            }

            pre = cur;
            cur = next;

            m--;
            n--;
        }


        return preHead.next;
    }
}
