package com.niluogege.javajvm.rtda;

import com.niluogege.javajvm.rtda.heap.methodarea.Method;
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

    private Method method;

    public Frame(Thread thread, Method method) {
        this.thread = thread;
        this.method = method;//当前方法
        this.localVars = new LocalVars(method.maxLocals);
        this.operandStack = new OperandStack(method.maxStack);
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
