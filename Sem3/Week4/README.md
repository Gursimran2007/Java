# Week 4 — Arrays (Category C)

LeetCode-style array problems: logic-building with arrays, loops and conditionals,
then prefix sums, two pointers and binary search.

| # | Practice | Assignment |
|---|----------|------------|
| 1 | [Two Sum](Practice/TwoSum.java) | [Product of Array Except Self](Assignment/ProductOfArrayExceptSelf.java) |
| 2 | [Best Time to Buy and Sell Stock](Practice/BestTimeToBuyAndSellStock.java) | [Maximum Subarray (Kadane's)](Assignment/MaximumSubarray.java) |
| 3 | [Contains Duplicate](Practice/ContainsDuplicate.java) | [3Sum](Assignment/ThreeSum.java) |
| 4 | [Merge Two Sorted Arrays](Practice/MergeTwoSortedArrays.java) | [Subarray Sum Equals K](Assignment/SubarraySumEqualsK.java) |
| 5 | [Rotate Array](Practice/RotateArray.java) | [Find Minimum in Rotated Sorted Array](Assignment/FindMinimumInRotatedSortedArray.java) |

### Complexity summary

| Problem | Time | Space |
|---------|------|-------|
| Two Sum | O(n²) | O(1) |
| Best Time to Buy and Sell Stock | O(n) | O(1) |
| Contains Duplicate | O(n²) | O(1) |
| Merge Two Sorted Arrays | O(n + m) | O(n + m) |
| Rotate Array | O(n) | O(n) |
| Product of Array Except Self | O(n) | O(1) extra |
| Maximum Subarray | O(n) | O(1) |
| 3Sum | O(n²) | O(1) extra |
| Subarray Sum Equals K | O(n) | O(n) |
| Find Minimum in Rotated Sorted Array | O(log n) | O(1) |

The practice set deliberately avoids `HashSet` / `HashMap` shortcuts, since Category C
restricts it to arrays, loops and conditionals.

Write-ups with problem statements, approach notes and captured output are in
[`solutions/`](solutions).
