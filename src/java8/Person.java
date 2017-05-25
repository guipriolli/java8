/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

/**
 *
 * @author Guibl
 */
public class Person {
    
    private String name;

    public Person() {
    }
    
    public Person(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public static void say() {
        System.out.println("A person is saying...");
    }
    
    public static void walk(String str) {
        System.out.println("A person is walking... " + str);
    }
}
