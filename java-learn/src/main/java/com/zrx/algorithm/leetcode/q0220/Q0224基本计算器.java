package com.zrx.algorithm.leetcode.q0220;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description
 * 基本计算器
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0224基本计算器 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0224基本计算器.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                "1 + 1",
                " 2-1 + 2 ",
                "(1+(4+5+2)-3)+(6+8)",
                "(1+1)"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                2,3,23,2
        );
    }

    @Code(info = """
            实现一个基本的计算器来计算一个简单的字符串表达式的值。

            字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。

            示例 1:

            输入: "1 + 1"
            输出: 2
            示例 2:

            输入: " 2-1 + 2 "
            输出: 3
            示例 3:

            输入: "(1+(4+5+2)-3)+(6+8)"
            输出: 23
            说明：

            你可以假设所给定的表达式都是有效的。
            请不要使用内置的库函数 eval。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/basic-calculator
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int calculate(String s) {
        return (int) calculate((Deque<Character>) s.chars().mapToObj(i -> (char) i).collect(Collectors.toCollection(LinkedList::new)));
    }

    public long calculate(Deque<Character> exp) {
        long num = 0L;
        char preSign = '+';
        Deque<Long> stack = new LinkedList<>();



        while (!exp.isEmpty()) {
            char c = exp.pollFirst();

            switch (c){
                case '(' : num = calculate(exp); break;
                case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
                    num+=num*10+c-'0'; break;
                case ')' : break;
                case '+' : case '-' : case '*' : case '/':
                    switch (preSign){
                        case '+': stack.push(num); break;
                        case '-': stack.push(-num);break;
                        case '*': stack.push(stack.pop()*num);break;
                        case '/': stack.push(stack.pop()/num);break;
                    }
                    preSign = c; num = 0;
            }

        }

        switch (preSign){
            case '+': stack.push(num); break;
            case '-': stack.push(-num);break;
            case '*': stack.push(stack.pop()*num);break;
            case '/': stack.push(stack.pop()/num);break;
        }


        long sum = stack.stream().mapToLong(Long::longValue).sum();
        LOGGER.info("sum = {}", sum);
        return sum;
    }
}

/* 纯 + - 法，无括号的处理器
int calculate(string s) {
    stack<int> stk;
    // 记录算式中的数字
    int num = 0;
    // 记录 num 前的符号，初始化为 +
    char sign = '+';
    for (int i = 0; i < s.size(); i++) {
        char c = s[i];
        // 如果是数字，连续读取到 num
        if (isdigit(c))
            num = 10 * num + (c - '0');
        // 如果不是数字，就是遇到了下一个符号，
        // 之前的数字和符号就要存进栈中
        if (!isdigit(c) || i == s.size() - 1) {
            switch (sign) { // 这里的符号是旧符号
                case '+':
                    stk.push(num); break;
                case '-':
                    stk.push(-num); break;
            }
            // 更新符号为当前符号，数字清零
            sign = c;
            num = 0;
        }
    }
    // 将栈中所有结果求和就是答案
    int res = 0;
    while (!stk.empty()) {
        res += stk.top();
        stk.pop();
    }
    return res;
}

作者：labuladong
链接：https://leetcode-cn.com/problems/basic-calculator-ii/solution/chai-jie-fu-za-wen-ti-shi-xian-yi-ge-wan-zheng-ji-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

/* 纯 + - * / 无括号处理器
for (int i = 0; i < s.size(); i++) {
    char c = s[i];
    if (isdigit(c))
        num = 10 * num + (c - '0');

    if (!isdigit(c) || i == s.size() - 1) {
        switch (sign) {
            int pre;
            case '+':
                stk.push(num); break;
            case '-':
                stk.push(-num); break;
            // 只要拿出前一个数字做对应运算即可
            case '*':
                pre = stk.top();
                stk.pop();
                stk.push(pre * num);
                break;
            case '/':
                pre = stk.top();
                stk.pop();
                stk.push(pre / num);
                break;
        }
        // 更新符号为当前符号，数字清零
        sign = c;
        num = 0;
    }
}

作者：labuladong
链接：https://leetcode-cn.com/problems/basic-calculator-ii/solution/chai-jie-fu-za-wen-ti-shi-xian-yi-ge-wan-zheng-ji-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

/*
纯 + - * / 无括号处理器 py版
def calculate(s: str) -> int:

    def helper(s: List) -> int:
        stack = []
        sign = '+'
        num = 0

        while len(s) > 0:
            c = s.pop(0)
            if c.isdigit():
                num = 10 * num + int(c)

            if (not c.isdigit() and c != ' ') or len(s) == 0:
                if sign == '+':
                    stack.append(num)
                elif sign == '-':
                    stack.append(-num)
                elif sign == '*':
                    stack[-1] = stack[-1] * num
                elif sign == '/':
                    # python 除法向 0 取整的写法
                    stack[-1] = int(stack[-1] / float(num))
                num = 0
                sign = c

        return sum(stack)
    # 需要把字符串转成列表方便操作
    return helper(list(s))

作者：labuladong
链接：https://leetcode-cn.com/problems/basic-calculator-ii/solution/chai-jie-fu-za-wen-ti-shi-xian-yi-ge-wan-zheng-ji-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
* */

/*
带括号版本
def calculate(s: str) -> int:

    def helper(s: List) -> int:
        stack = []
        sign = '+'
        num = 0

        while len(s) > 0:
            c = s.pop(0)
            if c.isdigit():
                num = 10 * num + int(c)
            # 遇到左括号开始递归计算 num
            if c == '(':
                num = helper(s)

            if (not c.isdigit() and c != ' ') or len(s) == 0:
                if sign == '+': ...
                elif sign == '-': ...
                elif sign == '*': ...
                elif sign == '/': ...
                num = 0
                sign = c
            # 遇到右括号返回递归结果
            if c == ')': break
        return sum(stack)

    return helper(list(s))

作者：labuladong
链接：https://leetcode-cn.com/problems/basic-calculator-ii/solution/chai-jie-fu-za-wen-ti-shi-xian-yi-ge-wan-zheng-ji-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
