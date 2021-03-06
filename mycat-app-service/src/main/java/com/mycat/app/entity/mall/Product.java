package com.mycat.app.entity.mall;

import java.util.Date;

/**
 * @FileName: Product
 * @Author: <a href="dongann@aliyun.com">dongchang'an</a>.
 * @CreateTime: 2019/1/7 下午11:26
 * @Version: v1.0
 * @description:
 */
public class Product {
    private int productId;
    private String sku;
    private String category;
    private double price;
    private String title;
    private Date createdAt;
    private Date lastUpdate;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? "" : sku;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? "" : category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? "" : title;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt == null ? new Date() : createdAt;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }
}