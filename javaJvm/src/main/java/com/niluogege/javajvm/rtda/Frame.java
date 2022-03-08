package com.niluogege.javajvm.rtda;

import org.springframework.cglib.core.Local;

/**
 * 栈帧：里面要有 局部变量表 和 操作数栈
 */
public class Frame {

    //栈帧是一个链表，当前栈帧指向下一个栈帧
    Frame lower;

    //局部变量表
    private LocalVars localVars;

    //操作数栈
    private OperandStack operandStack;

    //当前线程
    private Thread thread;

    public Frame(Thread thread, int maxLocal, int maxStack) {
        this.thread = thread;
        this.localVars = new LocalVars(maxLocal);
        this.operandStack = new OperandStack(maxStack);
    }

    public LocalVars getLocalVars() {
        return localVars;
    }

    public OperandStack getOperandStack() {
        return operandStack;
    }

    public Thread getThread() {
        return thread;
    }
}
