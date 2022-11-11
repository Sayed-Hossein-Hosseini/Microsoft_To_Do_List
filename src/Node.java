public class Node <T> {

    private T data ;
    private Node <T> next ;

    public Node (T data , Node <T> next){

        this.data = data ;
        this.next = next ;
    }

    public Node (Node <T> node) {

        data = node.data ;
        next = node.next ;
    }

    public void setData (T data) {

        this.data = data ;
    }

    public void setNext (Node <T> next) {

        this.next = next ;
    }

    public T getData () {

        return data ;
    }

    public Node <T> getNext () {

        return next ;
    }

    public boolean equals (Object obj) {

        if (obj == null)
            return false ;

        if (getClass() != obj.getClass())
            return false ;

        Node test = (Node) obj ;

        return data.equals(test) ;
    }
}