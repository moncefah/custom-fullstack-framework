package com.example.framework;

import com.example.framework.app.service.UserService;
import com.example.framework.corecontainer.context.Context;
import com.example.framework.corecontainer.core.Core;
import com.sun.source.tree.CompilationUnitTree;

import java.util.ArrayList;
import java.util.List;


public class Main{
    public static void main() {
        Core core = new Core();
        Context context = new Context();
        UserService userService = new UserService();
        core.luncher(null);
    }
}


