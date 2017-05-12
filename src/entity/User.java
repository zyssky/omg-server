package entity;


import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/** 
 * This class represents the basic user object.
 *
 * @author Sehwan Noh (devnoh@gmail.com)
 */
@Entity
@Table(name = "user")
@XmlRootElement
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", nullable = false, length = 64, unique = true)
    private String username;

    @Column(name = "password", length = 64)
    private String password;

    private double balance;
    
    public double getBalance() {
    	DecimalFormat decimalFormat = new DecimalFormat("###.00");
		return Double.parseDouble(decimalFormat.format(balance));
	}

	public void setBalance(double balance) {
		DecimalFormat decimalFormat = new DecimalFormat("###.00");
		this.balance = Double.parseDouble(decimalFormat.format(balance));
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	private int credit;
    
    public User(){
    	
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User (String username , String password , double balance , int credit){
    	this.balance = balance;
    	this.credit = credit;
    	this.username = username;
    	this.password = password;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
