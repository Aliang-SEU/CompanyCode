package test;

import java.util.*;

public class www {
	public void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i<num; i++)
		{
			arr[i] = sc.nextInt();
		}
		moveZeroes(arr, num);
		for (int i = 0; i < num; i++)
		{
			System.out.println(arr[i]);
		}
	}
	public void moveZeroes(int[] nums, int numsSize) {
		int i;
		int feiling = 0;
		for (i = 0; i<numsSize; i++)
		{
			if (nums[i] == 0)
			{
				continue;
			}
			else
			{
				nums[feiling] = nums[i];
				feiling = feiling + 1;
			}
		}
		for (i = feiling; i<numsSize; i++)
		{
			nums[i] = 0;
		}
	}

}
