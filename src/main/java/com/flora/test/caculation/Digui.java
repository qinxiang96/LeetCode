package com.flora.test.caculation;

/**
 * @Author qinxiang
 * @Date 2023/6/27-下午10:11
 * 题目1：给你一个整数N，判断该整数是否是2的幂次方，是返回true,否返回false
 *
 * 思路：f(n) = 2*f(n/2) 终止条件：当n=1时 return true;当n%2 != 0 return false
 *
 *
 * 题目2：给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏。
 *
 * 玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。开始时，两个玩家的初始分值都是 0 。每一回合，玩家从数组的任意一端取一个数字（即，nums[0] 或 nums[nums.length - 1]），取到的数字将会从数组中移除（数组长度减 1 ）。玩家选中的数字将会加到他的得分上。当数组中没有剩余数字可取时，游戏结束。
 *
 * 如果玩家 1 能成为赢家，返回 true 。如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true 。你可以假设每个玩家的玩法都会使他的分数最大化。
 *
 * 思路：玩家如何知道选哪边会比对手多，需要知道如果选择了一个，剩余的部分给对手选的最优选法是多少，自己选的值与之做减法，如果>=0，则赢
 * 终止条件是什么 当剩下最后一个数没得选时--即left=right,对手只能接受这一个，而不能再分左右边选的情况了
 */
public class Digui {
    public static void main(String[] args) {
        //System.out.println(squar2(10));
        System.out.println(winner(new int[]{1, 5, 133,7}));
    }
    public static boolean squar2(int n){
        // 判断特殊用例
        if (n <= 0){
            return false;
        }
        if (n == 1){
            return true;
        }
        if (n % 2 != 0){
            return false;
        }
        return squar2(n / 2);
    }
    public static boolean winner(int[] nums){
        return winner(nums,0,nums.length - 1) >= 0;

    }
    public static int  winner(int[] nums,int left,int right){
        if (left == right){
            return nums[left];
        }
        // 理解：上面的是该递归的终止条件，即A选完一个数（无论左右）后，只剩下最后一个数，直接返回，这时候返回的是计算l或者r的后半段的数，还是需要将这公共的三步走完
        // （因为在一个总的winner函数里面，才会走到这个终止条件，而这个子winner函数的来源就是计算l或者r的后半段的数，此外前提是最开始传进来的是winner(nums,0,nums.length - 1)，左右一定不相等，一定存在子winner函数）
        // 总结：递归的本质就是先拆到满足终止条件得到结果后层层往上递归 适用于参数变化的相似的过程
        int l = nums[left] - winner(nums,left + 1,right);//第一步
        int r = nums[right] - winner(nums,left,right -1);//第二步
        return Math.max(l,r);//第三步
    }
}
