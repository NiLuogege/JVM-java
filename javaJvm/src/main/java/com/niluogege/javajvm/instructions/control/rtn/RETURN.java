package com.niluogege.javajvm.instructions.control.rtn;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;

/**
 * http://www.itstack.org
 * create by fuzhengwei on 2019/4/27
 */
public class RETURN extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        frame.thread().popFrame();
    }
    
}
