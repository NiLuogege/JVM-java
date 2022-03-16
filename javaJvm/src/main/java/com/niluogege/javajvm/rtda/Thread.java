package com.niluogege.javajvm.rtda;

import com.niluogege.javajvm.rtda.heap.methodarea.Method;

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

    public Frame topFrame(){
        return this.stack.top();
    }

    public Frame newFrame(Method method) {
        return new Frame(this, method);
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getPc() {
        return pc;
    }

    public boolean isStackEmpty(){
        return this.stack.isEmpty();
    }
}
