package com.niluogege.javajvm.instructions.references;

import com.niluogege.javajvm.instructions.base.InstructionIndex16;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;
import com.niluogege.javajvm.rtda.heap.constantpool.FieldRef;
import com.niluogege.javajvm.rtda.heap.constantpool.RunTimeConstantPool;
import com.niluogege.javajvm.rtda.heap.methodarea.Field;
import com.niluogege.javajvm.rtda.heap.methodarea.Slots;
import com.niluogege.javajvm.rtda.heap.methodarea.Object;

public class GET_FIELD extends InstructionIndex16 {

    @Override
    public void execute(Frame frame) {
        RunTimeConstantPool runTimeConstantPool = frame.method().clazz().constantPool();
        FieldRef fieldRef = (FieldRef) runTimeConstantPool.getConstants(this.idx);
        Field field = fieldRef.resolvedField();

        OperandStack stack = frame.operandStack();
        Object ref = stack.popRef();
        if (null == ref) {
            throw new NullPointerException();
        }
        String descriptor = field.descriptor();
        int slotId = field.slotId();
        Slots slots = ref.fields();

        switch (descriptor.substring(0, 1)) {
            case "Z":
            case "B":
            case "C":
            case "S":
            case "I":
                stack.pushInt(slots.getInt(slotId));
                break;
            case "F":
                stack.pushFloat(slots.getFloat(slotId));
                break;
            case "J":
                stack.pushLong(slots.getLong(slotId));
                break;
            case "D":
                stack.pushDouble(slots.getDouble(slotId));
                break;
            case "L":
            case "[":
                stack.pushRef(slots.getRef(slotId));
                break;
            default:
                break;
        }
    }

}