package edu.cmu.cs.webapp.hw4.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import edu.cmu.cs.webapp.hw4.databean.DocumentBean;

public class SeniorHousingDocAction extends Action {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "seniorHousingDoc.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		List<DocumentBean> docList = getDocs("c@gmail.com", 3, 1);
		request.setAttribute("docList", docList);
		return "SeniorHousingDocument.jsp";
	}
	
	private List<DocumentBean> getDocs(String email, long circleId, int service) {
		List<DocumentBean> list = new ArrayList<DocumentBean>();
		
		DocumentBean doc1 = new DocumentBean();
		doc1.setName("Document 1");
		doc1.setUrl("www.google.com");
		doc1.setAccessLevel(false);
		list.add(doc1);
		
		DocumentBean doc2 = new DocumentBean();
		doc2.setName("Document 2");
		doc2.setUrl("www.google.com");
		doc2.setAccessLevel(true);
		list.add(doc2);
		
		return list;
	}
}
