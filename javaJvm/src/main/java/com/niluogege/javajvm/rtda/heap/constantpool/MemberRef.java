package com.niluogege.javajvm.rtda.heap.constantpool;

import com.niluogege.javajvm.classfile.constantpool.impl.ConstantMemberRefInfo;

import java.util.Map;

public class MemberRef extends SymRef{
    public String name;
    public String descriptor;

    public void copyMemberRefInfo(ConstantMemberRefInfo refInfo){
        className=refInfo.className();
        Map<String, String> map = refInfo.nameAndDescriptor();
        name=map.get("name");
        descriptor=map.get("_type");
    }

    public String name(){
        return this.name;
    }

    public String descriptor(){
        return this.descriptor;
    }
}
