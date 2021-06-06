package org.launchcode._play_ball_game_batch.models;

import org.springframework.batch.item.file.transform.FieldSet;

public class Game {
    private final String id;
    private final String date;
    private final int gameNum;
    private final String dayOfWeek;                             // 3
    private final String startTime;
    private final String dhUsedFlag;            // T/F          // 5
    private final String dayNight;              // D/N
    private final String visitingTeam;
    private final String homeTeam;
    private final String ballparkId;                              // 9
    private final String playerIdVisitStartingPitcher;          // 10
    private final int playerPositionVisitStartingPitcher;
    private final String playerIdHomeStartingPitcher;
    private final int playerPositionHomeStartingPitcher;
    private final String umpireIdHomePlate;
    private final String umpireIdFirstBase;
    private final String umpireIdSecondBase;
    private final String umpireIdThirdBase;                     // 15
    private final String umpireIdLeftField;
    private final String umpireIdRightField;
    private final int gameAttendance;
    private final String psScorer;
    private final String translator;                            // 20
    private final String inputter;
    private final String inputTime;
    private final String editTime;
    private final String howScored;
    private final String pitchesEntered;                        // 25
    private final int gameTemperature;
    private final String gameWindDirection;
    private final int gameWindSpeed;
    private final String gameFieldCondition;
    private final String gamePrecipitation;                     // 30
    private final String gameSky;
    private final String gameTime;
    private final int numberOfInnings;
    private final int visitFinalScore;
    private final int homeFinalScore;                           // 35
    private final int visitHits;
    private final int homeHits;
    private final int visitErrors;
    private final int homeErrors;
    private final int visitLeftOnBase;                          // 40
    private final int homeLeftOnBase;
    private final String playerIdWinningPitcher;
    private final String playerIdLosingPitcher;
    private final String playerIdSaveFor;
    private final String playerIdWinningRbi;                // 45





    private final String playerIdVisit1;
    private final int playerPositionVisit1;
    private final String playerIdVisit2;
    private final int playerPositionVisit2;
    private final String playerIdVisit3;                        // 50
    private final int playerPositionVisit3;
    private final String playerIdVisit4;
    private final int playerPositionVisit4;
    private final String playerIdVisit5;
    private final int playerPositionVisit5;                     // 55
    private final String playerIdVisit6;
    private final int playerPositionVisit6;
    private final String playerIdVisit7;
    private final int playerPositionVisit7;
    private final String playerIdVisit8;                        // 60
    private final int playerPositionVisit8;
    private final String playerIdVisit9;
    private final int playerPositionVisit9;
    private final String playerIdHome1;
    private final int playerPositionHome1;                      // 65
    private final String playerIdHome2;
    private final int playerPositionHome2;
    private final String playerIdHome3;
    private final int playerPositionHome3;
    private final String playerIdHome4;                         // 70
    private final int playerPositionHome4;
    private final String playerIdHome5;
    private final int playerPositionHome5;
    private final String playerIdHome6;
    private final int playerPositionHome6;                      // 75
    private final String playerIdHome7;
    private final int playerPositionHome7;
    private final String playerIdHome8;
    private final int playerPositionHome8;
    private final String playerIdHome9;                         // 80
    private final int playerPositionHome9;

    private final String playerIdVisitFinalPitcher;             // 81 final visit pitcher, could be a duplicate
    private final String playerIdHomeFinalPitcher;              // 82 final home pitcher, could be a duplicate



