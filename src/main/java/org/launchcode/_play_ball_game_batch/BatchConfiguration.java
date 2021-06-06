package org.launchcode._play_ball_game_batch;

import org.launchcode._play_ball_game_batch.models.Game;
import org.launchcode._play_ball_game_batch.fieldSetMappers.GameFieldSetMapper;
import org.launchcode._play_ball_game_batch.listeners.JobCompletionNotificationListener;
//import org.launchcode.play_ball_game_player_batch.fieldSetMappers.GameFieldSetMapper;
//import org.launchcode.play_ball_game_player_batch.listeners.JobCompletionNotificationListener;
//import org.launchcode.play_ball_game_player_batch.models.Game;
//import org.launchcode.play_ball_game_player_batch.skipPolicies.InsertIgnoreVerificationSkipper;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;

import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
@EnableBatchProcessing              // adds many critical beans that support jobs
public class BatchConfiguration {

//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/play_ball");
//        dataSource.setUsername("java_techjobs_202011");
//        dataSource.setPassword("CodingEvents$99");
//        return dataSource;
//    }


    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    // create an ItemReader that reads in a flat file
    // https://www.programcreek.com/java-api-examples/?api=org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder
    // https://docs.spring.io/spring-batch/docs/current/reference/html/readersAndWriters.html#flatFiles
    public FlatFileItemReader<Game> reader() {
        DefaultLineMapper<Game> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(new DelimitedLineTokenizer(","));
        lineMapper.setFieldSetMapper(new GameFieldSetMapper());

        return new FlatFileItemReaderBuilder<Game>()
                .name("gameItemReader")
//                .resource(new ClassPathResource("/1919/WorldSeries/1919PostSeasonBGame.txt"))
                .resource(new PathResource("C:\\Users\\msunk\\Documents\\CoderGirlJava202011\\play_ball\\resources\\1982\\Series\\bgameEvent.txt"))
                .lineMapper(lineMapper)
                .build();
    }

//    private static final int STARTING_PLAYER = 0;
//    private static final int SUBSTITUTE_PLAYER = 1;
//    private static final int VISITING_PLAYER = 0;
//    private static final int HOME_PLAYER = 1;

    @Bean
    public JdbcBatchItemWriter<Game> writeGame(DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<Game>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())

                .sql("INSERT INTO game_detail (id, date, game_num, day_of_week, start_time, dh_used_flag, day_night, visiting_team, home_team, ballpark_id, " +
                       "player_id_visit_starting_pitcher, player_position_visit_starting_pitcher, " +
                       "player_id_home_starting_pitcher, player_position_home_starting_pitcher, " +
                       "umpire_id_home_plate, umpire_id_first_base, umpire_id_second_base, umpire_id_third_base, umpire_id_left_field, umpire_id_right_field, " +
                       "game_attendance, ps_scorer, translator, inputter, input_time, edit_time, how_scored, " +
                       "pitches_entered, game_temperature, game_wind_direction, game_wind_speed, game_field_condition, game_precipitation, game_sky, game_time, " +
                       "number_of_innings, visit_final_score, home_final_score, visit_hits, home_hits, visit_errors, home_errors, visit_left_on_base, home_left_on_base, " +
                       "player_id_winning_pitcher, player_id_losing_pitcher, player_id_save_for, player_id_winning_rbi, player_id_visit_final_pitcher, player_id_home_final_pitcher, " +
                       "year, game_type) VALUES " +
                        "(:id, :date, :gameNum, :dayOfWeek, :startTime, :dhUsedFlag, :dayNight, :visitingTeam, :homeTeam, :ballparkId, " +
                        " :playerIdVisitStartingPitcher, :playerPositionVisitStartingPitcher, " +
                        " :playerIdHomeStartingPitcher, :playerPositionHomeStartingPitcher, " +
                        " :umpireIdHomePlate, :umpireIdFirstBase, :umpireIdSecondBase, :umpireIdThirdBase, :umpireIdLeftField, :umpireIdRightField, " +
                        " :gameAttendance, :psScorer, :translator, :inputter, :inputTime, :editTime, :howScored, " +
                        " :pitchesEntered, :gameTemperature, :gameWindDirection, :gameWindSpeed, :gameFieldCondition, :gamePrecipitation, :gameSky, :gameTime, " +
                        " :numberOfInnings, :visitFinalScore, :homeFinalScore, :visitHits, :homeHits, :visitErrors, :homeErrors, :visitLeftOnBase, :homeLeftOnBase, " +
                        " :playerIdWinningPitcher, :playerIdLosingPitcher, :playerIdSaveFor, :playerIdWinningRbi, :playerIdVisitFinalPitcher, :playerIdHomeFinalPitcher, " +
                        " 1982, 'S'); ")

