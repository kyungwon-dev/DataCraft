package com.datacraft.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import java.util.List;
import java.util.Scanner;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import com.datacraft.excelreader.ExcelReader;
import com.datacraft.excelreader.FileLoader;
import com.datacraft.vo.*;


/**
 * Servlet implementation class Reader
 */
@WebServlet("/Reader")
public class ReaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReaderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ExcelReader excelReader = new ExcelReader();
		FileLoader fileLoader = new FileLoader();
		fileLoader.setfilePath("C:\\Java\\eclipse-workspace\\DataCraft\\WebContent\\resources\\excel");
		fileLoader.fileset();
		System.out.println(request.getParameter("inputStr"));
		excelReader.setFindString(request.getParameter("inputStr"));
		List<ExcelVO> xlsxList=null;
		for(int i=0;i<fileLoader.getFileLength();i++)
			xlsxList = excelReader.xlsxToExcelVoList(fileLoader.getFileList(i));
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("/tableok.jsp"); //넘길 페이지 주소
        request.setAttribute("xlsx",xlsxList);
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
