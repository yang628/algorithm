package sort;

/**
 * Created by yang on 2017/10/24.
 */
public class SortAll {
    /**
     * 冒泡排序
     * <p>
     * 思路：
     * 1、比较相邻的元素。如果第一个比第二个大，就交换他们两个。（每一次都选了一个最大的放入最后）
     * 2、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 3、针对所有的元素重复以上的步骤，除了最后一个。
     * 4、持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     * <p>
     * 特点：
     * 冒泡排序是与插入排序拥有相等的执行时间，但是两种法在需要的交换次数却很大地不同。
     * 在最坏的情况，冒泡排序需要O(n2)次交换，而插入排序只要最多O(n)交换。
     * 冒泡排序的实现（类似下面）通常会对已经排序好的数列拙劣地执行O(n2)，
     * 而插入排序在这个例子只需要O(n)个运算。
     * 因此很多实现中避免使用冒泡排序，而用插入排序取代之。
     * 冒泡排序如果能在内部循环第一次执行时，使用一个旗标来表示有无需要交换的可能，也有可能把最好的复杂度降低到O(n)。
     * 在这个情况，在已经排序好的数列就无交换的需要。（例如上面代码）
     */
    public static void BubbleSort(Integer[] a) {
        //1该数组的长度
        int length = a.length;
        //外循环:最多n-1趟冒泡排序,控制次数就好  注意：是等于小于！！！
        for (int i = 0; i <= length - 1 - 1; i++) {
            //每次比较的逻辑
            for (int j = 0; j <= length - i - 1 - 1; j++) {
                if (a[j] > a[j + 1]) {
                    a[j] = a[j] ^ a[j + 1];
                    a[j + 1] = a[j] ^ a[j + 1];
                    a[j] = a[j] ^ a[j + 1];
                }
            }
        }
    }

    /**
     * 插入排序  N--N^2
     *
     * @param
     */
    public static void InsertSort(int[] a) {
        int length = a.length;
        //外循环：控制次数
        for (int i = 1; i <= length - 1; i++) {
            //比较逻辑,&& (a[j]< a[j-1]) 说明前面已经有序
            for (int j = i; j >= 1 && (a[j] < a[j - 1]); j--) {
                int c = a[j];
                a[j] = a[j - 1];
                a[j - 1] = c;

            }
        }

    }

    /**
     * 希尔排序  可以观看http://www.iqiyi.com/v_19rrhzyejc.html
     * 由于插入排序，在初始数据基本是有序的或者大多数是有序的情况下，插入排序效率是很高的。
     * 基于这点，希尔排序的产生。
     * 注意：
     * 至于步长，是根据以往的经验而定的。
     * 刚开始，假如步长为5时，经过一轮排序，整个数组依然是乱的。但从统计学上来说，小的数在前面多是肯定的。
     *
     * @param
     */
    public static void shellSort(int[] a) {
        int N = a.length;
        int h = 1;
        //根据数组长度，选取适当的初始间隔
        while (h < N / 3) {
            h = 3 * h + 1;//1, 4,13...
        }
        //每一次shell编程h逐渐减小
        while (h >= 1) {
            //控制次序(想当h=1时，插入排序,然后替换)
            for (int i = h; i <= N - 1; i++) {
                for (int j = i; j >= h && (a[j] > a[j - h]); j -= h) {
                    //交换
                    int c = a[j];
                    a[j] = a[j - h];
                    a[j - h] = c;
                }
            }
            h = h / 3;
        }
    }


    public static void main(String[] args) {
        int[] arr = {12, 1, 5, 26, 23, 25, 26, 58, 98, 57, 47, 44, 1, 23, 6};
        // BubbleSort(arr);
        // InsertSort(arr);
        shellSort(arr);
        for (int i : arr) {
            System.out.print(i + "  ");
        }

    }


    //交换两个数字
    public static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(" a:" + a + " b:" + b);
    }


}
