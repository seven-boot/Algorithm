package com.seven.level0;

/**
 * @author QH
 * @date 2019/10/18
 * @description 线程不安全的银行取钱
 */
public class UnsafeBankTest {

    public static void main(String[] args) {
        Account account = new Account(100, "结婚礼金");
        Drawing you = new Drawing(account, 90, "你");
        Drawing she = new Drawing(account, 100, "她");
        you.start();
        she.start();
    }
}

// 账户
class Account{
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

// 模拟取钱
class Drawing extends Thread{
    Account account;    // 取钱的账户
    int drawingMoney;   // 取得钱数
    int packageTotal;   // 口袋里的钱

    Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        action();
    }

    // 锁提款机没用！应该锁account
    private void action() {
        if (account.money <= 0) {   // 提高性能，（失之毫厘，差之千里）
            return;
        }
        /**
         * synchronized 锁范围太小，锁不住；范围太大，效率低下
         */
        synchronized (account) {    // synchronized块，括号内是引用类型，也要是一个不变的对象，即地址不变
            if (account.money - drawingMoney < 0) {
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawingMoney;
            packageTotal += drawingMoney;
            System.out.println(this.getName() + "账户余额为："+account.money);
            System.out.println(this.getName() + "口袋里的钱为："+packageTotal);
        }
    }
}