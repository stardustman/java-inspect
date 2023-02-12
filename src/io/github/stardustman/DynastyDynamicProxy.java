package io.github.stardustman;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynastyDynamicProxy implements InvocationHandler {

    private Object delegate;
    public DynastyDynamicProxy(Object originalDynamic){
        this.delegate = originalDynamic;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("公元 618 年唐朝建立!");
        String res = (String) method.invoke(delegate,args);
        System.out.println(method.getName() + " of Tang Dynasty was " + res + "!");
        System.out.println("公元 907 年唐朝灭亡!\n");
        return res;
    }
}
