public class LinkedListDeque<T> {
    private class TNode{
        public TNode prev;
        public T item;
        public TNode next;

        public TNode(){
        }
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
            sentinel = new TNode();

    }
    public void addFirst(T item){
        while(sentinel == null){
            sentinel.item = item;
            sentinel.next = sentinel;
            sentinel.prev = sentinel;

        }
        sentinel.next= new TNode(sentinel, item, sentinel.next);
        size = size+1;
    }
    public void addLast(T item){
        while(sentinel == null){
            sentinel.item = item;
            sentinel.next = sentinel;
            sentinel.prev = sentinel;

        }
        sentinel.prev = new TNode(sentinel.prev, item, sentinel);
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
            TNode p = sentinel.next;
            T a = p.item;
            sentinel.next = p.next;
            p.prev = sentinel;
            size = size-1;
            p = null;
            return a;
        }
        return null;

    }
    public T removeLast(){
        if(size != 0){
            TNode p = sentinel.prev;
            T a = p.item;
            sentinel.prev = p.prev;
            p.next = sentinel;
            size = size-1;
            p = null;
            return a;
        }
        return null;

    }
    public T get(int index){
        TNode p = sentinel;
        int i = 0;
        while (size != 0){
            if(i == index){
                return p.next.item;
            }
            p = p.next;
            i += 1;
        }
        return null;

    }
    public T getRecursive(int index){
         if(size == 0 || index > size-1){
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
