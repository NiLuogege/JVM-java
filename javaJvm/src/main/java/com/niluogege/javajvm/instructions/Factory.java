package com.niluogege.javajvm.instructions;

import com.niluogege.javajvm.instructions.base.Instruction;
import com.niluogege.javajvm.instructions.constants.consts.ICONST_1;
import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import com.sun.org.apache.bcel.internal.generic.NOP;

/**
 * 指令工厂
 */
public class Factory {

    public static Instruction newInstruction(byte opcode) {

        switch (opcode){
            case 0x00:
//                return new NOP();
            case 0x01:
//                return new ACONST_NULL();
//            case 0x02:
//                return new ICONST_M1();
//            case 0x03:
//                return new ICONST_0();
            case 0x04:
                return new ICONST_1();

            default:
                return null;
        }
    }
}
