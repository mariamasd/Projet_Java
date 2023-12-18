package com.example.notomatic.com.example.notomatic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
 import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;
    

@SpringBootTest
class NotomaticApplicationTests {

	@Test
	void contextLoads() {
	}

   
    @RestController
    @RequestMapping("/api/test")
    public class TestController {
    
        @GetMapping
        public String getTestData() {
            return "Hello from the backend!";
        }
    }
}
