package com.datacraft.excelreader;


import java.io.File;

public class FileLoader {
	private String filePath;
	private File rootDir;
	private File[] fileList = null;
	private int fileLength;
	
	
	
	public void setfilePath(String path) { this.filePath=path;}
	public String getfilePath() { return filePath;} 
	public int getFileLength() { return fileLength; }
	
	public void fileset() {
		rootDir = new File(filePath);
		fileList = rootDir.listFiles();
		fileLength = fileList.length;
	}
	
	public File getFileList(int index) {
		if(fileList[index].isDirectory())
			return null;
		return fileList[index];
	}
}
