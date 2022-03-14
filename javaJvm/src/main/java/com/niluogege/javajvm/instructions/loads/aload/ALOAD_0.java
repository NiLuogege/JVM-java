package com.niluogege.javajvm.instructions.loads.aload;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.heap.methodarea.Object;
public class ALOAD_0 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Object ref = frame.localVars().getRef(0);
        frame.operandStack().pushRef(ref);
    }

}
