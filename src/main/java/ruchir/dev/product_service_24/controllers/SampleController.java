package ruchir.dev.product_service_24.controllers;


import org.springframework.web.bind.annotation.*;

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

    //http://localhost:8080/say/greet
    @PostMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Greetings, " + name + "!";
    }

    // http://localhost:8080/say/update/{id}
    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestParam String newValue) {
        // Logic to update based on id and newValue
        return "Updated value for id " + id + " to " + newValue;
    }

    //http://localhost:8080/say/delete/{id}
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        // Logic to delete based on id
        return "Deleted item with id " + id;
    }


}
