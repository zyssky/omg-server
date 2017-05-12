package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="avail")
@XmlRootElement
public class AvailCourtMsg {

	@Id
	private String courtTitle;
	
	private int availCount;
	
	
}
