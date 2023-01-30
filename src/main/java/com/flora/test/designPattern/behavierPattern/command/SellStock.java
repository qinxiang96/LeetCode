package com.flora.test.designPattern.behavierPattern.command;

/**
 * @Author qinxiang
 * @Date 2022/10/20-上午10:42
 */
public class SellStock implements Order{
    private Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}
