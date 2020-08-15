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
import modelo.Plantilla2;
import modelo.PlantillaDAO2;

/**
 *
 * @author jacob
 */
public class ControladorPlantilla2 extends HttpServlet {
PlantillaDAO2 dao= new PlantillaDAO2();
Plantilla2 u=new Plantilla2 ();
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
            out.println("<title>Servlet ControladorPlantilla2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorPlantilla2 at " + request.getContextPath() + "</h1>");
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
    request.getRequestDispatcher("ListarPlantilla2.jsp").forward(request, response);
 
    break;
    case"Nuevo":
    request.getRequestDispatcher("IngresarPlantilla.jsp").forward(request, response);

    break;
    case "Guardar":
        
       // String id=request.getParameter("txtid");
                String idcategoria=request.getParameter("txtidcategoria");
                        String nombre=request.getParameter("txtnombre");
                                String fecha=request.getParameter("txtfecha");
                                        String descripcion=request.getParameter("txtdescripcion");
                                                String iniciarlas=request.getParameter("txtiniciarlas");
                                                    
                                                      //  u.setId(id);
                                                        u.setIdcategoria(idcategoria);
                                                        u.setNombre(nombre);
                                                        u.setFecha(fecha);
                                                           u.setDescripcion(descripcion);
                                                        u.setIniciarlas(iniciarlas);
                                                                                                               
                                                            dao.agregar(u);
                                                            request.getRequestDispatcher("ControladorPlantilla2?accion=Listar").forward(request, response);
        break;
        
    case "Editar":
        String ide=request.getParameter("id");
     
        Plantilla2 ue=dao.listarId(ide);
           request.setAttribute("plantilla", ue);
        request.getRequestDispatcher("EditarPlantilla2.jsp").forward(request, response);
        break;
        
    case "Actualizar":
        String id1=request.getParameter("txtid");
            String idcategori=request.getParameter("txtidcategoria");
          String nombr=request.getParameter("txtnombre");
            String fech=request.getParameter("txtfecha");
              String descripcio=request.getParameter("txtdescripcion");
                String iniciarla=request.getParameter("txtiniciarlas");
            
                    
                    u.setId(id1);
                    u.setIdcategoria(idcategori);
                    u.setNombre(nombr);
                    u.setFecha(fech);
                    u.setDescripcion(descripcio);
                    u.setIniciarlas(iniciarla);
                   
                    
                    dao.actualizar(u);
                    request.getRequestDispatcher("ControladorPlantilla2?accion=Listar").forward(request, response);
                    
                    
        
        break;
        
        
    case "Delete":
       String id3=request.getParameter("id");
      
                 dao.delete(id3);
                   request.getRequestDispatcher("ControladorPlantilla2?accion=Listar").forward(request, response);
                    
       
        
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
