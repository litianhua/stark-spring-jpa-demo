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

	@Column(name = "STATE", length = 2)
	private String state;//0表示禁用，1表示启用
	
	@Column(name = "DESCRIPTION", length = 200)
	private String description;//描述信息
	
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
