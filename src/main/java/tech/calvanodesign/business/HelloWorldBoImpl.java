package tech.calvanodesign.business;

import javax.inject.Named;

/**
 * HelloWorld Business Object Implementation
 * @author Eric
 *
 */
@Named("helloWorldBo")
public class HelloWorldBoImpl implements HelloWorldBo {

	/**
	 * Tests the spring and jsf implementation
	 */
	@Override
	public void springTest(String name) {
		// TODO Auto-generated method stub
		System.out.println("HelloWorldBoImpl:: springTest : " + name);
	}
}