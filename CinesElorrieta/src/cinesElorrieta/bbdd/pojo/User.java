package cinesElorrieta.bbdd.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * Object of the t_cliente from the DB. It represents a User.
 */
public class User implements Serializable {

	private static final long serialVersionUID = 2732415763483267232L;

	String userId = null;
	String userName = null;
	String userLasName = null;
	String userSex = null;
	String userPassword = null;
	String userEmail = null;
	// int ticketId = null; Esto es la relacion no se como hacerla

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLasName() {
		return userLasName;
	}

	public void setUserLasName(String userLasName) {
		this.userLasName = userLasName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userEmail, userId, userLasName, userName, userPassword, userSex);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userEmail, other.userEmail) && Objects.equals(userId, other.userId)
				&& Objects.equals(userLasName, other.userLasName) && Objects.equals(userName, other.userName)
				&& Objects.equals(userPassword, other.userPassword) && Objects.equals(userSex, other.userSex);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userLasName=" + userLasName + ", userSex="
				+ userSex + ", userPassword=" + userPassword + ", userEmail=" + userEmail + "]";
	}

}
