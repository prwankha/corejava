package com.cg.payroll.services;

import java.util.List;

import com.cg.payroll.beans.*;
import com.cg.payroll.exceptions.*;

public interface PayrollServices {

	int acceptAssociate(Associate associate);

	int calculateNetSalary(int associateId) throws AssociateDetailsNotFoundException;

	Associate getAssociateDetails(int associateId) throws AssociateDetailsNotFoundException;

	List<Associate> getAllAssociateDetails();
}