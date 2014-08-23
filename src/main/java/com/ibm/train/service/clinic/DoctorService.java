package com.ibm.train.service.clinic;

import org.springframework.stereotype.Service;

import com.ibm.train.entity.clinic.Doctor;
import com.ibm.train.service.AbstractService;

/**
 * @author HuZhonghua
 *
 */
@Service
public class DoctorService extends AbstractService<Doctor> {

	public DoctorService(Class<Doctor> entity) {
		super(entity);
	}

	public DoctorService() {
		this(Doctor.class);
	}

}
