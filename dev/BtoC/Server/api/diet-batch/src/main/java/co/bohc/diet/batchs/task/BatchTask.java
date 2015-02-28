package co.bohc.diet.batchs.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BatchTask implements Runnable {
    
    protected static final Logger L = LoggerFactory.getLogger("batch");
    
    protected static final String D_PATH_FORMAT = "META-INF/velocity/%s.vm";
    
    private boolean activated = true;
    
    public boolean isActivted() {
        return activated;
    }

    public void Activate() {
        L.info("B0001 Task Is Activated");
        this.activated = true;
    }

    public void InActivate() {
        L.info("B0001 Task Is UnActivated");
        this.activated = false;
    }
    
    @Override
    public void run() {
        if (isActivted()) {
            L.info("===START [{}]", getClass().getSimpleName());
            execute();
            L.info("===END");
        }
    }
    
    protected abstract void execute();

}
