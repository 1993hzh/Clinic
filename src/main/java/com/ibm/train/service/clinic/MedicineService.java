package com.ibm.train.service.clinic;

import org.springframework.stereotype.Service;

import com.ibm.train.entity.clinic.Medicine;
import com.ibm.train.service.AbstractService;

@Service
public class MedicineService extends AbstractService<Medicine> {

	public MedicineService(Class<Medicine> entity) {
		super(entity);
	}

	public MedicineService() {
		this(Medicine.class);
	}

}
