package steps;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.ibsqa.chameleon.steps.AbstractSteps;
import ru.ibsqa.chameleon.steps.TestStep;

@Component
@Slf4j
public class CustomDebugSteps extends AbstractSteps {

    @TestStep("debug \"${param}\"")
    public void stepDebug(String param) {
        log.debug("stepDebug: "+param);
    }

}
