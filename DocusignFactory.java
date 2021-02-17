package Examen.pageObjects;

import Examen.prueba_netflix;
import org.testng.annotations.Factory;

public class DocusignFactory {

    @Factory
    public Object[] factoryTest(){
        return new Object[]{
                new prueba_netflix(),
                new prueba_netflix(),



        };
    }

}
