package hcm.compensation;

import hcm.seldriver.SeleniumDriver;

public class App
{
    public static void main( String[] args ) throws Exception{
    	
    	
    	SeleniumDriver sel = new SeleniumDriver();
    	System.out.println("Initializing drivers...");
    	sel.initializeDriver("http://selenium-hub:4444/wd/hub", "firefox");
    	System.out.println("Running Test in FireFox");
    	System.out.println("Drivers Initialized.");
    	//testaRea
    	sel.testArea();
    	sel.dispose();
    }
}