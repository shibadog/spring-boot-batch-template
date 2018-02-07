package com.hainet.profile.driven;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("foo")
public class ProfileDrivenApplicationTest {

    @Test
    public void contextLoads() {
    }
}
