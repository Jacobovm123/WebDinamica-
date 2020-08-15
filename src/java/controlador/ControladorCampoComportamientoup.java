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
import modelo.CampoComportamiento;
import modelo.CampoComportamientoDAO;

/**
 *
 * @author jacob
 */
public class ControladorCampoComportamientoup extends HttpServlet {
    
CampoComportamientoDAO dao= new  CampoComportamientoDAO ();
CampoComportamiento u=new CampoComportamiento ();
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
            out.println("<title>Servlet ControladorCampoComportamientoup</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCampoComportamientoup at " + request.getContextPath() + "</h1>");
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
    request.getRequestDispatcher("ListarCampoComportamiento.jsp").forward(request, response);
 
    break;
    case"Nuevo":
    request.getRequestDispatcher("IngresoCampoComportamiento.jsp").forward(request, response);

    break;
    case "Guardar":
        
       // String id=request.getParameter("txtid");
               
        String  id_campo_proceso=request.getParameter("txtidcampoproceso");
                        String id_paso=request.getParameter("txtidpaso");
                                String nombre_campo=request.getParameter("txtnombrecampo");
                                        String numero_campo=request.getParameter("txtnumerocampo");
                                                String dato=request.getParameter("txtdato");
                                                        String  descripcion=request.getParameter("txtdescripcion");
                                                      //  u.setId(id);
                                                        u.setId_campo_proceso(id_campo_proceso);
                                                        u.setId_paso(id_paso);
                                                        u.setNombre_campo(nombre_campo);
                                                           u.setNumero_campo(numero_campo);
                                                        u.setDato(dato);
                                                        u.setDescripcion(descripcion);
                                                            
                                                            dao.agregar(u);
                                                            request.getRequestDispatcher("ControladorCampoComportamientoup?accion=Listar").forward(request, response);
        break;
        
    case "Editar":
        String ide=request.getParameter("id");
     
        CampoComportamiento ue=dao.listarId(ide);
           request.setAttribute("campocomportamiento", ue);
        request.getRequestDispatcher("EditarCampoComportamiento.jsp").forward(request, response);
        break;
        
    case "Actualizar":
        String id1=request.getParameter("txtid");
          String id_campo_proce=request.getParameter("txtidcampoproceso");
            String id_pas=request.getParameter("txtidpaso");
              String nombre_camp=request.getParameter("txtnombrecampo");
                String numero_camp=request.getParameter("txtnumerocampo");
                  String dat=request.getParameter("txtdato");
                    String descri=request.getParameter("txtdescripcion");
                    
                    u.setId(id1);
                    u.setId_campo_proceso(id_campo_proce);
                    u.setId_paso(id_pas);
                    u.setNombre_campo(nombre_camp);
                    u.setNumero_campo(numero_camp);
                    u.setDato(dat);
                    u.setDescripcion(descri);
                    
                    dao.actualizar(u);
                    request.getRequestDispatcher("ControladorCampoComportamientoup?accion=Listar").forward(request, response);
                    
                    
        
        break;
        //inicio 
        
         case "Editar1":
        String ide1=request.getParameter("id");
     
        CampoComportamiento ue1=dao.listarId(ide1);
           request.setAttribute("campocomportamiento", ue1);
        // response.sendRedirect("EditarCampoComportamiento.jsp?dropPlantilla="+request.getParameter("dropPlantilla") );

       request.getRequestDispatcher("procesopaso.jsp?idpro=183&idpas=167").forward(request, response);
             System.out.println(request.getParameter("idpro"));
             System.out.println(request.getParameter("idpas"));
        break;
        
    case "Actualizar1":
        String id11=request.getParameter("txtid");
     
                    String descri1=request.getParameter("txtdescripcion");
                    
                    u.setId(id11);
                  
                    u.setDescripcion(descri1);
                    
                    dao.actualizar1(u);
                    request.getRequestDispatcher("ControladorCampoComportamientoup?accion=Listar").forward(request, response);
                    
                    
        
        break;
        
        
        //fin 
        
    case "Delete":
       String id3=request.getParameter("id");
      
                 dao.delete(id3);
                   request.getRequestDispatcher("ControladorCampoComportamientoup?accion=Listar").forward(request, response);
                    
       
        
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
