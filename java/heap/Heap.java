public class Heap {
	private int[] datas;
	private int n;
	private int count;

	public class Heap(int capacity) {
		datas = new int[capacity + 1];
		n = capacity;
		count = 0;
	}

	public void insert(int data) {
		if (count >= n) {
			System.out.println("heap has full");
			return -1;
		}

		++count;
		datas[count] = data;
		//自下往上堆化
		int i = count;
		while(i / 2 > 0 && datas[i / 2] < datas[i]) {
			swap(data, i / 2, i);
			i = i / 2
		}
	}

	public int deleteTop() {
		if (count == 0) {
			return -1;
		}

		datas[1] = datas[count--];
		heapify(datas, count, 1);
	}

	public static void buildHeap(int[] datas) {
		for (int i = datas.length / 2; i >= 0; i--) {
			heapify(datas, datas.length - 1, i);
		}
	}

	public static void sort(int[] datas) {
		buildHeap(datas);
		int heapifyCount = datas.length;
		while(heapifyCount > 1) {
			swap(datas, 0, datas.length - 1);
			--heapifyCount;
			heapify(datas, heapifyCount - 1, 0);
		}
	}

	//自顶向下堆化
	private static void heapify(int[] datas, int n, int index) {
		int i = index;
		int maxIndex = i;
		while(true) {
			if(2 * i <= n && datas[2 * i] > datas[maxIndex]) maxIndex = 2 * i;
			if(2 * i + 1 <= n && datas[2 * i + 1] > datas[maxIndex]) maxIndex = 2 * i + 1;
			if (maxIndex == i) break;
			swap(datas, i, maxIndex)
			i = maxIndex;
		}
	}
}