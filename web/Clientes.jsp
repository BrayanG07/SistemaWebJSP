<%-- 
    Document   : Clientes
    Created on : Jan 30, 2021, 9:42:30 PM
    Author     : Buddys
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-header text-center bg-dark text-light">
                    <h3>Registrar Clientes</h3>  
                </div>
                <div class="card-body">
                    <form action="Controlador?menu=Cliente" method="POST">
                        <div class="form-group">
                            <label>Dni</label>
                            <input type="text" name="txtDni" value="${cliente.getDni()}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" name="txtNombres" value="${cliente.getNombres()}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Direccion</label>
                            <textarea name="txtDireccion" class="form-control">${cliente.getDireccion()}</textarea>
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" name="txtEstado" value="${cliente.getEstado()}" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-striped text-center">
                    <thead>
                        <tr class="bg-dark text-light">
                            <th>ID</th>
                            <th>DNI</th>
                            <th>NOMBRES</th>
                            <th>DIRECCION</th>
                            <th>ESTADO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="c" items="${clientes}">
                            <tr>
                                <td>${c.getIdCliente()}</td>
                                <td>${c.getDni()}</td>
                                <td>${c.getNombres()}</td>
                                <td>${c.getDireccion()}</td>
                                <td>${c.getEstado()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Cliente&accion=Editar&id=${c.getIdCliente()}">Editar</a>  
                                    <a class="btn btn-danger" href="Controlador?menu=Cliente&accion=Delete&id=${c.getIdCliente()}">Eliminar</a>  
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>        
        <script src="lib/bootstrap.bundle.min.js" type="text/javascript"></script>
    </body>
</html>
