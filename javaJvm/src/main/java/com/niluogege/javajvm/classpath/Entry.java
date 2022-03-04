package com.niluogege.javajvm.classpath;

import com.niluogege.javajvm.classpath.impl.CompositeEntry;
import com.niluogege.javajvm.classpath.impl.DirEntry;
import com.niluogege.javajvm.classpath.impl.WildcardEntry;
import com.niluogege.javajvm.classpath.impl.ZipEntry;

import java.io.File;
import java.io.IOException;

/**
 * http://www.itstack.org
 * create by fuzhengwei on 2019/4/24
 * 类路径接口
 */
public interface Entry {

    byte[] readClass(String className) throws IOException;

    static Entry create(String path) {

        //File.pathSeparator；路径分隔符(win\linux)
        if (path.contains(File.pathSeparator)) {
            return new CompositeEntry(path);
        }

        if (path.endsWith("*")) {
            return new WildcardEntry(path);
        }

        if (path.endsWith(".jar") || path.endsWith(".JAR") ||
                path.endsWith(".zip") || path.endsWith(".ZIP")) {
            return new ZipEntry(path);
        }

        return new DirEntry(path);
    }

}
