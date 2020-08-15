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
import modelo.Rol;
import modelo.RolDAO;

/**
 *
 * @author jacob
 */
public class ControladorRol extends HttpServlet {
RolDAO dao= new RolDAO();
Rol u=new Rol ();
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
    request.getRequestDispatcher("ListarRol.jsp").forward(request, response);
 
    break;
    case"Nuevo":
    request.getRequestDispatcher("IngresoRol.jsp").forward(request, response);

    break;
    case "Guardar":
        
        String id=request.getParameter("txtid");
                String nombre=request.getParameter("txtnombre");
                    
                                                        u.setId(id);
                                                        u.setNombre(nombre);
                                               
                                                       dao.agregar(u);
                                                    request.getRequestDispatcher("ControladorRol?accion=Listar").forward(request, response);
        break;
    
    case "Editar":
        String ide=request.getParameter("id");
     
        Rol ue=dao.listarId(ide);
           request.setAttribute("rol", ue);
        request.getRequestDispatcher("EditarRol.jsp").forward(request, response);
        break;
        
    case "Actualizar":
        String id1=request.getParameter("txtid");
          String nom=request.getParameter("txtnombre");
       
                    
                    u.setId(id1);
                    u.setNombre(nom);
                
                    
                    dao.actualizar(u);
                    request.getRequestDispatcher("ControladorRol?accion=Listar").forward(request, response);
                    
                    
        
        break;
        
        
    case "Delete":
       String id2=request.getParameter("id");
      try{
                 dao.delete(id2);
                   request.getRequestDispatcher("ControladorRol?accion=Listar").forward(request, response);
                    
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
