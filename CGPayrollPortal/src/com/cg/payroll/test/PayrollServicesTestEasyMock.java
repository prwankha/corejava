package com.cg.payroll.test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.AssociateDAO;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;

public class PayrollServicesTestEasyMock {

	private static PayrollServices payrollServices;
	private static AssociateDAO mockAssociateDAO;

	@BeforeClass
	public static void setTestEnv() {
		mockAssociateDAO = EasyMock.mock(AssociateDAO.class);
		payrollServices = new PayrollServicesImpl(mockAssociateDAO);
	}

	@Before
	public void setUpTestMockData() {
		Associate associate1 = new Associate(101, 5000, "Anvesh", "Ragava", "ECE", "Analyst", "PAN7676TT",
				"ragava@gmail.com", new Salary(50000, 1000, 1000), new BankDetails(101010, "Citi bank", "IFSC1544"));
		Associate associate2 = new Associate(102, 4000, "Moreshwar", "T", "HCE", "Associate", "PAN7446TT",
				"moresh@gmail.com", new Salary(50000, 2000, 2000), new BankDetails(104440, "HDFC bank", "IFSC1447"));
		
		ArrayList<Associate> associateList=new ArrayList<>();
		associateList.add(associate1);
		associateList.add(associate2);
		
		EasyMock.expect(mockAssociateDAO.findOne(101)).andReturn(associate1);
		EasyMock.expect(mockAssociateDAO.findOne(102)).andReturn(associate2);
		EasyMock.expect(mockAssociateDAO.findOne(1234)).andReturn(null);
		
		EasyMock.expect(mockAssociateDAO.save(associate1)).andReturn(associate1);
		EasyMock.expect(mockAssociateDAO.findAll()).andReturn(associateList);
		EasyMock.replay(mockAssociateDAO);
	}
	
	/*@Test
    public void testAcceptAssociateDetailsForValidData() {
        int expectedAssociateId=104;
        int actualAssociateId=payrollServices.acceptAssociate(4000, "Abhi", "S", "HCE", "Associate", "PAN3252DS",
				"as@gmail.com",50000, 2000, 2000,104440, "Kotak", "KKBK3422");
        EasyMock.verify(mockAssociateDAO.save(new Associate(4000, "Abhi", "S", "HCE", "Associate", "PAN3252DS",
				"as@gmail.com", new Salary(50000, 2000, 2000), new BankDetails(104440, "Kotak", "KKBK3422"))));
        assertEquals(expectedAssociateId, actualAssociateId);
    }*/

	@Test(expected=AssociateDetailsNotFoundException.class)
	public void testGetAssociateDetailsForInvalidAssociateId()throws AssociateDetailsNotFoundException{
		payrollServices.getAssociateDetails(1234);
		EasyMock.verify(mockAssociateDAO.findOne(1234));
	}
	
	@Test(expected=AssociateDetailsNotFoundException.class)
	public void testGetAssociateDetailsForValidAssociateId() throws AssociateDetailsNotFoundException {
		Associate expectedAssociate=new Associate(101, 5000, "Anvesh", "Ragava", "ECE", "Analyst", "PAN7676TT",
				"ragava@gmail.com", new Salary(50000, 1000, 1000), new BankDetails(101010, "Citi bank", "IFSC1544"));
		Associate actualAssociate=payrollServices.getAssociateDetails(101);
		EasyMock.verify(mockAssociateDAO.findOne(101));
		assertEquals(expectedAssociate, actualAssociate);
	}	
	///////////////////////////////////////
	@After
	public void tearDownTestMockData() {
		EasyMock.resetToDefault(mockAssociateDAO);
	}
	
	@AfterClass
	public static void tearDownTestEnv() {
		mockAssociateDAO = null;
		payrollServices = null;
	} 
}
