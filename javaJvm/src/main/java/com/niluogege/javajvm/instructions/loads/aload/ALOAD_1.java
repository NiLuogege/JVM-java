package com.niluogege.javajvm.instructions.loads.aload;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.heap.methodarea.Object;
//将第二个引用类型本地变量推送至栈顶
public class ALOAD_1 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Object ref = frame.localVars().getRef(1);
        frame.operandStack().pushRef(ref);
    }

}
