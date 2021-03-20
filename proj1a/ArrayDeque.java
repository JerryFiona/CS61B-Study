public class ArrayDeque<T>{
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    private void resizeLarge(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addFirst(T item) {
        if (size == items.length) {
           resizeLarge(size*2);
        }
        if ((nextFirst < 0) && (size < items.length)) {
            nextFirst = nextFirst + items.length;
        }
        items[nextFirst] = item;
        size += 1;
        nextFirst -= 1;

    }
    public void addLast(T item){
        if (size == items.length) {
            resizeLarge(size*2);
        }
        if ((nextLast > items.length - 1) && (size < items.length)) {
            nextLast = nextLast - items.length;
        }
        items[nextLast] = item;
        size += 1;
        nextLast += 1;
    }

    public boolean isEmpty() {
        if(size == 0)
            return true;
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for(int i = 0; i < size; i += 1) {
            System.out.print(items[i] + " ");
        }
    }

    private void resizeSmall(int capacity) {
        T[] a = (T[]) new Object[capacity];
        if (nextFirst < nextLast) {
            System.arraycopy(items, nextFirst + 1, a, 0, size);
            nextFirst = a.length - 1;
            nextLast = size;
            items = a;
        }
        if (nextFirst > nextLast) {
            System.arraycopy(items, nextFirst + 1, a, 0, size - nextFirst - 1 );
            System.arraycopy(items, 0, a, size - nextFirst - 1 , nextLast);
            nextFirst = a.length - 1;
            nextLast = size;
            items = a;
        }

    }

    public T removeFirst() {
        if (items.length > 16) {
            double R = (double) size/items.length;
            if (R < 0.25) {
                resizeSmall(items.length/2);
            }
        }
        size -= 1;
        nextFirst += 1;
        if (nextFirst > items.length -1) {
            nextFirst = nextFirst - items.length;
        }
        return items[nextFirst];
    }

    public T removeLast() {
        if (items.length > 16) {
            double R = (double) size/items.length;
            if (R < 0.25 ) {
                resizeSmall(items.length/2);
            }
        }
        size -= 1;
        nextLast -= 1;
        if (nextLast < 0) {
            nextLast = nextLast + items.length;
        }
        return items[nextLast];
    }

    public T get(int index){
        return items[index];
    }
}
