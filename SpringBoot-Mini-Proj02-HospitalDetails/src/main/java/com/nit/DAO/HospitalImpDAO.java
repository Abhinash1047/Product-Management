package com.nit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nit.modelclass.Hospital;
@Repository("hospitaldao")
public class HospitalImpDAO implements IHospital {
	
	private static final String GET_ALL_HOSPITALS="select * from hospitaldetails";
	private static final String INSERT_HOSPITAL="insert into hospitaldetails values(?,?,?,?)";
	private static final String UPADTE_HOSPITAL="update hospitaldetails set specialization=? where hcode=?";
	private static final String DELETE_HOSPITAL="delete from hospitaldetails where hcode=?";
	
	@Autowired
	private DataSource ds;
	
	public List<Hospital> list= new ArrayList<Hospital>();
	
	@Override
	public List<Hospital> getAllHospitals() throws Exception 
	{
		try(Connection con=ds.getConnection();
			  PreparedStatement ps= con.prepareStatement(GET_ALL_HOSPITALS);ResultSet rs= ps.executeQuery();)
		{
			list.clear();
			  while(rs.next())
			  {
					
				  Hospital h= new Hospital();
				 	
				 	h.setCode(rs.getInt(1));
				 	h.setSpecialization(rs.getString(2));
				 	h.setName(rs.getString(3));
				 	h.setLocation(rs.getString(4));
				 	
				 	list.add(h);
				
			  }
			 
		}
		catch (Exception e) {
			throw e;
		}
		
		return list;
	}

	
	
	
	
	@Override
	public int addHospital(Hospital hos) throws Exception 
	{
		int k=0;
		try(Connection con1=ds.getConnection();
				PreparedStatement ps1=con1.prepareStatement(INSERT_HOSPITAL);)
		{
			
			ps1.setInt(1, hos.getCode());
			ps1.setString(2, hos.getSpecialization());
			ps1.setString(3, hos.getName());
			ps1.setString(4,hos.getLocation());
			
			 k = ps1.executeUpdate();
			if(k>0)
			{
				System.out.println("Record inserted successfully..");
			}
			else
			{
				System.out.println("invalid inputs....");
			}
		}
		catch (Exception e) {
			throw e;
		}
		return k;
	}

	@Override
	public int updateHospital(int code, String specialization) throws Exception
	{
		int k=0;
		try(Connection con3= ds.getConnection();
				PreparedStatement ps= con3.prepareStatement(UPADTE_HOSPITAL);)
		{
			
			ps.setString(1,specialization );
			ps.setInt(2, code);
			
			k  = ps.executeUpdate();
//			if(k>=0)
//			{
//				System.out.println("Record updated successfully..");
//			}
//			else
//			{
//				System.out.println("invalid inputes....");
//			}
			
		}
		catch (Exception e) {
			throw e;
			
		}
		return k;
	}

	@Override
	public int deleteHospital(int code) throws Exception
	{
		int k=0;
		try(Connection con4 = ds.getConnection();
				PreparedStatement ps=con4.prepareStatement(DELETE_HOSPITAL);)
		{
			
			ps.setInt(1, code);
			
			 k = ps.executeUpdate();
//			 if(k>0)
//			 {
//				 System.out.println("Record Deleted successfully....");
//			 }
//			 else
//			 {
//				 System.out.println("invalid Hospital code....");
//			 }
			
		}
		catch (Exception e) {
			throw e;
		}
		return k;
	}

}
