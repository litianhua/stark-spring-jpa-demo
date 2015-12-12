package com.stark.demo.entitys;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * 用户实体类
 * @author stark
 */
@Entity
@Table(name="USER")
public class User implements Serializable {

	private static final long serialVersionUID = -6395834411937686352L;
	
	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;//唯一id，使用uuid生成策略
	
	@Column(name = "NAME", length = 50)
	private String name;//用户名
	
	@Column(name = "PWD", length = 50)
	private String pwd;//用户密码

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
