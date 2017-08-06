package edu.cmu.cs.webapp.hw4.databean;

public class DocumentBean {
	private String name;
	private String url;
	private boolean accessLevel;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(boolean accessLevel) {
		this.accessLevel = accessLevel;
	}
}
