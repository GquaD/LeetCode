package LeetCode.medium;

public class Problem912 {
    //https://leetcode.com/problems/sort-an-array/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/sort-an-array/solutions/3242230/java-mergesort-solution/
    //Runtime
    //30 ms
    //Beats
    //75.78%
    //Memory
    //51.9 MB
    //Beats
    //84.65%
    static int[] sortArray1(int[] nums) {
        MergeSort.mergeSort(nums);
        return nums;
    }

    //from my algorithms repo //https://github.com/GquaD/algorithms
    private static class MergeSort {
        private static int[] array;

        public static void mergeSort(int[] arr) {
            array = arr;
            int len = array.length;
            int[] workspace = new int[len];
            recursiveMergeSort(workspace, 0, len - 1);
        }

        private static void recursiveMergeSort(int[] workSpace, int lowerBound,
                                        int upperBound) {
            if (lowerBound == upperBound) {
                return;
            } else {
                int mid = (lowerBound + upperBound) / 2;
                recursiveMergeSort(workSpace, lowerBound, mid);
                recursiveMergeSort(workSpace, mid + 1, upperBound);
                merge(workSpace, lowerBound, mid + 1, upperBound);
            }
        }

        private static void merge(int[] workspace, int lowPointer,
                           int highPointer, int upperBound) {
            int i = 0;
            int lowerBound = lowPointer;
            int mid = highPointer - 1;
            int numberOfItems = upperBound - lowerBound + 1;

            while (lowPointer <= mid && highPointer <= upperBound) {
                if (array[lowPointer] < array[highPointer]) {
                    workspace[i++] = array[lowPointer++];
                } else {
                    workspace[i++] = array[highPointer++];
                }
            }

            while (lowPointer <= mid)
                workspace[i++] = array[lowPointer++];

            while (highPointer <= upperBound)
                workspace[i++] = array[highPointer++];

            for (i = 0; i < numberOfItems; i++)
                array[lowerBound + i] = workspace[i];
        }
    }

    //Runtime
    //1500 ms
    //Beats
    //10.77%
    //Memory
    //57.6 MB
    //Beats
    //21.62%
    static int[] sortArray(int[] nums) {
        new QuickSort().quickSort(nums);
        return nums;
    }

    private static class QuickSort {
        private int[] array;

        public void quickSort(int[] arr) {
            array = arr;
            recursiveQuickSort(0, array.length - 1);
        }

        private void recursiveQuickSort(int left, int right) {
            if (right - left <= 0) {
                return;
            } else {
                int pivot = array[right];
                int partition = partitionIt(left, right, pivot);
                recursiveQuickSort(left, partition - 1);
                recursiveQuickSort(partition + 1, right);
            }
        }

        private int partitionIt(int left, int right, int pivot) {
            int leftPointer = left - 1;
            int rightPointer = right;
            while (true) {
                while (array[++leftPointer] < pivot);

                while (rightPointer > 0 && array[--rightPointer] > pivot);

                if (leftPointer >= rightPointer) {
                    break;
                } else {
                    swap(leftPointer, rightPointer);
                }
            }
            swap(leftPointer, right);
            return leftPointer;
        }

        private void swap(int idx1, int idx2) {
            int temp = array[idx1];
            array[idx1] = array[idx2];
            array[idx2] = temp;
        }
    }
}