    // constructor
//
//    public Game(String id, String site, String homeTeam, String visitingTeam, String date, String dayNight, int gameNum, String playerIdVisit1, int playerPositionVisit1, String playerIdVisit2, int playerPositionVisit2, String playerIdVisit3, int playerPositionVisit3, String playerIdVisit4, int playerPositionVisit4, String playerIdVisit5, int playerPositionVisit5, String playerIdVisit6, int playerPositionVisit6, String playerIdVisit7, int playerPositionVisit7, String playerIdVisit8, int playerPositionVisit8, String playerIdVisit9, int playerPositionVisit9, String playerIdVisit10, int playerPositionVisit10, String playerIdHome1, int playerPositionHome1, String playerIdHome2, int playerPositionHome2, String playerIdHome3, int playerPositionHome3, String playerIdHome4, int playerPositionHome4, String playerIdHome5, int playerPositionHome5, String playerIdHome6, int playerPositionHome6, String playerIdHome7, int playerPositionHome7, String playerIdHome8, int playerPositionHome8, String playerIdHome9, int playerPositionHome9, String playerIdHome10, int playerPositionHome10) {
//        this.id = id;
//        this.site = site;
//        this.homeTeam = homeTeam;
//        this.visitingTeam = visitingTeam;
//        this.date = date;
//        this.dayNight = dayNight;
//        this.gameNum = gameNum;
//        this.playerIdVisit1 = playerIdVisit1;
//        this.playerPositionVisit1 = playerPositionVisit1;
//        this.playerIdVisit2 = playerIdVisit2;
//        this.playerPositionVisit2 = playerPositionVisit2;
//        this.playerIdVisit3 = playerIdVisit3;
//        this.playerPositionVisit3 = playerPositionVisit3;
//        this.playerIdVisit4 = playerIdVisit4;
//        this.playerPositionVisit4 = playerPositionVisit4;
//        this.playerIdVisit5 = playerIdVisit5;
//        this.playerPositionVisit5 = playerPositionVisit5;
//        this.playerIdVisit6 = playerIdVisit6;
//        this.playerPositionVisit6 = playerPositionVisit6;
//        this.playerIdVisit7 = playerIdVisit7;
//        this.playerPositionVisit7 = playerPositionVisit7;
//        this.playerIdVisit8 = playerIdVisit8;
//        this.playerPositionVisit8 = playerPositionVisit8;
//        this.playerIdVisit9 = playerIdVisit9;
//        this.playerPositionVisit9 = playerPositionVisit9;
//        this.playerIdVisit10 = playerIdVisit10;
//        this.playerPositionVisit10 = playerPositionVisit10;
//
//        this.playerIdHome1 = playerIdHome1;
//        this.playerPositionHome1 = playerPositionHome1;
//        this.playerIdHome2 = playerIdHome2;
//        this.playerPositionHome2 = playerPositionHome2;
//        this.playerIdHome3 = playerIdHome3;
//        this.playerPositionHome3 = playerPositionHome3;
//        this.playerIdHome4 = playerIdHome4;
//        this.playerPositionHome4 = playerPositionHome4;
//        this.playerIdHome5 = playerIdHome5;
//        this.playerPositionHome5 = playerPositionHome5;
//        this.playerIdHome6 = playerIdHome6;
//        this.playerPositionHome6 = playerPositionHome6;
//        this.playerIdHome7 = playerIdHome7;
//        this.playerPositionHome7 = playerPositionHome7;
//        this.playerIdHome8 = playerIdHome8;
//        this.playerPositionHome8 = playerPositionHome8;
//        this.playerIdHome9 = playerIdHome9;
//        this.playerPositionHome9 = playerPositionHome9;
//        this.playerIdHome10 = playerIdHome10;
//        this.playerPositionHome10 = playerPositionHome10;
//    }
    
