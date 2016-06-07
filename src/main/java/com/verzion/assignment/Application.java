package com.verzion.assignment;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) throws Exception {
		if (args.length > 0 && args[0].equals("testRest")) { // testRest
			testRest();
		} else { // standalone
			SpringApplication.run(DepartmentApplication.class);
			SpringApplication.run(EmployeeApplication.class);
		}

	}

	static void testRest() throws Exception {
		String[] urls = {
				"http://localhost:8080/department/save?name=Computer&min_salary_range=10000&max_salary_range=20000",
				"http://localhost:8080/department/save?name=Sales&min_salary_range=11000&max_salary_range=23999",
				"http://localhost:8080/department/save?name=Marketing&min_salary_range=30000&max_salary_range=50000",
				"http://localhost:8080/department/save?name=Accounting&min_salary_range=23999&max_salary_range=50000",
				"http://localhost:8080/department/save?name=Finance&min_salary_range=40000&max_salary_range=80000",

				"http://localhost:8080/department/query?name=Accounting",

				"http://localhost:8080/employee/save?firstName=f&lastName=l&salary=100000&department=1",
				"http://localhost:8080/employee/save?firstName=f2&lastName=l2&salary=10000&department=1&manager=1",
				"http://localhost:8080/employee/query?id=2",				
				"http://localhost:8080/employee/delete?id=2",
				"http://localhost:8080/employee/query?id=2",
				"http://localhost:8080/employee/save?firstName=f2&lastName=l2&salary=10000&department=1&manager=1",
				"http://localhost:8080/employee/update?id=3&salary=50000"
		};

		Arrays.asList(urls).forEach(url -> sendGet(url));
	}

	// HTTP GET request
	static private void sendGet(String url) {
		try {
			HttpURLConnection con = (HttpURLConnection) new URL(url)
					.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			// add request header

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			System.out.println(getResponse(con)+"\n\n\n");
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

	}

	static private String getResponse(URLConnection con) {
		String inputLine;
		StringBuffer response = new StringBuffer();

		try (BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()))) {

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

		// print result
		return response.toString();
	}

	// HTTP POST request
	private void sendPost(String url, String urlParameters) throws Exception {
		HttpsURLConnection con = (HttpsURLConnection) new URL(url)
				.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		// Send post request
		con.setDoOutput(true);

		try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
			wr.writeBytes(urlParameters);
			wr.flush();
		}

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		System.out.println(getResponse(con));

	}

}
