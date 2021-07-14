package com.young.springbootkafka.ms;

import java.util.*;

/**
 * Solution
 *
 * @Author young
 * @Date 2021/5/24
 */
public class Solution {

    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     * <p>
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     * <p>
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int d = 0, p = 1, sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = Math.floorMod(d + p, 1000000007);
            d = p;
            p = sum;
        }
        return d;
    }

    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

    /**
     * 方法一：哈希表 / Set
     * 利用数据结构特点，容易想到使用哈希表（Set）记录数组的各个数字，当查找到重复数字则直接返回。
     * <p>
     * 算法流程：
     * 初始化： 新建 HashSet ，记为 dicdic ；
     * 遍历数组 numsnums 中的每个数字 numnum ：
     * 当 numnum 在 dicdic 中，说明重复，直接返回 numnum ；
     * 将 numnum 添加至 dicdic 中；
     * 返回 -1−1 。本题中一定有重复数字，因此这里返回多少都可以。
     * 复杂度分析：
     * 时间复杂度 O(N)O(N) ： 遍历数组使用 O(N)O(N) ，HashSet 添加与查找元素皆为 O(1)O(1) 。
     * 空间复杂度 O(N)O(N) ： HashSet 占用 O(N)O(N) 大小的额外空间。
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> dic = new HashSet<>();
        for (int num : nums) {
            if (dic.contains(num)) {
                return num;
            }
            dic.add(num);
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }

    /**
     * 从矩阵 matrix 左下角元素（索引设为 (i, j) ）开始遍历，并与目标值对比：
     * 当 matrix[i][j] > target 时，执行 i-- ，即消去第 i 行元素；
     * 当 matrix[i][j] < target 时，执行 j++ ，即消去第 j 列元素；
     * 当 matrix[i][j] = target 时，返回 truetrue ，代表找到目标值。
     * 若行索引或列索引越界，则代表矩阵中无目标值，返回 falsefalse 。
     * 每轮 i 或 j 移动后，相当于生成了“消去一行（列）的新矩阵”， 索引(i,j) 指向新矩阵的左下角元素（标志数），因此可重复使用以上性质消去行（列）。
     * <p>
     * 复杂度分析：
     * 时间复杂度 O(M+N)O(M+N) ：其中，NN 和 MM 分别为矩阵行数和列数，此算法最多循环 M+NM+N 次。
     * 空间复杂度 O(1)O(1) : i, j 指针使用常数大小额外空间
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * n      res
     * 1        1
     * 2        2
     * 3        3
     * 4        5
     * 动态规划，时间复杂度O(n)，空间复杂度O(n);
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

    /**
     * 动态规划，时间复杂度O(n)，空间复杂度O(1);
     *
     * @param n
     * @return
     */
    public int numWays2(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int pre = 1, cur = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = (pre + cur) % 1000_000_007;
            pre = cur;
            cur = tmp;
        }
        return cur;
    }

    /**
     * 算法流程：
     * 初始化： 声明 ii, jj 双指针分别指向 numsnums 数组左右两端；
     * 循环二分： 设 m = (i + j) / 2m=(i+j)/2 为每次二分的中点（ "/" 代表向下取整除法，因此恒有 i \leq m < ji≤m<j ），可分为以下三种情况：
     * 当 nums[m] > nums[j]nums[m]>nums[j] 时： mm 一定在 左排序数组 中，即旋转点 xx 一定在 [m + 1, j][m+1,j] 闭区间内，因此执行 i = m + 1i=m+1；
     * 当 nums[m] < nums[j]nums[m]<nums[j] 时： mm 一定在 右排序数组 中，即旋转点 xx 一定在[i, m][i,m] 闭区间内，因此执行 j = mj=m；
     * 当 nums[m] = nums[j]nums[m]=nums[j] 时： 无法判断 mm 在哪个排序数组中，即无法判断旋转点 xx 在 [i, m][i,m] 还是 [m + 1, j][m+1,j] 区间中。解决方案： 执行 j = j - 1j=j−1 缩小判断范围，分析见下文。
     * 返回值： 当 i = ji=j 时跳出二分循环，并返回 旋转点的值 nums[i]nums[i] 即可。
     * 正确性证明：
     * 当 nums[m] = nums[j]nums[m]=nums[j] 时，无法判定 mm 在左（右）排序数组，自然也无法通过二分法安全地缩小区间，因为其会导致旋转点 xx 不在区间 [i, j][i,j] 内。举例如下：
     * <p>
     * 设以下两个旋转点值为 00 的示例数组，则当 i = 0i=0, j = 4j=4 时 m = 2m=2 ，两示例结果不同。
     * 示例一 [1, 0, 1, 1, 1][1,0,1,1,1] ：旋转点 x = 1x=1 ，因此 m = 2m=2 在 右排序数组 中。
     * 示例二 [1, 1, 1, 0, 1][1,1,1,0,1] ：旋转点 x = 3x=3 ，因此 m = 2m=2 在 左排序数组 中。
     * <p>
     * 而证明 j = j - 1j=j−1 正确（缩小区间安全性），需分为两种情况：
     * <p>
     * 当 x < jx<j 时： 易得执行 j = j - 1j=j−1 后，旋转点 xx 仍在区间 [i, j][i,j] 内。
     * <p>
     * 当 x = jx=j 时： 执行 j = j - 1j=j−1 后越过（丢失）了旋转点 xx ，但最终返回的元素值 nums[i]nums[i] 仍等于旋转点值 nums[x]nums[x] 。
     * <p>
     * 由于 x = jx=j ，因此 nums[x] = nums[j] = nums[m] \leq number[i]nums[x]=nums[j]=nums[m]≤number[i] ;
     * 又由于 i \leq m <ji≤m<j 恒成立，因此有 m < xm<x ，即此时 mm 一定在左排序数组中，因此 nums[m] \geq nums[i]nums[m]≥nums[i] ;
     * 综合 1. , 2. ，可推出 nums[i] = nums[m]nums[i]=nums[m] ，且区间 [i, m][i,m] 内所有元素值相等，即有：
     * nums[i] = nums[i+1] = \cdots = nums[m] = nums[x]
     * nums[i]=nums[i+1]=⋯=nums[m]=nums[x]
     * <p>
     * 此时，执行 j = j - 1j=j−1 后虽然丢失了旋转点 xx ，但之后区间 [i, j][i,j] 只包含左排序数组，二分下去返回的一定是本轮的 nums[i]nums[i] ，而其与 nums[x]nums[x] 相等。
     * 综上所述，此方法可以保证返回值 nums[i]nums[i] 等于旋转点值 nums[x]nums[x] ，但在少数特例下 i \ne xi
     * 
     * ​
     * =x ；而本题目只要求返回 “旋转点的值” ，因此本方法正确。
     * <p>
     * 补充思考： 为什么本题二分法不用 nums[m]nums[m] 和 nums[i]nums[i] 作比较？
     * <p>
     * 二分目的是判断 mm 在哪个排序数组中，从而缩小区间。而在 nums[m] > nums[i]nums[m]>nums[i]情况下，无法判断 mm 在哪个排序数组中。本质上是由于 jj 初始值肯定在右排序数组中； ii 初始值无法确定在哪个排序数组中。举例如下：
     * <p>
     * 对于以下两示例，当 i = 0, j = 4, m = 2i=0,j=4,m=2 时，有 nums[m] > nums[i] ，而结果不同。
     * [1, 2, 3, 4 ,5][1,2,3,4,5] 旋转点 x = 0x=0 ： mm 在右排序数组（此示例只有右排序数组）；
     * [3, 4, 5, 1 ,2][3,4,5,1,2] 旋转点 x = 3x=3 ： mm 在左排序数组。
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] < numbers[j]) {
                j = m;
            } else if (numbers[m] > numbers[j]) {
                i = m + 1;
            } else {
                j--;
            }
        }
        return numbers[i];
    }

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> subject : result) {
                List<Integer> newSubset = new ArrayList<>(subject);
                newSubset.add(num);
                newSubsets.add(newSubset);
            }
            result.addAll(newSubsets);
        }
        return result;
    }

    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat","abt","ttt"});
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String strSort = String.valueOf(chars);
            List<String> list = map.containsKey(strSort) ? map.get(strSort) : new ArrayList<>();
            list.add(str);
            map.put(strSort, list);
        }
        return new ArrayList<>(map.values());
    }

}
