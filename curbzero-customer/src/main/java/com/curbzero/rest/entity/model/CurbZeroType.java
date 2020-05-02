package com.curbzero.rest.entity.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "CRB_ZERO_TYPE")
public class CurbZeroType {

    @Id
    @Column(name = "CRB_ZERO_TY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curb_type_seq")
    @SequenceGenerator(name = "curb_type_seq", sequenceName = "curb_type_seq", allocationSize = 1)
    private Long id;

    @Column(name = "TYPE")
    private String type;
    
    @CreationTimestamp
	private LocalDateTime createDateTime;
    
    @Column(name = "COMMENTS", length = 200)
    @Size(min = 4, max = 200)
    private String comments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
