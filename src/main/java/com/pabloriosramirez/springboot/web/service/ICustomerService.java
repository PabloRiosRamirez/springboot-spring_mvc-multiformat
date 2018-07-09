/**
 * @author Pablo Ríos Ramírez
 * @Created 28-06-2018 2:43:46
 * @web http://www.pabloriosramirez.com
 *
 */

package com.pabloriosramirez.springboot.web.service;
 
import com.pabloriosramirez.springboot.web.model.Customer;
import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
}
