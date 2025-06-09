package com.nit.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nit.Service.IHospitalService;
import com.nit.modelclass.Hospital;

@Controller("hospitalcontoller")
public class HospitalContoller {
	
	@Autowired
	private IHospitalService hs;
	
	
	public List<Hospital> getAllInformation() throws Exception
	{
		
		List<Hospital> allhos = hs.getAll();
		return allhos;
		
	}
	
	public int addHospitalDetails(Hospital hospital) throws Exception {
		int h2 = hs.addHospitalDetails(hospital);
		return h2;
	}
	
	public int updateHospitalInformation(int code, String specialization) throws Exception {
	    int h6 = hs.updateHospitalDetails(code,specialization);
	return h6; 
    }
	 
	public int deleteHospitalInformation(int code) throws Exception {
		int del= hs.deleteHospitalDetails(code);
		return del;
	}
	

}
