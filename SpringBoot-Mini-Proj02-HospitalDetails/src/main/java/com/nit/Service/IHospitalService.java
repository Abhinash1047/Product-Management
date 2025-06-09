package com.nit.Service;

import java.util.List;

import com.nit.modelclass.Hospital;

public interface IHospitalService 
{
	public List<Hospital> getAll() throws Exception;
    public int addHospitalDetails(Hospital hos)throws Exception;
    public int updateHospitalDetails(int code, String specialization)throws Exception;
    public int deleteHospitalDetails(int code)throws Exception;
}
