/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnt.uth.controlador;

import hnt.uth.modelo.Cliente;
import hnt.uth.modelo.ClienteDAO;
import hnt.uth.modelo.Empleado;
import hnt.uth.modelo.EmpleadoDAO;
import hnt.uth.modelo.Producto;
import hnt.uth.modelo.ProductoDAO;
import hnt.uth.modelo.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Buddys
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Empleado em = new Empleado();
    Cliente cl = new Cliente();
    Producto pr = new Producto();
    ProductoDAO prdao = new ProductoDAO();
    EmpleadoDAO edao = new EmpleadoDAO();
    ClienteDAO cldao = new ClienteDAO();
    int idEmpleado;
    
    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item, codigoProducto, cantidad;
    String descripcion;
    double precio, subtotal, totalPagar;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nombre = request.getParameter("txtNombres");
                    String telefono = request.getParameter("txtTel");
                    String estado = request.getParameter("txtEstado");
                    String usuario = request.getParameter("txtUsuario");
                    em.setDni(dni);
                    em.setNom(nombre);
                    em.setTel(telefono);
                    em.setEstado(estado);
                    em.setUser(usuario);
                    int n = edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar": //Listar en las cajas de texto
                    idEmpleado = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(idEmpleado);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nombre1 = request.getParameter("txtNombres");
                    String telefono1 = request.getParameter("txtTel");
                    String estado1 = request.getParameter("txtEstado");
                    String usuario1 = request.getParameter("txtUsuario");
                    em.setDni(dni1);
                    em.setNom(nombre1);
                    em.setTel(telefono1);
                    em.setEstado(estado1);
                    em.setUser(usuario1);
                    em.setId(idEmpleado);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idEmpleado = Integer.parseInt(request.getParameter("id"));
                    edao.delete(idEmpleado);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if (menu.equals("Cliente")) {
            switch (accion) {
                case "Listar":
                    List lista = cldao.listar();
                    request.setAttribute("clientes", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nombre = request.getParameter("txtNombres");
                    String direccion = request.getParameter("txtDireccion");
                    String estado = request.getParameter("txtEstado");
                    cl.setDni(dni);
                    cl.setNombres(nombre);
                    cl.setDireccion(direccion);
                    cl.setEstado(estado);
                    cldao.agregar(cl);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Editar": //Listar en las cajas de texto
                    idEmpleado = Integer.parseInt(request.getParameter("id"));
                    Cliente c = cldao.listarId(idEmpleado);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nombre1 = request.getParameter("txtNombres");
                    String direccion1 = request.getParameter("txtDireccion");
                    String estado1 = request.getParameter("txtEstado");
                    cl.setDni(dni1);
                    cl.setNombres(nombre1);
                    cl.setDireccion(direccion1);
                    cl.setEstado(estado1);
                    cl.setIdCliente(idEmpleado);
                    cldao.actualizar(cl);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idEmpleado = Integer.parseInt(request.getParameter("id"));
                    cldao.delete(idEmpleado);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List lista = prdao.listar();
                    request.setAttribute("productos", lista);
                    break;
                case "Agregar":
                    String nombre = request.getParameter("txtNombres");
                    double precio = Double.parseDouble(request.getParameter("txtPrecio"));
                    int stock = Integer.parseInt(request.getParameter("txtStock"));
                    String estado = request.getParameter("txtEstado");
                    pr.setNombre(nombre);
                    pr.setPrecio(precio);
                    pr.setStock(stock);
                    pr.setEstado(estado);
                    prdao.agregar(pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar": //Listar en las cajas de texto
                    idEmpleado = Integer.parseInt(request.getParameter("id"));
                    Producto p = prdao.listarId(idEmpleado);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nombre1 = request.getParameter("txtNombres");
                    double precio1 = Double.parseDouble(request.getParameter("txtPrecio"));
                    int stock1 = Integer.parseInt(request.getParameter("txtStock"));
                    String estado1 = request.getParameter("txtEstado");
                    pr.setNombre(nombre1);
                    pr.setPrecio(precio1);
                    pr.setStock(stock1);
                    pr.setEstado(estado1);
                    pr.setIdProducto(idEmpleado);
                    prdao.actualizar(pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idEmpleado = Integer.parseInt(request.getParameter("id"));
                    prdao.delete(idEmpleado);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if (menu.equals("NuevaVenta")) {
            switch (accion) {
                case "BuscarCliente":
                    String dni = request.getParameter("CodigoCliente");
                    cl.setDni(dni);
                    Cliente c = cldao.buscar(dni);
                    request.setAttribute("c", c);
                    break;
                case "BuscarProducto":
                    int id = Integer.parseInt(request.getParameter("CodigoProducto"));
                    pr = prdao.listarId(id); //pr almacenara todo lo que esta listando el metodo listarId
                    request.setAttribute("producto", pr);
                    //CON ESTO LA TABLA NO SE QUEDARA EN BLANCO CUANDO SE PRESIONE EL BOTON
                    request.setAttribute("lista", lista);
                    break;
                case "Agregar":
                    this.totalPagar = 0.0;
                    item = item + 1;
                    this.codigoProducto = pr.getIdProducto();
                    this.descripcion = request.getParameter("nombreProducto");
                    this.precio = Double.parseDouble(request.getParameter("precio"));
                    this.cantidad = Integer.parseInt(request.getParameter("cantidad"));
                    this.subtotal = this.precio * this.cantidad;
                    v = new Venta(); //PARA QUE CADA VEZ QUE DE CLICK SE ACUMULE EL SUBTOTAL
                    //ES COMO UN REINICIO DEL OBJETO
                    v.setItem(item);
                    v.setId(codigoProducto);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cantidad);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    for (int i = 0; i < lista.size(); i++) {
                        this.totalPagar = this.totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalPagar", this.totalPagar);
                    //Enviando todo a la tabla
                    request.setAttribute("lista", lista);
                    break;
                default:
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
