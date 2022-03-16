package com.niluogege.javajvm.instructions.references;

import com.niluogege.javajvm.instructions.base.ClassInitLogic;
import com.niluogege.javajvm.instructions.base.InstructionIndex16;
import com.niluogege.javajvm.instructions.base.MethodInvokeLogic;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.heap.constantpool.MethodRef;
import com.niluogege.javajvm.rtda.heap.constantpool.RunTimeConstantPool;
import com.niluogege.javajvm.rtda.heap.methodarea.Class;
import com.niluogege.javajvm.rtda.heap.methodarea.Method;

/**
 * invokestatic调用static方法
 */
public class INVOKE_STATIC extends InstructionIndex16 {
    @Override
    public void execute(Frame frame) {
        //拿到运行时常量池
        RunTimeConstantPool runTimeConstantPool = frame.method().clazz.runTimeConstantPool;
        //找到目标 MethodRef
        MethodRef methodRef = (MethodRef) runTimeConstantPool.getConstants(idx);
        //转换为 Method
        Method resolvedMethod = methodRef.ResolvedMethod();

        //这里没有实现 非静态方法的调用
        if (!resolvedMethod.isStatic()) {
            throw new IncompatibleClassChangeError();
        }

        Class clazz = resolvedMethod.clazz;
        if (!clazz.initStarted()) {
            frame.revertNextPC();
            ClassInitLogic.initClass(frame.thread(), clazz);
            return;
        }

        MethodInvokeLogic.invokeMethod(frame, resolvedMethod);
    }
}
