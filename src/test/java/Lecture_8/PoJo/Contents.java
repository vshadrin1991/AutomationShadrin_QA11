package Lecture_8.PoJo;

public class Contents {
    String contents;
    String productID;
    String productName;
    String quantity;

    public String getContents() {
        return contents;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Contents{" +
                "contents='" + contents + '\'' +
                ", productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
