package com.cg.payroll.test;

public class PayrollServicesTest {
   /* private static PayrollServices payrollServices;

    @BeforeClass
    public static void setUpTestEnv() {
        payrollServices = new PayrollServicesImpl();
    }

    @Before
    public void setUpTestData() {
        Associate associate1 = new Associate(101, 5000, "Anvesh", "Ragava", "ECE", "Analyst", "PAN7676TT",
                "ragava@gmail.com", new Salary(50000, 1000, 1000), new BankDetails(101010, "Citi bank", "IFSC1544"));
        Associate associate2 = new Associate(102, 4000, "Moreshwar", "T", "HCE", "Associate", "PAN7446TT",
                "moresh@gmail.com", new Salary(50000, 2000, 2000), new BankDetails(104440, "HDFC bank", "IFSC1447"));
        PayrollUtil.associates.put(associate1.getAssociateId(), associate1);
        PayrollUtil.associates.put(associate2.getAssociateId(), associate2);
        PayrollUtil.ASSOCIATE_ID_COUNTER = 103;
    }

    @Test
    public void testAcceptAssociateDetailsForValidData() {
        int expectedAssociateId=104;
        int actualAssociateId=payrollServices.acceptAssociate(4000, "Moreshwar", "T", "HCE", "Associate", "PAN7446TT",
                "moresh@gmail.com",50000, 2000, 2000,104440,"HDFC bank", "IFSC1447");
        Assert.assertEquals(expectedAssociateId, actualAssociateId);
    }
    
    @Test
    public void testCalculateNetSalaryForValidData() throws AssociateDetailsNotFoundException {
        int expectedAns=86808;
        int actualAns=payrollServices.calculateNetSalary(101);
        Assert.assertEquals(expectedAns, actualAns);
    }
    

    @Test(expected=AssociateDetailsNotFoundException.class)
    public void testCalculateNetSalaryForInvalidData() throws AssociateDetailsNotFoundException {
        payrollServices.calculateNetSalary(74);
    }

    @Test
    public void testGetAssociateDetailsForValidData() throws AssociateDetailsNotFoundException {
        Associate expectedAssociate=new Associate(101, 5000, "Anvesh", "Ragava", "ECE", "Analyst", "PAN7676TT",
                "ragava@gmail.com", new Salary(50000, 1000, 1000), new BankDetails(101010, "Citi bank", "IFSC1544"));
        Associate actualAssociate=payrollServices.getAssociateDetails(101);
        Assert.assertEquals(expectedAssociate, actualAssociate);
    }
    
    @Test(expected=AssociateDetailsNotFoundException.class)
    public void testGetAssociateDetailsForInvalidData() throws AssociateDetailsNotFoundException {
        payrollServices.getAssociateDetails(74);
    }
    
    @After
    public void tearDownTestData() {
        PayrollUtil.ASSOCIATE_ID_COUNTER = 100;
        PayrollUtil.associates.clear();
    }

    @AfterClass
    public static void tearDownTestEnv() {
        payrollServices = null;
    }*/
}