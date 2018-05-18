package com.cdut.myschool.core.dto;

import java.util.Date;

public class RoastDto {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roast.id
     *
     * @mbg.generated Mon May 07 15:12:54 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roast.user_id
     *
     * @mbg.generated Mon May 07 15:12:54 CST 2018
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roast.context
     *
     * @mbg.generated Mon May 07 15:12:54 CST 2018
     */
    private String context;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roast.type
     *
     * @mbg.generated Mon May 07 15:12:54 CST 2018
     */
    private Integer type;

    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roast.time
     *
     * @mbg.generated Mon May 07 15:12:54 CST 2018
     */
    private Date time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roast.cognate_id
     *
     * @mbg.generated Mon May 07 15:12:54 CST 2018
     */
    private String cognateId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roast.hide
     *
     * @mbg.generated Mon May 07 15:12:54 CST 2018
     */
    private Integer hide;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roast.id
     *
     * @return the value of roast.id
     *
     * @mbg.generated Mon May 07 15:12:54 CST 2018
     */
    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roast.id
     *
     * @param id the value for roast.id
     *
     * @mbg.generated Mon May 07 15:12:54 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roast.user_id
     *
     * @return the value of roast.user_id
     *
     * @mbg.generated Mon May 07 15:12:54 CST 2018
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roast.user_id
     *
     * @param userId the value for roast.user_id
     *
     * @mbg.generated Mon May 07 15:12:54 CST 2018
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roast.context
     *
     * @return the value of roast.context
     *
     * @mbg.generated Mon May 07 15:12:54 CST 2018
     */
    public String getContext() {
        return context;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roast.context
     *
     * @param context the value for roast.context
     *
     * @mbg.generated Mon May 07 15:12:54 CST 2018
     */
    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roast.type
     *
     * @return the value of roast.type
     *
     * @mbg.generated Mon May 07 15:12:54 CST 2018
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roast.type
     *
     * @param type the value for roast.type
     *
     * @mbg.generated Mon May 07 15:12:54 CST 2018
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roast.time
     *
     * @return the value of roast.time
     *
     * @mbg.generated Mon May 07 15:12:54 CST 2018
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roast.time
     *
     * @param time the value for roast.time
     *
     * @mbg.generated Mon May 07 15:12:54 CST 2018
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roast.cognate_id
     *
     * @return the value of roast.cognate_id
     *
     * @mbg.generated Mon May 07 15:12:54 CST 2018
     */
    public String getCognateId() {
        return cognateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roast.cognate_id
     *
     * @param cognateId the value for roast.cognate_id
     *
     * @mbg.generated Mon May 07 15:12:54 CST 2018
     */
    public void setCognateId(String cognateId) {
        this.cognateId = cognateId == null ? null : cognateId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roast.hide
     *
     * @return the value of roast.hide
     *
     * @mbg.generated Mon May 07 15:12:54 CST 2018
     */
    public Integer getHide() {
        return hide;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roast.hide
     *
     * @param hide the value for roast.hide
     *
     * @mbg.generated Mon May 07 15:12:54 CST 2018
     */
    public void setHide(Integer hide) {
        this.hide = hide;
    }
}