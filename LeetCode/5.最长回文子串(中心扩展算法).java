回文可以从它的中心展开，并且只有 2n−12n - 12n−1 个这样的中心。
你可能会问，为什么会是 2n−12n - 12n−1 个，而不是 nnn 个中心？原因在于所含字母数为偶数的回文的中心可以处于两字母之间
（例如 “abba”\textrm{“abba”}“abba” 的中心在两个 ‘b’\textrm{‘b’}‘b’ 之间）。
public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
}

private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        L--;
        R++;
    }
    return R - L - 1;
}

作者：LeetCode
链接：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode/
来源：力扣（LeetCode）
