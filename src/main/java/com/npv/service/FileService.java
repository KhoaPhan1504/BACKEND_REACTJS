package com.npv.service;

import java.io.IOException;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.npv.utils.FileManager;

@Service
public class FileService implements IFileService{
	
	private FileManager fileManager = new FileManager();

//	private String linkFolder = "C:\\Users\\BienCao-NamViet\\Desktop\\Ra41-React\\ReactJs-FinalExam-Formik\\public\\upload";

	private String linkFolder = "D:\\JavaFullStack\\FE\\FE_REACTJS\\11. Source Practice On Class\\reactjs_12\\public\\upload";

	@Override
	public String upLoadImage(MultipartFile image) throws IOException {
		String nameImage = new Date().getTime() + "." + fileManager.getFormatFile(image.getOriginalFilename());

		String path = linkFolder + "\\" + nameImage;

		fileManager.createNewMultiPartFile(path, image);

		// TODO save link file to database

		// return link uploaded file
		return path;
	}

}
