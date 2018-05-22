package com.cdut.myschool.persist.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.id
     *
     * @mbg.generated Tue May 22 16:11:45 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.good_id
     *
     * @mbg.generated Tue May 22 16:11:45 CST 2018
     */
    private String goodId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.buyer_id
     *
     * @mbg.generated Tue May 22 16:11:45 CST 2018
     */
    private String buyerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.seller_id
     *
     * @mbg.generated Tue May 22 16:11:45 CST 2018
     */
    private String sellerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.time
     *
     * @mbg.generated Tue May 22 16:11:45 CST 2018
     */
    private Date time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.price
     *
     * @mbg.generated Tue May 22 16:11:45 CST 2018
     */
    private BigDecimal price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.status
     *
     * @mbg.generated Tue May 22 16:11:45 CST 2018
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.id
     *
     * @return the value of order.id
     *
     * @mbg.generated Tue May 22 16:11:45 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.id
     *
     * @param id the value for order.id
     *
     * @mbg.generated Tue May 22 16:11:45 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.good_id
     *
     * @return the value of order.good_id
     *
     * @mbg.generated Tue May 22 16:11:45 CST 2018
     */
    public String getGoodId() {
        return goodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.good_id
     *
     * @param goodId the value for order.good_id
     *
     * @mbg.generated Tue May 22 16:11:45 CST 2018
     */
    public void setGoodId(String goodId) {
        this.goodId = goodId == null ? null : goodId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.buyer_id
     *
     * @return the value of order.buyer_id
     *
     * @mbg.generated Tue May 22 16:11:45 CST 2018
     */
    public String getBuyerId() {
        return buyerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.buyer_id
     *
     * @param buyerId the value for order.buyer_id
     *
     * @mbg.generated Tue May 22 16:11:45 CST 2018
     */
    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId == null ? null : buyerId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.seller_id
     *
     * @return the value of order.seller_id
     *
     * @mbg.generated Tue May 22 16:11:45 CST 2018
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.seller_id
     *
     * @param sellerId the value for order.seller_id
     *
     * @mbg.generated Tue May 22 16:11:45 CST 2018
     */
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.time
     *
     * @return the value of order.time
     *
     * @mbg.generated Tue May 22 16:11:45 CST 2018
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.time
     *
     * @param time the value for order.time
     *
     * @mbg.generated Tue May 22 16:11:45 CST 2018
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.price
     *
     * @return the value of order.price
     *
     * @mbg.generated Tue May 22 16:11:45 CST 2018
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.price
     *
     * @param price the value for order.price
     *
     * @mbg.generated Tue May 22 16:11:45 CST 2018
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.status
     *
     * @return the value of order.status
     *
     * @mbg.generated Tue May 22 16:11:45 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.status
     *
     * @param status the value for order.status
     *
     * @mbg.generated Tue May 22 16:11:45 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}