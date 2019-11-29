class Solution:
    def removeDuplicates(self, nums， k):
        i = 0
        for n in nums:
            if i < k or n != nums[i-k]:
                nums[i] = n
                i += 1
        return i
