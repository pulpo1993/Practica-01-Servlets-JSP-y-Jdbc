

<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Buscar</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/e564244708.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="diseño/css/styles.css">
    </head>
     <body>
    
        <c:set var = "users" value = "${requestScope['users']}" />
        <c:set var = "userId" value = "${sessionScope['userID']}" />
          <div id="fullscreen_bg" class="fullscreen_bg"/>
        <div class="ui container">
            <div class="ui secondary  menu">
                <div class="item logo">
                    <a href="/Practica-01-JSP-Servlets-Jdbc"><h2><span>AGENDA TELEFONICA</span></h2></a>
                </div>

                <div class="right menu">
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
                            <div class="item">
                                <a href="registro" class="ui primary button">Registro</a>
                            </div>
                            <div class="item">
                                <a href="login" class="ui button">Iniciar Sesion</a> 
                            </div>
                        </c:when>    
                        <c:otherwise>
                            <div class="item">
                                <a href="my-agenda" class="ui primary button">Mi perfil</a>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>

        <div class="ui container">
            <c:choose>
                <c:when test="${users.size() > 0}">
                    <table class="table table-hover">
                        <thead>
                        	<tr>
                        	<td>Usuarios</td>
                        	</tr>
                            <tr>
                                <th scope="col">Nombre</th>
                                <th scope="col">Apellido</th>
                                <th scope="col">Correo</th>
                            	<th scope="col">Cedula</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="i" value = "${0}"/>
                            <c:forEach var="user" items="${users}">
                                <c:set var="i" value = "${i+1}"/>
                                <tr data-toggle="modal" data-target="#exampleModal${i}" data-whatever="@mdo">
                                    <td>
                                        <div class="ui middle aligned selection list">
                                            <div class="item">
                                               
                                                <div class="content">
                                                    <div class="header">${user.nombre}</div>
                                                </div>
                                            </div>

                                    </td>
                                    
                                    <td>${user.apellido}</td>
                                    <td>${user.correo}</td>
                   					<td>${user.cedula}</td>
           
                                </tr>

                            <div class="modal fade" id="exampleModal${i}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content " style="width: 293px;">
                                        <div class="ui card aling-self-center">
                                            <div class="image">
                                                
                                            </div>
                                            <div class="content">
                                                <a class="header">${user.nombre} ${user.apellido} ${user.cedula}</a>
                                                <div class="meta">
                                                   <i class=""></i> <a href="mailto:${user.correo}"> ${user.correo}</a>
                                                </div>
                                                <div class="description">
                                                    <c:choose>
                                                        <c:when test="${user.telefonos.size() > 0}">
                                                            <c:forEach var="telefono" items="${user.telefonos}">
                                                                <p><i class=" &#9678"></i> <a href="tel:${telefono.numero}">${telefono.numero}</a>  &#9678; ${telefono.tipo} &#9678; ${telefono.operadora}</p>
                                                            </c:forEach>
                                                        </c:when>    
                                                        <c:otherwise>
                                                            <p>No tiene numeros aún.</p>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                            <div class="extra content">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </c:forEach>
                        </tbody>
                    </table>
                </c:when>    
                <c:otherwise>
                    <h1>No hay contactos para esta busqueda</h1>
                </c:otherwise>
            </c:choose>
        </div>
        </div>
        <footer>
            <div class="">
                <i class="fas fa-chevron-up"></i>
            </div>
            
            <p>&COPY; Todos los derechos reservados | Realizado por Marcelo Durazno</p>
        </footer>

        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
    </body>
</html>
