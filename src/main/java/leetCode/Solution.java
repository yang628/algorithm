/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package leetCode;

/**
 * Solution
 *
 * @author cheqianzi.ygj
 * @email: cheqianzi@2dfire.com
 * @desc:
 * @since 2017-12-28
 */
class Solution {


	public boolean checkPossibility(int[] nums) {
		boolean flag = false;
		int condition = 0;

		if (nums.length == 1){
			return true;
		}
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] < 0 || nums[i] > 10000) {
				continue;
			}

			if (nums[i] < nums[i + 1]) {
				condition++;
				if (condition > 1) {
					return flag;
				}
			}
		}

		if (condition == 1) {
			return true;
		}
		return false;
	}
}