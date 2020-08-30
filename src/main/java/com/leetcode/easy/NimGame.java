package com.leetcode.easy;

/**
 * 292. Nim Game
 * @link https://leetcode.com/problems/nim-game/tabs/description
 *
 * @author wangjf
 * @date 2017 - 07 - 28 23:51
 */
public class NimGame {

    public static void main(String[] args) {
        int n = 6;
        System.out.println(new NimGame().canWinNim(n));
    }

    /**
     * ��n��[1,3]ʱ�����ֱ�ʤ��
     *
     * ��n == 4ʱ���������ֵ�һ�����ѡȡ����һ�ֶ���ת��Ϊn��[1,3]�����Σ���ʱ���ֱظ���
     *
     * ��n��[5,7]ʱ�����ֱ�ʤ�����ֱַ�ͨ��ȡ��[1,3]��ʯͷ���ɽ�״̬ת��Ϊn == 4ʱ�����Σ���ʱ���ֱظ���
     *
     * ��n == 8ʱ���������ֵ�һ�����ѡȡ����һ�ֶ���ת��Ϊn��[5,7]�����Σ���ʱ���ֱظ���
     */
    public boolean canWinNim(int n) {
        if (n % 4 == 0){
            return false;
        }

        return true;
    }

}
