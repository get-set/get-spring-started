package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

// @RestController 是 @Controller 和 @RequestBody 的组合体。
@RestController
public class GreetingController {

    private final String template = "Hello, %s";
    private final AtomicLong atomicCounter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        // 默认使用 MappingJackson2HttpMessageConverter 将返回的对象转化为 JSON 格式。
        return new Greeting(atomicCounter.incrementAndGet(),
                String.format(template, name));
    }
}
