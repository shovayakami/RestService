package np.pangait.restservice.controller;

import np.pangait.restservice.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //@RequestMapping(method= RequestMethod.GET, path = "/greeting")
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "n", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template,name));
    }
}
