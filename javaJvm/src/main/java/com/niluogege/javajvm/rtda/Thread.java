package com.niluogege.javajvm.rtda;

/**
 * 线程 ： 线程中要有 java虚拟机栈 和 寄存器
 */
public class Thread {

    //pc 寄存器
    private int pc;

    //java 栈
    private JavaStack stack;

    public Thread() {
        this.stack = new JavaStack(1024);
    }

    //压栈
    public void pushFrame(Frame frame) {
        stack.push(frame);
    }

    //弹栈
    public Frame popFrame() {
        return stack.pop();
    }

    public Frame currentFrame() {
        return this.stack.top();
    }


    public Frame newFrame(int maxLocal, int maxStack) {
        return new Frame(this, maxLocal, maxStack);
    }

}
