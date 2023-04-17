/* Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order...
 * Eg 1: nums = [1,1,1,2,2,3]        k = 2             Output = [1,2]
 * Eg 2: nums = [1]                  k = 1             Output = [1]
 */
import java.util.*;
public class Frequent
{
    public int[] TopKFrequent(int nums[], int k)
    {
        int ans[] = new int[k];
        if(nums.length == 1)      // Base condition, if array contains a single element...
            return ans = nums;
        Arrays.sort(nums);        // Sorting the arrays to bring similar elements nearer...
        Vector<int[]> vector = new Vector<int[]>();    // Creating a vector of arrays to store data and count...
        int count = 0, j = 0;
        for(int i = 0; i < nums.length - 1; i++)    // Creating Buckets on Sorted Array...
        {
            if(nums[i] == nums[i + 1])    // If the two adjacent elements are same...
                count++;
            else if(nums[i] != nums[i + 1])    // If the two elements are distinct...
            {
                int data[] = new int[2];   // Creating a bucket...
                data[0] = nums[i];
                data[1] = count + 1;
                vector.add(j, data);    // Adding the created bucket to vector...
                j++;
                count = 0;
            }
        }
        if(nums[nums.length - 2] != nums[nums.length - 1])
        {    // Checking for the bucketing of the last element...
            int data[] = {nums[nums.length - 1], 1};
            vector.add(j, data);
        }
        int array[][] = new int[vector.size()][2];    // Creating the vector...
        for(int i = 0; i < vector.size(); i++)
        {
            array[i][0] = vector.get(i)[0];    // data value...
            array[i][1] = vector.get(i)[1];    // count value...
        }
        Arrays.sort(array, (a, b) -> b[1] - a[1]);   // Sorted on the basis of first dimension in descending order (b)  1 is used for descending and 0 for ascending...
        for(int i = 0; i < array.length; i++)
            System.out.print("["+array[i][0]+", "+array[i][1]+"]");
        System.out.println();
        for(int i = 0; i < k; i++)   // Storing the most frequent element into the output array...
            ans[i] = array[i][0];   // The Most frequent element is in the first index...
        return ans;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter number of elements in the array : ");
        n = sc.nextInt();
        int nums[] = new int[n];
        for(int i = 0; i < nums.length; i++)
        {
            System.out.print("Enter data : ");
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter the value of k : ");
        n = sc.nextInt();
        Frequent frequent = new Frequent();    // Object creation...
        int key[] = new int[n];
        key = frequent.TopKFrequent(nums, n);     // Function calling...
        System.out.println("The "+n+" most frequent elements are : ");
        for(int i = 0; i < key.length; i++)
            System.out.print(key[i]+", ");
        System.out.println();
        sc.close();
    }
}


// Time Complexity  - O(n log n) time...
// Space Complexity - O(k) space...       k = unique number of elements...

/* DEDUCTIONS :-
 * We first sort the array, such that after sorting buckets of similar elements will be formed...
 * Then, we can count each unique element, and store it in a 2d array and sort it again...
 * Now, we can simply iterate for the first k or last k elements to get the top k frequent elements...
 */