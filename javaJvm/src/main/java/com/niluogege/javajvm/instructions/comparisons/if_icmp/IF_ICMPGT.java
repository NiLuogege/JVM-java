package com.niluogege.javajvm.instructions.comparisons.if_icmp;

import com.niluogege.javajvm.instructions.base.Instruction;
import com.niluogege.javajvm.instructions.base.InstructionBranch;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;

/**
 * 比较栈顶两个 int 数大小，当前者大于后者时跳转
 */
public class IF_ICMPGT extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int val2 = stack.popInt();
        int val1 = stack.popInt();

//        System.out.println("IF_ICMPGT 前者= "+val2 +" 后者="+val1);

        if (val1 > val2) {
            Instruction.branch(frame, this.offset);
        }
    }

}