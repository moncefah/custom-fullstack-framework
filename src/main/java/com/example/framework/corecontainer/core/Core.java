package com.example.framework.corecontainer.core;

import com.example.framework.corecontainer.annotations.Component;
import com.example.framework.corecontainer.context.Context;
import com.sun.source.tree.CompilationUnitTree;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Core {

    private Map<Class<?>, Object> beansBluePrint;

    public void luncher(Context context){
        IO.println("The core is starting ..");
        Set<Class> classes = getListOfAllClasses();
        IO.println(classes);
      //  this.beansBluePrint = createBeansBluePrint(classes);
        //context.instantiate(beansBluePrint);

    }
    // work with a map for now cuz our Beans are singeloton only
    private Map<Class<?>, Object> createBeansBluePrint(Set<Class> listOfClasses){

        return null;
    }
    private Set<Class> getListOfAllClasses(){
        Set<Class> classes = new HashSet<>();
        Package[] pa = Package.getPackages();
        for (int i = 0; i < pa.length; i++) {

            Package p = pa[i];

            if (p.getName().contains("com.example.framework")){
                classes.addAll(getListOfClassesFromPackage(p.getName()))  ;
            }



        }

        return classes;
    }

    private Set<Class> getListOfClassesFromPackage(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }

    private Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }

    private boolean hasCycle(){

        return true;
    }

}
