package mybatis;


import com.ittzg.mybatis.entity.UserEntity;
import com.ittzg.mybatis.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisSpringTest {
	
    @Autowired
    private UserMapper userMapper;

	@Test
	public void testQuery(){
        UserEntity userEntity= userMapper.findById(1L);

        System.out.println(userEntity);

	}


}
