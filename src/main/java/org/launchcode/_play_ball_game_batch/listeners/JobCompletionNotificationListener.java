package org.launchcode._play_ball_game_batch.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results");

//            List<String> gameIds = jdbcTemplate.queryForList(
//                    "SELECT id FROM game",
//                    String.class);
//            for (String gameId : gameIds) {
//                log.info("Found game - " + gameId);
//            }

            int gameCount = jdbcTemplate.queryForObject(
                    "SELECT COUNT(*) FROM game_new WHERE year = 1919 and game_type='R'",
                    Integer.class);
            log.info("1919 Game_New count - " + gameCount);


//            int gamePlayercount = jdbcTemplate.queryForObject(
//                    "SELECT COUNT(*) FROM game_player WHERE game_id like '%1919%'",
//                    Integer.class);
//            log.info("1919 Game_Player count - " + gamePlayercount);


        }
    }
}

