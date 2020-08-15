/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Categoria;
import modelo.CategoriaDAO;

/**
 *
 * @author jacob
 */
public class ControladorCategoria extends HttpServlet {
CategoriaDAO dao= new CategoriaDAO(); 
Categoria u = new Categoria ();
    /**
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorCategoria</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCategoria at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        
        
       String accion =request.getParameter("accion");
      
           switch(accion){
               case "Listar":
    request.getRequestDispatcher("ListarCategoria.jsp").forward(request, response);
 
    break;
    case"Nuevo":
    request.getRequestDispatcher("IngresoCategoria.jsp").forward(request, response);

    break;
    case "Guardar":
        
        String id=request.getParameter("txtid");
                String categoria=request.getParameter("txtcategoria");
                        String descripcion=request.getParameter("txtdescripcion");
                             
                                                        u.setId(id);
                                                        u.setCategoria(categoria);
                                                        u.setDescripcion(descripcion);
                                                      
                                                            dao.agregar(u);
                                                            request.getRequestDispatcher("ControladorCategoria?accion=Listar").forward(request, response);
        break;
        
    case "Editar":
        String ide=request.getParameter("id");
     
      //  Categoria ue=dao.listarId(ide);
        //   request.setAttribute("categoria", ue);
        request.getRequestDispatcher("EditarCategoria.jsp").forward(request, response);
        break;
        
    case "Actualizar":
        String id1=request.getParameter("txtid");
          String cat=request.getParameter("txtcategoria");
            String dscri=request.getParameter("txtdescripcion");
   
                    
                    u.setId(id1);
                    u.setCategoria(cat);
                    u.setDescripcion(dscri);
               
                    
                    dao.actualizar(u);
                    request.getRequestDispatcher("ControladorCategoria?accion=Listar").forward(request, response);
                    
                    
        
        break;
        
        
    case "Delete":
       String id2=request.getParameter("id");
      try{
                 dao.delete(id2);
                   request.getRequestDispatcher("ControladorCategoria?accion=Listar").forward(request, response);
                    
      }catch (Exception e){
          
          System.out.println("Error 1");
      }
          
       
        
        break;
    
default:
    throw new AssertionError();

}
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
