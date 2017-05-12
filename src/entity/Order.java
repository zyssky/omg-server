package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name = "order_form")
@XmlRootElement
public class Order {

    @Id
    private Long id;
    
    private Long userId;
    
    private String courtTitle;
    
    private Date dateString;
    
	private int countNum;
	
	private double total;
    
//    
//    @Temporal(TemporalType.TIME)
    private Date startTime;
    
//    @Temporal(TemporalType.TIME)
    private Date endTime;
    
    public Order(long userId,String courtTitle,int courtNum,Date dateString,
    		Date startTime,Date endTime,double total){
    	this.userId = userId;
    	this.courtTitle = courtTitle;
    	this.dateString = dateString;
    	this.countNum = courtNum;
    	this.startTime = startTime;
    	this.endTime = endTime;
    	this.total = total;
    }
    
    public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Order () {
		
	}
    
    
//    private int availTimeType;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCourtTitle() {
		return courtTitle;
	}

	public void setCourtTitle(String courtTitle) {
		this.courtTitle = courtTitle;
	}

	public Date getDateString() {
		return dateString;
	}

	public void setDateString(Date dateString) {
		this.dateString = dateString;
	}

	public int getCountNum() {
		return countNum;
	}

	public void setCountNum(int countNum) {
		this.countNum = countNum;
	}



	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


    
    
    
    
   
    
    
}
