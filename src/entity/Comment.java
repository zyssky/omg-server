package entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "comment")
@XmlRootElement
public class Comment {
	@Id
	private Long id;
	
	private String username;
	
	private String courtTitle;
	
	private String content;
	
	private Date date;
	
	public Comment(){
		
	}
	
	public Comment(Long id , String username , String courtTitle , String content , Date date){
		this.id = id;
		this.content = content;
		this.username = username;
		this.courtTitle = courtTitle;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCourtTitle() {
		return courtTitle;
	}

	public void setCourtTitle(String courtTitle) {
		this.courtTitle = courtTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
