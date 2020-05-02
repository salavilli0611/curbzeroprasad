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
@Table(name = "CRB_ZERO_STORE")
public class Store {

    @Id
    @Column(name = "CRB_CUST_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curb_store_seq")
    @SequenceGenerator(name = "curb_store_seq", sequenceName = "curb_store_seq", allocationSize = 1)
    private Long id;
    
    @Column(name = "STORE_NAME", length = 100)
    @Size(min = 4, max = 100)
    private String name;
    
    @Column(name = "STORE_LAT", length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private String latitude;
    
    @Column(name = "STORE_LON", length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private String longitude;
    
    @Column(name = "COMMENTS", length = 200)
    @Size(min = 4, max = 200)
    private String comments;
    
    @Column(name = "TRIP_PING")
    private int tripPing;
    
    @Column(name = "TRIP_RANGE")
    private int tripRange;
    
    @CreationTimestamp
	private LocalDateTime createDateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getTripPing() {
		return tripPing;
	}

	public void setTripPing(int tripPing) {
		this.tripPing = tripPing;
	}

	public int getTripRange() {
		return tripRange;
	}

	public void setTripRange(int tripRange) {
		this.tripRange = tripRange;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}
}
