public class QuickSort {

    static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[end] = temp;
        return i;
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pidx = partition(arr, start, end);

            quickSort(arr, start, pidx - 1);
            quickSort(arr, pidx + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 3, 12, 7, 36, 45, 27};
        int length = arr.length;

        quickSort(arr, 0, length - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
