package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.mvc.common.mybatis.Template.getSqlSession;

public class EmployeeService {

    private  EmployeeMapper employeeMapper; // 반환받아옴
    public EmployeeDTO selectOneEmpById(String empId) {

        //SqlSession 객체 생성 -> Template 에서 작성해서 호출
        SqlSession sqlSession = getSqlSession();
        System.out.println("sqlSession : " + sqlSession);

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class); //선언하고

        EmployeeDTO selectedEmp = employeeMapper.selectOneEmpById(empId);

        sqlSession.close();

        return selectedEmp; // 사원 정보 반환받
    }

    public List<EmployeeDTO> selectAllEmp() {

        SqlSession sqlSession = getSqlSession();
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        List<EmployeeDTO> empList = employeeMapper.selectAllEmp();

        sqlSession.close();

        return empList;
    }

    public int insertEmp(EmployeeDTO emp) {
        SqlSession sqlSession = getSqlSession();
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        int result = employeeMapper.insertEmp(emp);

        if (result > 0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result;
    }


    public int updateEmp(EmployeeDTO emp) {

        SqlSession session = getSqlSession();
        employeeMapper = session.getMapper(EmployeeMapper.class);

        int result = employeeMapper.updateEmp(String.valueOf(emp));

        if(result > 0) {
            session.commit();
        } else {
            session.rollback();
        }

        session.close();

        return result;
    }
}
