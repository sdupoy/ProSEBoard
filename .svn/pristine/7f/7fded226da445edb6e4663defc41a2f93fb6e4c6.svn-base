package fr.eseo.ld.proseboard.controllers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
	
import javax.servlet.http.HttpServletRequest;
	
import javax.servlet.http.HttpServletResponse;
	
import javax.servlet.http.HttpSession;
	
	
import org.apache.ibatis.session.SqlSession;
	
import fr.eseo.ld.proseboard.models.Bill;
	
import fr.eseo.ld.proseboard.models.User;
	
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
	
import fr.eseo.ld.proseboard.mybatis.mappers.BillMapper;
	
import fr.eseo.ld.proseboard.mybatis.mappers.UserMapper;
	
@WebServlet("/ManageBills")
	
public class ManageBills extends HttpServlet {
	
        
	
        private static final long serialVersionUID = 1L;
	
        
	
        public ManageBills() {
	
                super();
	
        }
	
	
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
                
	
                SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
	
                BillMapper billMapper = sqlSession.getMapper(BillMapper.class);
	
                UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

                HttpSession session = request.getSession();
	
                User user = (User)session.getAttribute("user");
	
                List<Bill> listBills = billMapper.getBillsForUserId(user.getId());
	
                request.setAttribute("bills", listBills);

                List<User> listEmitters = new ArrayList<User>();
	
                Iterator<Bill> i = listBills.iterator();
	
                while(i.hasNext()) listEmitters.add(userMapper.getById(i.next().getIdUserTransmitter()));
	
                request.setAttribute("emitters", listEmitters);
	
                sqlSession.close();
	
                request.getRequestDispatcher("/WEB-INF/JSP/ManageBills.jsp").forward(request, response);
	
        }
	
	
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
                
	
                SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
	
                BillMapper billMapper = sqlSession.getMapper(BillMapper.class);
	
                String billId = request.getParameter("billId");
	
                billMapper.delete(new Long(billId));
	
               sqlSession.commit();
	
                sqlSession.close();
	
                doGet(request,response);
	
        }
	
}