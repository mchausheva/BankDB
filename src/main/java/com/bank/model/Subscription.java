package com.bank.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC,force = true)
@Entity (name = "subscriptions")
@Table(name = "up_subscriptions")
public class Subscription implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
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
    
    @Column(name = "merchant_name")
    public final String merchantName;
    
    @Column(name = "customer_name")
    public final String customerName;
    
    @Column(name = "address")
    public final String address;
    
    @Column(name = "short_desc")
    public final String shortDesc;
    
    @Column(name = "payment_method")
    public final String paymentMethod;
    
    @Column(name = "payment_account")
    public final String paymentAccount;
    
    @Column(name = "payment_account_desc")
    public final String paymentAccountDesc;
    
    @Column(name = "automatic_payment")
    public final Boolean automaticPayment;
    
    @Column(name = "automatic_max_amount")
    public final Integer maxAmountAuto;
    
    @Column(name = "automatic_max_days_retry")
    public final Integer retryDays;
    
    @Column(name = "insert_date")
    public final Date insertDate;
    
    @Column(name = "last_update_date")
    public final Date lastUpdateDate;
    
    @Column(name = "cached_due_amount")
    public final Integer cachedDueAmount;
    
    @Column(name = "cached_due_checked_date")
    public final Date cachedDueCheckedDate;
    
    @Column(name = "cached_due_service_response")
    public final String cachedDueServiceResponse;
    
    @Column(name = "cached_due_error_code")
    public final String cachedDueErrorCode;
    
    @Column(name = "cached_due_error_description")
    public final String cachedDueErrorDescription;
    
    @Column(name = "cached_due_id")
    public final Integer cachedDueId;
}