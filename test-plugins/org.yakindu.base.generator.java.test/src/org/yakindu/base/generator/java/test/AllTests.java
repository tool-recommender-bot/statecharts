package org.yakindu.base.generator.java.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	MethodTest.class,
	ClassTest.class,
	InterfaceTest.class
})
public class AllTests {

}
