package restprofile;

import org.springframework.beans.factory.annotation.Autowired;

public class DenemeService {
    @Autowired
    Greeting greeting;
    public void deneme(){

        System.out.println("deneme");
        greeting.setAd("a");
        greeting.setSoyad("b");
    }
}
