import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.vahan.ApiApplication;
import com.vahan.config.AppConfig;
import com.vahan.controller.UserEndpoints;
import com.vahan.domain.User;
import com.vahan.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

/**
 * Created by TCE\vahany on 3/31/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = ApiApplication.class)
//@ContextConfiguration(classes = {AppConfig.class})
//@AutoConfigureMockMvc
public class UserTest {

  /*  @Autowired
    private UserEndpoints userEndpoints;

    @Autowired
    private MockMvc mockMvc;*/

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    /*@Test
    public void contexLoads() throws Exception {
        assertThat(userEndpoints).isNotNull();
    }*/

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        String path = String.format("http://localhost:%d/posts/hello", port);
        String result = restTemplate.getForObject(path, String.class);
        assertThat(result).contains("Hello user!");
    }








}
