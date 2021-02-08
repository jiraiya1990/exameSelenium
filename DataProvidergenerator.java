package Examen.pageObjects;

import org.testng.annotations.DataProvider;

public class DataProvidergenerator {

    @DataProvider(name = "emails")
    public Object [][] crearEmail(){
        return new Object[][]{
                {"juan@test.com"},
                {"Maria@testing.com"},
                {"Pepitp@hotmail.com"}
        };
    }



}
