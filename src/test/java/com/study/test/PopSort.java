package com.study.test;

public class PopSort {

  public static void main(String[] args) {
    //    bubbleSort(new int[] {2, 3, 1, 4, 5, 0});
    quickSort(new int[] {2, 3, 1, 4, 5, 0}, 0, 5);
  }

  public static void bubbleSort(int[] arr) {

    int temp; // 临时变量
    boolean flag; // 是否交换的标志
    for (int i = 0; i < arr.length - 1; i++) { // 表示趟数，一共arr.length-1次。

      flag = false;
      for (int j = arr.length - 1; j > i; j--) {

        if (arr[j] < arr[j - 1]) {
          temp = arr[j];
          arr[j] = arr[j - 1];
          arr[j - 1] = temp;
          flag = true;
        }
      }
      if (!flag) break;
    }
    System.out.println(arr);
  }

  public static void quickSort(int a[], int l, int r) {
    if (l >= r) return;

    int i = l;
    int j = r;
    int key = a[l]; // 选择第一个数为key

    while (i < j) {

      while (i < j && a[j] >= key) // 从右向左找第一个小于key的值
      j--;
      if (i < j) {
        a[i] = a[j];
        i++;
      }

      while (i < j && a[i] < key) // 从左向右找第一个大于key的值
      i++;

      if (i < j) {
        a[j] = a[i];
        j--;
      }
    }
    // i == j
    a[i] = key;
    quickSort(a, l, i - 1); // 递归调用
    quickSort(a, i + 1, r); // 递归调用
    System.out.println(a);
  }

  public static void InsertSort(int R[], int n) {
    int i, j;
    int temp;
    for (i = 1; i < n; ++i) {
      temp = R[i]; // 将待排关键字暂时存放在temp中
      j = i - 1; // 待排关键字的前一个关键字序号
      while (j >= 0 && temp < R[j])
      // 从待排关键字的前一个关键字开始扫描，如果大于待排关键字，则往后移一个位置
      {
        R[j + 1] = R[j];
        --j;
      }
      R[j + 1] = temp; // 找到插入位置，将temp中暂存的待排关键字插入
    }
  }
}
