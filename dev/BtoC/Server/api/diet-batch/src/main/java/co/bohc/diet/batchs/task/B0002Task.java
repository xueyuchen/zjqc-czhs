package co.bohc.diet.batchs.task;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import co.bohc.diet.domain.service.accessory.AccessoryService;

/**
 * サービス完了
 * 
 * @author unicorn(haiyin-ma) 2015-01-13
 */
@Component
public class B0002Task implements Runnable {

    @Inject
    private AccessoryService accessoryService;
    
    @Override
    public void run() {
        System.out.println("begin task");
        accessoryService.savePicture();
        System.out.println("end task");
    }

}
