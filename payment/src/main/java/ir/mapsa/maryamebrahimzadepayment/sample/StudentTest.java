package ir.mapsa.maryamebrahimzadepayment.sample;

import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@TestPropertySource(locations = "classpath:application-local.properties")
public class StudentTest {
}
