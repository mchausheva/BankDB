package com.bank.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC,force = true)
@Entity //(name = "subscription")
@Table(name = "up_subscription")
public class Subscription implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "subscription_id")
    public final Integer subscriptionId;
    
    @Column(name = "user_id")
    public final Integer userId;
    
    @Column(name = "alias")
    public final String alias;
    
    @Column(name = "merchant_ref_no")
    public final String merchantRefNo;
    
    @Column(name = "merchant_id")
    public final Integer merchantId;
    
    @Column(name = "customer_name")
    public final String customerName;
    
    @Column(name = "address")
    public final String address;
    
    @Column(name = "short_desc")
    public final String short_desc;
    
    @Column(name = "payment_method")
    public final String paymentMethod;
    
    @Column(name = "payment_account")
    public final String paymentAccount;
    
    @Column(name = "automatic_payment")
    public final Boolean automatic_payment;
    
    @Column(name = "automatic_max_amount")
    public final Boolean automatic_max_amount;
    
    @Column(name = "automatic_max_days_retry")
    public final Integer automatic_max_days_retry;
    
    @Column(name = "insert_date")
    public final String insert_date;
    
    @Column(name = "last_update_date")
    public final String last_update_date;
    
    @Column(name = "cached_due_amount")
    public final Integer cached_due_amount;
    
    @Column(name = "cached_due_checked_date")
    public final String cached_due_checked_date;
    
    @Column(name = "cached_due_service_response")
    public final String cached_due_service_response;
    
    @Column(name = "cached_due_error_code")
    public final String cached_due_error_code;
    
    @Column(name = "cached_due_error_description")
    public final String cached_due_error_description;
    
    @Column(name = "cached_due_id")
    public final Integer cached_due_id;
}