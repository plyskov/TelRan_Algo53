package lesson03_20230522;

import java.util.ArrayDeque;
import java.util.Stack;

public class SpecialStack {
    private Stack<Integer> values;
    private Stack<Integer> minimums;

    public SpecialStack() {
        values = new Stack<>();
        minimums = new Stack<>();
    }

    public void push(Integer element) {
        values.push(element);
        if (minimums.empty()) {
            minimums.push(element);
        } else {
            minimums.push(Math.min(element, minimums.peek()));
        }
    }

    public Integer pop() {
        minimums.pop();
        return values.pop();
    }


}
