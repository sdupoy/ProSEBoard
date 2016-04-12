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

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.MessageMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.NotificationMapper;

/**
 * Servlet Filter implementation class Messages
 */
@WebFilter(filterName="messagecount", urlPatterns="/*")
public class Messages implements Filter {

    /**
     * Default constructor. 
     */
    public Messages() {
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        //The filter does not create anything we need to destroy
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)res;
        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");
        if (user != null){
            Integer count = null;

            SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();

            try{
                MessageMapper messageMapper = sqlSession.getMapper(MessageMapper.class);
                count = messageMapper.count(user.getId().intValue());
                session.setAttribute("count", count);
                NotificationMapper notificationMapper = sqlSession.getMapper(NotificationMapper.class);
                count = notificationMapper.getUsersCount(user);
                session.setAttribute("notifCount", count);
            }finally{
                sqlSession.close();
            }
        }
        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        //This filter does not need any configuration before beeing executed
    }

}
