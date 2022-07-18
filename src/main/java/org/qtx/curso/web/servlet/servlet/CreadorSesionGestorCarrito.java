package org.qtx.curso.web.servlet.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class CreadorSesionGestorCarrito extends HttpServlet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
    HttpSession session = req.getSession(true);

    // Recuperar carrito a partir de la sesión. Si no existe, crearlo

    List<String> carritoDeCompras = (ArrayList<String>) session.getAttribute("carrito");
    if (carritoDeCompras == null) {
      carritoDeCompras = new ArrayList<String>();
      session.setAttribute("carrito", carritoDeCompras);
    } 
    
    PrintWriter salidaNavegador = res.getWriter();
    res.setContentType("text/html");
    
    //Recuperar la lista de productos elegidos a partir de la petición http y agregarlos al carrito
   
    String[] listaProductosElegidos = req.getParameterValues("productoElegido");
    String productoElegidoI;
    if (listaProductosElegidos != null) {
      for (int i = 0; i < listaProductosElegidos.length; i++) {
        productoElegidoI = listaProductosElegidos[i];
        carritoDeCompras.add(productoElegidoI);
      } 
    } 

    // Mostrar en la respuesta el contenido del carrito 
    
    String respuestaHtml=UtileriasHtml.getEncabezadosHtml("Datos de carrito y sesión");    
    respuestaHtml+="<H1>Seguros contratados</H1><BR>\n";
    salidaNavegador.println(respuestaHtml); 
    
    respuestaHtml="";
    
    for(String productoI:carritoDeCompras)
    	respuestaHtml+="<P>"+productoI + "</P>\n";
    respuestaHtml+="<BR>";
    
    //Armar link de "regreso"
    
    String url= res.encodeURL("catalogo"); // Para soportar la sesión aunque estén deshabilitadas las cookies
    
    respuestaHtml+="<P><A HREF=\"" + url  + "\">Regresar</A></P><BR><BR>\n";
    
    // Mostrar la cantidad de productos en el carrito
    
    respuestaHtml+=UtileriasHtml.getConteoProductosHtml(carritoDeCompras.size());
    
    // Mostrar los datos de la sesión
    
    respuestaHtml+= UtileriasHtml.getDatosSesionHtml(session);
    salidaNavegador.println(respuestaHtml);
    salidaNavegador.println(UtileriasHtml.getPieHtml()); 
  } 
}
