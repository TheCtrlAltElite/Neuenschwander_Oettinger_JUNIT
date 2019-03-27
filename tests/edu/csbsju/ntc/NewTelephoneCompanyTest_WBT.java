package edu.csbsju.ntc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NewTelephoneCompanyTest_WBT {
	 private NewTelephoneCompany ntc;
	  
	  @Before
	  public void setUp() throws Exception {
	    ntc = new NewTelephoneCompany();
	  }

	@Test(expected=UnsupportedOperationException.class)
	  public void testComputeCharge_InvalidStartTime() {
	    ntc.setStartTime(-5);
	    ntc.setDuration(-5);
	    ntc.computeCharge();
	  }
	
	  @Test(expected=UnsupportedOperationException.class)
	  public void testComputeCharge_InvalidDuration() {
	    ntc.setStartTime(1800);
	    ntc.setDuration(0);
	    ntc.computeCharge();
	  } 
	  
	  @Test
	  public void testComputeCharge_DiscountedStartTimeAndDuration() {
	    ntc.setStartTime(500);
	    ntc.setDuration(100);
	    double expResult = 1768.0;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
	    ntc.setStartTime(1959);
	    ntc.setDuration(61);
	    expResult = 1078.48;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge()); 
	  }
	  
	  @Test
	  public void testComputeCharge_DiscountedStartTime() {
	    ntc.setStartTime(0);
	    ntc.setDuration(60);
	    double expResult = 1248.0;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
	    ntc.setStartTime(1800);
	    ntc.setDuration(10);
	    expResult = 208.0;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());  
	  }
	  
	  @Test
	  public void testComputeCharge_DurationDiscount() {
	    ntc.setStartTime(800);
	    ntc.setDuration(65);
	    double expResult = 2298.40  ;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
	  } 
	  
	  @Test
	  public void testComputeCharge_NoDiscounts() {
	    ntc.setStartTime(1000);
	    ntc.setDuration(40);
	    double expResult = 1664.00  ;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
	    ntc.setStartTime(800);
	    ntc.setDuration(1);
	    expResult = 41.60 ;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge()); 
	    ntc.setStartTime(801);
	    ntc.setDuration(59);
	    expResult = 2454.40 ;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge()); 
	    ntc.setStartTime(1759);
	    ntc.setDuration(60);
	    expResult = 2496.00 ;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());   
	  }
}
