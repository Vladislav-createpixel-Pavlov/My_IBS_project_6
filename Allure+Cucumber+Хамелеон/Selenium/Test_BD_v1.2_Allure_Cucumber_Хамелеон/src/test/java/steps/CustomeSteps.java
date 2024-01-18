package steps;

import io.cucumber.java.ru.Когда;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ibsqa.chameleon.steps.AbstractSteps;

public class CustomeSteps extends AbstractSteps {
    @Autowired
    private CustomDebugSteps customDebugSteps; // здесь подключаем бин с тестовыми шагами

    @Когда("^debug \"([^\"]*)\"")
    public void stepDebug(String param) {
        flow(() ->
                // Здесь происходит вызов кастомного тестового шага, в котором и реализуется основная логика
                customDebugSteps.stepDebug(param)
        );
    }

}
