package oop.adts;

public class StringQueue {
    QueueLink first, last;

    //je vubec kontruktor treba?
    //slusne ano, neni nutne

    void enqueue(String toAdd){
        //2 varianty, fronta uz neco ma, nebo je prazdna
        QueueLink link = new QueueLink();
        link.data = toAdd;

        //pripad 1, fronta je prazdna
        if (first == null){
            first = link;
        } else { //pripad 2: ve fronte uz nekdo je
            last.next = link;
        }
        last = link;
    }

    String dequeue(){
        if (first == null){
            return null;
        }
        String toReturn = first.data;
        first = first.next;
        return toReturn;
    }


} class QueueLink{
    String data;
    QueueLink next;
}
