package com.niluogege.javajvm.instructions.loads.aload;

import com.niluogege.javajvm.instructions.base.InstructionIndex8;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.heap.methodarea.Object;

/**
 * 从本地变量表中  获取 idx 位置上的引用
 */
public class ALOAD extends InstructionIndex8 {
    @Override
    public void execute(Frame frame) {
        Object ref = frame.localVars().getRef(idx);
        frame.operandStack().pushRef(ref);
    }
}
