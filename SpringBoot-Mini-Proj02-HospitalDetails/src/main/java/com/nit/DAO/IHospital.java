package com.nit.DAO;

import java.util.List;

import com.nit.modelclass.Hospital;

public interface IHospital
{
     public List<Hospital> getAllHospitals() throws Exception;
     public int addHospital(Hospital hos)throws Exception;
     public int updateHospital(int code, String specialization)throws Exception;
     public int deleteHospital(int code)throws Exception;
     
}
