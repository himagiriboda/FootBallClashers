package de.footballclashers.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:app-context.xml")
public class PullMatchesTest {

	private static Logger logger = LoggerFactory.getLogger(PullMatchesTest.class);
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job pullMatchesJob;
	
	@Test
	public void pullMatchesData() throws Exception{
		JobParametersBuilder jpBuilder = new JobParametersBuilder();
		JobExecution jobExecution = null;
		try {
			jpBuilder.addLong("time", System.currentTimeMillis());
			jobExecution = jobLauncher.run(pullMatchesJob,
					jpBuilder.toJobParameters());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("pullMatchesJob failed");
		}
		String status = jobExecution.getStatus().toString();
		assertNotNull("status not null", status);
	}
}
