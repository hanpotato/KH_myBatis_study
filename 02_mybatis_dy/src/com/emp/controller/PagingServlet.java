package com.emp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.model.service.EmpService;
import com.emp.model.service.EmpServiceImpl;

/**
 * Servlet implementation class PagingServlet
 */
@WebServlet("/paging.do")
public class PagingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmpService service = new EmpServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cPage;
		int numPerPage = 4;
		
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			cPage = 1;
		}
		
		//전체자료갯수
		int total = service.selectCount();

		//자료
		List<Map> list = service.selectPaging(cPage,numPerPage);

		int totalPage = (int)Math.ceil((double)total/numPerPage);
		int pageBarSize = 5;
		String pageBar = "";
		
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo + pageBarSize-1;
		
		pageBar+="<ul class='pagination justify-content pagination-sm'>";
		
		if(pageNo==1) {
			pageBar+="<li class='page-item disabled'>";
			pageBar+="<a class='page-link' href='#' tabindex='-1'>이전</a>";
			pageBar+="</li>";
		}
		else {
			pageBar+="<li class='page-item'>";
			pageBar+="<a class='page-link' href='javascript:void(0);' onclick='fn_paging("+ (pageNo-1) +")'>이전</a>";
			pageBar+="</li>";
		}
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar+="<li class='page-item active'>";
				pageBar+="<a class='page-link'>"+ pageNo + "</a>";
				pageBar+="</li>";
			}
			else {
				pageBar+="<li class='page-item'>";
				pageBar+="<a class='page-link' href='javascript:void(0);' onclick='fn_paging("+ pageNo +")'>" + pageNo + "</a>";
				pageBar+="</li>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
			pageBar+="<li class='page-item disabled'>";
			pageBar+="<a class='page-link' href='#'>다음</a>";
			pageBar+="</li>";
		}
		else {
			pageBar+="<li class='page-item'>";
			pageBar+="<a class='page-link' href='javascript:void(0);' onclick='fn_paging("+ pageNo +")'>다음</a>";
			pageBar+="</li>";
		}
		
		pageBar+="</ul>";
		
		pageBar+="<script>";
		pageBar+="function fn_paging(cPage)";
		pageBar+="{";
		pageBar+="location.href='"+ request.getRequestURI() +"?cPage='+cPage";
		// location.href='localhost:9090/~~/paging.do?cPage='+cPage
		// request.getRequestURI() 는 현재 서블릿에 있는 주소를 받는다.
		pageBar+="}";
		pageBar+="</script>";
		
		request.setAttribute("list", list);
		request.setAttribute("pageBar", pageBar);
		request.getRequestDispatcher("/views/emp/search1.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
