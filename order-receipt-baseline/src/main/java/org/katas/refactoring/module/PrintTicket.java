package org.katas.refactoring.module;

import org.katas.refactoring.Order;

/**
 * 模版方法模式
 *
 * @author msh11535
 */
public abstract class PrintTicket {

    public final String print(Order order) {
        StringBuilder output = new StringBuilder();
        printHeaders(order, output);
        printCustomer(order, output);
        printsLineItems(order, output);
        printSummary(order, output);
        return output.toString();
    }

    abstract void printHeaders(Order order, StringBuilder output);

    abstract void printCustomer(Order order, StringBuilder output);

    abstract void printsLineItems(Order order, StringBuilder output);

    abstract void printSummary(Order order, StringBuilder output);

}
