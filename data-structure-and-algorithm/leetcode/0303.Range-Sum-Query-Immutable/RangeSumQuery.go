package leetcode

type NumArray struct {
	sums []int
}

func Constructor(nums []int) NumArray {
	array := NumArray{
		make([]int, len(nums)+1),
	}
	sum := 0
	for i := 0; i < len(nums); i++ {
		sum += nums[i]
		array.sums[i+1] = sum
	}
	return array
}

func (this *NumArray) SumRange(i int, j int) int {
	return this.sums[j+1] - this.sums[i]
}
