package org.qtx.curso.web.servlet.servlet;

import java.util.Date;

import javax.servlet.http.HttpSession;

public class UtileriasHtml {
	public static String getEncabezadosHtml(String nombrePestaniaNavegador){
	    String encabezadoHtml="";
	    
	    encabezadoHtml+="<!DOCTYPE HTML>\n";
	    encabezadoHtml+="<HTML><HEAD>\n";
	    encabezadoHtml+="<TITLE>"+nombrePestaniaNavegador+"</TITLE>\n";
	    encabezadoHtml+="<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"/> \n";
	    encabezadoHtml+="<link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\" />\n";
	    encabezadoHtml+="<link rel=\"stylesheet\" href=\"css/formStyle.css\" type=\"text/css\" />\n";
	    encabezadoHtml+="</HEAD>\n";
	    encabezadoHtml+="<BODY>\n";
	    return encabezadoHtml;
	}
	public static String getConteoProductosHtml(int numProductosEnCarrito){
		String SPAN = "<span class=\"valor\">";
		String FIN_SPAN = "</span>\n";
		String conteoProductosHtml= "<BR>Cantidad de productos en el carrito:";
		conteoProductosHtml += SPAN + numProductosEnCarrito + FIN_SPAN + "<BR>";

		return conteoProductosHtml;
		
	}
	public static String getDatosSesionHtml(HttpSession session){
		String SPAN = "<span class=\"valor\">";
		String FIN_SPAN = "</span>\n";
		String datosSesionHtml="<BR>Estado:";
		if (session.isNew()) 
			datosSesionHtml+=SPAN + "Nueva Sesion." + FIN_SPAN;
		else 
			datosSesionHtml+=SPAN + "Sesion Activa." + FIN_SPAN;
		datosSesionHtml+="<BR>ID: " 		+ SPAN + session.getId() + FIN_SPAN;
		datosSesionHtml+="<BR>Creación: " + SPAN + new Date(session.getCreationTime()) + FIN_SPAN;
		datosSesionHtml+="<BR>Ultimo acceso:"+ SPAN + new Date(session.getLastAccessedTime()) + FIN_SPAN;
		datosSesionHtml+="<BR>Intervalo Maximo de inactividad(segundos):"+ SPAN + session.getMaxInactiveInterval()+ FIN_SPAN;
		return datosSesionHtml;
	}
	public static String getPieHtml(){
		return "</BODY>" + "</HTML>\n";
	}
	public static String getCuerpoPagSeleccionProdHtml(String url){
		String htmlPagina = "";
		htmlPagina+="<div id=\"wrap\">"+"\n";
		htmlPagina+="<div id=\"sidebar\">"+"\n";
		htmlPagina+="<img src=\"img/logo.jpg\" alt=\"Qtx de M&eacute;xico.\" />"+ "</div>"+"\n";
		htmlPagina+="<div id=\"container\">";
		htmlPagina+="<div id=\"title\">Capacitaci&oacute;n JavaWeb<br/>Qtx de M&eacute;xico.</div>"+"\n";
		htmlPagina+="<div id=\"content2\">"+"\n";
		htmlPagina+="<div id=\"main\">"+"\n";
		htmlPagina+="<TABLE id=\"tbTitulos\">"+"\n";
		htmlPagina+="<TR>"+"\n";
		htmlPagina+="<TD valign=\"top\"> <img src=\"Seguros.jpg\" height=\"150\"> </TD>"+"\n";
		htmlPagina+="<TD align=\"center\" valign=\"center\"> <H3>SELECCI&Oacute;N DE SEGUROS POR CLIENTE</H3></TD>"+"\n";
		htmlPagina+="</TR> "
				   + "</TABLE><P> </P>"+"\n";
		
		htmlPagina+="<FORM ACTION=\""+ url +"\" METHOD=\"POST\">"+"\n";
		
		htmlPagina+="<TABLE id=\"tbProductos\">"+"\n";
		htmlPagina+="<TR><TD  colspan=\"2\"><B>EL CLIENTE CONTAR&Aacute; CON LOS SIGUIENTES BENEFICIOS:</B></TD></TR>"+"\n";
		htmlPagina+="<TR>"+"\n";
		htmlPagina+="<TD> <INPUT TYPE=\"Checkbox\" NAME=\"productoElegido\"  VALUE=\"SEGURO DE VIDA\"></TD>"+"\n";
		htmlPagina+="<TD>SEGURO DE VIDA</TD>"+"\n";
		htmlPagina+="</TR>"+"\n";
		htmlPagina+="<TR>"+"\n";
		htmlPagina+="<TD> <INPUT TYPE=\"Checkbox\" NAME=\"productoElegido\" VALUE=\"SEGURO DE GASTOS MEDICOS MAYORES\"></TD>"+"\n";
		htmlPagina+="<TD>SEGURO DE GASTOS M&Eacute;DICOS MAYORES</TD>"+"\n";
		htmlPagina+="</TR>"+"\n";
		htmlPagina+="<TR>"+"\n";
		htmlPagina+="<TD> <INPUT TYPE=\"Checkbox\" NAME=\"productoElegido\" VALUE=\"SEGURO DE AUTO\"></TD>"+"\n";
		htmlPagina+="<TD>SEGURO DE AUTO</TD>"+"\n";
		htmlPagina+="</TR>"+"\n";
		htmlPagina+="<TR>"+"\n";
		htmlPagina+="<TD> <INPUT TYPE=\"Checkbox\" NAME=\"productoElegido\" VALUE=\"SEGURO DE EMPLEO\"></TD>"+"\n";
		htmlPagina+="<TD>SEGURO DE EMPLEO</TD>"+"\n";
		htmlPagina+="</TR>"+"\n";
		htmlPagina+="</TABLE><P>"+"\n";
		htmlPagina+="<INPUT TYPE=\"Submit\" NAME=\"btn_submit\"  VALUE=\"Añadir beneficios al Cliente\">"+"\n";
		htmlPagina+="</FORM></div></div>"+"\n";
		htmlPagina+="<div id=\"footer\"><br>"+"\n";
		htmlPagina+="<a href=\"http://www.qualitrain.com.mx\">Qualitrain Express</a>"+"\n";
		htmlPagina+="</div> </div> </div>"+"\n";
		
		return htmlPagina;
	}

}
