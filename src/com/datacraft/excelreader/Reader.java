package com.datacraft.excelreader;

import java.util.List;
import java.util.Scanner;

import com.datacraft.vo.*;

public class Reader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelReader excelReader = new ExcelReader();
		FileLoader fileLoader = new FileLoader();
		//xls file
		//List<ExcelVO> xlsList = excelReader.xlsxToExcelVoList("C:\\Java\\eclipse-workspace\\PaasTA\\stored\\예제1.xls");
		//printList(xlsList);

		String inputStr = null;
		Scanner scan = new Scanner(System.in);
		inputStr = scan.nextLine();
		
		fileLoader.setfilePath("C:\\Java\\eclipse-workspace\\DataCraft\\WebContent\\resources\\excel\\");
		fileLoader.fileset();
		excelReader.setFindString(inputStr);
		
		for(int i=0;i<fileLoader.getFileLength();i++) {
			List<ExcelVO> xlsxList = excelReader.xlsxToExcelVoList(fileLoader.getFileList(i));
			printList(xlsxList);
		}
		scan.close();
	}

	public static void printList(List<ExcelVO> list) {
		ExcelVO vo;
		for (int i = 0; i < list.size(); i++) {
			vo = list.get(i);
			System.out.println(vo.toString());
		}
	}

}
