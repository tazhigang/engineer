package com.ittzg.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Base64;

/**
 * @author: tazhigang
 * @date: 2020/11/10 13:34
 * @Email: tazhigang095@163.com
 * @desc:
 */
public class LoggerHandler implements InvocationHandler {

   static volatile int a = 1;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        System.out.println("before");
        Object invoke = method.invoke(proxy, args);
        System.out.println("after");
        return invoke;
    }


    public static Log getInstance() {
        return (Log) Proxy.newProxyInstance(LoggerHandler.class.getClassLoader(),new Class[]{Log.class},new LoggerHandler());
    }


    public static synchronized void main(String[] args) {

        a ++;
        byte[] decode = Base64.getDecoder().decode("eyJkZXZpY2VfaWQiOiIxMTExMTExMTExIiwiZGV2aWNlX3R5cGUiOiIxIiwic291cmNlX2lwIjoiMC4wLjAuMCIsImFjY291bnRfaWRfaGFzaCI6IjAwMDAwMCIsIm1vYmlsZSI6IjEzMTExMTExMTExIn0=");
        System.out.println(new String(decode));
    }
}
