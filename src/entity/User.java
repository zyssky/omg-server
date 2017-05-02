package entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/** 
 * This class represents the basic user object.
 *
 * @author Sehwan Noh (devnoh@gmail.com)
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 4733464888738356502L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", nullable = false, length = 64, unique = true)
    private String username;

    @Column(name = "password", length = 64)
    private String password;

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
