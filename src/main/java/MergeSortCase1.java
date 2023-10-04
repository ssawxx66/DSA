
/**
 * @Author:xx
 * @Date:2023/10/4 20:58
 * @Description TODO 小和
 */
public class MergeSortCase1 {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3};
        System.out.println(bruteforce(arr));
        System.out.println(r(arr, 0, arr.length - 1));
    }
    public static int r(int[] arr, int l, int r) {
        if (l == r) return 0;
        int mid = l + ((r - l) >> 1);
        return r(arr, l, mid) + r(arr, mid + 1, r) + merge(arr, l, mid, r);
    }
    private static int merge(int[] arr, int l, int mid, int r) {
        int pointerL = l;
        int pointerR = mid + 1;
        int tmp[] = new int[r - l + 1];
        int tmpIndex = 0;
        int res = 0;
        while (pointerL <= mid && pointerR <= r) {
            res += arr[pointerL] < arr[pointerR] ? (r - pointerR + 1) * arr[pointerL] : 0;
            tmp[tmpIndex++] = arr[pointerL] < arr[pointerR] ? arr[pointerL++] : arr[pointerR++];
        }
        while (pointerL <= mid) tmp[tmpIndex++] = arr[pointerL++];
        while (pointerR <= r) tmp[tmpIndex++] = arr[pointerR++];
        for (int i = 0; i < tmp.length; i++) {
            arr[l + i] = tmp[i];
        }
        return res;
    }
    /**
     * brute force
     */
    public static int bruteforce(int[]arr){
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i])res+=arr[j];
            }
        }
        return res;
    }
}
