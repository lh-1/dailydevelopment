package org.katas.refactoring;

import org.katas.refactoring.utils.Constant;

public class LineItem {
    private String desc;
    private double p;
    private int qty;

    public LineItem(String desc, double p, int qty) {
        super();
        this.desc = desc;
        this.p = p;
        this.qty = qty;
    }

    public String getDescription() {
        return desc;
    }

    public double getPrice() {
        return p;
    }

    public int getQuantity() {
        return qty;
    }

    double totalAmount() {
        return p * qty;
    }

    /**
     * 总金额，含税
     *
     * @param rate
     * @return
     */
    double totalAmountWithTax(double rate) {
        return p * qty * (1 + rate);
    }

    /**
     * 税
     *
     * @param rate
     * @return
     */
    double totalTax(double rate) {
        return p * qty * rate;
    }

    @Override
    public String toString() {
        return this.desc + Constant.TAB +
                this.p + Constant.TAB +
                this.qty + Constant.TAB +
                totalAmount() + Constant.LINE_FEED;
    }
}