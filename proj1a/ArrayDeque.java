public class ArrayDeque <T>{
    T[] items;
    int size;
    int nextFirst;
    int nextLast;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 7;
        nextLast = 0;
    }
    private void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items,0,a,0,size);
        items = a;
        nextFirst = items.length-1;
    }
    public void addFirst(T item){
        if (size==items.length){
           resize(size*2);
        }
        items[nextFirst]=item;
        size+=1;
        nextFirst-=1;
    }
    public void addLast(T item){
        if (size==items.length){
            resize(size*2);
        }
        items[nextLast]=item;
        size+=1;
        nextLast+=1;


    }
    public boolean isEmpty(){
        if(items == null)
            return true;
        return false;

    }
    public int size(){
        return size;

    }
    public void printDeque(){
        for(int i = 0; i < size; i+=1){
            System.out.print(items[i]+" ");
        }

    }
    public T removeFirst(){
        double R = (double) size/items.length;
        if (R < 0.25 >) {
            resize(size/2);
        }
        size-=1;
        nextFirst+=1;
        return items[nextFirst];
    }
    public T removeLast(){
        double R = (double) size/items.length;
        if (R < 0.25 >) {
            resize(size/2);
        }
        size-=1;
        nextLast-=1;
        return items[nextLast];
    }
    public T get(int index){
        return items[index];
    }

}
