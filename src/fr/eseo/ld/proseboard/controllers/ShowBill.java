package fr.eseo.ld.proseboard.controllers;	
import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
	
	
import org.apache.ibatis.session.SqlSession;
	
	
import fr.eseo.ld.proseboard.models.Bill;
	
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
	
import fr.eseo.ld.proseboard.mybatis.mappers.BillMapper;
	
	
@WebServlet("/ShowBill")
	
public class ShowBill extends HttpServlet {
	
        
	
        private static final long serialVersionUID = 1L;
	
        
	
        public ShowBill() {
	
                super();
	
        }
	
	
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
                
	
                SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
	
                BillMapper billMapper = sqlSession.getMapper(BillMapper.class);
	
                String billId = request.getParameter("billId");
	
                Bill bill = billMapper.getBillById(new Long(billId));
	
                request.setAttribute("bill", bill);
	
                request.getRequestDispatcher("/WEB-INF/JSP/ShowBill.jsp").forward(request, response);
	
                sqlSession.close();
	
        }
	
}