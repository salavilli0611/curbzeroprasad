package com.curbzero.rest.entity.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "CRB_ZERO_STORE_CUST")
public class StoreCustomer {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_store_seq")
    @SequenceGenerator(name = "customer_store_seq", sequenceName = "customer_store_seq", allocationSize = 1)
    private Long id;

    @Column(name = "CRB_CUST_ID", length = 100)
    @Size(min = 4, max = 100)
    @NotNull
    private String customerId;

    @Column(name = "STORE_ID", length = 100)
    @Size(min = 4, max = 100)
    @NotNull
    private String storeId;
    
    @Column(name = "STORE_ORDER_ID", length = 100)
    @Size(min = 4, max = 100)
    @NotNull
    private String storeOrderId;
    
    @Column(name = "CUST_STATUS", length = 100)
    @Size(min = 1, max = 100)
    @NotNull
    private String custStatus;
    
    @CreationTimestamp
	private LocalDateTime createDateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreOrderId() {
		return storeOrderId;
	}

	public void setStoreOrderId(String storeOrderId) {
		this.storeOrderId = storeOrderId;
	}

	public String getCustStatus() {
		return custStatus;
	}

	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}
}