package ar.com.ada.sb.api.di.component;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component("utilsComponent")
public class UtilsComponent {

    public Long generateId(){

        return new Random().nextLong() % (100 - 10) + 10;
    }


}
