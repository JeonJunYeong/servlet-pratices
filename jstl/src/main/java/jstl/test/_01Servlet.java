package jstl.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class _01Servlet
 */
@WebServlet("/01")
public class _01Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int iVal = 10;
		long lVal = 10;
		float fVal = 1.4f;
		boolean bVal = true;
		Object obj = null;
		UserVo vo = new UserVo();
		vo.setNo(1);
		String sval = "가\n나\n다\n라\n마";
		//map을 사용해서 여러 값을 한번에 넘기는 방법
		Map<String,Object> map = new HashMap<>();
		
		map.put("ival",iVal);
		map.put("lval",iVal);
		map.put("fval", fVal);
		map.put("bval", bVal);
		
		
		request.setAttribute("map", map);
		request.setAttribute("sval", sval);
		
		request.getRequestDispatcher("/WEB-INF/views/01.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
