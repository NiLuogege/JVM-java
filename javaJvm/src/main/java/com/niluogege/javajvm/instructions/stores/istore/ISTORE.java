package com.niluogege.javajvm.instructions.stores.istore;

import com.niluogege.javajvm.instructions.base.InstructionIndex8;
import com.niluogege.javajvm.rtda.Frame;

/**
 * 把操作数栈中的idx对应下标的数 存到 本地变量表中
 */
public class ISTORE extends InstructionIndex8 {
    @Override
    public void execute(Frame frame) {
        _istore(frame,idx);
    }
}
