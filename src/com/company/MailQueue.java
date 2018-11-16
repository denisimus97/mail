package com.company;
import java.util.PriorityQueue;
public class MailQueue {
    private PriorityQueue<Human> queue;

    public MailQueue() {
        queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.isPensioner() && !o2.isPensioner()) {
                return -1;
            } else if (o1.isPensioner() && o2.isPensioner()){
                return 0;
            }

            return 1;
        });
    }

    public void offer(Human human) {
        queue.add(human);
    }

    public Human peek() {
        return queue.peek();
    }

    public Human pool() {
        return queue.poll();
    }
}

class Human {
    private String name;
    private int age;
    private static int PENSIONER_AGE = 65;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean isPensioner() {
        return age > PENSIONER_AGE;
    }

    public String getName() {
        return this.name;
    }
}
