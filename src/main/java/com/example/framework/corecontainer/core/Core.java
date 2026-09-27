package com.example.framework.corecontainer.core;

import com.example.framework.corecontainer.annotations.Component;
import com.example.framework.corecontainer.context.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Core {

    private Map<Class<?>, Object> beansBluePrint;

    public void luncher(Context context){
        IO.println("The core is starting ..");
        this.beansBluePrint = createBeansBluePrint();
        context.instantiate(beansBluePrint);

    }
    // work with a map for now cuz our Beans are singeloton only
    private Map<Class<?>, Object> createBeansBluePrint(){

        return null;
    }
    private Object getListOfClasses(String packageName){
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }

    private Object getClass(String line, String packageName) {
        return null;
    }

    private boolean hasCycle(){

        return true;
    }


}
