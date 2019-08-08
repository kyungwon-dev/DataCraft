package com.datacraft.vo;

public class ExcelVO {
    
    private String cell[];
    private int cellSize;
    private String sheetName;
    private String filepath;
    
    
    
    public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getSheetName() {
		return sheetName;
	}
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	public void setCellSize(int cellSize) {
    	this.cellSize = cellSize;
    }
    public int getCellSize() {
    	return this.cellSize;
    }
    
    public void makeCellLength() {
    	cell = new String[cellSize];
    }
   
    public void setCell(int i,String cell) {
    	this.cell[i]=cell;
    }
    public String getCell(int i) {
    	return this.cell[i];
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<cellSize;i++)
        	sb.append(cell[i]+" ");
        return sb.toString();
    }
}
