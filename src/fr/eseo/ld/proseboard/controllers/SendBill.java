package fr.eseo.ld.proseboard.controllers;
import java.io.IOException;
import java.util.Date;
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
	
	
@WebServlet("/SendBill")
	
public class SendBill extends HttpServlet {
	
        
	
        private static final long serialVersionUID = 1L;
	
        
	
        public SendBill() {
	
                super();
	
        }
	
	
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                
	
                SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
	
                UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
	
                HttpSession session = request.getSession();
	
                User user = (User)session.getAttribute("user");
	
                List<User> potentialBillReceivers = userMapper.getPotentialBillReceivers(user.getId());        
	
                request.setAttribute("potentialBillReceivers", potentialBillReceivers);        
	
                request.getRequestDispatcher("/WEB-INF/JSP/SendBill.jsp").forward(request, response);
	
                sqlSession.close(); 
	
        }
	
	
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
                
	
                String amount = request.getParameter("amount");
	
                
	
                if(isPriceFormat(amount))
	
                {
	
                        String subject = request.getParameter("subject");
	
                        String comments = request.getParameter("comments");
	
                        String idBillReceiver = request.getParameter("idBillReceiver");
	
                        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
	
                        HttpSession session = request.getSession();        
	
                        User user = (User)session.getAttribute("user");
	
                        BillMapper billMapper = sqlSession.getMapper(BillMapper.class);        
	
                        Bill bill = new Bill(user.getId(), new Long(idBillReceiver), subject, (new Float(amount)).floatValue(), comments, new Date());
	
                        billMapper.insert(bill);
	
                        sqlSession.commit();
	
                        sqlSession.close();
	
                        response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/ManageBills"));
	
                }
	
                else
	
                {
	
                        request.setAttribute("errorMsg", "Montant incorrect, veuillez recommencer la saisie");
	
                        doGet(request, response);        
	
                }
	
        }
	
        
	
        private boolean isPriceFormat(String str) {
	
                try {
	
                        Float.parseFloat(str);
	
                }catch (NumberFormatException e){
	
                        return false;
	
                }
	
                return true;
	
        }
	
}