package DSA.hasing;

import java.util.*;

public class Hashing {

    /* =========================
       EASY PROBLEMS
       ========================= */

    // 1. Two Sum (Return indices)
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (map.containsKey(rem)) {
                return new int[]{map.get(rem), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    // 2. Contains Duplicate
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (!set.add(x)) return true;
        }
        return false;
    }

    // 3. First Non-Repeating Character
    public static char firstNonRepeatingChar(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        for (char c : s.toCharArray())
            if (freq.get(c) == 1)
                return c;

        return '#';
    }

    // 4. Count Frequency of Elements
    public static Map<Integer, Integer> frequencyCount(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr)
            map.put(x, map.getOrDefault(x, 0) + 1);
        return map;
    }


    /* =========================
       MEDIUM PROBLEMS
       ========================= */

    // 5. Subarray Sum Equals K
    public static int subarraySumEqualsK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0, count = 0;
        for (int x : nums) {
            sum += x;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // 6. Longest Consecutive Sequence
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);

        int longest = 0;
        for (int x : set) {
            if (!set.contains(x - 1)) {
                int curr = x;
                int streak = 1;
                while (set.contains(curr + 1)) {
                    curr++;
                    streak++;
                }
                longest = Math.max(longest, streak);
            }
        }
        return longest;
    }

    // 7. Group Anagrams
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    // 8. Longest Subarray with Zero Sum
    public static int longestZeroSumSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == 0)
                maxLen = i + 1;

            if (map.containsKey(sum))
                maxLen = Math.max(maxLen, i - map.get(sum));
            else
                map.put(sum, i);
        }
        return maxLen;
    }


    /* =========================
       HARD PROBLEMS
       ========================= */

    // 9. Count Subarrays with Equal 0s and 1s
    public static int countSubarraysEqualZeroOne(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0, count = 0;
        for (int x : nums) {
            sum += (x == 0 ? -1 : 1);
            count += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // 10. Longest Subarray with Given XOR
    public static int longestSubarrayWithXor(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int xor = 0, maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];

            if (xor == k)
                maxLen = i + 1;

            if (map.containsKey(xor ^ k))
                maxLen = Math.max(maxLen, i - map.get(xor ^ k));

            map.putIfAbsent(xor, i);
        }
        return maxLen;
    }

    // 11. Distinct Elements in Every Window
    public static List<Integer> distinctInWindow(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if (i >= k) {
                map.put(nums[i - k], map.get(nums[i - k]) - 1);
                if (map.get(nums[i - k]) == 0)
                    map.remove(nums[i - k]);
            }

            if (i >= k - 1)
                result.add(map.size());
        }
        return result;
    }

    // 12. Minimum Window Substring
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, count = 0;
        int minLen = Integer.MAX_VALUE, start = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                if (need.get(c) > 0) count++;
                need.put(c, need.get(c) - 1);
            }

            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char lc = s.charAt(left++);
                if (need.containsKey(lc)) {
                    need.put(lc, need.get(lc) + 1);
                    if (need.get(lc) > 0) count--;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}

