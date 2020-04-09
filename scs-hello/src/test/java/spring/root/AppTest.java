package spring.root;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xwzj.springboot.Application;


@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(classes = Application.class,initializers = ConfigFileApplicationContextInitializer.class)
public class AppTest {
   
}
