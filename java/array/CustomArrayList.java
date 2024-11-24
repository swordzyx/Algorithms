package array;

/**
 * 动态数组
 */
class CustomArrayList<T> {
    int capacity;
    int count;
    T[] data;

    public CustomArrayList(int capacity) {
        this.capacity = capacity;
        this.count = 0;
    }

    public CustomArrayList() {
        this(10);
    }
    
    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public T get(int index) {
        if(index < 0 || index >= count) {
            throw new IllegalArgumentException("Index is illegal.");
        }

        return data[index];
    }

    public boolean contains(T e) {
        for (T t : data) {
            if (t.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(T e) {
        for (int i = 0; i < count; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //O(n)
    public boolean add(int index, T e) {
        if (index < 0 || index > capacity) {
            System.out.println("插入位置不合法");
            return false;
        }

        if (count == capacity) {
            resize();
        }

        for(i = count - 1; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        ++count;
        return true;
    }

    public boolean addFirst(T e) {
        return add(0, e);
    }

    public boolean addLast(T e) {
        return add(count, e);
    }

    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            System.out.println("索引不合法");
            return false;
        }

        for (int i = index + 1; i < count; i++) {
            data[i - 1] = data[i];
        }
        --count;

        if (count < capacity / 4 && count > 1) {
            reduceSize();
        }
       
        return true;
    }

    public boolean deleteFirst() {
        return delete(0);
    }

    public boolean deleteLast() {
        return delete(count - 1);
    }

    public boolean delete(T e) {
        int index = indexOf(e);
        if (index == -1) {
            return false;
        }
        return delete(index);
    }

    public String toString() {
        StringBuild sb = new StringBuilder();
        sb.append(String.format("Array size = %d, capacity = %d\n", count, capacity));
        for (int i = 0; i < count; i++) {
            sp.append(data[i]);
            if (i != count - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    private void resize() {
        //扩容至原来的 2 倍
        T[] newdata = (T[]) new Object[capacity * 2];

        for (int i = 0; i < count; i++) {
            newdata[i] = data[i];
        }

        data = newdata;
    }

    private void reduceSize() {
        if (count >= capacity / 4 || capacity == 1) {
            System.out.println("未达到缩容条件");
            return;
        }
        T[] newdata = (T[]) new Object[capacity / 2];

        for (int i = 0; i < count; i++) {
            newdata[i] = data[i];
        }

        data = newdata;
    }
}