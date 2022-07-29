package org.example.staticProxy;

/**
 * 静态代理 - 代理角色
 *  实现行为
 *  增强行为
 */
public class MarryCompany implements Marry {
    //目标角色固定
    private final You target;

    public MarryCompany(You target) {
        //通过带参构造器传递目标
        this.target = target;
    }
    @Override
    public void toMarry() {
        before();
        this.target.toMarry();
        after();
    }

    private void after() {
        System.out.println("新婚快乐....");
    }

    private void before() {
        System.out.println("正在布置婚礼现场....");
    }
}
