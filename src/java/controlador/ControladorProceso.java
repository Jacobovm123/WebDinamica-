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
import modelo.Proceso;
import modelo.ProcesoDAO;

/**
 *
 * @author jacob
 */
public class ControladorProceso extends HttpServlet {
    
ProcesoDAO dao= new ProcesoDAO();
Proceso u=new Proceso ();
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
            out.println("<title>Servlet ControladorProceso</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorProceso at " + request.getContextPath() + "</h1>");
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
    request.getRequestDispatcher("ListarProceso.jsp").forward(request, response);
 
    break;
    case"Nuevo":
    request.getRequestDispatcher("IngresoProceso.jsp").forward(request, response);

    break;
    case "Guardar":
        
       // String id=request.getParameter("txtid");
                String id_plantilla=request.getParameter("txtidplantilla");
                        String id_usuario=request.getParameter("txtidusuario");
                                String nombreproceso=request.getParameter("txtnombreproceso");
                                        String estado_proceso=request.getParameter("txtestadoproceso");
                                                String fecha=request.getParameter("txtfecha");
                                                      //  String cargo=request.getParameter("txtcargo");
                                                      //  u.setId(id);
                                                        u.setId_plantilla(id_plantilla);
                                                        u.setId_usuario(id_usuario);
                                                        u.setNombre_proceso(nombreproceso);
                                                           u.setEstado_proceso(estado_proceso);
                                                        u.setFecha(fecha);
                                                  
                                                            
                                                            dao.agregar(u);
                                                            request.getRequestDispatcher("ControladorProceso?accion=Listar").forward(request, response);
        break;
        
    case "Editar":
        String ide=request.getParameter("id");
     
        Proceso ue=dao.listarId(ide);
           request.setAttribute("proceso", ue);
        request.getRequestDispatcher("EditarProceso.jsp").forward(request, response);
        break;
        
    case "Actualizar":
        String id1=request.getParameter("txtid");
          String id_plantill =request.getParameter("txtidplantilla");
            String idus=request.getParameter("txtidusuario");
              String nombreproces=request.getParameter("txtnombreproceso");
                String estadoproce=request.getParameter("txtestadoproceso");
                  String fech=request.getParameter("txtfecha");
                
                    
                    u.setId(id1);
                    u.setId_plantilla(id_plantill);
                    u.setId_usuario(idus);
                    u.setNombre_proceso(nombreproces);
                    u.setEstado_proceso(estadoproce);
                    u.setFecha(fech);
                    
                    
                    dao.actualizar(u);
                    request.getRequestDispatcher("ControladorProceso?accion=Listar").forward(request, response);
                    
                    
        
        break;
        
        
    case "Delete":
       String id3=request.getParameter("id");
      
                 dao.delete(id3);
                   request.getRequestDispatcher("ControladorProceso?accion=Listar").forward(request, response);
                    
       
        
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
