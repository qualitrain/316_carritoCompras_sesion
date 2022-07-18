package org.qtx.curso.web.servlet.servlet;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class SeleccionadorProductos extends HttpServlet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
	
	int numProductosEnCarrito = 0;
	
    HttpSession session = req.getSession(true);
    List<String> carritoDeCompras = (ArrayList<String>) session.getAttribute("carrito");
    if(carritoDeCompras!=null)
        numProductosEnCarrito = carritoDeCompras.size();

    res.setContentType("text/html");
    PrintWriter salidaNavegador = res.getWriter();
    salidaNavegador.println(UtileriasHtml.getEncabezadosHtml("Selección de Productos"));
    
    String url = res.encodeURL("carritoDeCompras");
    System.out.println(url);
    
    salidaNavegador.println(UtileriasHtml.getCuerpoPagSeleccionProdHtml(url));

    salidaNavegador.println(UtileriasHtml.getConteoProductosHtml(numProductosEnCarrito));
    salidaNavegador.println(UtileriasHtml.getDatosSesionHtml(session));
    salidaNavegador.println(UtileriasHtml.getPieHtml());
   } 
  
}
