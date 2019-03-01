package com.mycat.app.entity.mall;

/**
 * @FileName: CartItem
 * @Author: <a href="dongann@aliyun.com">dongchang'an</a>.
 * @CreateTime: 2019/1/7 下午11:26
 * @Version: v1.0
 * @description:
 */
public class CartItem {
    private int productId;
    private int quantity;
    private double price;
    private double subtotal;
    private double discount;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}