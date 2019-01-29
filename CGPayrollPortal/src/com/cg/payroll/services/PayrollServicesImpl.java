package com.cg.payroll.services;

import java.util.List;

import com.cg.payroll.beans.*;
import com.cg.payroll.daoservices.AssociateDAO;
import com.cg.payroll.daoservices.AssociateDAOImpl;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;

public class PayrollServicesImpl implements PayrollServices {

	private AssociateDAO associateDAO;
	
	public PayrollServicesImpl() {
		associateDAO=new AssociateDAOImpl();
	}

	//obj for easymock - dep injection
	public PayrollServicesImpl(AssociateDAO associateDAO) {
		super();
		this.associateDAO = associateDAO;
	}

	@Override
	public int acceptAssociate(Associate associate) {
		associate = associateDAO.save(associate);				
		return associate.getAssociateId();
	}

	@Override
	public int calculateNetSalary(int associateId) throws AssociateDetailsNotFoundException {
		Associate associate = this.getAssociateDetails(associateId);
		if (associate == null)
			throw new AssociateDetailsNotFoundException("Id not found");
		float annualSalary, taxableAmt=0,annualTax = 0, netSalary = 0,investments;

		//allownces
		associate.getSalary().setHra((associate.getSalary().getBasicSalary() * 40) / 100);
		associate.getSalary().setConveyenceAllowance((associate.getSalary().getBasicSalary() * 30) / 100);
		associate.getSalary().setOtherAllowance((associate.getSalary().getBasicSalary() * 20) / 100);
		associate.getSalary().setPersonalAllowance((associate.getSalary().getBasicSalary() * 20) / 100);
		//gross n ann
		associate.getSalary().setGrossSalary(associate.getSalary().getBasicSalary() + associate.getSalary().getHra() + associate.getSalary().getConveyenceAllowance() + associate.getSalary().getOtherAllowance()
				+ associate.getSalary().getPersonalAllowance());
		annualSalary = associate.getSalary().getGrossSalary() * 12;
		//tax cal pure gross(sal+a) aftr sub invs
		investments=associate.getYearlyInvestmentUnder80C() +associate.getSalary().getEpf() * 12
				+ associate.getSalary().getCompanyPf() * 12;
		if(investments>180000)
			taxableAmt = annualSalary +(investments-180000);
		else
			taxableAmt = annualSalary -investments;
		if (taxableAmt < 250000)
			annualTax = 0;
		if (taxableAmt > 250000 && taxableAmt <= 500000)
			annualTax = annualTax + ((taxableAmt - 250000) * 10) / 100;
		if (taxableAmt > 500000 && taxableAmt <= 1000000)
			annualTax = 25000 + ((taxableAmt - 500000) * 20) / 100;
		if (taxableAmt > 1000000)
			annualTax = 125000 + ((taxableAmt - 1000000) * 30) / 100;
		associate.getSalary().setMonthlyTax((int) (annualTax / 12));
		associate.getSalary().setNetSalary((int) (associate.getSalary().getGrossSalary() - associate.getSalary().getEpf() - associate.getSalary().getCompanyPf() - associate.getSalary().getMonthlyTax()));
		associateDAO.update(associate);
		return associate.getSalary().getNetSalary();
	}

	@Override
	public Associate getAssociateDetails(int associateId) throws AssociateDetailsNotFoundException {
		Associate associate = associateDAO.findOne(associateId);
		if (associate == null)
			throw new AssociateDetailsNotFoundException("Associate Details Not Found for " + associateId);
		return associate;
	}

	@Override
	public List<Associate> getAllAssociateDetails() {
		return associateDAO.findAll();
	}
}