public class QuickSort {
	public void sort(int[] arrays) {
		if(arrays.length <= 1) {
			return;
		}
	}
 
	public void sort(int[] arrays, int start, int end) {
		if (start >= end) {
			return;
		}

		int provitIndex = provit(arrays, start, end - 1);
		sort(arrays, start, provitIndex);
		sort(arrays, provitIndex + 1, end);
	}


	private void provit(int[] arrays, int start, int end) {
		int provit = end;
		int i = start;
		for(int j = start; j < end; j++) {
			if(arrays[j] < provit) {
				swap(array, i, j);
				i++;
			}
		}
		swap(array, i, provit);
		return i;
	}

	private void swap(int[] arrays, int i, int j) {
		if(i == j || arrays[i] == arrays[j]) {
			return;
		}
		int temp = arrays[i];
		arrays[i] = arrays[j];
		arrays[j] = temp;
	}
}