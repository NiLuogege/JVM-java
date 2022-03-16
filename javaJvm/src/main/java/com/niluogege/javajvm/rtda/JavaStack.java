package com.niluogege.javajvm.rtda;

/**
 * java虚拟机栈：里面要有 栈帧
 */
public class JavaStack {

    //栈最大容量
    private int maxSize;

    //当前容量
    private int size;

    //栈帧（头部）
    private Frame _top;

    public JavaStack(int maxSize) {
        this.maxSize = maxSize;
    }

    //压栈
    public void push(Frame frame) {

        if (size >= maxSize) {
            throw new StackOverflowError();
        }

        if (_top != null) {
            frame.lower = _top;
        }

        _top = frame;
        size++;
    }

    //弹栈
    public Frame pop() {
        if (_top == null) {
            throw new RuntimeException("java stack is empty!");
        }

        //拿到栈顶帧
        Frame top = _top;
        //切换栈顶帧
        _top = top.lower;
        //切掉引用
        top.lower = null;

        size--;

        return top;
    }

    public Frame top() {
        if (this._top == null) {
            throw new RuntimeException("jvm stack is empty!");
        }
        return this._top;
    }

    public boolean isEmpty(){
        return this._top == null;
    }
}
