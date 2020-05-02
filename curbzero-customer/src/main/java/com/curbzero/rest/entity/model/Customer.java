package com.curbzero.rest.entity.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @Column(name = "CRB_CUST_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
    private Long id;

    @Column(name = "ROLE", length = 100)
    @Size(min = 4, max = 100)
    @NotNull
    private String role;

    @Column(name = "PASSWORD", length = 100)
    @Size(min = 4, max = 100)
    @NotNull
    private String password;

    @Column(name = "ADDRESS", length = 100)
    @Size(min = 4, max = 100)
    @NotNull
    private String address;

    @Column(name = "NAME", length = 50, unique = true)
    @NotNull
    @Size(min = 4, max = 50)
    private String name;
    
    @Column(name = "PHONE", length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private String phone;
    
    @Column(name = "EMAIL", length = 50, unique = true)
    @NotNull
    @Size(min = 4, max = 50)
    private String email;
    
    @Column(name = "COMMENTS", length = 200)
    @NotNull
    @Size(min = 4, max = 200)
    private String comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
    
 
}