public class ArrayList<E> {
    /**
     * 元素的数量
     */
    private int size;
    /**
     * 所有元素
     */
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

    public ArrayList(int capacity) {
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 清除所有元素
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * 获取元素的数量
     */
    public int size() {
        return size;
    }

    /**
     * 返回动态数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 返回数组是否包含某一个元素
     */
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 添加元素到尾部
     */
    public void add(E element) {
        elements[++size] = element;
    }

    /**
     * 获取 index 位置的元素
     */
    public E get(int index) {
        //检查 index 是否合法
        indexCheck(index);
        return elements[index];
    }

    /**
     * 设置 index 位置的元素
     */
    public E set(int index, E element) {
        indexCheck(index);

        E old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 在 index 处插入元素
     */
    public void add(int index, E element) {
        indexCheck(index);
        for(int i=index; i<size; i++) {
            
        }
    }
    
    private void indexCheck(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("数组下表越界 index = " + index + " size: " + size);
        }
    }
}





































