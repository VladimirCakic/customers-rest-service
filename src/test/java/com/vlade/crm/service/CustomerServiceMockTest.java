
package com.vlade.crm.service;

import com.vlade.crm.dao.CustomerDAO;
import com.vlade.crm.entity.Customer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Vladimir Cakic
 */
public class CustomerServiceMockTest {
    
    public CustomerServiceMockTest() {
    }
    
    static final int CUSTOMER_ID = 1;
    final Customer customer = new Customer("Nevenka", "Djordjevic", "nena@mail.com");
    
    //Creates mock instance of the field it annotates
    @Mock 
    private CustomerDAO mockDao;
    
    //Injects mock object in the object we want to test
    @InjectMocks
    private CustomerServiceImpl service;
    
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test of getCustomer method, of class CustomerServiceImpl, with the existing id.
     */
    @Test
    public void testGetCustomerPositive() {
        System.out.println("getCustomerPositive");
        Customer newCustomer = customer;
        newCustomer.setId(CUSTOMER_ID);
        when(mockDao.getCustomer(any(Integer.class))).thenReturn(newCustomer);
        Customer result = service.getCustomer(CUSTOMER_ID);
        assertNotNull(result);
        assertEquals(newCustomer.getId(), result.getId());
    }
     
}
