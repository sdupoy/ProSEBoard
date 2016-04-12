package fr.eseo.ld.proseboard.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Auth
 */
@WebFilter(filterName= "auth", urlPatterns = "/*")
public class Auth implements Filter {

    /**
     * Default constructor. 
     */
    public Auth() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	  //Nothing to do because the filter does not create any useless data
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		HttpSession session = request.getSession();
		
		/* Non-filtrage des ressources statiques */
		String path = request.getRequestURI().substring( request.getContextPath().length() );
		if ( path.startsWith( "/resources" ) || path.startsWith( "/login" ) ) {
			chain.doFilter( req, res );
		}else{
			if(session.getAttribute("user") == null){
				session.setAttribute("from", path);
				response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/login"));
				return;
			}else{
				// pass the request along the filter chain
				chain.doFilter(req, res);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	  //No configuration necessary
	}

}