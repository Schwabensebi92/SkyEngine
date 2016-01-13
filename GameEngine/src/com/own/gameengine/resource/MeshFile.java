package com.own.gameengine.resource;


public class MeshFile {
	
	private MeshFileType	type;
	private String			fileText;
	
	public MeshFile(MeshFileType type, String fileText) {
		this.type = type;
		this.fileText = fileText;
	}
	
	public MeshFileType getType() {
		return type;
	}
	
	public String getFileText() {
		return fileText;
	}
}
