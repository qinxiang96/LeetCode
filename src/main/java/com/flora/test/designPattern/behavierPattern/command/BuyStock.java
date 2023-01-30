package com.flora.test.designPattern.behavierPattern.command;

/**
 * @Author qinxiang
 * @Date 2022/10/20-上午10:40
 */
public class BuyStock implements Order{
    private Stock stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}
