package jp.matrix.service;

import java.util.List;

import lombok.Data;

@Data
public class CartItem {
	private int cartId;
	
	private List<Item> itemList; 
}
