
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Tu Agenda Telefonica</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="diseño/css/styles.css">
    </head>
    <body>
        <c:set var = "userId" value = "${sessionScope['userID']}" />
			<div class="uno">            
                  
       			 <h1>TU AGENDA TELEFONICA </h1>                    
    		</div>
      		
      			
                    <div class="item">
                        <form action="busqueda">
                            <div class="ui left icon action input">
                                <i class="users icon"></i>
                                <input type="text" placeholder="Buscar..." name="usuario">
                                <input type="submit" class="ui blue submit button" value="Buscar">
                            </div>
                        </form>
                    </div>
                    
                    <c:choose>
                        <c:when test="${userId == null}">
                            <div class="item1">
                                <a href="registro" class="ui primary button">Registro</a>
                            </div>
                            <div class="item1">
                                <a href="login" class="ui button">Iniciar Sesion</a> 
                            </div>
                            <div class="item1">
                                <a href="my-agenda" class="ui primary button">Mi perfil</a>
                            </div>
                            
                        </c:when>    
                       
                    </c:choose>
              
       <div class="item1">
            
                <div class="buttuns-content">
                  
                    <a href="busqueda?usuario=all">Ver Usuarios</a>
                </div>
        </div>

        <footer>
            
            <p>&COPY;  Todos los derechos reservados | Designed By Marcelo Durazno</p>
        </footer>

        
    </body>
</html>
