package com.datacraft.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FilepathServlet
 */
@WebServlet("/result")
@MultipartConfig(maxFileSize=1024*1024*2 , location="F:\\")
public class FilepathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String filename = request.getParameter("upfile");
		Part part = request.getPart(filename);
		FileWriter writer = null;
		try {
			
			writer = new FileWriter(new File("F:\\"+part.getName()+".xlsx"));
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}finally {
			writer.close();
		}
		
		response.sendRedirect("/datacraft/uploadok.jsp");
	}

}
