package de.footballclashers.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class PullMatchesTasklet implements Tasklet {

	private static Logger logger = LoggerFactory.getLogger(PullMatchesTasklet.class);
	
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Callin the pull matches Tasklet");
		return null;
	}

}
