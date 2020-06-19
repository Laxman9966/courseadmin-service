package com.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

//	@Query("SELECT scl FROM School scl  WHERE scl.schoolName=(:companyname)")
//    List<EmployerPrfl> getJobsByEmployer(@Param("companyname") String companyname);
//	
//	@Query("SELECT scl FROM School scl  WHERE scl.schoolName=(:companyname)")
//    List<JobPosting> getJobsDetails(@Param("jobid") int jobid);

}
