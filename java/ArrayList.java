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
     * 在 index 处插入元素  1, 2, 3   size: 3  add(1, 1)
     */
    public void add(int index, E element) {
        indexCheckForAdd(index);
        for(int i=size; i>index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
    }

    /**
     * 检查当前是否有 capacity 的容量
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if(oldCapacity >= capacity) return;

        //容量不够了，扩容。oldCapacity 右移一位表示除以 2
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];

        //为什么不直接使用 oldCapacity 来进行 for 循环
        for(int i=0; i<oldCapacity; i++) {
            newElements[i] = elements[i];
        }
        System.out.println("数组扩容，" + oldCapacity + " 扩容为 " + newCapacity );
    }
    
    private void indexCheck(int index) {
        //todo: 这里为什么是 index >= size
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数组下表越界 index = " + index + " size: " + size);
        }
    }

    /**
     * 检查添加元素时的索引是否合法
     */
    private void indexCheckForAdd(int index) {
        if(index < 0 || index > size) {
            
        }
    }
}





































