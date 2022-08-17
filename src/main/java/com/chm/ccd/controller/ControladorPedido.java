package com.chm.ccd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chm.ccd.model.Ingrediente;
import com.chm.ccd.model.Menu;
import com.chm.ccd.model.Pedido;
import com.chm.ccd.model.Pedido_Menu;
import com.chm.ccd.model.Pedido_Producto;
import com.chm.ccd.model.Producto;
import com.chm.ccd.model.Producto_Ingrediente;
import com.chm.ccd.model.Restaurante;
import com.chm.ccd.model.Restaurante_Producto;
import com.chm.ccd.security.dto.Message;
import com.chm.ccd.security.jwt.JwtProvider;
import com.chm.ccd.service.ServicioPedido;
import com.chm.ccd.service.ServicioPedidoMenu;
import com.chm.ccd.service.ServicioPedidoProducto;
import com.chm.ccd.service.ServicioProducto;
import com.chm.ccd.service.ServicioUsuario;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "pedidos")
public class ControladorPedido {

	@Autowired
    ServicioPedido pedidoService;
	
	@Autowired
    ServicioUsuario userService;
	
	@Autowired
    ServicioProducto productService;
	
	@Autowired
    ServicioPedidoProducto pedidoProductService;
	
	@Autowired
    ServicioPedidoMenu pedidoMenuService;
	
	
	@Transactional
	@PostMapping("/newpedido")
	public ResponseEntity<?> nuevoPedido(@RequestBody Pedido nuevoPedido, @RequestParam String[] productos,@RequestParam String[] menus ){
		//System.out.println(nuevoPedido.getIdUsuario());
		nuevoPedido.setUsuario(userService.getById(nuevoPedido.getIdUsuario()).get());
		System.out.println("Menus" + menus.length);
		Pedido pedidoGuardado = pedidoService.save(nuevoPedido);
		for(int i=0;i<productos.length;i+=2) {
			Integer idProducto = Integer.parseInt(productos[i]);
			int cantidad = Integer.parseInt(productos[i+1]);
			//Producto producto = productService.getByName(nombre).get();
			//Producto_Ingrediente pIngrediente = new Producto_Ingrediente(productoGuardado.getIdProducto(),ingrediente.getIdIngrediente(),cantidad);
			Pedido_Producto pp = new Pedido_Producto(pedidoGuardado.getIdPedido(),idProducto,cantidad);
			pedidoProductService.save(pp);
		}
		for(int i=0;i<menus.length;i+=2) {
			Integer idMenu = Integer.parseInt(menus[i]);
			int cantidad = Integer.parseInt(menus[i+1]);
			//Producto producto = productService.getByName(nombre).get();
			//Producto_Ingrediente pIngrediente = new Producto_Ingrediente(productoGuardado.getIdProducto(),ingrediente.getIdIngrediente(),cantidad);
			Pedido_Menu pm = new Pedido_Menu(pedidoGuardado.getIdPedido(),idMenu,cantidad);
			pedidoMenuService.save(pm);
		}
		return new ResponseEntity<Message>(new Message("Pedido guardado"), HttpStatus.CREATED);
	}
	
	@GetMapping("/getPedidos")
	public List<Pedido> getMenusByNit(@RequestParam Long id) {
		return pedidoService.getPedidosById(id);
	}
}
