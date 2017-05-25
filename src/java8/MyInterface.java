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
@FunctionalInterface
public interface MyInterface {
    
    void print();
    
    default void body(){
        System.out.println("This is my interface function body");
    }
}
