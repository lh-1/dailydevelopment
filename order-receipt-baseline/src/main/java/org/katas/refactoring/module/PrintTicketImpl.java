package org.katas.refactoring.module;

import org.katas.refactoring.LineItem;
import org.katas.refactoring.Order;
import org.katas.refactoring.utils.Constant;

import java.util.List;

/**
 * @author msh11535
 */
public class PrintTicketImpl extends PrintTicket {


    @Override
    void printHeaders(Order order, StringBuilder output) {
        output.append("======Printing Orders======" + Constant.LINE_FEED);
    }

    @Override
    void printCustomer(Order order, StringBuilder output) {
        output.append(order.getCustomerName() + order.getCustomerAddress() + Constant.LINE_FEED);
    }

    @Override
    void printsLineItems(Order order, StringBuilder output) {
        List<LineItem> lineItems = order.getLineItems();
        if (lineItems != null && lineItems.size() > 0) {
            lineItems.stream().forEach(lineItem -> output.append(lineItem.toString()));
        }
    }

    @Override
    void printSummary(Order order, StringBuilder output) {
        if (order.getLineItems() != null && order.getLineItems().size() > 0) {
            output.append("Sales Tax").append(Constant.TAB).append(order.findTotalTax(Constant.RATE));
            output.append("Total Amount").append(Constant.TAB).append(order.findTotalAmount() + order.findTotalTax(Constant.RATE));
        }
    }
}
