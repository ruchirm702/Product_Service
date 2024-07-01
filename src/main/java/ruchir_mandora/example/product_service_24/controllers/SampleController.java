package ruchir_mandora.example.product_service_24.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This class will be hosting a set Http API's
@RestController
@RequestMapping("/say")


public class SampleController {

    //http://localhost:8080/say/hello
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello Everyone !";
    }

    // http://localhost:8080/say/bye
    @GetMapping("/bye")
    public String sayBye(){
        return "Bye Everyone !";
    }


    // http://localhost:8080/say/hey/ruchir
    @GetMapping("/hey/{name}")
    public String sayHey(@PathVariable("name") String name){
        return "Hey " + name ;
    }

}
