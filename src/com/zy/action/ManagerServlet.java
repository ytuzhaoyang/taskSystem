package com.zy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import com.common.dbaccessframework.util.PageModel;
import com.zy.dao.ManagerDao;
import com.zy.po.ManagerBean;
import com.zy.utils.PageConfig;
import com.zy.utils.md5Util;

public class ManagerServlet extends HttpServlet {
	private ManagerDao dao = new ManagerDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		System.out.println(method);
		if("list".equalsIgnoreCase(method)){
			listManager(request,response);
		}else if("add".equalsIgnoreCase(method)){
			add(request,response);
		}else if("del".equalsIgnoreCase(method)){
			del(request,response);
		}else if("logout".equalsIgnoreCase(method)){
			logout(request,response);
		}
	}
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getSession().invalidate();
		request.getRequestDispatcher("/app/login.jsp").forward(request, response);
	}

	private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String ids = request.getParameter("managerId");
            dao.del(Integer.parseInt(ids));
            request.getRequestDispatcher("manager?method=list").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             String name = request.getParameter("managerName");
             String pwd1 = request.getParameter("managerPwd");
             String pwd2 = request.getParameter("password2");
             String phone = request.getParameter("managerPhone");
             ManagerBean bean = new ManagerBean(name,phone,md5Util.md5(pwd1),0);
             try {
            	 dao.add(bean);
				request.getRequestDispatcher("manager?method=list").forward(request, response);
			} catch (Exception e) {
				request.getRequestDispatcher("manager?method=add").forward(request, response);
				e.printStackTrace();
			} 
             
	}

	private void listManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String curpage = request.getParameter("curpage")!=null?request.getParameter("curpage"):"1";
		PageModel<ManagerBean> pp=dao.all(Integer.parseInt(curpage), PageConfig.PAGESIZE);
		request.setAttribute("pp", pp);
		request.getRequestDispatcher("app/system/manager_list.jsp").forward(request, response);	
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
