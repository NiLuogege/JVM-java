package com.niluogege.javajvm.instructions.references;

import com.niluogege.javajvm.instructions.base.InstructionIndex16;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;
import com.niluogege.javajvm.rtda.heap.constantpool.FieldRef;
import com.niluogege.javajvm.rtda.heap.constantpool.RunTimeConstantPool;
import com.niluogege.javajvm.rtda.heap.methodarea.Field;
import com.niluogege.javajvm.rtda.heap.methodarea.Slots;
import com.niluogege.javajvm.rtda.heap.methodarea.Class;

/**
 * 获取指定类的静态字段，并将其压入栈顶
 */
public class GET_STATIC extends InstructionIndex16 {
    @Override
    public void execute(Frame frame) {
        //获取到运行时常量池
        RunTimeConstantPool runTimeConstantPool = frame.method().clazz().constantPool();
        //找到对应 ConstantInfo 因为是个demo 所以直接 强转为 FieldRef
        FieldRef ref = (FieldRef) runTimeConstantPool.getConstants(this.idx);
        Field field = ref.resolvedField();
        if (!field.isStatic()){
            throw new IncompatibleClassChangeError();
        }
        Class clazz = field.clazz();
        String descriptor = field.descriptor();

//       System.out.println 的 descriptor 是 Ljava/io/PrintStream;
//        System.out.println("GET_STATIC descriptor = "+descriptor);

        int slotId = field.slotId();
        Slots slots = clazz.staticVars();
        OperandStack stack = frame.operandStack();
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