    public Game(FieldSet fieldSet) {
        this.id = fieldSet.readString(0);
        this.date = fieldSet.readString(1);     // date
        this.gameNum = fieldSet.readInt(2);        // game number 0-not a doubleheader; 1-first game of doubleheader; 2-second game of doubleheader
        this.dayOfWeek = fieldSet.readString(3);     // day of the week
        this.startTime = fieldSet.readString(4);     // game start time
        this.dhUsedFlag = fieldSet.readString(5);     // designated hitter used
        this.dayNight =  fieldSet.readString(6);     // day/night game
        this.visitingTeam = fieldSet.readString(7);     // visiting team
        this.homeTeam = fieldSet.readString(8);     // home team
        this.ballparkId = fieldSet.readString(9);     // game site
        this.playerIdVisitStartingPitcher = fieldSet.readString(10);    // starting home pitcher; could be a duplicate
        this.playerPositionVisitStartingPitcher = 1;                     // starting home pitcher position
        this.playerIdHomeStartingPitcher = fieldSet.readString(11);    // starting visit pitcher; could be a duplicate
        this.playerPositionHomeStartingPitcher = 1;                     // starting visiting pitcher position
        this.umpireIdHomePlate = fieldSet.readString(12);    // umpire home plate
        this.umpireIdFirstBase = fieldSet.readString(13);    // umpire first base
        this.umpireIdSecondBase = fieldSet.readString(14);    // umpire second base
        this.umpireIdThirdBase =  fieldSet.readString(15);    // umpire third base
        this.umpireIdLeftField =  fieldSet.readString(16);    // umpire left field
        this.umpireIdRightField = fieldSet.readString(17);    // umpire right field
        this.gameAttendance = fieldSet.readInt(18);       // game attendance
        this.psScorer = fieldSet.readString(19);    // ps scorer
        this.translator = fieldSet.readString(20);    // translator
        this.inputter = fieldSet.readString(21);    // inputter
        this.inputTime = fieldSet.readString(22);    // input time
        this.editTime = fieldSet.readString(23);    // edit time
        this.howScored = fieldSet.readString(24);    // how scored
        this.pitchesEntered = fieldSet.readString(25);    // pitches entered
        this.gameTemperature = fieldSet.readInt(26);       // game temperature
        this.gameWindDirection = fieldSet.readString(27);    // game wind direction
        this.gameWindSpeed = fieldSet.readInt(28);       // game wind speed
        this.gameFieldCondition = fieldSet.readString(29);    // game field condition
        this.gamePrecipitation = fieldSet.readString(30);    // game precipitation
        this.gameSky = fieldSet.readString(31);    // game sky
        this.gameTime = fieldSet.readString(32);    // game time
        this.numberOfInnings = fieldSet.readInt(33);       // game innings
        this.visitFinalScore = fieldSet.readInt(34);       // visit final score
        this.homeFinalScore = fieldSet.readInt(35);       // home final score
        this.visitHits = fieldSet.readInt(36);       // visit hits
        this.homeHits = fieldSet.readInt(37);       // home hits
        this.visitErrors = fieldSet.readInt(38);       // visit errors
        this.homeErrors = fieldSet.readInt(39);       // home errors
        this.visitLeftOnBase = fieldSet.readInt(40);       // visit left on base
        this.homeLeftOnBase = fieldSet.readInt(41);       // home left on base
        this.playerIdWinningPitcher = fieldSet.readString(42);    // winning pitcher
        this.playerIdLosingPitcher = fieldSet.readString(43);    // losing pitcher
        this.playerIdSaveFor = fieldSet.readString(44);    // save for
        this.playerIdWinningRbi = fieldSet.readString(45);    // game winning RBI

        this.playerIdVisit1 = fieldSet.readString(46);    // playerIdVisit1;
        this.playerPositionVisit1 = fieldSet.readInt(47);       // playerPositionVisit1;

        this.playerIdVisit2 = fieldSet.readString(48);    // playerIdVisit2;
        this.playerPositionVisit2 = fieldSet.readInt(49);       // playerPositionVisit2;

        this.playerIdVisit3 = fieldSet.readString(50);    // playerIdVisit3;
        this.playerPositionVisit3 = fieldSet.readInt(51);       // playerPositionVisit3;

        this.playerIdVisit4 = fieldSet.readString(52);    // playerIdVisit4;
        this.playerPositionVisit4 = fieldSet.readInt(53);       // playerPositionVisit4;

        this.playerIdVisit5 = fieldSet.readString(54);    // playerIdVisit5;
        this.playerPositionVisit5 = fieldSet.readInt(55);       // playerPositionVisit5;

        this.playerIdVisit6 = fieldSet.readString(56);    // playerIdVisit6;
        this.playerPositionVisit6 = fieldSet.readInt(57);       // playerPositionVisit6;

        this.playerIdVisit7 = fieldSet.readString(58);    // playerIdVisit7;
        this.playerPositionVisit7 = fieldSet.readInt(59);       // playerPositionVisit7;

        this.playerIdVisit8 = fieldSet.readString(60);    // playerIdVisit8;
        this.playerPositionVisit8 = fieldSet.readInt(61);       // playerPositionVisit8;

        this.playerIdVisit9 = fieldSet.readString(62);    // playerIdVisit9;
        this.playerPositionVisit9 = fieldSet.readInt(63);       // playerPositionVisit9;

        this.playerIdHome1 = fieldSet.readString(64);    // playerIdHome1;
        this.playerPositionHome1 = fieldSet.readInt(65);       // playerPositionHome1;

        this.playerIdHome2 =          fieldSet.readString(66);    // playerIdHome2;
        this.playerPositionHome2 = fieldSet.readInt(67);       // playerPositionHome2;

        this.playerIdHome3 =          fieldSet.readString(68);    // playerIdHome3;
        this.playerPositionHome3 = fieldSet.readInt(69);       // playerPositionHome3;

        this.playerIdHome4 =          fieldSet.readString(70);    // playerIdHome4;
        this.playerPositionHome4 = fieldSet.readInt(71);       // playerPositionHome4;

        this.playerIdHome5 =          fieldSet.readString(72);    // playerIdHome5;
        this.playerPositionHome5 = fieldSet.readInt(73);       // playerPositionHome5;

        this.playerIdHome6 =          fieldSet.readString(74);    // playerIdHome6;
        this.playerPositionHome6 = fieldSet.readInt(75);       // playerPositionHome6;

        this.playerIdHome7 =          fieldSet.readString(76);    // playerIdHome7;
        this.playerPositionHome7 = fieldSet.readInt(77);       // playerPositionHome7;

        this.playerIdHome8 =          fieldSet.readString(78);    // playerIdHome8;
        this.playerPositionHome8 = fieldSet.readInt(79);       // playerPositionHome8;

        this.playerIdHome9 =          fieldSet.readString(80);    // playerIdHome9;
        this.playerPositionHome9 = fieldSet.readInt(81);       // playerPositionHome9;

        this.playerIdVisitFinalPitcher = fieldSet.readString(82);    // final visit pitcher
        this.playerIdHomeFinalPitcher = fieldSet.readString(83);    // final home pitcher

    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getGameNum() {
        return gameNum;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getDhUsedFlag() {
        return dhUsedFlag;
    }

    public String getDayNight() {
        return dayNight;
    }

    public String getVisitingTeam() {
        return visitingTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getBallparkId() {
        return ballparkId;
    }

    public String getPlayerIdVisitStartingPitcher() {
        return playerIdVisitStartingPitcher;
    }

    public int getPlayerPositionVisitStartingPitcher() {
        return playerPositionVisitStartingPitcher;
    }

    public String getPlayerIdHomeStartingPitcher() {
        return playerIdHomeStartingPitcher;
    }

    public int getPlayerPositionHomeStartingPitcher() {
        return playerPositionHomeStartingPitcher;
    }

    public String getUmpireIdHomePlate() {
        return umpireIdHomePlate;
    }

    public String getUmpireIdFirstBase() {
        return umpireIdFirstBase;
    }

    public String getUmpireIdSecondBase() {
        return umpireIdSecondBase;
    }

    public String getUmpireIdThirdBase() {
        return umpireIdThirdBase;
    }

    public String getUmpireIdLeftField() {
        return umpireIdLeftField;
    }

    public String getUmpireIdRightField() {
        return umpireIdRightField;
    }

    public int getGameAttendance() {
        return gameAttendance;
    }

    public String getPsScorer() {
        return psScorer;
    }

    public String getTranslator() {
        return translator;
    }

    public String getInputter() {
        return inputter;
    }

    public String getInputTime() {
        return inputTime;
    }

    public String getEditTime() {
        return editTime;
    }

    public String getHowScored() {
        return howScored;
    }

    public String getPitchesEntered() {
        return pitchesEntered;
    }

    public int getGameTemperature() {
        return gameTemperature;
    }

    public String getGameWindDirection() {
        return gameWindDirection;
    }

    public int getGameWindSpeed() {
        return gameWindSpeed;
    }

    public String getGameFieldCondition() {
        return gameFieldCondition;
    }

    public String getGamePrecipitation() {
        return gamePrecipitation;
    }

    public String getGameSky() {
        return gameSky;
    }

    public String getGameTime() {
        return gameTime;
    }

    public int getNumberOfInnings() {
        return numberOfInnings;
    }

    public int getVisitFinalScore() {
        return visitFinalScore;
    }

    public int getHomeFinalScore() {
        return homeFinalScore;
    }

    public int getVisitHits() {
        return visitHits;
    }

    public int getHomeHits() {
        return homeHits;
    }

    public int getVisitErrors() {
        return visitErrors;
    }

    public int getHomeErrors() {
        return homeErrors;
    }

    public int getVisitLeftOnBase() {
        return visitLeftOnBase;
    }

    public int getHomeLeftOnBase() {
        return homeLeftOnBase;
    }

    public String getPlayerIdWinningPitcher() {
        return playerIdWinningPitcher;
    }

    public String getPlayerIdLosingPitcher() {
        return playerIdLosingPitcher;
    }

    public String getPlayerIdSaveFor() {
        return playerIdSaveFor;
    }

    public String getPlayerIdWinningRbi() {
        return playerIdWinningRbi;
    }

    public String getPlayerIdVisit1() {
        return playerIdVisit1;
    }

    public int getPlayerPositionVisit1() {
        return playerPositionVisit1;
    }

    public String getPlayerIdVisit2() {
        return playerIdVisit2;
    }

    public int getPlayerPositionVisit2() {
        return playerPositionVisit2;
    }

    public String getPlayerIdVisit3() {
        return playerIdVisit3;
    }

    public int getPlayerPositionVisit3() {
        return playerPositionVisit3;
    }

    public String getPlayerIdVisit4() {
        return playerIdVisit4;
    }

    public int getPlayerPositionVisit4() {
        return playerPositionVisit4;
    }

    public String getPlayerIdVisit5() {
        return playerIdVisit5;
    }

    public int getPlayerPositionVisit5() {
        return playerPositionVisit5;
    }

    public String getPlayerIdVisit6() {
        return playerIdVisit6;
    }

    public int getPlayerPositionVisit6() {
        return playerPositionVisit6;
    }

    public String getPlayerIdVisit7() {
        return playerIdVisit7;
    }

    public int getPlayerPositionVisit7() {
        return playerPositionVisit7;
    }

    public String getPlayerIdVisit8() {
        return playerIdVisit8;
    }

    public int getPlayerPositionVisit8() {
        return playerPositionVisit8;
    }

    public String getPlayerIdVisit9() {
        return playerIdVisit9;
    }

    public int getPlayerPositionVisit9() {
        return playerPositionVisit9;
    }

    public String getPlayerIdHome1() {
        return playerIdHome1;
    }

    public int getPlayerPositionHome1() {
        return playerPositionHome1;
    }

    public String getPlayerIdHome2() {
        return playerIdHome2;
    }

    public int getPlayerPositionHome2() {
        return playerPositionHome2;
    }

    public String getPlayerIdHome3() {
        return playerIdHome3;
    }

    public int getPlayerPositionHome3() {
        return playerPositionHome3;
    }

    public String getPlayerIdHome4() {
        return playerIdHome4;
    }

    public int getPlayerPositionHome4() {
        return playerPositionHome4;
    }

    public String getPlayerIdHome5() {
        return playerIdHome5;
    }

    public int getPlayerPositionHome5() {
        return playerPositionHome5;
    }

    public String getPlayerIdHome6() {
        return playerIdHome6;
    }

    public int getPlayerPositionHome6() {
        return playerPositionHome6;
    }

    public String getPlayerIdHome7() {
        return playerIdHome7;
    }

    public int getPlayerPositionHome7() {
        return playerPositionHome7;
    }

    public String getPlayerIdHome8() {
        return playerIdHome8;
    }

    public int getPlayerPositionHome8() {
        return playerPositionHome8;
    }

    public String getPlayerIdHome9() {
        return playerIdHome9;
    }

    public int getPlayerPositionHome9() {
        return playerPositionHome9;
    }

    public String getPlayerIdVisitFinalPitcher() {
        return playerIdVisitFinalPitcher;
    }

    public String getPlayerIdHomeFinalPitcher() {
        return playerIdHomeFinalPitcher;
    }
}