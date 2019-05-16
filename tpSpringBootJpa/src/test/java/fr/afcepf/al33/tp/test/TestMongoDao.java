package fr.afcepf.al33.tp.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al33.mongo.collections.Info;
import fr.afcepf.al33.tp.MySpringBootApplication;
import fr.afcepf.al33.tp.mongo.dao.DaoInfo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {MySpringBootApplication.class})
public class TestMongoDao {
	
	
		
		private static Logger logger = LoggerFactory.getLogger(TestMongoDao.class);
		
		
		
		@Autowired //comme @Inject
		private DaoInfo daoInfo;
		
		@Test
		public void testCrudInfo() {
			
			Info info1 = new Info(1L,"info1");
			daoInfo.save(info1);
			
			List<Info> listeInfos =(List<Info>) daoInfo.findAll();
			Assert.assertNotNull(listeInfos);
			logger.info("***** listeInfos="+listeInfos);
			
		}

}
