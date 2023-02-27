package jums;

import java.io.Serializable;
import java.sql.Timestamp;

public class CartDataDTO implements Serializable{
	private int CartID;
	private int user_id;
	private int product_id;
	private int quantity;
	private Timestamp added_date;
	private Boolean cart_delete_flag;

	public int getCartID() {
		return CartID;
	}
	public void setCartID(int cartID) {
		CartID = cartID;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Timestamp getAdded_date() {
		return added_date;
	}
	public void setAdded_date(Timestamp added_date) {
		this.added_date = added_date;
	}
	public Boolean getCart_delete_flag() {
		return cart_delete_flag;
	}
	public void setCart_delete_flag(Boolean cart_delete_flag) {
		this.cart_delete_flag = cart_delete_flag;
	}
}
