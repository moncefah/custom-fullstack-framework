package com.example.framework.corecontainer.core;

import com.example.framework.corecontainer.context.Context;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.util.*;
import java.util.stream.Collectors;

public class Core {

    public Map<Class<?>, Object> beansBluePrint;
    private Set<Class<?>> classes;

    public void luncher(Context context){
        this.classes = getListOfAllClasses();
        List<Annotation[]> x =  classes.stream()
                                        .map(Class::getAnnotations)
                                        .toList();
    }


    // work with a map for now cuz our Beans are singeloton only
    private Map<Class<?>, Object> createBeansBluePrint(Set<Class> listOfClasses){

        return null;
    }
    private Set<Class<?>> getListOfAllClasses(){
        Set<Class<?>> classes = new HashSet<>();
        Package[] pa = Package.getPackages();
        for (Package p : pa) {
            if (p.getName().contains("com.example.framework")) {
                classes.addAll(getListOfClassesFromPackage(p.getName()));
            }
        }

        return classes;
    }

    private Set getListOfClassesFromPackage(String packageName) {
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

    private void printAnnotations(Class<?> clazz){
            Arrays.stream(clazz.getAnnotations()).forEach(item -> {
                String objectString = item.toString();
                System.out.println("Item details: " + objectString);
            });
    }

}
