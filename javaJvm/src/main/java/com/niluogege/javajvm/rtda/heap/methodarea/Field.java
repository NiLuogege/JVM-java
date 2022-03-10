package com.niluogege.javajvm.rtda.heap.methodarea;

import com.niluogege.javajvm.classfile.MemberInfo;
import com.niluogege.javajvm.classfile.attributes.impl.ConstantValueAttribute;
import com.niluogege.javajvm.rtda.heap.constantpool.AccessFlags;

public class Field extends ClassMember{
    public int constValueIndex;
    public int slotId;

    public Field[] newFields(Class clazz, MemberInfo[] cfFields){
        Field[] fields = new Field[cfFields.length];
        for (int i = 0; i < cfFields.length; i++) {
            Field field = new Field();
            field.clazz=clazz;
            field.copyMemberInfo(cfFields[i]);
            field.copyAttributes(cfFields[i]);
            fields[i]=field;
        }
        return fields;
    }

    public void copyAttributes(MemberInfo cfField) {
        ConstantValueAttribute valAttr = cfField.ConstantValueAttribute();
        if (null != valAttr) {
            this.constValueIndex = valAttr.constantValueIdx();
        }
    }

    public boolean isVolatile() {
        return 0 != (this.accessFlags & AccessFlags.ACC_VOLATILE);
    }

    public boolean isTransient() {
        return 0 != (this.accessFlags & AccessFlags.ACC_TRANSIENT);
    }

    public boolean isEnum() {
        return 0 != (this.accessFlags & AccessFlags.ACC_ENUM);
    }

    public int constValueIndex() {
        return this.constValueIndex;
    }

    public int slotId() {
        return this.slotId;
    }

    public boolean isLongOrDouble() {
        return this.descriptor.equals("J") || this.descriptor.equals("D");
    }

}
