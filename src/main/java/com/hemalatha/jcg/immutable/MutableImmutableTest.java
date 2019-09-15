package com.hemalatha.jcg.immutable;

import java.util.concurrent.ConcurrentHashMap;

public class MutableImmutableTest {

    private final ConcurrentHashMap<String,ImmutableLogin> immutableLoginConcurrentHashMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String,MutableLogin> mutableLoginConcurrentHashMap = new ConcurrentHashMap<>();
    public static void main(String[] args) {
          MutableImmutableTest test = new MutableImmutableTest();
          test.changeImmutableLogin();
          test.readImmutableLogin();
    }

    private void changeImmutableLogin(){
        immutableLoginConcurrentHashMap.compute("loginA",(key,immutableLogin) -> {
            return new ImmutableLogin(key,"newPassword");
        });
    }

    private void changeMutableLogin(){
        MutableLogin login = mutableLoginConcurrentHashMap.get("loginA");
        synchronized (login){
            login.setPassword("newPassword");
        }
    }

    private void readImmutableLogin(){
        ImmutableLogin login = immutableLoginConcurrentHashMap.get("loginA");
        System.out.println(login.getPassword());
    }

    private void readMutableLogin(){
        MutableLogin login = mutableLoginConcurrentHashMap.get("loginA");
        synchronized (login) {
            System.out.println(login.getPassword());
        }
    }


}
