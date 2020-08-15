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
import modelo.PlantillaPaso;
import modelo.PlantillaPasoDAO;

/**
 *
 * @author jacob
 */
public class ControladorPlantillaPaso extends HttpServlet {
PlantillaPasoDAO dao= new PlantillaPasoDAO();
PlantillaPaso u=new PlantillaPaso ();
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
            out.println("<title>Servlet ControladorPlantillaPaso</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorPlantillaPaso at " + request.getContextPath() + "</h1>");
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
    request.getRequestDispatcher("ListarPlantillaPaso.jsp").forward(request, response);
 
         case "ver":
        
        String idee=request.getParameter("id");
     
        PlantillaPaso uee=dao.listarId(idee);
           request.setAttribute("plantillapaso", uee);
    
     //request.getRequestDispatcher("ListarPlantillaCampo.jsp").forward(request, response);
        
            response.sendRedirect("ListarPlantilla2.jsp?dropPlantilla="+request.getParameter("dropPlantilla") );
    
    break;
    case"Nuevo":
        
    response.sendRedirect("IngresarPlantillaPaso.jsp?dropPlantilla="+request.getParameter("dropPlantilla") );
   // request.getRequestDispatcher("IngresarPlantillaPaso.jsp").forward(request, response);

    break;
    case "Guardar":
        
        //String id=request.getParameter("txtid");
                String id_plantilla=request.getParameter("dropPlantilla");
                        String numero_pasos=request.getParameter("txtnumeropaso");
                                String nombre=request.getParameter("txtnombre");
                                        String aprobadores=request.getParameter("dropaprobadores");
                                        
                                            
                                                       
                                                     //   u.setId(id);
                                                        u.setId_plantilla(id_plantilla);
                                                        u.setNumero_pasos(numero_pasos);
                                                        u.setNombre(nombre);
                                                           u.setAprobadores(aprobadores);
                                                           
                                                           
                                           
                                                            
                                                            dao.agregar(u);
                                                            request.getRequestDispatcher("ControladorPlantillaPaso?accion=Listar").forward(request, response);
        break;
        
    case "Editar":
        String ide=request.getParameter("id");
     
        PlantillaPaso ue=dao.listarId(ide);
           request.setAttribute("plantillapaso", ue);
        request.getRequestDispatcher("EditarPlantillaPaso.jsp").forward(request, response);
        break;
        
    case "Actualizar":
        String id1=request.getParameter("txtid");
          String id_plantill=request.getParameter("txtidplantilla");
            String numero_pas=request.getParameter("txtnumeropaso");
              String nombr=request.getParameter("txtnombre");
                String aproba=request.getParameter("txtaprobadores");
                
     
                    
                    u.setId(id1);
                    u.setId_plantilla(id_plantill);
                    u.setNumero_pasos(numero_pas);
                    u.setNombre(nombr);
                    u.setAprobadores(aproba);
       
                    
                    dao.actualizar(u);
                    request.getRequestDispatcher("ControladorPlantillaPaso?accion=Listar").forward(request, response);
                    
                    
        
        break;
        
        
    case "Delete":
       String id3=request.getParameter("id");
      
                 dao.delete(id3);
                   request.getRequestDispatcher("ControladorPlantillaPaso?accion=Listar").forward(request, response);
                    
       
        
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
