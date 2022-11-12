public class LinkedList <T> {

    private Node <T> head = null ;
    private Node <T> tail = null ;

    private Node <T> help = null ;
    private int size = 0 ;

    public LinkedList () {}

    public int getSize () {

        return size ;
    }

    public Node <T> getHead () {

        return head ;
    }

    public boolean isEmpty () {

        return size == 0 ;
    }

    public T first () {

        if (isEmpty())
            return  null ;

        return head.getData() ;
    }

    public T last () {

        if (isEmpty())
            return  null ;

        return tail.getData() ;
    }

    public void addFirst (T element) {

        head = new Node<>(element , head) ;

        if (size == 0)
            tail = head ;

        size ++ ;
    }

    public void addLast (T element) {

        Node <T> newest = new Node<>(element , head) ;

        if (isEmpty()) {

            head = newest ;
        } else {

            tail.setNext(newest);
        }

        tail = newest ;

        size++ ;
    }

    public T removeFirst () {

        if (isEmpty())
            return null ;

        T element = head.getData() ;

        head = head.getNext() ;

        size-- ;

        if (size == 0)
            tail = null ;

        return element ;
    }

    public Node <T> search (T element) {

        if (size == 0)
            return null ;

        int i = 1 ;

        Node <T> test = head ;
        Node <T> testP = null ;

        while (true) {

            if (test.getData().equals(element)) {

                help = testP ;

                System.out.println("size : " + i);

                return test;
            }

            if (test.getNext() != head) {

                testP = test;

                test = test.getNext();
            } else {

                return null ;
            }

            i++ ;
        }
    }

    public boolean changeHead (Node <T> test) {

        if (help.getNext() == test){

            head = test ;

            tail = help ;

            return true ;
        }

        return false ;
    }

    public boolean equals (Object obj) {

        if (obj == null)
            return false ;

        if (getClass() != obj.getClass())
            return false ;

        LinkedList <T> test = (LinkedList <T>) obj ;

        if (test.getSize() != getSize())
            return false ;

        Node <T> Q = search(test.head.getData()) ;
        Node <T> W = test.head ;

        if (Q.getData().equals(W.getData())) {

            while (Q.getNext() != head){

                Q = Q.getNext() ;
                W = W.getNext() ;

                if (!(Q.getData().equals(W.getData())))
                    return false ;
            }

            return true ;
        }

        return false ;
    }

    public void traverse() {
        if (this.isEmpty() == true)
            System.out.println("There is not any steps!");
        else {
            int count = 1;
            Node<T> q = this.head;
            while (count <= this.size) {
                System.out.println("Step" + count + ":" + q.getData());
                q = q.getNext();
                count++;
            }
        }
    }
}