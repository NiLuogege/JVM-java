package com.niluogege.javajvm;

import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.Thread;
import com.niluogege.javajvm.rtda.heap.methodarea.Method;

/**
 * 解析器
 */
public class Interpret {

    public Interpret(Method method) {
        Thread thread = new Thread();
        Frame frame = thread.newFrame(method);
        thread.pushFrame(frame);
        loop(thread,method.code);
    }

    private void loop(Thread thread, byte[] code) {
        //一个方法一个frame,同一个方法里的frame是共享的
        Frame frame = thread.popFrame();

    }
}
