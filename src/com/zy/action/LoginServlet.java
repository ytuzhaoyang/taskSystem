package com.zy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zy.dao.ManagerDao;
import com.zy.po.ManagerBean;
import com.zy.utils.md5Util;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		ManagerDao dao = new ManagerDao();
		ManagerBean bean = dao.login(name, md5Util.md5(password));
		HttpSession session = request.getSession();
		if(bean!=null){
			session.setAttribute("login", bean);
			request.getRequestDispatcher("/app/main.html").forward(request, response);
		}else{
			request.setAttribute("errormessage", "用户名或密码有误请重新输入");
			request.getRequestDispatcher("/app/login.jsp").forward(request, response);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
