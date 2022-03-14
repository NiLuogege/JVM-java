package com.niluogege.javajvm.instructions.comparisons.if_acmp;


import com.niluogege.javajvm.instructions.base.Instruction;
import com.niluogege.javajvm.instructions.base.InstructionBranch;
import com.niluogege.javajvm.rtda.Frame;

/**
 * 比较两个引用类型数值，当结果相等时跳转
 */
public class IF_ACMPEQ extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        if (_acmp(frame)) {
            Instruction.branch(frame, this.offset);
        }
    }

}
