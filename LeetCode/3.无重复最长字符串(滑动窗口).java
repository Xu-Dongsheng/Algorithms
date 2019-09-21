在暴力法中，我们会反复检查一个子字符串是否含有有重复的字符，但这是没有必要的。如果从索引 iii 到 j−1j - 1j−1 之间的子字符串 sijs_{ij}sij​ 已经被检查为没有重复字符。我们只需要检查 s[j]s[j]s[j] 对应的字符是否已经存在于子字符串 sijs_{ij}sij​ 中。
要检查一个字符是否已经在子字符串中，我们可以检查整个子字符串，这将产生一个复杂度为 O(n2)O(n^2)O(n2) 的算法，但我们可以做得更好。
通过使用 HashSet 作为滑动窗口，我们可以用 O(1)O(1)O(1) 的时间来完成对字符是否在当前的子字符串中的检查。
滑动窗口是数组/字符串问题中常用的抽象概念。 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即 [i,j)[i, j)[i,j)（左闭，右开）。而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。例如，我们将 [i,j)[i, j)[i,j) 向右滑动 111 个元素，则它将变为 [i+1,j+1)[i+1, j+1)[i+1,j+1)（左闭，右开）。
回到我们的问题，我们使用 HashSet 将字符存储在当前窗口 [i,j)[i, j)[i,j)（最初 j=ij = ij=i）中。 然后我们向右侧滑动索引 jjj，如果它不在 HashSet 中，我们会继续滑动 jjj。直到 s[j] 已经存在于 HashSet 中。此时，我们找到的没有重复字符的最长子字符串将会以索引 iii 开头。如果我们对所有的 iii 这样做，就可以得到答案。

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}

作者：LeetCode
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetcod/
来源：力扣（LeetCode）
