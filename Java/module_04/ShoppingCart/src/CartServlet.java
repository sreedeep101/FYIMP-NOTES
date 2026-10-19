import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    // Product IDs and prices
    private static final Map<String, Integer> PRODUCTS =
        new LinkedHashMap<>();

    static {
        PRODUCTS.put("Laptop", 50000);
        PRODUCTS.put("Mouse", 500);
        PRODUCTS.put("Keyboard", 1000);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        // Retrieve the cart from the session
        Map<String, Integer> cart =
            (Map<String, Integer>) session.getAttribute("cart");

        if (cart == null) {
            cart = new LinkedHashMap<>();
            session.setAttribute("cart", cart);
        }

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Shopping Cart</title></head>");
        out.println("<body>");

        out.println("<h2>Available Products</h2>");

        // Display products
        for (Map.Entry<String, Integer> product : PRODUCTS.entrySet()) {

            out.println("<p>" + product.getKey()
                + " - Rs. " + product.getValue() + "</p>");

            out.println("<form method='post' action='cart'>");
            out.println("<input type='hidden' name='action' value='add'>");
            out.println("<input type='hidden' name='product' value='"
                + product.getKey() + "'>");
            out.println("<button type='submit'>Add to Cart</button>");
            out.println("</form>");
        }

        out.println("<hr>");
        out.println("<h2>Your Shopping Cart</h2>");

        int total = 0;

        if (cart.isEmpty()) {
            out.println("<p>Your cart is empty.</p>");
        } else {
            for (Map.Entry<String, Integer> item : cart.entrySet()) {

                String name = item.getKey();
                int quantity = item.getValue();
                int price = PRODUCTS.get(name);
                int subtotal = price * quantity;

                total += subtotal;

                out.println("<p>" + name
                    + " | Quantity: " + quantity
                    + " | Subtotal: Rs. " + subtotal + "</p>");

                out.println("<form method='post' action='cart'>");
                out.println("<input type='hidden' name='action' value='remove'>");
                out.println("<input type='hidden' name='product' value='"
                    + name + "'>");
                out.println("<button type='submit'>Remove One</button>");
                out.println("</form>");
            }
        }

        out.println("<h3>Total: Rs. " + total + "</h3>");

        out.println("<form method='post' action='cart'>");
        out.println("<input type='hidden' name='action' value='clear'>");
        out.println("<button type='submit'>Clear Cart</button>");
        out.println("</form>");

        out.println("<br><a href='logout'>End Session / Logout</a>");

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        String action = request.getParameter("action");
        String product = request.getParameter("product");

        HttpSession session = request.getSession();

        Map<String, Integer> cart =
            (Map<String, Integer>) session.getAttribute("cart");

        if (cart == null) {
            cart = new LinkedHashMap<>();
            session.setAttribute("cart", cart);
        }

        if ("add".equals(action)) {

            // Add only valid products
            if (product != null && PRODUCTS.containsKey(product)) {
                cart.put(product, cart.getOrDefault(product, 0) + 1);
            }

        } else if ("remove".equals(action)) {

            if (product != null && cart.containsKey(product)) {
                int quantity = cart.get(product);

                if (quantity > 1) {
                    cart.put(product, quantity - 1);
                } else {
                    cart.remove(product);
                }
            }

        } else if ("clear".equals(action)) {

            cart.clear();
        }

        // Redirect to prevent resubmission when the page is refreshed
        response.sendRedirect(request.getContextPath() + "/cart");
    }
}
