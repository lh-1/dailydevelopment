package org.katas.refactoring;

import org.katas.refactoring.utils.CommonUtils;

import java.util.List;

public class Order {
    String nm;
    String addr;
    List<LineItem> li;

    public Order(String nm, String addr, List<LineItem> li) {
        this.nm = nm;
        this.addr = addr;
        this.li = li;
    }

    public String getCustomerName() {
        return nm;
    }

    public String getCustomerAddress() {
        return addr;
    }

    public List<LineItem> getLineItems() {
        return li;
    }

    /**
     * 可实现打印方法
     *
     * @return
     */
    public String print() {
        return null;
    }

    private Double totalTax;

    public Double findTotalAmount() {
        if (this.li != null && this.li.size() > 0) {
            return this.li.stream().mapToDouble(item -> item.totalAmount()).sum();
        }
        return null;
    }

    public Double findTotalTax(double rate) {
        if (this.li != null && this.li.size() > 0) {
            totalTax = 0D;
            this.li.stream().forEach(item -> totalTax += item.totalAmount() * rate);
        }
        return totalTax;
    }

}
