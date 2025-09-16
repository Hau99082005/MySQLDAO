package hau.dev.data.model;
import java.sql.Timestamp;

public class Order {
	public String code;
	public Boolean status;
	public int user_id;
	public Timestamp created_at;
	public Order(String code, Boolean status, int user_id, Timestamp created_at) {
		super();
		this.code = code;
		this.status = status;
		this.user_id = user_id;
		this.created_at = created_at;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
}
