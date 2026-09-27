package com.example.framework;

import com.example.framework.corecontainer.core.Core;

import java.util.ArrayList;
import java.util.List;


public class Main{
    public static void main() {
        // i want to have the list of all classes that are found in the package ("xyz")
        var c = Integer.class;
        IO.println(c.getClass());
    }
    public List<Class<?>> getAllClassesByPackageName(String packagePath){

        return null;
    }
}


