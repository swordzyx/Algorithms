//1 3 4 8 2 4 9 19 20
public class MergeSort {
	public void sort(int[] arrays) {
		if(arrays.length <= 1) {
			return;
		}
		sort(arrays, 0, arrays.length);
		
	}

	private void sort(int[] arrays, int start, int end) {
		int mid = arrays.length / 2;
		sort(arrays, start, mid);
		sort(arrays, mid + 1, end);
		merge(arrays, start, mid, end);
	}

	public void merge(int[] arrays, int start, int mid, int end) {
		int[] tempArray = new int[end - start + 1];
		int i = start;
		int j = mid;
		int k;
		for (k = 0; k < tempArray.length; k++) {
			if (arrays[i] <= arrays[j]) {
				tempArray[k] = arrays[i++];
			} else {
				tempArray[k] = arrays[j++];
			}

			if (i >= mid || j >= end) {
				break;
			}
		}

		if (i >= mid) {
			i = j;			
		}

		for (; k < tempArray.length; k++) {
			tempArray[k] = arrays[i++];
		}
	}
}