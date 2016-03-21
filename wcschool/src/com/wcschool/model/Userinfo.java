package com.wcschool.model;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */
public class Userinfo extends AbstractUserinfo implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -9180286591819579954L;

	/** default constructor */
	public Userinfo() {
	}

	/** full constructor */
	public Userinfo(String password, String username) {
		super(password, username);
	}

}
