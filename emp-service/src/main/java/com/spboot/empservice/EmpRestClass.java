package com.spboot.empservice;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpRestClass {

	static List<String> empList = (List<String>) Arrays.asList("Anu", "Sam", "Himan", "karna", "sha");
	
	
	public EmpRestClass() {
	}
	
	@GetMapping("/getEmployeeById")
	public String getEmployeeById(@PathParam(value = "id") int id) {
		try {
			if(empList.get(id)!=null) {
				return "Employee id is : "+ empList.get(id);
			}
		}catch (ArrayIndexOutOfBoundsException e) {
			return "Couldn't fine the employee, Select a range from 0 to " +empList.size();
		
		}
		return null;
		
	}

	@GetMapping("/getEmployees")
	public List getEmployees() {
			if(empList!=null) {
				return empList;
			}
		return null;
		
	}
}
