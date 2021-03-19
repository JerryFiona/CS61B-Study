public class LinkedListDeque <T> {
    private class TNode{
        public TNode prev;
        public T item;
        public TNode next;

        //public TNode(){}
        public TNode(TNode m, T i, TNode n){
            prev = m;
            item = i;
            next = n;
        }
    }

    private TNode sentinel;
    private int size;

    public LinkedListDeque(){
        size = 0;
        sentinel = new TNode(null, (T)"null", null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;

    }
    public void addFirst(T item){
        /**while(sentinel == null){
            sentinel = new TNode(sentinel, item, sentinel);
        }*/

        sentinel.next = new TNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;


        size = size+1;
    }
    public void addLast(T item){
        /**
        while(sentinel == null){
            sentinel = new TNode(sentinel, item, sentinel);
        }*/

        sentinel.prev = new TNode(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;


        size = size + 1;
    }

    public boolean isEmpty(){
        if (size == 0 )
            return true;
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        TNode p = sentinel;

        while(p.next != null){
            System.out.print(p.next.item + " ");
            p = p.next;

        }

    }
    public T removeFirst(){
        if(size != 0){

            T a = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size = size-1;
            return a;
        }
        return null;

    }
    public T removeLast(){
        if(size != 0){
            T a = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size = size-1;
            return a;
        }
        return null;

    }
    public T get(int index){
        TNode p = sentinel;
        int i = 0;
        while (size != 0){
            p = p.next;
            if(i == index){
                return p.item;
            }
            i += 1;
        }
        return null;

    }
    public T getRecursive(int index){
         if(index < 0 || size == 0 || index > size-1){
             return null;
        }
         return getHelp(sentinel.next, index);
    }
    private T getHelp(TNode m, int n){
        if (n == 0){
            return m.item;
        }
        return getHelp(m.next, n-1);
    }
}
