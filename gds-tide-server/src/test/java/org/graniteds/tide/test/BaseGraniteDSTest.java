/**
 * 
 */
package org.graniteds.tide.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;

/**
 * @author Emmanuel Nollase - emanux
 * @created 2009 12 2 - 10:29:09
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")

public class BaseGraniteDSTest extends TestCase
{

}
