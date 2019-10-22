package com.seven.level10;

/**
 * @author QH
 * @date 2019/10/21
 * @description 浅复制测试：ArrayList的fastRemove方法
 */
public class ShallowCopy {
    public static void main(String[] args) {
        Ve[] v1 = new Ve[1];
        v1[0] = new Ve("jack");
        Ve[] v2 = new Ve[1];
        System.out.println(v1[0]);
        /*
         * 调用 System.arraycopy();
         */
        System.arraycopy(v1, 0, v2, 0, 1);
        System.out.println(v2[0]);

        System.out.println("v1修改前："+v1[0].name);
        System.out.println("v2修改前："+v2[0].name);

        /*
            由于 v1[0] 和 v2[0] 指向同一个地址，
         */
        v1[0].name = "nick";
        System.out.println("v1修改后："+v1[0].name);
        System.out.println("v2："+v2[0].name);
    }

    static class Ve{
        String name;

        Ve(String name) {
            this.name = name;
        }
    }
}
