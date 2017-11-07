import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/11/07.
 */
public class SpaceStack {
    Object[] data;

    int maxSize;

    //栈顶位置
    int top;

    public SpaceStack(int maxSize) {
        this.maxSize = maxSize;
        data = new Object[maxSize];
        top = -1;
    }

    /**
     * 获取堆栈长度
     * @return 堆栈长度
     */
    public int getSize()
    {
        return maxSize;
    }

    /**
     * 返回栈中元素的个数
     * @return 栈中元素的个数
     */
    public int getElementCount()
    {
        return top;
    }

    /**
     * 判断栈空
     * @return 栈空
     */
    public boolean isEmpty()
    {
        return top == -1;
    }

    /**
     * 判断栈满
     * @return 栈满
     */
    public boolean isFull()
    {
        return top+1 == maxSize;
    }

    /**
     * 依次加入数据
     * @param data 要加入的数据通信
     * @return 添加是否成功
     */
    public boolean push(Object data) {
        if(isFull())
        {
            System.out.println("栈已满!");
            return false;
        }
        this.data[++top] = data;
        return true;
    }

    /**
     * 从栈中取出数据
     * @return 取出的数据
     */
    public Object pop() throws Exception{
        if(isEmpty())
        {
            throw new Exception("栈已空!");
        }
        return this.data[top--];
    }

    /**
     * 返回栈顶元素
     * @return
     */
    public Object peek()
    {
        return this.data[getElementCount()];
    }

}
