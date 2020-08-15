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
import modelo.PlantillaRol;
import modelo.PlantillaRolDAO;

/**
 *
 * @author jacob
 */
public class ControladorPlantillaRol extends HttpServlet {
PlantillaRol u =new PlantillaRol();
PlantillaRolDAO  dao = new PlantillaRolDAO();

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
            out.println("<title>Servlet ControladorPlantillaRol</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorPlantillaRol at " + request.getContextPath() + "</h1>");
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
    request.getRequestDispatcher("ListarPlantillaRol.jsp").forward(request, response);
 
    break;
    case"Nuevo":
    request.getRequestDispatcher("IngresoPlantillaRol.jsp").forward(request, response);

    break;
    case "Guardar":
        
        //String id=request.getParameter("txtid");
                String id_plantilla=request.getParameter("txtidplantilla");
                        String id_rol=request.getParameter("txtidrol");
                        
                        
                                            
                                                       
                                                     //   u.setId(id);
                                                        u.setId_plantilla(id_plantilla);
                                                        u.setId_rol(id_rol);
                                                        
                                                 
                                                            
                                                            dao.agregar(u);
                                                            request.getRequestDispatcher("ControladorPlantillaRol?accion=Listar").forward(request, response);
        break;
        
    case "Editar":
        String ide=request.getParameter("id");
     
        PlantillaRol ue=dao.listarId(ide);
           request.setAttribute("plantillarol", ue);
        request.getRequestDispatcher("EditarPlantillaRol.jsp").forward(request, response);
        break;
        
    case "Actualizar":
        String id1=request.getParameter("txtid");
          String id_plantill=request.getParameter("txtidplantilla");
            String id_plantillaro=request.getParameter("txtidplantillarol");
       
     
                    
                    u.setId(id1);
                    u.setId_plantilla(id_plantill);
                    u.setId_rol(id_plantillaro);
                    
             
                    dao.actualizar(u);
                    request.getRequestDispatcher("ControladorPlantillaRol?accion=Listar").forward(request, response);
                    
                    
        
        break;
        
        
    case "Delete":
       String id3=request.getParameter("id");
      
                 dao.delete(id3);
                   request.getRequestDispatcher("ControladorPlantillaRol?accion=Listar").forward(request, response);
                    
       
        
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
