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
        sentinel = new TNode();
        size = 0;
    }
    public void addFirst(T item){
        sentinel.next = new TNode(sentinel, item, sentinel.next);
        size += 1;
    }
    public void addLast(T item){
        sentinel.prev = new TNode(sentinel.prev, item, sentinel);
        size += 1;
    }
    public boolean isEmpty(){
        if (sentinel.next == null && sentinel.prev == null)
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
            p.next.prev = sentinel;
            p = null;
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
            p.prev.next = sentinel;
            p = null;
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
