
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;
import dao.negocioM;

public class control2 extends HttpServlet {
    negocioM obj = new negocioM();
    

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int op=Integer.parseInt(request.getParameter("opc"));
        if(op==1)listaEsp(request,response);
        if(op==2)listaMedicos(request,response);
        if(op==3)listaHorariosMedi(request,response);
        
    }
    
     protected void listaEsp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("dato", obj.lisEsp());
         String pag="/especialidad.jsp";
         request.getRequestDispatcher(pag).forward(request, response);
        
    }
     
     protected void listaMedicos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String cod=request.getParameter("cod");
        String nom= request.getParameter("nom");
        request.setAttribute("dato", obj.lisMedico(cod));
        request.setAttribute("dato2", nom);
        
        String pag="/medicosEspecializados.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
        
    }
     
     
     
     protected void listaHorariosMedi(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String cod=request.getParameter("cod");
        String nom= request.getParameter("nom");
        request.setAttribute("dato", obj.lisHoraiosMedi(cod));
        request.setAttribute("dato2", nom);
        
        String pag="/horariosMedicos.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
        
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
        processRequest(request, response);
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
