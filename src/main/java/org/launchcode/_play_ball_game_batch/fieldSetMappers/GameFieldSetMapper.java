package org.launchcode._play_ball_game_batch.fieldSetMappers;

import org.launchcode._play_ball_game_batch.models.Game;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class GameFieldSetMapper implements FieldSetMapper<Game> {

    @Override
    public Game mapFieldSet(FieldSet fieldSet) throws BindException {

        return new Game(fieldSet);

//                fieldSet.readString(0),     // game id
//                fieldSet.readString(1),     // date
//                fieldSet.readInt(2),        // game number 0-not a doubleheader, 1-first game of doubleheader, 2-second game of doubleheader
//                fieldSet.readString(3),     // day of the week
//                fieldSet.readString(4),     // game start time
//                fieldSet.readString(5),     // designated hitter used
//                fieldSet.readString(6),     // day/night game
//                fieldSet.readString(7),     // visiting team
//                fieldSet.readString(8),     // home team
//                fieldSet.readString(9),     // game site
//                fieldSet.readString(10),    // starting home pitcher, could be a duplicate
//                1,                     // starting home pitcher position
//                fieldSet.readString(11),    // starting visit pitcher, could be a duplicate
//                1,                     // starting visiting pitcher position
//                fieldSet.readString(12),    // umpire home plate
//                fieldSet.readString(13),    // umpire first base
//                fieldSet.readString(14),    // umpire second base
//                fieldSet.readString(15),    // umpire third base
//                fieldSet.readString(16),    // umpire left field
//                fieldSet.readString(17),    // umpire right field
//                fieldSet.readInt(18),       // game attendance
//                fieldSet.readString(19),    // ps scorer
//                fieldSet.readString(20),    // translator
//                fieldSet.readString(21),    // inputter
//                fieldSet.readString(22),    // input time
//                fieldSet.readString(23),    // edit time
//                fieldSet.readString(24),    // how scored
//                fieldSet.readString(25),    // pitches entered
//                fieldSet.readInt(26),       // game temperature
//                fieldSet.readString(27),    // game wind direction
//                fieldSet.readInt(28),       // game wind speed
//                fieldSet.readString(29),    // game field condition
//                fieldSet.readString(30),    // game precipitation
//                fieldSet.readString(31),    // game sky
//                fieldSet.readString(32),    // game time
//                fieldSet.readInt(33),       // game innings
//                fieldSet.readInt(34),       // visit final score
//                fieldSet.readInt(35),       // home final score
//                fieldSet.readInt(36),       // visit hits
//                fieldSet.readInt(37),       // home hits
//                fieldSet.readInt(38),       // visit errors
//                fieldSet.readInt(39),       // home errors
//                fieldSet.readInt(40),       // visit left on base
//                fieldSet.readInt(41),       // home left on base
//                fieldSet.readString(42),    // winning pitcher
//                fieldSet.readString(43),    // losing pitcher
//                fieldSet.readString(44),    // save for
//                fieldSet.readString(45),    // game winning RBI
//
//                fieldSet.readString(46),    // playerIdVisit1;
//                fieldSet.readInt(47),       // playerPositionVisit1;
//
//                fieldSet.readString(48),    // playerIdVisit2;
//                fieldSet.readInt(49),       // playerPositionVisit2;
//
//                fieldSet.readString(50),    // playerIdVisit3;
//                fieldSet.readInt(51),       // playerPositionVisit3;
//
//                fieldSet.readString(52),    // playerIdVisit4;
//                fieldSet.readInt(53),       // playerPositionVisit4;
//
//                fieldSet.readString(54),    // playerIdVisit5;
//                fieldSet.readInt(55),       // playerPositionVisit5;
//
//                fieldSet.readString(56),    // playerIdVisit6;
//                fieldSet.readInt(57),       // playerPositionVisit6;
//
//                fieldSet.readString(58),    // playerIdVisit7;
//                fieldSet.readInt(59),       // playerPositionVisit7;
//
//                fieldSet.readString(60),    // playerIdVisit8;
//                fieldSet.readInt(61),       // playerPositionVisit8;
//
//                fieldSet.readString(62),    // playerIdVisit9;
//                fieldSet.readInt(63),       // playerPositionVisit9;
//
//
//
//
//                fieldSet.readString(64),    // playerIdHome1;
//                fieldSet.readInt(65),       // playerPositionHome1;
//
//                fieldSet.readString(66),    // playerIdHome2;
//                fieldSet.readInt(67),       // playerPositionHome2;
//
//                fieldSet.readString(68),    // playerIdHome3;
//                fieldSet.readInt(69),       // playerPositionHome3;
//
//                fieldSet.readString(70),    // playerIdHome4;
//                fieldSet.readInt(71),       // playerPositionHome4;
//
//                fieldSet.readString(72),    // playerIdHome5;
//                fieldSet.readInt(73),       // playerPositionHome5;
//
//                fieldSet.readString(74),    // playerIdHome6;
//                fieldSet.readInt(75),       // playerPositionHome6;
//
//                fieldSet.readString(76),    // playerIdHome7;
//                fieldSet.readInt(77),       // playerPositionHome7;
//
//                fieldSet.readString(78),    // playerIdHome8;
//                fieldSet.readInt(79),       // playerPositionHome8;
//
//                fieldSet.readString(80),    // playerIdHome9;
//                fieldSet.readInt(81),       // playerPositionHome9;
//
//                fieldSet.readString(82),    // final visit pitcher
//                10,                               // final visit pitcher position
//
//                fieldSet.readString(83),    // final home pitcher
//                10);                              // final home pitcher position
    }
}

