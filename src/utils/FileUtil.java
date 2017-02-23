package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

public class FileUtil {
	
	/**
	 * 경로+파일명에서 파일명,확장자 추출
	 * @param filePath
	 * @return
	 */
	public static String extractFullFileName(String fileFullPath) {
		
		if(CommonUtil.isEmpty(fileFullPath)) 
			throw new IllegalArgumentException("filePath not found");
		return fileFullPath.trim().substring(fileFullPath.lastIndexOf("\\")+1);
	}
	
	/**
	 * 경로+파일명에서 파일명만 추출
	 * @param filePath
	 * @return
	 */
	public static String extractOnlyFileName(String fileFullPath) {
		
		if(CommonUtil.isEmpty(fileFullPath)) 
			throw new IllegalArgumentException("filePath not found");
		return fileFullPath.trim().substring(fileFullPath.lastIndexOf("\\")+1,fileFullPath.lastIndexOf("."));
	}
	
	/**
	 * 경로+파일명에서 확장자만 추출
	 * @param filePath
	 * @return
	 */
	public static String extractFileExt(String fileFullPath) {
		
		if(CommonUtil.isEmpty(fileFullPath)) 
			throw new IllegalArgumentException("filePath not found");
		return fileFullPath.trim().substring(fileFullPath.lastIndexOf("."));
	}
	
	/**
	 * 경로+파일명에서 경로만 추출
	 * @param fileFullPath
	 * @return
	 */
	public static String extractFilePath(String fileFullPath) {
		
		if(CommonUtil.isEmpty(fileFullPath)) 
			throw new IllegalArgumentException("filePath not found");
		return fileFullPath.trim().substring(0,fileFullPath.lastIndexOf("\\")+1);
	}
	
	/**
	 * file path 를 받아서 파일생성에 필요한 상위폴더 생성
	 * @param fileFullPath
	 */
	public static void makeFilePath(String fileFullPath) {
		if(CommonUtil.isEmpty(fileFullPath)) {
			throw new IllegalArgumentException("filePath is Empty");
		}
		
		File file = new File(fileFullPath);
		File fullDirectorys = file.getAbsoluteFile();
		
		if (null != file.getPath()) {
			fullDirectorys.mkdirs();
		}
	}
	
	/**
	 * 파일 존재여부 확인
	 * @param fileName
	 */
	public static boolean isFile(String fileFullPath) {
		
		File f = new File(fileFullPath);
		
		return f.isFile();
	}
	
	/**
	 * 파일 복사(copy)
	 * @param originFileFullPath
	 * @param copyFileFullPath
	 * @throws IOException
	 */
	public static void copyFile(String originFileFullPath, String copyFileFullPath) throws IOException {
		
		FileInputStream input = new FileInputStream(originFileFullPath);
		FileOutputStream output = new FileOutputStream(copyFileFullPath);
		
		FileChannel fcin = input.getChannel();
		FileChannel fcout = output.getChannel();
		
		long size;
			
		size = fcin.size();
		fcin.transferTo(0, size, fcout); 
		
		fcout.close();
		fcin.close(); 
		input.close();
		output.close();
	}
	
	/**
	 * 경로에 존재하는 모든 파일명을 가져온다
	 * @param path
	 * @return
	 */
	public static ArrayList<String> getFileNames(String path) {
		
		ArrayList<String> fileNameList = new ArrayList<String>();
		
		File file = new File(path);
		File [] fileArray = file.listFiles();
		
		for(File f : fileArray) {
			fileNameList.add(f.getName());
		}
		
		return fileNameList;
	}
}
