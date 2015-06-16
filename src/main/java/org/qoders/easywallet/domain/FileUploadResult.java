package org.qoders.easywallet.domain;

import java.io.Serializable;

/**
 * This object will be returned to client after file upload, If there is any error, 
 * error reason will be return otherwise upload file and thumbnail location will be return
 * @author Nhu Trinh
 *
 */
public class FileUploadResult implements Serializable {
	private static final long serialVersionUID = 2642753072774928575L;
	
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	private boolean error=false;
	private String message;
	private String path;
	private String filename;
	private String thumbnail;

}
