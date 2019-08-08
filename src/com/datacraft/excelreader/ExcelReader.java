package com.datacraft.excelreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.datacraft.vo.*;
@SuppressWarnings("unused")
public class ExcelReader {
	private String findString;
	private List<ExcelVO> list;
	private int listSize;
	private ExcelInfoVO excelInfoVO;
	private int findIndex[][]; 
	private int sheetpage ;
	private XSSFRow curRow ;
	
	public XSSFRow getXSSFRow() {
		return curRow;
	}
	
	public int getSheetPage() {
		return sheetpage;
	}
	
	public int getfindIndex(int i,int j){
		return this.findIndex[i][j];
	}
	
	public ExcelInfoVO getExcelInfoV() {
		return this.excelInfoVO;
	}
	public String getFindstring() {
		return this.findString;
	}
	public void setFindString(String findString) {
		this.findString = findString;
	}
	public int getlistSize() {
		return this.listSize;
	}
	/**
	 * XLSX �뙆�씪�쓣 遺꾩꽍�븯�뿬 List<ExcelVo> 媛앹껜濡� 諛섑솚
	 * 
	 * @param filePath
	 * @return
	 */
	public String printList(int index,int i) {
		ExcelVO vo;
		vo = list.get(index);
		return vo.getCell(i);
	}
	public List<ExcelVO> xlsxToExcelVoList(File filePath) {
		// 諛섑솚�븷 媛앹껜瑜� �깮�꽦
		list = new ArrayList<ExcelVO>();

		FileInputStream fis = null;
		XSSFWorkbook workbook = null;

		// �깘�깋�뿉 �궗�슜�븷 Sheet, Row, Cell 媛앹껜
		XSSFSheet curSheet;
		XSSFCell curCell;
		ExcelVO excelVO ;
		excelInfoVO =new ExcelInfoVO();
		
		
		int i=0;
		
		try {
			fis = new FileInputStream(filePath);
			
			// HSSFWorkbook�� �뿊���뙆�씪 �쟾泥� �궡�슜�쓣 �떞怨� �엳�뒗 媛앹껜
			workbook = new XSSFWorkbook(fis);
			curSheet = workbook.getSheetAt(0);
			curRow = curSheet.getRow(0);
			sheetpage = workbook.getNumberOfSheets();
			findIndex = new int[sheetpage][curSheet.getPhysicalNumberOfRows()];

			// excel�쓽 �냽�꽦 媛� 媛��졇�삤湲�.
			for (int cellIndex = 0; cellIndex < curRow.getPhysicalNumberOfCells(); cellIndex++) {
				curCell = curRow.getCell( cellIndex, MissingCellPolicy.CREATE_NULL_AS_BLANK);
				excelInfoVO.SetInfo(cellIndex, curCell.toString());
				//�냽�꽦 異쒕젰
				//System.out.println(excelInfoVO.getInfo(cellIndex));
			}
			
			//excel�쓽 �냽�꽦 湲몄씠 吏��젙
			excelInfoVO.setIndex();

			
			// Sheet �깘�깋 for臾�	
			for (int sheetIndex = 0; sheetIndex < sheetpage; sheetIndex++) {
				// �쁽�옱 Sheet 諛섑솚
				curSheet = workbook.getSheetAt(sheetIndex);
				for (int rowIndex = 1; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++) {
					curRow = curSheet.getRow(rowIndex);
					curCell = curRow.getCell( 0, MissingCellPolicy.CREATE_NULL_AS_BLANK);
					if(curCell.toString().equals(findString)) {
						findIndex[sheetIndex][i]=rowIndex;
						i++;
					}
				}
				i=0;
			}
		
			//�빐�떦�븯�뒗 媛� (�슦由ш� 寃��깋�븳 媛� ) �꽔湲�
			for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
				curSheet = workbook.getSheetAt(sheetIndex);
				for (int rowIndex = 0; findIndex[sheetIndex][rowIndex]!=0; rowIndex++) {
					curRow = curSheet.getRow(findIndex[sheetIndex][rowIndex]);
					
					excelVO = new ExcelVO();
					//excel �냽�꽦 湲몄씠 �꽆寃⑥쨲
					excelVO.setCellSize(excelInfoVO.getIndex());
					//excel 湲몄씠留뚰겮 臾몄옄�뿴 �깮�꽦.
					excelVO.makeCellLength();
					for (int cellIndex = 0; cellIndex < curRow.getPhysicalNumberOfCells(); cellIndex++) {
						curCell = curRow.getCell(cellIndex,MissingCellPolicy.CREATE_NULL_AS_BLANK);
						String value="";
						switch (curCell.getCellType()) {
						case BLANK:
							value = curCell.getCellFormula();
							break;
						case NUMERIC:
							value = curCell.getNumericCellValue() + "";
							break;
						case STRING:
							value = curCell.getStringCellValue() + "";
							break;
						case _NONE:
							value = curCell.getBooleanCellValue() + "";
							break;
						case FORMULA:
							value = curCell.getErrorCellValue() + "";
							break;
						}
						excelVO.setCell(cellIndex,value);
						excelVO.setSheetName(curSheet.getSheetName());
						excelVO.setFilepath(filePath.getName());
					}
					list.add(excelVO);
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				// �궗�슜�븳 �옄�썝�� finally�뿉�꽌 �빐�젣
				if (workbook != null)
					workbook.close();
				if (fis != null)
					fis.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.listSize=list.size();
		return list;
	}
}
