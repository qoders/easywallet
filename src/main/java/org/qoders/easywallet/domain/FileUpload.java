package org.qoders.easywallet.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

/**
 * Domain object for file upload
 * @author Nhu Trinh
 *
 */
public class FileUpload implements Serializable {
	private static final long serialVersionUID = 5238513534350490116L;

	/**
	 * File field in multipart file upload
	 */
	@NotNull(message="{Form.Upload.FileEmpty}")
	private MultipartFile file;
	
	/**
	 * Path is a string which indicate which type of this upload, location of upload, 
	 * path = receipt then the file will be put in /media/receipts/<user_name>/<random-uuid>.jpg
	 * ...
	 */
	@NotEmpty(message="{Form.Upload.FilePathEmpty}")
	private String path;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String type) {
		this.path = type;
	}

	
}