                .dataSource(dataSource)
                .build();
    }

//    @Bean
//    public JdbcBatchItemWriter<Game> writeGameVisitingPlayer1(DataSource dataSource){
//        return new JdbcBatchItemWriterBuilder<Game>()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql( "INSERT INTO game_player (game_id, player_id, start_sub, visit_home, batting_order, field_position, game_num, player_batting_order, player_field_position, player_start_sub, year, day_night, game_type, home_team_league, player_bats, player_throws, player_visit_home, visiting_team_league) VALUES " +
//                        "(:id, :playerIdVisit1, " + STARTING_PLAYER + ", " + VISITING_PLAYER + ", 1, :playerPositionVisit1, 0, 0, 0, 0, 0, \"\", \"\", \"\", \"\", \"\", 0, \"\"); ")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Game> writeGameVisitingPlayer2(DataSource dataSource){
//        return new JdbcBatchItemWriterBuilder<Game>()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql( "INSERT INTO game_player (game_id, player_id, start_sub, visit_home, batting_order, field_position, game_num, player_batting_order, player_field_position, player_start_sub, year, day_night, game_type, home_team_league, player_bats, player_throws, player_visit_home, visiting_team_league) VALUES " +
//                        "(:id, :playerIdVisit2, " + STARTING_PLAYER + ", " + VISITING_PLAYER + ", 2, :playerPositionVisit2, 0, 0, 0, 0, 0, \"\", \"\", \"\", \"\", \"\", 0, \"\"); ")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Game> writeGameVisitingPlayer3(DataSource dataSource){
//        return new JdbcBatchItemWriterBuilder<Game>()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql( "INSERT INTO game_player (game_id, player_id, start_sub, visit_home, batting_order, field_position, game_num, player_batting_order, player_field_position, player_start_sub, year, day_night, game_type, home_team_league, player_bats, player_throws, player_visit_home, visiting_team_league) VALUES " +
//                        "(:id, :playerIdVisit3, " + STARTING_PLAYER + ", " + VISITING_PLAYER + ", 3, :playerPositionVisit3, 0, 0, 0, 0, 0, \"\", \"\", \"\", \"\", \"\", 0, \"\"); ")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Game> writeGameVisitingPlayer4(DataSource dataSource){
//        return new JdbcBatchItemWriterBuilder<Game>()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql( "INSERT INTO game_player (game_id, player_id, start_sub, visit_home, batting_order, field_position, game_num, player_batting_order, player_field_position, player_start_sub, year, day_night, game_type, home_team_league, player_bats, player_throws, player_visit_home, visiting_team_league) VALUES " +
//                        "(:id, :playerIdVisit4, " + STARTING_PLAYER + ", " + VISITING_PLAYER + ", 4, :playerPositionVisit4, 0, 0, 0, 0, 0, \"\", \"\", \"\", \"\", \"\", 0, \"\"); ")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Game> writeGameVisitingPlayer5(DataSource dataSource){
//        return new JdbcBatchItemWriterBuilder<Game>()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql( "INSERT INTO game_player (game_id, player_id, start_sub, visit_home, batting_order, field_position, game_num, player_batting_order, player_field_position, player_start_sub, year, day_night, game_type, home_team_league, player_bats, player_throws, player_visit_home, visiting_team_league) VALUES " +
//                        "(:id, :playerIdVisit5, " + STARTING_PLAYER + ", " + VISITING_PLAYER + ", 5, :playerPositionVisit5, 0, 0, 0, 0, 0, \"\", \"\", \"\", \"\", \"\", 0, \"\"); ")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Game> writeGameVisitingPlayer6(DataSource dataSource){
//        return new JdbcBatchItemWriterBuilder<Game>()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql( "INSERT INTO game_player (game_id, player_id, start_sub, visit_home, batting_order, field_position, game_num, player_batting_order, player_field_position, player_start_sub, year, day_night, game_type, home_team_league, player_bats, player_throws, player_visit_home, visiting_team_league) VALUES " +
//                        "(:id, :playerIdVisit6, " + STARTING_PLAYER + ", " + VISITING_PLAYER + ", 6, :playerPositionVisit6, 0, 0, 0, 0, 0, \"\", \"\", \"\", \"\", \"\", 0, \"\"); ")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Game> writeGameVisitingPlayer7(DataSource dataSource){
//        return new JdbcBatchItemWriterBuilder<Game>()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql( "INSERT INTO game_player (game_id, player_id, start_sub, visit_home, batting_order, field_position, game_num, player_batting_order, player_field_position, player_start_sub, year, day_night, game_type, home_team_league, player_bats, player_throws, player_visit_home, visiting_team_league) VALUES " +
//                        "(:id, :playerIdVisit7, " + STARTING_PLAYER + ", " + VISITING_PLAYER + ", 7, :playerPositionVisit7, 0, 0, 0, 0, 0, \"\", \"\", \"\", \"\", \"\", 0, \"\"); ")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Game> writeGameVisitingPlayer8(DataSource dataSource){
//        return new JdbcBatchItemWriterBuilder<Game>()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql( "INSERT INTO game_player (game_id, player_id, start_sub, visit_home, batting_order, field_position, game_num, player_batting_order, player_field_position, player_start_sub, year, day_night, game_type, home_team_league, player_bats, player_throws, player_visit_home, visiting_team_league) VALUES " +
//                        "(:id, :playerIdVisit8, " + STARTING_PLAYER + ", " + VISITING_PLAYER + ", 8, :playerPositionVisit8, 0, 0, 0, 0, 0, \"\", \"\", \"\", \"\", \"\", 0, \"\"); ")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Game> writeGameVisitingPlayer9(DataSource dataSource){
//        return new JdbcBatchItemWriterBuilder<Game>()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql( "INSERT INTO game_player (game_id, player_id, start_sub, visit_home, batting_order, field_position, game_num, player_batting_order, player_field_position, player_start_sub, year, day_night, game_type, home_team_league, player_bats, player_throws, player_visit_home, visiting_team_league) VALUES " +
//                        "(:id, :playerIdVisit9, " + STARTING_PLAYER + ", " + VISITING_PLAYER + ", 9, :playerPositionVisit9, 0, 0, 0, 0, 0, \"\", \"\", \"\", \"\", \"\", 0, \"\"); ")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Game> writeGameVisitingPlayer10(DataSource dataSource){
//        return new JdbcBatchItemWriterBuilder<Game>()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql( "INSERT INTO game_player (game_id, player_id, start_sub, visit_home, batting_order, field_position, game_num, player_batting_order, player_field_position, player_start_sub, year, day_night, game_type, home_team_league, player_bats, player_throws, player_visit_home, visiting_team_league) VALUES " +
//                        "(:id, :playerIdVisit10, " + STARTING_PLAYER + ", " + VISITING_PLAYER + ", 10, :playerPositionVisit10, 0, 0, 0, 0, 0, \"\", \"\", \"\", \"\", \"\", 0, \"\"); ")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Game> writeGameHomePlayer1(DataSource dataSource){
//        return new JdbcBatchItemWriterBuilder<Game>()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql( "INSERT INTO game_player (game_id, player_id, start_sub, visit_home, batting_order, field_position, game_num, player_batting_order, player_field_position, player_start_sub, year, day_night, game_type, home_team_league, player_bats, player_throws, player_visit_home, visiting_team_league) VALUES " +
//                        "(:id, :playerIdHome1, " + STARTING_PLAYER + ", " + HOME_PLAYER + ", 1, :playerPositionHome1, 0, 0, 0, 0, 0, \"\", \"\", \"\", \"\", \"\", 0, \"\"); ")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Game> writeGameHomePlayer2(DataSource dataSource){
//        return new JdbcBatchItemWriterBuilder<Game>()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql( "INSERT INTO game_player (game_id, player_id, start_sub, visit_home, batting_order, field_position, game_num, player_batting_order, player_field_position, player_start_sub, year, day_night, game_type, home_team_league, player_bats, player_throws, player_visit_home, visiting_team_league) VALUES " +
//                        "(:id, :playerIdHome2, " + STARTING_PLAYER + ", " + HOME_PLAYER + ", 2, :playerPositionHome2, 0, 0, 0, 0, 0, \"\", \"\", \"\", \"\", \"\", 0, \"\"); ")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Game> writeGameHomePlayer3(DataSource dataSource){
//        return new JdbcBatchItemWriterBuilder<Game>()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql( "INSERT INTO game_player (game_id, player_id, start_sub, visit_home, batting_order, field_position, game_num, player_batting_order, player_field_position, player_start_sub, year, day_night, game_type, home_team_league, player_bats, player_throws, player_visit_home, visiting_team_league) VALUES " +
//                        "(:id, :playerIdHome3, " + STARTING_PLAYER + ", " + HOME_PLAYER + ", 3, :playerPositionHome3, 0, 0, 0, 0, 0, \"\", \"\", \"\", \"\", \"\", 0, \"\"); ")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Game> writeGameHomePlayer4(DataSource dataSource){
//        return new JdbcBatchItemWriterBuilder<Game>()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql( "INSERT INTO game_player (game_id, player_id, start_sub, visit_home, batting_order, field_position, game_num, player_batting_order, player_field_position, player_start_sub, year, day_night, game_type, home_team_league, player_bats, player_throws, player_visit_home, visiting_team_league) VALUES " +
//                        "(:id, :playerIdHome4, " + STARTING_PLAYER + ", " + HOME_PLAYER + ", 4, :playerPositionHome4, 0, 0, 0, 0, 0, \"\", \"\", \"\", \"\", \"\", 0, \"\"); ")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Game> writeGameHomePlayer5(DataSource dataSource){
//        return new JdbcBatchItemWriterBuilder<Game>()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql( "INSERT INTO game_player (game_id, player_id, start_sub, visit_home, batting_order, field_position, game_num, player_batting_order, player_field_position, player_start_sub, year, day_night, game_type, home_team_league, player_bats, player_throws, player_visit_home, visiting_team_league) VALUES " +
//                        "(:id, :playerIdHome5, " + STARTING_PLAYER + ", " + HOME_PLAYER + ", 5, :playerPositionHome5, 0, 0, 0, 0, 0, \"\", \"\", \"\", \"\", \"\", 0, \"\"); ")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Game> writeGameHomePlayer6(DataSource dataSource){
//        return new JdbcBatchItemWriterBuilder<Game>()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql( "INSERT INTO game_player (game_id, player_id, start_sub, visit_home, batting_order, field_position, game_num, player_batting_order, player_field_position, player_start_sub, year, day_night, game_type, home_team_league, player_bats, player_throws, player_visit_home, visiting_team_league) VALUES " +
//                        "(:id, :playerIdHome6, " + STARTING_PLAYER + ", " + HOME_PLAYER + ", 6, :playerPositionHome6, 0, 0, 0, 0, 0, \"\", \"\", \"\", \"\", \"\", 0, \"\"); ")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Game> writeGameHomePlayer7(DataSource dataSource){
//        return new JdbcBatchItemWriterBuilder<Game>()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql( "INSERT INTO game_player (game_id, player_id, start_sub, visit_home, batting_order, field_position, game_num, player_batting_order, player_field_position, player_start_sub, year, day_night, game_type, home_team_league, player_bats, player_throws, player_visit_home, visiting_team_league) VALUES " +
//                        "(:id, :playerIdHome7, " + STARTING_PLAYER + ", " + HOME_PLAYER + ", 7, :playerPositionHome7, 0, 0, 0, 0, 0, \"\", \"\", \"\", \"\", \"\", 0, \"\"); ")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Game> writeGameHomePlayer8(DataSource dataSource){
//        return new JdbcBatchItemWriterBuilder<Game>()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql( "INSERT INTO game_player (game_id, player_id, start_sub, visit_home, batting_order, field_position, game_num, player_batting_order, player_field_position, player_start_sub, year, day_night, game_type, home_team_league, player_bats, player_throws, player_visit_home, visiting_team_league) VALUES " +
//                        "(:id, :playerIdHome8, " + STARTING_PLAYER + ", " + HOME_PLAYER + ", 8, :playerPositionHome8, 0, 0, 0, 0, 0, \"\", \"\", \"\", \"\", \"\", 0, \"\"); ")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Game> writeGameHomePlayer9(DataSource dataSource){
//        return new JdbcBatchItemWriterBuilder<Game>()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql( "INSERT INTO game_player (game_id, player_id, start_sub, visit_home, batting_order, field_position, game_num, player_batting_order, player_field_position, player_start_sub, year, day_night, game_type, home_team_league, player_bats, player_throws, player_visit_home, visiting_team_league) VALUES " +
//                        "(:id, :playerIdHome9, " + STARTING_PLAYER + ", " + HOME_PLAYER + ", 9, :playerPositionHome9, 0, 0, 0, 0, 0, \"\", \"\", \"\", \"\", \"\", 0, \"\"); ")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Game> writeGameHomePlayer10(DataSource dataSource){
//        return new JdbcBatchItemWriterBuilder<Game>()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql( "INSERT INTO game_player (game_id, player_id, start_sub, visit_home, batting_order, field_position, game_num, player_batting_order, player_field_position, player_start_sub, year, day_night, game_type, home_team_league, player_bats, player_throws, player_visit_home, visiting_team_league) VALUES " +
//                        "(:id, :playerIdHome10, " + STARTING_PLAYER + ", " + HOME_PLAYER + ", 10, :playerPositionHome10, 0, 0, 0, 0, 0, \"\", \"\", \"\", \"\", \"\", 0, \"\"); ")
//                .dataSource(dataSource)
//                .build();
//    }

    @Bean
    public CompositeItemWriter<Game> compositeItemWriter(DataSource dataSource){
        CompositeItemWriter<Game> compositeItemWriter = new CompositeItemWriter<>();
        compositeItemWriter.setDelegates(Arrays.asList(
                writeGame(dataSource)));
//                writeGame(dataSource),
//                writeGameVisitingPlayer1(dataSource),
//                writeGameVisitingPlayer2(dataSource),
//                writeGameVisitingPlayer3(dataSource),
//                writeGameVisitingPlayer4(dataSource),
//                writeGameVisitingPlayer5(dataSource),
//                writeGameVisitingPlayer6(dataSource),
//                writeGameVisitingPlayer7(dataSource),
//                writeGameVisitingPlayer8(dataSource),
//                writeGameVisitingPlayer9(dataSource),
//                writeGameVisitingPlayer10(dataSource),
//
//                writeGameHomePlayer1(dataSource),
//                writeGameHomePlayer2(dataSource),
//                writeGameHomePlayer3(dataSource),
//                writeGameHomePlayer4(dataSource),
//                writeGameHomePlayer5(dataSource),
//                writeGameHomePlayer6(dataSource),
//                writeGameHomePlayer7(dataSource),
//                writeGameHomePlayer8(dataSource),
//                writeGameHomePlayer9(dataSource),
//                writeGameHomePlayer10(dataSource)));

        return compositeItemWriter;
    }

    @Bean
    public Step step1(DataSource dataSource) {
        return stepBuilderFactory.get("step1")
                .<Game, Game> chunk(10)
                .reader(reader())
                .faultTolerant()
                //.skipPolicy(new InsertIgnoreVerificationSkipper())
                .writer(compositeItemWriter(dataSource))
                .build();
    }

    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }
}

