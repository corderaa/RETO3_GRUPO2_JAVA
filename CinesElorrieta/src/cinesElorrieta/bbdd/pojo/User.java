package cinesElorrieta.bbdd.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Object of the t_cliente from the DB. It represents a User.
 */
public class User implements Serializable {

	private static final long serialVersionUID = 2732415763483267232L;

	private String userId = null;
	private String userName = null;
	private String userLasName = null;
	private String userGender = null;
	private String userPassword = null;
	private String userEmail = null;

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
		return userGender;
	}

	public void setUserSex(String userSex) {
		this.userGender = userSex;
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
		return Objects.hash(userEmail, userId, userLasName, userName, userPassword, userGender);
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
				&& Objects.equals(userPassword, other.userPassword) && Objects.equals(userGender, other.userGender);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userLasName=" + userLasName + ", userSex="
				+ userGender + ", userPassword=" + userPassword + ", userEmail=" + userEmail + "]";
	}
}
