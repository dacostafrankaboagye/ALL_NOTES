import java.util.Arrays;

class Solution{
    public static int minProductSum(int[] nums1, int[] nums2) {

        int ans = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = nums2.length - 1;

        while(i < nums1.length && j >=0) {
            ans += + nums1[i] * nums2[j];
            i++;
            j--;
        }

        return ans;
    }
}

public class QnA{

    public static void main(String[] args) {
        // int[] nums1 = {5,3,4,2}, nums2 = {4,2,2,5};  // ans = 40
        int[] nums1 = {2,1,4,5,7}, nums2 = {3,2,4,8,6}; // ans = 65

        int result = Solution.minProductSum(nums1, nums2);
        System.out.println(result);    
    }
}