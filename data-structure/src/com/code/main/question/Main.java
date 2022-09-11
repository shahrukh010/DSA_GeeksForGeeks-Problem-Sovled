import com.queue.Queue;
import com.queue.ArrayQueue;
import com.queue.QueueList;

/***..
   *QueueList is Concret class which is extends to Abstract class
   *which is noting a partial implementation of Interface..............
   *QueueList is also implementation of Interface................
   */


public class Main extends QueueList  {

    public Main(int cap){

        super(cap);
    }


    public static void main(String...Box){

    Queue queue = new QueueList(5);
    queue.enqueue(6);
    queue.enqueue(8);
    queue.enqueue(9);
    queue.enqueue(5);
    queue.enqueue(1);
    System.out.println(queue);
//  queue.size = 100;//not allowd because  of interface variabe 
                     //default is public static final
    //System.out.println(queue);
 //   System.out.println(queue.getSize());

/***
      System.out.println(queue.deQueue());
      System.out.println(queue.deQueue());
      System.out.println(queue.deQueue());
      System.out.println(queue.deQueue());
      System.out.println(queue.deQueue());
      System.out.println(queue.deQueue());
*/

        
//   Queue list = new QueueList();
//   System.out.println(queue);

/***
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
*/

     //   System.out.println(list);
      //  list.remove();



    }
}
