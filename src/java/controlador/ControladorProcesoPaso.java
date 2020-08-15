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
import modelo.ProcesoPaso;
import modelo.ProcesoPasoDAO;

/**
 *
 * @author jacob
 */
public class ControladorProcesoPaso extends HttpServlet {
ProcesoPasoDAO dao= new ProcesoPasoDAO();
ProcesoPaso u=new ProcesoPaso ();
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
            out.println("<title>Servlet ControladorProcesoPaso</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorProcesoPaso at " + request.getContextPath() + "</h1>");
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
    request.getRequestDispatcher("ListarProcesoPaso.jsp").forward(request, response);
 
    break;
    case"Nuevo":
       // response.sendRedirect("IngresarProcesoPaso.jsp?dropPlantilla="+request.getParameter("dropPlantilla") );
    request.getRequestDispatcher("IngresarProcesoPaso.jsp").forward(request, response);

    break;
    case "Guardar":
        
       // String id=request.getParameter("txtid");
                String  id_proceso=request.getParameter("txtidproceso");
                        String nombre_paso_proceso=request.getParameter("txtnombrepasoproceso");
                                String paso_estado=request.getParameter("txtpasoestado");
                                        String pasos=request.getParameter("txtpasos");
                                                String fecha=request.getParameter("txtfecha");
                                                        
                                                String  aprobadores=request.getParameter("txtaprobadores");
                                                   
                                                      //  u.setId(id);
                                                        u.setId_proceso(id_proceso);
                                                        u.setNombre_paso_proceso(nombre_paso_proceso);
                                                        u.setPaso_estado(paso_estado);
                                                           u.setPasos(pasos);
                                                        u.setFecha(fecha);
                                                        u.setAprobadores(aprobadores);
                                                      
                                                            dao.agregar(u);
                                                            request.getRequestDispatcher("ControladorProcesoPaso?accion=Listar").forward(request, response);
        break;
        
    case "Editar":
        String ide=request.getParameter("id");
     
        ProcesoPaso ue=dao.listarId(ide);
           request.setAttribute("procesopaso", ue);
        request.getRequestDispatcher("EditarProcesoPaso.jsp").forward(request, response);
        break;
        
    case "Actualizar":
        String id1=request.getParameter("txtid");
          String id_proces=request.getParameter("txtidproceso");
            String nombrepasoproceso=request.getParameter("txtnombrepasoproceso");
              String paso_estad=request.getParameter("txtpasoestado");
                String paso=request.getParameter("txtpaso");
                  String fech=request.getParameter("txtfecha");
                    String aprobadore=request.getParameter("txtaprobadores");
                   
                   
                    u.setId(id1);
                    u.setId_proceso(id_proces);
                    u.setNombre_paso_proceso(nombrepasoproceso);
                    u.setPaso_estado(paso_estad);
                    u.setPasos(paso);
                    u.setFecha(fech);
                    u.setAprobadores(aprobadore);
          
                    dao.actualizar(u);
                    
                    request.getRequestDispatcher("ControladorProcesoPaso?accion=Listar").forward(request, response);

        break;
        
        //inicio
        
        
           case "Rechazar":
        String idproc = request.getParameter("idproc");
        String idpaso = request.getParameter("idpaso");
        dao.actualizar2(idproc, idpaso);
        
        request.getRequestDispatcher("MenuAdmin.jsp").forward(request, response);
        break;
        
    
        
        
        //fin  
        
        
        //inicio redireccionamiento
        
        
           case "Redireccionamiento":
    
        
        request.getRequestDispatcher("MenuAdmin.jsp").forward(request, response);
        break;
        
        
        //fin redireccionamiento
        //aprobar inicion
        case "Aprobar":
    
        
        request.getRequestDispatcher("MenuAdmin.jsp").forward(request, response);
        break;
        //aprobar fin 
        
        
            case "Delete":
       String id3=request.getParameter("id");
      
                 dao.delete(id3);
                   request.getRequestDispatcher("ControladorProcesoPaso?accion=Listar").forward(request, response);
     
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
