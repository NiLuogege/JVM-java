package com.niluogege.javajvm.instructions.references;

import com.niluogege.javajvm.instructions.base.InstructionIndex16;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;
import com.niluogege.javajvm.rtda.heap.constantpool.FieldRef;
import com.niluogege.javajvm.rtda.heap.constantpool.RunTimeConstantPool;
import com.niluogege.javajvm.rtda.heap.methodarea.Field;
import com.niluogege.javajvm.rtda.heap.methodarea.Method;
import com.niluogege.javajvm.rtda.heap.methodarea.Slots;
import com.niluogege.javajvm.rtda.heap.methodarea.Class;

/**
 * 为指定静态变量复制
 */
public class PUT_STATIC extends InstructionIndex16 {

    @Override
    public void execute(Frame frame) {
        Method currentMethod = frame.method();
        Class currentClazz = currentMethod.clazz();
        RunTimeConstantPool runTimeConstantPool = currentClazz.constantPool();
        FieldRef fieldRef = (FieldRef) runTimeConstantPool.getConstants(this.idx);
        Field field = fieldRef.resolvedField();
        Class clazz = field.clazz();

        String descriptor = field.descriptor();
        int slotId = field.slotId();
        Slots slots = clazz.staticVars();
        OperandStack stack = frame.operandStack();
        switch (descriptor.substring(0, 1)) {
            case "Z":
            case "B":
            case "C":
            case "S":
            case "I":
                slots.setInt(slotId, stack.popInt());
                break;
            case "F":
                slots.setFloat(slotId, stack.popFloat());
                break;
            case "J":
                slots.setLong(slotId, stack.popLong());
                break;
            case "D":
                slots.setDouble(slotId, stack.popDouble());
                break;
            case "L":
            case "[":
                slots.setRef(slotId, stack.popRef());
                break;
            default:
                break;
        }
    }

}
