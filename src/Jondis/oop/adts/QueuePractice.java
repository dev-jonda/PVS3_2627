package jondis.oop.adts;

public class QueuePractice {
    public static void main(String[] args) {
        StringQueue queue = new StringQueue();
        queue.enqueue("Test");
        queue.enqueue("Dalsi");
        queue.enqueue("slovo");
        System.out.println(queue.peek());
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("Another");
        System.out.println(queue.peek());
        System.out.println(queue.getSize());

        StringQueue roulette = new StringQueue();
        roulette.enqueue("Týnka");
        roulette.enqueue("Lucka");
        roulette.enqueue("Ema");
        roulette.enqueue("Markéta");
        roulette.enqueue("Kiwi");
        roulette.enqueue("Naty");
        roulette.enqueue("Adéla");
        roulette.enqueue("Linda");

        String onTurn;
        while (roulette.getSize() > 1){
            // ten kdo hraje jde z fronty ven
            onTurn = roulette.dequeue();

            // sance 1/6, PREZIL
            if (Math.random() > 0.16){
                roulette.enqueue(onTurn);
            }
        }
    }
}
