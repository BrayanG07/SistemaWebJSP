<%-- 
    Document   : RegistrarVenta
    Created on : Jan 30, 2021, 9:42:59 PM
    Author     : Buddys
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <!--<link href="lib/bootstrap.min.css" rel="stylesheet" type="text/css"/>-->
        <!--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">-->
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-4">
                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del Cliente</label>      
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="CodigoCliente" value="${c.getDni()}" class="form-control" placeholder="Codigo">
                                    <button type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">Buscar</button>
                                </div>        
                                <div class="col-sm-6">
                                    <input type="text" name="nombresCliente" value="${c.getNombres()}" class="form-control" placeholder="Datos Cliente">
                                </div>        
                            </div>
                            <!--DATOS DEL PRODUCTO-->
                            <div class="form-group">
                                <label>Datos Producto</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="CodigoProducto" value="${producto.getIdProducto()}" class="form-control" placeholder="Codigo">
                                    <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">Buscar</button>
                                </div>        
                                <div class="col-sm-6">
                                    <input type="text" name="nombreProducto" value="${producto.getNombre()}" class="form-control" placeholder="Datos Producto">
                                </div> 
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="precio" value="${producto.getPrecio()}" class="form-control" placeholder="L. 0.00">
                                </div>        
                                <div class="col-sm-3">
                                    <input type="number" name="cantidad" value="1" min="0" class="form-control" placeholder="0">
                                </div> 
                                <div class="col-sm-3">
                                    <input type="text" name="stock" value="${producto.getStock()}" class="form-control" placeholder="Stock">
                                </div> 
                            </div>

                            <!--BTN PARA AGREGAR PRODUCTO A LA TABLA-->
                            <div class="form-group">
                                <div class="col-sm">
                                    <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar Producto</button>  
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-6 ml-auto">
                            <label>Nro Serie</label>   
                            <input type="text" name="NroSerie" value="${nSerie}" class="form-control">
                        </div>
                        <!-- Tabla Inicio-->
                        <table class="table table-striped text-center">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Código</th>
                                    <th>Descripción</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>SubTotal</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="e" items="${lista}">
                                    <tr>
                                        <td>${e.getItem()}</td>
                                        <td>${e.getId()}</td>
                                        <td>${e.getDescripcionP()}</td>
                                        <td>${e.getPrecio()}</td>
                                        <td>${e.getCantidad()}</td>
                                        <td>${e.getSubtotal()}</td>
                                        <td>
                                            <a class="btn btn-warning" href="#">Editar</a>
                                            <a class="btn btn-danger" href="#">Eliminar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <input type="submit" name="accion" value="Generar Venta" class="btn btn-success">
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                        </div>
                        <div class="col-sm-4 ml-auto">
                            <input type="text" name="txtTotal" value="L. ${totalPagar}0" class="form-control font-weight-bold">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>        
        <script src="lib/bootstrap.bundle.min.js" type="text/javascript"></script>        
    </body>
</html>
