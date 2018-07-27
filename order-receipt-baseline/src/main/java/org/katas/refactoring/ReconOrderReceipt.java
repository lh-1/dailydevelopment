package org.katas.refactoring;

import org.katas.refactoring.utils.Constant;

import java.util.List;

public class ReconOrderReceipt {

    public String printReceipt(Order order) {
        StringBuilder output = new StringBuilder();
        printHeaders(output);
        printCustomer(order, output);
        printsLineItems(order, output);
        printSummary(order, output);
        return output.toString();
    }

    private void printsLineItems(Order order, StringBuilder output) {
        List<LineItem> lineItems = order.getLineItems();
        if (lineItems != null && lineItems.size() > 0) {
            lineItems.stream().forEach(lineItem -> output.append(lineItem.toString()));
        }
    }

    private void printHeaders(StringBuilder output) {
        output.append("======Printing Orders======" + Constant.LINE_FEED);
    }

    private void printCustomer(Order order, StringBuilder output) {
        output.append(order.getCustomerName() + order.getCustomerAddress() + Constant.LINE_FEED);
    }

    private void printSummary(Order order, StringBuilder output) {
        if (order.getLineItems() != null && order.getLineItems().size() > 0) {
            output.append("Sales Tax").append(Constant.TAB).append(order.findTotalTax(Constant.RATE));
            output.append("Total Amount").append(Constant.TAB).append(order.findTotalAmount() + order.findTotalTax(Constant.RATE));
        }
    }

}
