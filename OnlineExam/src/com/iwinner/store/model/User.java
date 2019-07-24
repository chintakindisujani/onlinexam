package com.iwinner.store.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserIn")
public class User implements java.io.Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "USERNAME")
	public String username;
	@Column(name = "accountStatus")
	public String accountStatus;
	@Column(name = "emailId")
	public String emailId;
	@Column(name = "first_name")
	public String firstName;
	@Column(name = "last_name")
	public String lastName;
	@Column(name = "lastUpdateTime")
	public Timestamp lastUpdateTime;
	@Column(name = "loginTime")
	public Timestamp lastLoginTime;
	@Column(name = "PASSWORD")
	public String password;
	@Column(name = "passwordExpiration")
	public Date passwordExpirtationDate;
	@Column(name = "pastPassword")
	public String pastPassword;
	@Column(name = "phone")
	public String phone;
	@Column(name = "roleType")
	public String roleType;
	@Column(name = "updatedTime")
	public Timestamp updateTime;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getPasswordExpirtationDate() {
		return passwordExpirtationDate;
	}

	public void setPasswordExpirtationDate(Date passwordExpirtationDate) {
		this.passwordExpirtationDate = passwordExpirtationDate;
	}

	public String getPastPassword() {
		return pastPassword;
	}

	public void setPastPassword(String pastPassword) {
		this.pastPassword = pastPassword;
	}
	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}
	
	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String toString() {
		return "User [username=" + username + ", accountStatus="
				+ accountStatus + ", emailId=" + emailId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", lastUpdateTime="
				+ lastUpdateTime + ", lastLoginTime=" + lastLoginTime
				+ ", password=" + password + ", passwordExpirtationDate="
				+ passwordExpirtationDate + ", pastPassword=" + pastPassword
				+ ", phone=" + phone + ", roleType=" + roleType
				+ ", updateTime=" + updateTime + "]";
	}
}
