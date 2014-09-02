package com.saei.actions.product;

import com.saei.actions.BaseAction;

public class ProductSearchAction extends BaseAction {
	
	@Override
	public String execute() throws Exception {
		
		getServletRequest().setAttribute("produtos", 
				getAplicationEng().getProdutoEng().getAllProdutos());
		
		return SUCCESS;
	}
}
