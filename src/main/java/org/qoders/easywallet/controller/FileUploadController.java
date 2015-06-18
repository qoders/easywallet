package org.qoders.easywallet.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.qoders.easywallet.domain.FileUpload;
import org.qoders.easywallet.domain.FileUploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Handle all file upload controller
 * @author Nhu Trinh
 *
 */
@Controller
public class FileUploadController {
	@Autowired
	ServletContext context;
	
	@RequestMapping(value="/api/upload", method = RequestMethod.POST)
	public @ResponseBody FileUploadResult uploadHandle(FileUpload fileUpload, BindingResult result){
		//TODO: Security file upload
		FileUploadResult fur = new FileUploadResult();
		if (result.hasErrors()){
			fur.setError(true);
			String errors = "";
			for(FieldError error : result.getFieldErrors()){
				errors += String.format("%s: %s (%s)\n", error.getField(), 
						error.getDefaultMessage(), error.getCode());
			}
			fur.setMessage(errors);
		}else{
			String ROOT_PATH = context.getRealPath("/");
			switch(fileUpload.getPath()){
			case "receipt":
				//TODO: Generate userid based on logged in user
				String userDirs = "Temp_User_Dir";
				String returnPath = "/media/receipts/" + userDirs + "/";
				String fullPath = ROOT_PATH + returnPath;
				String fileName = UUID.randomUUID().toString() + ".jpg";
				try{
					File dir = new File(fullPath);
					if (!dir.exists()){
						dir.mkdirs();
					}
					File uploadTo = new File(fullPath + fileName);
					fileUpload.getFile().transferTo(uploadTo);
					fur.setError(false);
					fur.setFilename(fileName);
					fur.setPath(returnPath);
					fur.setThumbnail(fileName);
				}catch(Exception ex){
					fur.setError(true);
					fur.setMessage("Could not upload file");
				}
				break;
			default:
				fur.setError(true);
				fur.setMessage("Unknown path");
			}
		}
		return fur;
	}
	
	
}
