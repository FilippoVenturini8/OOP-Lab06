package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
    	final int ELEMS_TO_WRITE = 100_000;
    	final int ELEMS_TO_READ = 1000;
    	final int TO_MS = 1_000_000;
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        /*
         * 8) Compute the population of the world
         */
    	final long AFRICA_POPULATION = 1_110_635_000L;
    	final long AMERICAS_POPULATION = 972_005_000L;
        final long ANTARCTICA_POPULATION = 0L;
        final long ASIA_POPULATION = 4_298_723_000L;
        final long EUROPE_POPULATION = 742_452_000L;
        final long OCEANIA_POPULATION = 38_304_000L;
        
    	List <Integer> arrayList = new ArrayList <>();
    	for(int i = 1000; i < 2000; i++) {
    		arrayList.add(i);
    	}
    	
    	List <Integer> linkedList = new LinkedList <>(arrayList);
    	
    	Integer tmp = arrayList.get(arrayList.size() - 1); //Save the last element
    	arrayList.set(arrayList.size() - 1, arrayList.get(0)); //Add the first element to the last position
    	arrayList.set(0, tmp); //Add the last element to the first position
    	
    	for(Integer i : arrayList) {
    		System.out.println(i);
    	}
    	
    	//Measuring time for insert elements in arrayList
    	long time = System.nanoTime();
        for (int i = 0; i < ELEMS_TO_WRITE; i++) {
        	arrayList.add(0, i);
        }
        time = System.nanoTime() - time;
        System.out.println(
            "Inserting " + ELEMS_TO_WRITE + " elements as first in an ArrayList took "
            + time + " NS | " + time / TO_MS + " MS "
        );
        
      //Measuring time for insert elements in LinkedList
    	time = System.nanoTime();
        for (int i = 0; i < ELEMS_TO_WRITE; i++) {
        	linkedList.add(0, i);
        }
        time = System.nanoTime() - time;
        System.out.println(
            "Inserting " + ELEMS_TO_WRITE + " elements as first in an LinkedList took "
            + time + " NS | " + time / TO_MS + " MS "
        );
        
      //Measuring time for read elements in arrayList
    	time = System.nanoTime();
        for (int i = 0; i < ELEMS_TO_READ; i++) {
        	arrayList.get(linkedList.size()/2);
        }
        time = System.nanoTime() - time;
        System.out.println(
            "Reading " + ELEMS_TO_READ + " times element in the middle of arrayList took "
            + time + " NS | " + time / TO_MS + " MS "
        );
        
      //Measuring time for read elements in LinkedList
    	time = System.nanoTime();
        for (int i = 0; i < ELEMS_TO_READ; i++) {
        	linkedList.get(linkedList.size()/2);
        }
        time = System.nanoTime() - time;
        System.out.println(
            "Reading " + ELEMS_TO_READ + " times element in the middle of LinkedList took "
            + time + " NS | " + time / TO_MS + " MS "
        );
        
        Map<String, Long> world = new HashMap <>();
        world.put("Africa", AFRICA_POPULATION);
        world.put("Americas", AMERICAS_POPULATION);
        world.put("Antartica", ANTARCTICA_POPULATION);
        world.put("Asia", ASIA_POPULATION);
        world.put("Europe", EUROPE_POPULATION);
        world.put("Oceania", OCEANIA_POPULATION);
        
        Long worldPopulation = 0L;
        for(String name : world.keySet()) {
        	worldPopulation += world.get(name);
        }
        
        System.out.println("World population: " + worldPopulation);
    }
}
