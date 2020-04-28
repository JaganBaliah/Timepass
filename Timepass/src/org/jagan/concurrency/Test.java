package org.jagan.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test implements Runnable {

	//Using normal list will end up overwriting some elements
	//static List<Integer> ls = new ArrayList<Integer>();

	//Using synchronized list will make sure only one thread access the list at any given time
	static List<Integer> ls = Collections.synchronizedList(new ArrayList<Integer>());

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Test());
        Thread t2 = new Thread(new Test());
        long ms1 = System.currentTimeMillis();
        
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        long ms2 = System.currentTimeMillis();
        long ms = ms2 - ms1;
        System.out.println(ls.size());
        /*
        for (int i = 0; i < ls.size(); ++i) {
            System.out.println(i + "  " + ls.get(i));
        }
        */
        System.out.println("Time taken : " + (ms));        
    }

    @Override
    public synchronized void run() {
        try {
            for (int i = 0; i < 1000; ++i) {
                ls.add(i);
                Thread.sleep(5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}