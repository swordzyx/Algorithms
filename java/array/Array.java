package array;
class Array {
    private int data[];
    private int count;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.count = capacity;
    }

    //根据索引，找到数组中的元素并返回
    public int find(int index) {
        if (index < 0 || index >= count) {
            System.out.println("数组越界");
            return -1;
        }

        return data[index];
    }


    //在指定的索引处插入元素
    public boolean insert(int index, int value) {
        //判断数组是否还有剩余空间
        if (count == capacity) {
            System.out.println("数组已满，无法插入");
            return false;
        }

        //判断插入的位置是否合法
        if (index < 0 || index > capacity) {
            System.out.println("插入位置不合法");
            return false;
        }

        //插入元素
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    //删除指定索引的元素
    public boolean delete(int index) {
        //判断索引是否合法
        if (index < 0 || index >= count) {
            System.out.println("索引不合法");
            return false;
        }

        //删除元素
        for (int i = index + 1; i < count; i++) {
            data[i - 1] = data[i];
        }
        --count;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        array.printAll();
    }

}