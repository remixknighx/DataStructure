package com.bill.disjointset;

/**
 * 不相交集合类的初步实现
 */
public class DisjSets {

    /**
     * 以数组的形式保存不相交集合类
     */
    private int[] s;

    /* public methods */
    /**
     * 构造不相交集合类
     *
     * @param numElements 初始化对象
     */
    public DisjSets(int numElements){
        s = new int[numElements];
        for (int i = 0; i < s.length; i++) {
            s[i] = -1;
        }
    }

    /**
     * 联合两个不相交集合类
     *
     * @param root1 集合1的根元素
     * @param root2 集合2的根元素
     */
    public void union(int root1, int root2){
        s[root2] = root1;
    }

    /**
     * 使用按高度求并方法
     *
     * @param root1 集合1的根元素
     * @param root2 集合2的根元素@
     */
    public void heightUnion(int root1, int root2){
        if(s[root2] < s[root1]){
            s[root1] = root2;
        }
        else {
            if(s[root2] == s[root1]){
                s[root1]--;
            }
            s[root2] = root1;
        }
    }

    /**
     * 执行查找
     *
     * @param x 待搜索的元素
     * @return 返回包含x的集合
     */
    public int find(int x){
        if(s[x] < 0) {
            return x;
        } else {
            return find(s[x]);
        }
    }

}
