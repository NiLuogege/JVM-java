package com.niluogege.javajvm.instructions.base;


import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;

/**
 * 没有操作数的指令
 */
public class InstructionNoOperands implements Instruction {
    @Override
    public void fetchOperands(BytecodeReader reader) {
        //empty
    }

    @Override
    public void execute(Frame frame) {
        // nothing to do
    }

    protected void _astore(Frame frame, int idx) {
        Object ref = frame.operandStack().popRef();
        frame.localVars().setRef(idx, ref);
    }

    protected void _dstore(Frame frame, int idx) {
        double val = frame.operandStack().popDouble();
        frame.localVars().setDouble(idx, val);
    }

    protected void _fstore(Frame frame, int idx) {
        float val = frame.operandStack().popFloat();
        frame.localVars().setFloat(idx, val);
    }

    /**
     * 操作数栈顶数据 存放到 局部变量表idx 位置
     */
    protected void _istore(Frame frame,int idx){
        int val = frame.operandStack().popInt();
        frame.localVars().setInt(idx,val);
    }

    protected void _lstore(Frame frame, int idx) {
        long val = frame.operandStack().popLong();
        frame.localVars().setLong(idx, val);
    }

    protected void _dcmp(Frame frame, boolean gFlag) {
        OperandStack stack = frame.operandStack();
        double v2 = stack.popDouble();
        double v1 = stack.popDouble();
        if (v1 > v2) {
            stack.pushInt(1);
            return;
        }
        if (v1 == v2) {
            stack.pushInt(0);
            return;
        }
        if (v1 < v2) {
            stack.pushInt(-1);
            return;
        }
        if (gFlag) {
            stack.pushInt(1);
            return;
        }
        stack.pushInt(-1);
    }

    protected void _fcmp(Frame frame, boolean gFlag) {
        OperandStack stack = frame.operandStack();
        double v2 = stack.popFloat();
        double v1 = stack.popFloat();
        if (v1 > v2) {
            stack.pushInt(1);
            return;
        }
        if (v1 == v2) {
            stack.pushInt(0);
            return;
        }
        if (v1 < v2) {
            stack.pushInt(-1);
            return;
        }
        if (gFlag) {
            stack.pushInt(1);
            return;
        }
        stack.pushInt(-1);
    }
}
