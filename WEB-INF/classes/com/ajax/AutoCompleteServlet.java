package com.ajax;


import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author nbuser
 */
public class AutoCompleteServlet extends HttpServlet {

    static{
            System.out.println("Aotu Complete present");
    }
    private ServletContext context;
    private ItemData itemData = new ItemData();
    private HashMap<String,MainCatalogItem> products = itemData.getitems();

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
    }

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String action = request.getParameter("action");
        String targetId = request.getParameter("id");
        StringBuffer sb = new StringBuffer();
        MainCatalogItem items = null;


        if (targetId != null) {
            targetId = targetId.trim().toLowerCase();
        } else {
            context.getRequestDispatcher("/error.jsp").forward(request, response);
        }

        boolean namesAdded = false;
        if (action.equals("complete")) {

            // check if user sent empty string
            if (!targetId.equals("")) {
                System.out.println("total products::"+products.size());
                Iterator it = products.keySet().iterator();
                System.out.println("All products::"+products);
                while (it.hasNext()) {
                    String id = (String) it.next();
                    items = (MainCatalogItem)products.get(id);
                    System.out.println("item::"+items);
                    if (items.getShortDescription().toLowerCase().startsWith(targetId)) 
                         {

                        sb.append("<item>");
                        sb.append("<id>" + items.getItemID() + "</id>");
                        sb.append("<shortDescription>" + items.getShortDescription() + "</shortDescription>");
                        sb.append("</item>");
                        namesAdded = true;
                    }
                }
            }
            System.out.println("items::"+sb.toString());

            if (namesAdded) {
                response.setContentType("text/xml");
                response.setHeader("Cache-Control", "no-cache");
                response.getWriter().write("<items>" + sb.toString() + "</items>");//change
            } else {
                //nothing to show
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        }

        if (action.equals("lookup")) {
                // put the target composer in the request scope to display 
            if((targetId != null) && products.containsKey(targetId.trim())) {
                MainCatalogItem p = products.get(targetId);

                String d = p.getShortDescription();

                if(d.equals("Play Station 3 - Limited Edition") || d.equals("Play Station 3 - Black Edition") || d.equals("Play Station 3 - Yellow Edition") || d.equals("Play Station 4 - BATMAN Edition"))

            {

            context.getRequestDispatcher("/PlayStation.html").forward(request, response);
            
            }

            else if(d.equals("X Box Original") || d.equals("X Box 360") || d.equals("X Box One"))

            {

            context.getRequestDispatcher("/XBox.html").forward(request, response);
            
            }

            else if(d.equals("WII-1X") || d.equals("WII-2X") || d.equals("WIIU"))

            {



            context.getRequestDispatcher("/nintendo.html").forward(request, response);
            

            }

            else if(d.equals("Assasins Creed 4 - PS3") || d.equals("God Of War 3 - PS4") || d.equals("Mario 8 Racing - WII") || d.equals("All Stars Battle Royal - PSVITA"))

            {

            context.getRequestDispatcher("/games.html").forward(request, response);
            
            }

            else

            {
                context.getRequestDispatcher("/Access.html").forward(request, response);

            }


            }
                
        }
    }
}
