package com.healthcareDemo.repository;

import com.healthcareDemo.model.Department;
import com.healthcareDemo.service.ConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {

    private static Connection connection = null;

    public void initConnection() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection = new ConnectionService().getConnection();
        }
    }

    List<Department> departmentList = new ArrayList<>();

    public boolean addDepartment(Department department) throws SQLException {
        this.initConnection();
        String query = "insert into department(deptId,deptName,doctorId,hospitalId)values(?,?,?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,department.getDeptId());
            preparedStatement.setString(2,department.getDeptName());
            preparedStatement.setInt(3,department.getDoctorId());
            preparedStatement.setInt(4,department.getHospitalId());

            System.out.println("inserting data: "+department);

            int rowInserted = preparedStatement.executeUpdate();

            return rowInserted > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try{
                if(connection!= null){
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("connection close: "+e.getMessage());
            }
        }

    }

    public Department viewDepartment(Department department) throws SQLException {

        this.initConnection();
      ;
        try{
            String query = "Select * from department";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            System.out.println("departments: "+department);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return department;
    }

    public boolean deleteDepartment(int deptId) throws SQLException {

        this.initConnection();
        String query = "delete from department where deptId=?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,deptId);

            System.out.println("deleting data: "+deptId);

            int deleteRow = preparedStatement.executeUpdate();

            return deleteRow > 0;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        finally {
            try{
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
