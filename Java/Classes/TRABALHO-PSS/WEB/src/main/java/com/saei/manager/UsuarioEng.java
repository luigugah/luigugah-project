package com.saei.manager;

import java.util.Date;
import java.util.List;

import com.saei.domain.commons.Usuario;
import com.saei.services.UsuarioService;

public class UsuarioEng {

	private static UsuarioService USUARIO_SERVICE;
	
	static {
		USUARIO_SERVICE = new UsuarioService();
	}
	
	public Usuario registerProduct(Usuario usuario){
		usuario.setDataCadastro(new Date());
		USUARIO_SERVICE.salvarUsuario(usuario);
		
		return usuario;
	}
	
	public List<Usuario> getAllUsuarios(){
		return USUARIO_SERVICE.searchUsuario(null);
	}
	
	public void deleteProductByProduct(Usuario usuario){
		if(usuario != null){
			deleteProductById(usuario.getId());
		}
	}
	
	public void deleteProductById(int id){
		Usuario prod = new Usuario();
		prod.setId(id);
		USUARIO_SERVICE.removeUsuario(prod);
	}
	
	public Usuario getUsuarioById(int id){
		return USUARIO_SERVICE.searchUsuarioById(id);
	}
	
	public void updateUsuarioByUsuario(Usuario usuario){
		USUARIO_SERVICE.updateUsuario(usuario);
	}
}