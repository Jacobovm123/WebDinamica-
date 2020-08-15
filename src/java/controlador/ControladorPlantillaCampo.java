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
import modelo.PlantillaCampo;
import modelo.PlantillaCampoDAO;

/**
 *
 * @author jacob
 */
public class ControladorPlantillaCampo extends HttpServlet {
PlantillaCampoDAO dao= new PlantillaCampoDAO();
PlantillaCampo u=new PlantillaCampo ();
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
            out.println("<title>Servlet ControladorPlantillaCampo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorPlantillaCampo at " + request.getContextPath() + "</h1>");
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
    request.getRequestDispatcher("ListarPlantillaCampo.jsp").forward(request, response);
 
    break;
  
 
    
        case "ver":
        
        String idee=request.getParameter("id");
     
        PlantillaCampo uee=dao.listarId1(idee);
           request.setAttribute("plantillacampo", uee);
    
     //request.getRequestDispatcher("ListarPlantillaCampo.jsp").forward(request, response);
        
            response.sendRedirect("ListarPlantilla2.jsp?dropPlantilla="+request.getParameter("dropPlantilla") );
        break;
        
          case"Nuevo":
        

    request.getRequestDispatcher("IngresoPlantillaCampo.jsp").forward(request, response);
    

    break;
    
    case "Guardar":
     
             // String  id_plantilla_paso=request.getParameter("droppaso");
              //String id_plantilla_campo=request.getParameter("dropcampo");
        
        
       //  String id_plantilla=request.getParameter("droppaso");
         //               String nombre_campo=request.getParameter("dropcampo");
                        
                           String id_plantilla=request.getParameter("dropPlantilla");
                        String nombre_campo=request.getParameter("txtnombrecampo");
                        
                        
                                String numero_campo=request.getParameter("txtnumerocampo");
                                        String dato=request.getParameter("txtdato");
                                                String descripcion=request.getParameter("txtdescripcion");
                                                       
                                                       // u.setId(id);
                                                        u.setId_plantilla(id_plantilla);
                                                        u.setNombre_campo(nombre_campo);
                                                        u.setNumero_campo(numero_campo);
                                                           u.setDato(dato);
                                                        u.setDescripcion(descripcion);
                                                       
                                                            
                                                            dao.agregar(u);
                                                            request.getRequestDispatcher("ControladorPlantillaCampo?accion=Listar").forward(request, response);
        break;
        

        
    case "Editar":
        String ide=request.getParameter("id");
     
        PlantillaCampo ue=dao.listarId(ide);
           request.setAttribute("plantillacampo", ue);
        request.getRequestDispatcher("EditarPlantillaCampo.jsp").forward(request, response);
        break;
        
    case "Actualizar":
        String id1=request.getParameter("txtid");
          String id_plantill=request.getParameter("txtidplantilla");
            String nombre_camp=request.getParameter("txtnombrecampo");
              String numero_camp=request.getParameter("txtnumerocampo");
                String dat=request.getParameter("txtdato");
                  String descrip=request.getParameter("txtdescripcion");
                   
                    
                    u.setId(id1);
                    u.setId_plantilla(id_plantill);
                    u.setNombre_campo(nombre_camp);
                    u.setNumero_campo(numero_camp);
                    u.setDato(dat);
                    u.setDescripcion(descrip);
                  
                    
                    dao.actualizar(u);
                    request.getRequestDispatcher("ControladorPlantillaCampo?accion=Listar").forward(request, response);
                    
                    
        
        break;
        
        
    case "Delete":
       String id3=request.getParameter("id");
      
                 dao.delete(id3);
                   request.getRequestDispatcher("ControladorPlantillaCampo?accion=Listar").forward(request, response);
                    
       
        
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
