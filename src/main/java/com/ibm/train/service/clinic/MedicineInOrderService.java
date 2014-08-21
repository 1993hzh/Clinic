package com.ibm.train.service.clinic;

import org.springframework.stereotype.Service;

import com.ibm.train.entity.clinic.MedicineInOrder;
import com.ibm.train.service.AbstractService;

@Service
public class MedicineInOrderService extends AbstractService<MedicineInOrder> {

	public MedicineInOrderService(Class<MedicineInOrder> entity) {
		super(entity);
	}

	public MedicineInOrderService() {
		this(MedicineInOrder.class);
	}

}
