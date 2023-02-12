package io.github.stardustman;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class DynastyTest {
    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        TangDynasty tangDynasty = new TangDynasty();
        InvocationHandler handler = new DynastyDynamicProxy(tangDynasty);

        Dynasty dynasty = (Dynasty) Proxy.newProxyInstance(handler.getClass().getClassLoader(), new Class[]{Dynasty.class},handler);
        System.out.println(dynasty.getClass());
        Arrays.stream(dynasty.getClass().getDeclaredMethods()).forEach(method -> {
            System.out.println(method.getName());
        });
        Arrays.stream(dynasty.getClass().getDeclaredFields()).forEach(field -> {
            System.out.println(field.getName());
        });
        dynasty.founder();
        dynasty.reviver();
        dynasty.lastEmperor();
//        ProxyGenerator
    }
}
