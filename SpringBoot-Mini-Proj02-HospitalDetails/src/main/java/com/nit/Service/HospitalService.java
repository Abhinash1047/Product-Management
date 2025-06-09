package com.nit.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.DAO.IHospital;
import com.nit.modelclass.Hospital;
@Service("hospitalservice")
public class HospitalService implements IHospitalService
{
	@Autowired
     private IHospital hos;
	
	@Override
	public List<Hospital> getAll() throws Exception 
	{
		List<Hospital> all= hos.getAllHospitals();
		return all;
	}

	@Override
	public int addHospitalDetails(Hospital hospital) throws Exception {
		int hospital2 = hos.addHospital(hospital);
		return hospital2;
	}

	@Override
	public int updateHospitalDetails(int code, String specialization) throws Exception {
		    int h5 = hos.updateHospital( code,  specialization);
		return h5;
	}

	@Override
	public int deleteHospitalDetails(int code) throws Exception {
		int delete = hos.deleteHospital(code);
		return delete;
	}

}
