package edu.cmu.cs.webapp.hw4.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.cs.webapp.hw4.formbean.CreateCircleForm;
import edu.cmu.cs.webapp.hw4.model.Model;
import edu.cmu.cs.webapp.hw4.model.UserDAO;

import org.json.*;

public class CreateTeamAction extends Action {
	private FormBeanFactory<CreateCircleForm> formBeanFactory = FormBeanFactory.getInstance(CreateCircleForm.class);
	
	public CreateTeamAction() {
	}

	public String getName() {
		return "createteam.do";
	}

	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		JSONObject responseObj = new JSONObject();

		try {
			CreateCircleForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);

			// If no params were passed, return with no errors so that the form
			// will be
			// presented (we assume for the first time).
			if (!form.isPresent()) {
				return "CreateCaregiverTeam.jsp";
			}

			// Any validation errors?
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				return "CreateCaregiverTeam.jsp";
			}

			if (form.getAction().equals("CreateCaregiverTeam")) {
				String query = "http://localhost:8080/CurantisBackendService/curantis/createcircle";
				JSONObject json = new JSONObject();
				try {
					//?????
					json.put("teamname", form.getTeamname());
					json.put("lovename", form.getLovename());
					json.put("loveaddress", form.getLoveaddress());
					json.put("relation", form.getRelation());
					json.put("georelation", form.getGeorelation());
					json.put("event", form.getEvent());
				} catch (JSONException e1) {
					e1.printStackTrace();
				}
				try {
					URL url = new URL(query);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setConnectTimeout(5000);
					conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
					conn.setDoOutput(true);
					conn.setDoInput(true);
					conn.setRequestMethod("POST");
					OutputStream os = conn.getOutputStream();
					os.write(json.toString().getBytes("UTF-8"));
					os.close();
					// read the response
					if (conn.getResponseCode() != 200) {
						throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
					}

					BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

					String output;
					System.out.println("Output from Server .... \n");

					while ((output = br.readLine()) != null) {
						try {
							responseObj = new JSONObject(output);
							Boolean success = responseObj.getBoolean("success");
							String message = responseObj.getString("message");
							if (success != true) {
								if (message.equals("Missing circle name or email!")) {
									errors.add("Missing circle name or email!");
									return "CreateCaregiverTeam.jsp";
								} else if (message.equals("Circle name exists!")) {
									errors.add("Circle name exists!");
									return "CreateCaregiverTeam.jsp";
								} else if (message.equals("Creating circle failed!")) {
									errors.add("Creating circle failed!");
									return "CreateCaregiverTeam.jsp";
								}
							}

						} catch (JSONException e) {
							e.printStackTrace();
						}
						System.out.println(output);
					}

					conn.disconnect();

				} catch (MalformedURLException e) {

					e.printStackTrace();

				} catch (IOException e) {

					e.printStackTrace();

				}
				String teamname = new String();
				String lovename = new String();
				String loveaddress = new String();
				String relation = new String();
				String georelation = new String();
				String event = new String();
				try {
					teamname = responseObj.getString("teamname");
					lovename = responseObj.getString("lovename");
					loveaddress = responseObj.getString("loveaddress");
					relation = responseObj.getString("relation");
					georelation = responseObj.getString("georelation");
					event = responseObj.getString("event");
				} catch (JSONException e) {
					e.printStackTrace();
				}
				//session.setAttribute("user", teamname );
				return "mydashboard.do";
			} else {
				return "createteam.do";
			}
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "createteam.do";
		}
	}
}
