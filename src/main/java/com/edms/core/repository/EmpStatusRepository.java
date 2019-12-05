package com.edms.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edms.core.domain.Data;
import com.edms.core.domain.Professional;
import com.edms.core.domain.StatusData;

/**
 * @author anurag
 *
 */
public interface EmpStatusRepository extends JpaRepository<Professional, Long> {
	
	/**
	 * @returns list of {@link Data} for charts
	 * based on emp_type
	 */
	@Query(value = "select count(e.id) as y ,s.name as name from employee e,emp_type et,status s where s.id=e.status_id and et.name='C2C' and e.emp_type_id=et.id  group by s.name", nativeQuery = true)
	List<Data> getC2CStatus();

	/**
	 * @returns list of {@link Data} for charts
	 * based on emp_type
	 */
	@Query(value = "select count(e.id) as y ,s.name as name from employee e,emp_type et,status s where s.id=e.status_id and et.name='W2' and e.emp_type_id=et.id  group by s.name", nativeQuery = true)
	List<Data> getW2Status();
	
	/**
	 * fetching the count of the employee where status is bench and emp type is C2C
	 * @return {@link StatusData} 
	 */
	@Query(value = "select count(p.employee_id) as count ,epr.name as employer from professional p,employer epr where p.employer_id=epr.id and p.employee_id in (select e.id from employee e,emp_type etyp,status s where e.status_id=s.id and etyp.name='C2C' and etyp.id=e.emp_type_id and s.name='Active Bench') group by p.employer_id", nativeQuery = true)
	List<StatusData> getEmployerC2CStatus();

	/**
	 * fetching the count of the employee where status is bench and emp type is W2
	 * @return {@link StatusData} 
	 */
	@Query(value = "select count(p.employee_id) as count ,epr.name as employer from professional p,employer epr where p.employer_id=epr.id and p.employee_id in (select e.id from employee e,emp_type etyp,status s where e.status_id=s.id and etyp.name='W2' and etyp.id=e.emp_type_id and s.name='Active Bench') group by p.employer_id", nativeQuery = true)
	List<StatusData> getEmployerW2Status();
	
}
