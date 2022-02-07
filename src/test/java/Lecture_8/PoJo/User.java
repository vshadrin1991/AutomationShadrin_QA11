package Lecture_8.PoJo;

import java.util.List;

public class User {
    Double orderID;
    String shopperName;
    String shopperEmail;
    List<Contents> contents;
    Boolean orderCompleted;

    public Double getOrderID() {
        return orderID;
    }

    public String getShopperName() {
        return shopperName;
    }

    public String getShopperEmail() {
        return shopperEmail;
    }

    public List<Contents> getContents() {
        return contents;
    }

    public Boolean getOrderCompleted() {
        return orderCompleted;
    }

    @Override
    public String toString() {
        return "User{" +
                "orderID='" + orderID + '\'' +
                ", shopperName='" + shopperName + '\'' +
                ", shopperEmail='" + shopperEmail + '\'' +
                ", contents=" + contents +
                ", orderCompleted=" + orderCompleted +
                '}';
    }
}

