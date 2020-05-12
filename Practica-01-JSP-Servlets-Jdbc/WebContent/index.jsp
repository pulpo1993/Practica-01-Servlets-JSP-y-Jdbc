
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>BookContact</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/e564244708.js" crossorigin="anonymous"></script>
       
        <link rel="stylesheet" href="diseño/css/styles.css">
    </head>
    <body>
        <c:set var = "userId" value = "${sessionScope['userID']}" />

        <div class="ui container">
            <div class="ui secondary  menu">
                <div class="item logo">
                    <a href="/Practica-de-laboratorio-01"><h2>Book<span>Contact</span></h2></a>
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

        <div class="layout-header">
            <div class="column-description">
                <h1>Book<span>Contact</span></h1>
                <div>
                    <p>Somos tu compañero de recuerdos.</p>
                    <p>Guarda tus contactos de forma segura e ilimitada!</p>
                </div>
                <c:choose>
                    <c:when test="${userId == null}">
                        <a href="registro" class="ui primary button btn-index-register">Registro</a>
                    </c:when>    
                    <c:otherwise>

                        <a href="my-agenda" class="ui primary button btn-index-register">Ver mi agenda</a>

                    </c:otherwise>
                </c:choose>
            </div>
            <div class="column-bg">
            </div>
        </div>


        <div class="header-contet">
            
                <div class="buttuns-content">
                  
                    <a href="busqueda?usuario=all">Ver Usuarios</a>
                </div>
        </div>

        <footer>
            
            <p>&COPY;  Todos los derechos reservados | Designed By Marcelo Durazno</p>
        </footer>

        <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/uikit@3.2.2/dist/js/uikit.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/uikit@3.2.2/dist/js/uikit-icons.min.js"></script>
    </body>
</html>
