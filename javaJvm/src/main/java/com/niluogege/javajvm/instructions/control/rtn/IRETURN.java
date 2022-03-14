package com.niluogege.javajvm.instructions.control.rtn;

import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.Thread;
import com.niluogege.javajvm.instructions.base.InstructionNoOperands;

/**
 * http://www.itstack.org
 * create by fuzhengwei on 2019/4/27
 */
public class IRETURN extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Thread thread = frame.thread();
        Frame currentFrame = thread.popFrame();
        Frame invokerFrame = thread.topFrame();
        int val = currentFrame.operandStack().popInt();
        invokerFrame.operandStack().pushInt(val);
    }

}
