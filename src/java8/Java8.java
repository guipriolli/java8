/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.time.Instant;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 *
 * @author Guibl
 */
public class Java8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("***** LAMBDA EXAMPLE *****");
        System.out.println();
        System.out.println("-- THREAD --");
        System.out.println();
        
        //Java 7
        Runnable run = new Runnable() {
            public void run() {
                System.out.println("Thread normal");
            }
        };
        new Thread(run).start();
        
        //Lambda
        Runnable run1 = () -> System.out.println("Thread com Lambda");
        new Thread(run1).start();
        
        //Lambda simplificado
        new Thread(() -> System.out.println("Thread com Lambda simplificado")).start();
        
        Thread.sleep(200);
        
        System.out.println();
        System.out.println("-- ARRAY --");
        System.out.println();
        
        List<String> strs = Arrays.asList("José", "Alberto", "João", "Pedro");
        
        //Java 7
        for (String str : strs) {
            System.out.println(str);
        }
        
        System.out.println();
        //Lambda
        strs.forEach(str -> System.out.println(str));
        
        System.out.println();
        //Lambda com filtro
        List<String> result = strs.stream().filter(str -> str.startsWith("Jo")).collect(Collectors.toList());
        result.forEach(System.out::println);
        
        System.out.println();
        System.out.println("-- CLASSE --");
        
        //Java 7
        Person.say();
        System.out.println();
        
        //Lambda
        result.forEach(str -> Person.say());
        System.out.println();
        
        //Lambda
        result.forEach(Person::walk);
        System.out.println();
        
        System.out.println("-- INTERFACE --");
        
        //Java 7
        MyInterface myInterface = new MyInterface() {
            @Override
            public void print() {
                System.out.println("Java 7 implementation - Function Interface");
            }
        };
        myInterface.print();
        
        //Java 8
        MyInterface myI = () -> {
            System.out.println("Java 8 implementation - Function Interface");
        };
        myI.print();
        System.out.println();
        
        MyInterface2 myI2 = (String s) -> {
            System.out.println("Java 8 implementation - Function Interface - " + s);
        };
        
        result.forEach(myI2::print);
        
        System.out.println();
        System.out.println("-- STREAM --");
        
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,0);
        List<Integer> filteredNumbers = numbers.stream().filter(number -> number > 5).collect(Collectors.toList());
        filteredNumbers.forEach(System.out::println);
        
        System.out.println();
        
        List<Integer> filteredNumbers2 = numbers.stream().sorted().collect(Collectors.toList());
        filteredNumbers2.forEach(System.out::println);
        
        System.out.println();
        
        List<String> texts = Arrays.asList("a","b","","c","");
        List<String> filteredText = texts.stream().filter(text -> text != "").collect(Collectors.toList());
        filteredText.forEach(System.out::println);
        
        System.out.println();
        System.out.println("-- RANDOM --");
        
        Random hash = new Random();
        hash.doubles().limit(2).forEach(System.out::println);
        
        System.out.println();
        System.out.println("-- OPTIONAL --");
        
        List<Person> people = new ArrayList<Person>();
        
        Person person1 = new Person("Guilherme");
        Person person2 = new Person(null);
        
        people.add(person1);
        people.add(person2);
        
        Optional<Person> op = Optional.of(person1);
        op.ifPresent(p -> System.out.println(p.getName()));
        
        Optional<String> op2 = Optional.ofNullable(person2.getName());
        op2.ifPresent(System.out::println);
        
        System.out.println();
        System.out.println("-- DATA TIME --");
        
        Instant now = Instant.now();
        System.out.println(now);
        
        Thread.sleep(3000);
        Instant now2 = Instant.now();
        
        Duration dur = Duration.between(now, now2);
        System.out.println(dur.getSeconds());
        
        System.out.println();
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        
        LocalDate birthday = LocalDate.of(1991, 11, 20);
        LocalDate birthday2 = LocalDate.of(2017, 3, 17);
        
        Period period = Period.between(birthday, birthday2);
        
        System.out.printf("%s %s %s", period.getYears(), period.getMonths(), period.getDays());
        System.out.println();
        System.out.println();
        System.out.println("-- NASHORN JavaScript Engine --");
        System.out.println();
        
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
        
        try {
            nashorn.eval("print('Hello World from Nashorn!'");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
