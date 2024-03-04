package algorithm.sorting;

public class MergeSort001 {
	
	private static int[] merge(int[] left, int[] right, int low) {
		int size = left.length + right.length;
		int[] res = new int[size];
		int l = 0, r = 0;
		int i = 0;
		
		while (l < left.length && r < right.length && i < size) {
			if (left[l] >= right[r]) {
				res[i] = right[r];
				r++;
			} else {
				res[i] = left[l];
				l++;
			}
			i++;
		}
		
		while (l < left.length) {
			res[i] = left[l];
			l++;
			i++;
		}

		while (r < right.length) {
			res[i] = right[r];
			r++;
			i++;
		}
		
		return res;
	}
	
	private static int[] doSort(int[] arr, int low, int high) {
		if (low > high) return null;
		if (low == high) {
			int[] res = { arr[low] };
			return res;
		} else {
			int mid = (low + high) / 2;
			int[] res1 = doSort(arr, low, mid);
			int[] res2 = doSort(arr, mid + 1, high);
			
			return merge(res1, res2, low);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = { 9, 2, 1, 39, -5, 1, 0, 9935, 3, 33, 3 };
		
		int[] res = doSort(arr, 0, arr.length - 1);
		
		for (int i : res) 
			System.out.print(i + " ");
		
	}

}
