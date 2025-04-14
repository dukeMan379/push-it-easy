package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.BaseClass;



public class Hooks {
   @Before(order=1)
    public void driverInit() {
        try{
            BaseClass.setDriver();

        }catch(Exception e){
            System.err.println("Error initializing driver: " + e.getMessage());
            e.printStackTrace();  // Prints full stack trace for debugging
        }
    }

    @After
    public void tearDown(){
        BaseClass.getDriver().quit();
    }


}
