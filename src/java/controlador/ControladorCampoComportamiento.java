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
import modelo.PasoCampoComportamiento;
import modelo.PasoCampoComportamientoDAO;

/**
 *
 * @author jacob
 */
public class ControladorCampoComportamiento extends HttpServlet {
    
PasoCampoComportamientoDAO dao= new  PasoCampoComportamientoDAO ();
PasoCampoComportamiento u=new PasoCampoComportamiento ();
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
            out.println("<title>Servlet ControladorCampoComportamiento</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCampoComportamiento at " + request.getContextPath() + "</h1>");
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
    request.getRequestDispatcher("ListarPasoCampoComportamiento.jsp").forward(request, response);
 
    break;
    case"Nuevo":
        response.sendRedirect("IngresoPasoCampoComportamiento.jsp?dropPlantilla="+request.getParameter("dropPlantilla") );
    //request.getRequestDispatcher("IngresoPasoCampoComportamiento.jsp").forward(request, response);

    break;
    case "Guardar":
        
       // String id=request.getParameter("txtid");
                String  id_plantilla_paso=request.getParameter("droppaso");
                        String id_plantilla_campo=request.getParameter("dropcampo");
                                String nombre_campo=request.getParameter("txtnombrecampo");
                                        String numero_campo=request.getParameter("txtnumerocampo");
                                                String dato=request.getParameter("txtdato");
                                                        
                                                String  descripcion=request.getParameter("txtdescripcion");
                                                         String  id_plantilla=request.getParameter("txtidplantilla");
                                                      //  u.setId(id);
                                                        u.setId_plantilla_paso(id_plantilla_paso);
                                                        u.setId_plantilla_campo(id_plantilla_campo);
                                                        u.setNombre_campo(nombre_campo);
                                                           u.setNumero_campo(numero_campo);
                                                        u.setDato(dato);
                                                        u.setDescripcion(descripcion);
                                                        u.setId_plantilla(id_plantilla);
                                                            dao.agregar(u);
                                                            request.getRequestDispatcher("ControladorCampoComportamiento?accion=Listar").forward(request, response);
        break;
        
        
    case "Editar":
        String ide=request.getParameter("id");
     
        PasoCampoComportamiento ue=dao.listarId(ide);
           request.setAttribute("campocomportamiento", ue);
        request.getRequestDispatcher("EditarPasoCampoComportamiento.jsp").forward(request, response);
        break;
        
    case "Actualizar":
        String id1=request.getParameter("txtid");
          String id_plantilla_pa=request.getParameter("txtidplantillapaso");
            String id_plantilla_cam=request.getParameter("txtidplantillacampo");
              String nombre_camp=request.getParameter("txtnombrecampo");
                String numero_camp=request.getParameter("txtnumerocampo");
                  String dat=request.getParameter("txtdato");
                    String descri=request.getParameter("txtdescripcion");
                     String id_plantill=request.getParameter("txtidplantilla");
                   
                    u.setId(id1);
                    u.setId_plantilla_paso(id_plantilla_pa);
                    u.setId_plantilla_campo(id_plantilla_cam);
                    u.setNombre_campo(nombre_camp);
                    u.setNumero_campo(numero_camp);
                    u.setDato(dat);
                    u.setDescripcion(descri);
                    u.setId_plantilla(id_plantill);
                    dao.actualizar(u);
                    
                    request.getRequestDispatcher("ControladorCampoComportamiento?accion=Listar").forward(request, response);
                    
                    
        
        break;
        ///inicio
        
        
        
        
        
        //finn  
        
    case "Delete":
       String id3=request.getParameter("id");
      
                 dao.delete(id3);
                   request.getRequestDispatcher("ControladorCampoComportamiento?accion=Listar").forward(request, response);
                    
       
        
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
