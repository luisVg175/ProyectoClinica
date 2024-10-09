package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.medicina;
import dao.CrudMedi;

public class control4 extends HttpServlet {

    CrudMedi obj = new CrudMedi();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int op=Integer.parseInt(request.getParameter("opc"));
        if(op==1)listado(request, response);
        if(op==2)adicion(request,response);
        if(op==3)editar(request,response);
        if(op==4)anula(request,response);
        if(op==5)cambia(request,response);
    }

    protected void listado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("dato", obj.lisMedi());
        request.setAttribute("medicina", new medicina());
        request.setAttribute("titulo", "Registrar medicina");
        request.setAttribute("nro", 2);

        String pag = "/pagCrud.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

    }

    protected void adicion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        medicina a = new medicina();
        a.setNomP(request.getParameter("txtnomM"));
        a.setCant(request.getParameter("txtCant"));
        a.setPrecio(Double.parseDouble(request.getParameter("txtPre")));
        a.setStock(Integer.parseInt(request.getParameter("txtStock")));
        obj.Adicion(a);

        request.setAttribute("dato", obj.lisMedi());
        request.setAttribute("medicina", new medicina());
        request.setAttribute("titulo", "Registrar medicina");
        request.setAttribute("nro", 2);

        String pag = "/pagCrud.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

    }

    protected void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cod = request.getParameter("id");

        request.setAttribute("dato", obj.lisMedi());
        request.setAttribute("medicina", obj.Busca(cod));
        request.setAttribute("titulo", "EDitar Medicina");
        request.setAttribute("nro", 5);
        String pag = "/pagCrud.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

    }

    protected void cambia(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        medicina a = new medicina();
        a.setNomP(request.getParameter("txtnomM"));
        a.setCant(request.getParameter("txtCant"));
        a.setPrecio(Double.parseDouble(request.getParameter("txtPre")));
        a.setStock(Integer.parseInt(request.getParameter("txtStock")));
        obj.Modifica(a);
        request.setAttribute("dato", obj.lisMedi());
        request.setAttribute("medicina", new medicina());
        request.setAttribute("titulo", "Registrar Medicina");
        request.setAttribute("nro", 2);

        String pag = "/pagCrud.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

    }

    protected void anula(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cod = request.getParameter("id");
        obj.Anula(cod);
        request.setAttribute("dato", obj.lisMedi());
        request.setAttribute("cliente", new medicina());
        request.setAttribute("titulo", "Registrar Cliente");
        request.setAttribute("nro", 2);
        String pag = "/pagCrud.jsp";
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
