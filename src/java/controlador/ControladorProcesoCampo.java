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
import modelo.ProcesoCampDAO;
import modelo.ProcesoCampo;

/**
 *
 * @author jacob
 */
public class ControladorProcesoCampo extends HttpServlet {
ProcesoCampDAO dao= new ProcesoCampDAO();
ProcesoCampo u=new ProcesoCampo ();
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
            out.println("<title>Servlet ControladorProcesoCampo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorProcesoCampo at " + request.getContextPath() + "</h1>");
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
    request.getRequestDispatcher("ListarProcesoCampo.jsp").forward(request, response);
 
    break;
    case"Nuevo":
    request.getRequestDispatcher("IngresarProcesoCampo.jsp").forward(request, response);

    break;
    case "Guardar":
        
       // String id=request.getParameter("txtid");
                String idproceso=request.getParameter("txtidproceso");
                        String nombrecampo=request.getParameter("txtnombrecampo");
                                String numerocampo=request.getParameter("txtnumerocampo");
                                        String dato=request.getParameter("txtdato");
                                                String descripcion=request.getParameter("txtdescripcion");
                                               
                                                      //  u.setId(id);
                                                        u.setIdproceso(idproceso);
                                                        u.setNombrecampo(nombrecampo);
                                                        u.setNumerocampo(numerocampo);
                                                           u.setDato(dato);
                                                        u.setDescripcion(descripcion);
                                                     
                                                            
                                                            dao.agregar(u);
                                                            request.getRequestDispatcher("ControladorProcesoCampo?accion=Listar").forward(request, response);
        break;
        
    case "Editar":
        String ide=request.getParameter("id");
     
        ProcesoCampo ue=dao.listarId(ide);
           request.setAttribute("procesocampo", ue);
        request.getRequestDispatcher("EditarProcesoCampo.jsp").forward(request, response);
        break;
        
    case "Actualizar":
        String id1=request.getParameter("txtid");
          String idproces=request.getParameter("txtidproceso");
            String nombrecamp=request.getParameter("txtnombrecampo");
              String numerocamp=request.getParameter("txtnumerocampo");
                String dat=request.getParameter("txtdato");
                  String descripcio=request.getParameter("txtdescripcion");
                  
                    
                    u.setId(id1);
                    u.setIdproceso(idproces);
                    u.setNombrecampo(nombrecamp);
                    u.setNumerocampo(numerocamp);
                    u.setDato(dat);
                    u.setDescripcion(descripcio);
               
                    
                    dao.actualizar(u);
                    request.getRequestDispatcher("ControladorProcesoCampo?accion=Listar").forward(request, response);
                    
                    
        
        break;
        
        
    case "Delete":
       String id3=request.getParameter("id");
      
                 dao.delete(id3);
                   request.getRequestDispatcher("ControladorProcesoCampo?accion=Listar").forward(request, response);
                    
       
        
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
