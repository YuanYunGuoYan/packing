
/**
 * Created by Administrator on 2017/11/07.
 */

//SpaceStack表示剩余空间堆栈
public class SpaceStack {
    /**
     * 栈的最大深度
     **/
    protected int MAX_DEPTH = 100000;

    /**
     * 栈的当前深度
     */
    protected int depth = 0;

    /**
     * 实际的栈
     */
    protected Container[] stack = new Container[MAX_DEPTH];

    /**
     * push，向栈中添加一个元素
     *
     * @param n 待添加的元素
     */
    protected void push(Container n) {
        if (depth == MAX_DEPTH - 1) {
            throw new RuntimeException("栈已满，无法再添加元素。");
        }
        stack[depth++] = n;
    }

    /**
     * pop，返回栈顶元素并从栈中删除
     *
     * @return 栈顶元素
     */
    protected Container pop() {
        if (depth == 0) {
            throw new RuntimeException("栈中元素已经被取完，无法再取。");
        }
        Container result = stack[--depth];
        stack[depth] = null;
        return result;
    }

    /**
     * peek，返回栈顶元素但不从栈中删除
     *
     * @return
     */
    protected Container peek() {
        if (depth == 0) {
            throw new RuntimeException("栈中元素已经被取完，无法再取。");
        }
        return stack[depth - 1];
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return stack.toString();
    }

    /**
     * 判断栈空
     */
    public boolean isEmpty() {
        return this.depth == 0;
    }

    /**
     * 判断栈溢
     */
    public boolean isFull() {
        return this.depth + 1 == this.MAX_DEPTH;
    }

}
