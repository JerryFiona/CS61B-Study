public class ArrayDeque<T> {
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
        if (nextFirst < nextLast) {
            System.arraycopy(items, nextFirst + 1, a, 0, size - nextFirst - 1);
            System.arraycopy(items, 0, a, size - nextFirst - 1, nextFirst + 1);
        } else {
            System.arraycopy(items, 0, a, 0, size);
        }
        nextFirst = a.length - 1;
        nextLast = size;
        items = a;
    }

    public void addFirst(T item) {
        items[nextFirst] = item;
        size += 1;
        nextFirst = nextFirst - 1;
        if (nextFirst < 0) {
            nextFirst = nextFirst + items.length;
        }
        if (size == items.length) {
            resizeLarge(size * 2);
        }


    }
    public void addLast(T item) {
        items[nextLast] = item;
        size += 1;
        nextLast += 1;
        if (nextLast >= items.length) {
            nextLast = nextLast - items.length;
        }
        if (size == items.length) {
            resizeLarge(size * 2);
        }

    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }

        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i += 1) {
            System.out.println(items[i] + " ");
        }
    }

    private void resizeSmall(int capacity) {
        T[] a = (T[]) new Object[capacity];
        if (nextFirst < nextLast) {
            System.arraycopy(items, nextFirst + 1, a, 0, size);
        } else {
            System.arraycopy(items, nextFirst + 1, a, 0, size - nextFirst - 1);
            System.arraycopy(items, 0, a, size - nextFirst - 1, nextLast + 1);
        }
        nextFirst = a.length - 1;
        nextLast = size;
        items = a;

    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            size = size - 1;
            nextFirst = nextFirst + 1;
            if (nextFirst > items.length - 1) {
                nextFirst = nextFirst - items.length;
            }
            T a = items[nextFirst];
            double R = (double) size / items.length;
            if ((items.length > 16) && (R < 0.25)) {
                resizeSmall(items.length / 2);
            }
            return a;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            size = size - 1;
            nextLast = nextLast - 1;
            if (nextLast < 0) {
                nextLast = nextLast + items.length;
            }
            T a = items[nextLast];
            double R = (double) size / items.length;
            if ((items.length > 16) && (R < 0.25)) {
                resizeSmall(items.length / 2);
            }
            return a;
        }
    }

    public T get(int index) {
        if (index >= size) {
            return  null;
        } else {
            int p = index + nextFirst + 1;
            if (p < items.length) {
                return items[p];
            } else {
                p = p - items.length;
                return items[p];
            }
        }
    }
}
