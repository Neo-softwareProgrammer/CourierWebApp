package za.ac.tut.logic;
/**
 *
 * @author Sboja
 */
public class OrderDetail {
    private String orderID;
    private String clientID;
    private double totalAmount;

    public OrderDetail() {
    }

    public OrderDetail(String orderID, String clientID, String totalAmount) {
        this.orderID = orderID;
        this.clientID = clientID;
        this.totalAmount = Float.parseFloat(totalAmount);
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getTotalAmount() {
        return String.format("%.2f", totalAmount);
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
