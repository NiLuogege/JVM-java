package com.niluogege.javajvm.instructions.base;

import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.Slot;
import com.niluogege.javajvm.rtda.Thread;
import com.niluogege.javajvm.rtda.heap.methodarea.Method;

/**
 * 静态方法调用逻辑
 */
public class MethodInvokeLogic {
    public static void invokeMethod(Frame invokerFrame, Method method) {
        Thread thread = invokerFrame.thread();

        //生成一个新的 栈帧进行方法执行，这里再次验证了 一个方法对应一个栈帧
        Frame newFrame = thread.newFrame(method);
        //栈帧放到线程里
        thread.pushFrame(newFrame);

        //方法调用需要吧 上一个栈帧操作数栈的数据 倒到下一个栈帧的局部变量表里
        int argSlotCount = method.argSlotCount();
        if (argSlotCount > 0) {
            for (int i = argSlotCount - 1; i >= 0; i--) {
                Slot slot = invokerFrame.operandStack().popSlot();
                newFrame.localVars().setSlot(i,slot);
            }
        }

        //hack
        if (method.isNative()) {
            if ("registerNatives".equals(method.name())) {
                thread.popFrame();
            } else {
                throw new RuntimeException("native method " + method.name());
            }
        }
    }
}
