package com.niluogege.javajvm.rtda.heap.constantpool;

import com.niluogege.javajvm.classfile.constantpool.impl.ConstantFieldRefInfo;
import com.niluogege.javajvm.rtda.heap.methodarea.Class;
import com.niluogege.javajvm.rtda.heap.methodarea.Field;

public class FieldRef extends MemberRef{
    private Field field;

    public static FieldRef newFieldRef(RunTimeConstantPool runTimeConstantPool, ConstantFieldRefInfo refInfo){
        FieldRef ref = new FieldRef();
        ref.runTimeConstantPool=runTimeConstantPool;
        ref.copyMemberRefInfo(refInfo);
        return ref;
    }

    public Field resolvedField(){
        if (null == field){
            try {
                resolvedFieldRef();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return field;
    }

    private void resolvedFieldRef() throws NoSuchFieldException {
        Class d = runTimeConstantPool.getClazz();
        Class c = resolvedClass();

        Field field = lookupField(c,name,descriptor);
        if (null==field){
            throw new NoSuchFieldException();
        }

        if (!field.isAccessibleTo(d)){
            throw new IllegalAccessError();
        }

        this.field = field;
    }

    /**
     * 找到目标方法
     */
    private Field lookupField(Class c, String name, String descriptor) {
        for (Field f : c.fields) {

            if (f.name.equals(name) && field.descriptor.equals(descriptor)){
                return field;
            }
        }

        for (Class iface : c.interfaces) {
            Field field = lookupField(iface, name, descriptor);
            if (null != field) return field;
        }

        if (c.superClass != null) {
            return lookupField(c.superClass, name, descriptor);
        }

        return null;

    }

}
