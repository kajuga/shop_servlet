package com.fedorovs.shop.servlet.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fedorovs.shop.form.ProductForm;
import com.fedorovs.shop.model.ShoppingCart;
import com.fedorovs.shop.util.SessionUtils;



@WebServlet("/ajax/json/product/remove")
public class RemoveProductController extends AbstractProductController {

	@Override
	protected void processProductForm(ProductForm form, ShoppingCart shoppingCart, HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException {
		getOrderService().removeProductFromShoppingCart(form, shoppingCart);
		if (shoppingCart.getItems().isEmpty()) {
			SessionUtils.clearCurrentShoppingCart(req, resp);
		} else {
			String cookieValue = getOrderService().serializeShoppingCart(shoppingCart);
			SessionUtils.updateCurrentShoppingCartCookie(cookieValue, resp);
		}
	}
}
