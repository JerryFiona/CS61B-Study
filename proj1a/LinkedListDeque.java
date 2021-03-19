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
    private TNode pointer;
    private int size;

    public LinkedListDeque(){
        sentinel = new TNode();
        pointer = sentinel;
        size = 0;
    }
    public void addFirst(T item){
        sentinel.next = new TNode(sentinel, item, sentinel.prev);
        size += 1;
    }
    public void addLast(T item){
        sentinel.prev = new TNode(sentinel.next, item, sentinel);
        size += 1;
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
        if(sentinel.next != null){
            TNode p = sentinel;
            p = p.next;
            T a = p.item;
            sentinel.next = p.next;
            p.prev = sentinel;
            p = null;
            size -= 1;
            return a;

        }
        return null;

    }
    public T removeLast(){
        if(sentinel.prev != null){
            TNode p = sentinel;
            p = p.prev;
            T a = p.item;
            sentinel.prev = p.prev;
            p.next = sentinel;
            p = null;
            size -= 1;
            return a;
        }
        return null;

    }
    public T get(int index){
        TNode p = sentinel;
        int i = 0;
        while (p.next != null){
            if(i == index){
                return p.next.item;
            }
            p = p.next;
            i += 1;
        }
        return null;

    }
    public T getRecursive(int index){
         if(sentinel.next == null || index > size-1){
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
