class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        int half = total / 2;
        
        int left = 0, right = m;
        while (left <= right) {
            int mid1 = (left + right) / 2;
            int mid2 = half - mid1;
            
            // Partition values
            int left1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int right1 = (mid1 == m) ? Integer.MAX_VALUE : nums1[mid1];
            int left2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int right2 = (mid2 == n) ? Integer.MAX_VALUE : nums2[mid2];
            
            // Check partitions
            if (left1 <= right2 && left2 <= right1) {
                // Found the correct partition
                if (total % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.min(right1, right2);
                }
            } else if (left1 > right2) {
                // Move left
                right = mid1 - 1;
            } else {
                // Move right
                left = mid1 + 1;
            }
        }
        
        throw new IllegalArgumentException("Input arrays are not sorted or valid");
    }
}

