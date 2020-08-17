package biz.xsoftware.api.usersvc;

public interface User {

	public abstract int getId();

	public abstract void setId(int id);

	public abstract String getFirstName();

	public abstract void setFirstName(String firstName);

	public abstract String getLastName();

	public abstract void setLastName(String lastName);

}