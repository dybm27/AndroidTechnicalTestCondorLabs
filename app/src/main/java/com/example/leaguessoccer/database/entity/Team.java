package com.example.leaguessoccer.database.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Team implements Serializable {
    private String nameLeague;
    @PrimaryKey(autoGenerate = false)
    @NonNull
    private String idTeam;
    private String idSoccerXML;
    private String idAPIfootball;
    private String intLoved;
    private String strTeam;
    private String strTeamShort;
    private String strAlternate;
    private String intFormedYear;
    private String strSport;
    private String strLeague;
    private String idLeague;
    private String strLeague2;
    private String idLeague2;
    private String strLeague3;
    private String idLeague3;
    private String strLeague4;
    private String idLeague4;
    private String strLeague5;
    private String idLeague5;
    private String strLeague6;
    private String idLeague6;
    private String strLeague7;
    private String idLeague7;
    private String strDivision;
    private String strManager;
    private String strStadium;
    private String strKeywords;
    private String strRSS;
    private String strStadiumThumb;
    private String strStadiumDescription;
    private String strStadiumLocation;
    private String intStadiumCapacity;
    private String strWebsite;
    private String strFacebook;
    private String strTwitter;
    private String strInstagram;
    private String strDescriptionEN;
    private String strDescriptionDE;
    private String strDescriptionFR;
    private String strDescriptionCN;
    private String strDescriptionIT;
    private String strDescriptionJP;
    private String strDescriptionRU;
    private String strDescriptionES;
    private String strDescriptionPT;
    private String strDescriptionSE;
    private String strDescriptionNL;
    private String strDescriptionHU;
    private String strDescriptionNO;
    private String strDescriptionIL;
    private String strDescriptionPL;
    private String strGender;
    private String strCountry;
    private String strTeamBadge;
    private String strTeamJersey;
    private String strTeamLogo;
    private String strTeamFanart1;
    private String strTeamFanart2;
    private String strTeamFanart3;
    private String strTeamFanart4;
    private String strTeamBanner;
    private String strYoutube;
    private String strLocked;

    public String getNameLeague() {
        return nameLeague;
    }

    public void setNameLeague(String nameLeague) {
        this.nameLeague = nameLeague;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getIdSoccerXML() {
        return idSoccerXML;
    }

    public void setIdSoccerXML(String idSoccerXML) {
        this.idSoccerXML = idSoccerXML;
    }

    public String getIdAPIfootball() {
        return idAPIfootball;
    }

    public void setIdAPIfootball(String idAPIfootball) {
        this.idAPIfootball = idAPIfootball;
    }

    public String getIntLoved() {
        return intLoved;
    }

    public void setIntLoved(String intLoved) {
        this.intLoved = intLoved;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrTeamShort() {
        return strTeamShort;
    }

    public void setStrTeamShort(String strTeamShort) {
        this.strTeamShort = strTeamShort;
    }

    public String getStrAlternate() {
        return strAlternate;
    }

    public void setStrAlternate(String strAlternate) {
        this.strAlternate = strAlternate;
    }

    public String getIntFormedYear() {
        return intFormedYear;
    }

    public void setIntFormedYear(String intFormedYear) {
        this.intFormedYear = intFormedYear;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    public String getStrLeague2() {
        return strLeague2;
    }

    public void setStrLeague2(String strLeague2) {
        this.strLeague2 = strLeague2;
    }

    public String getIdLeague2() {
        return idLeague2;
    }

    public void setIdLeague2(String idLeague2) {
        this.idLeague2 = idLeague2;
    }

    public String getStrLeague3() {
        return strLeague3;
    }

    public void setStrLeague3(String strLeague3) {
        this.strLeague3 = strLeague3;
    }

    public String getIdLeague3() {
        return idLeague3;
    }

    public void setIdLeague3(String idLeague3) {
        this.idLeague3 = idLeague3;
    }

    public String getStrLeague4() {
        return strLeague4;
    }

    public void setStrLeague4(String strLeague4) {
        this.strLeague4 = strLeague4;
    }

    public String getIdLeague4() {
        return idLeague4;
    }

    public void setIdLeague4(String idLeague4) {
        this.idLeague4 = idLeague4;
    }

    public String getStrLeague5() {
        return strLeague5;
    }

    public void setStrLeague5(String strLeague5) {
        this.strLeague5 = strLeague5;
    }

    public String getIdLeague5() {
        return idLeague5;
    }

    public void setIdLeague5(String idLeague5) {
        this.idLeague5 = idLeague5;
    }

    public String getStrLeague6() {
        return strLeague6;
    }

    public void setStrLeague6(String strLeague6) {
        this.strLeague6 = strLeague6;
    }

    public String getIdLeague6() {
        return idLeague6;
    }

    public void setIdLeague6(String idLeague6) {
        this.idLeague6 = idLeague6;
    }

    public String getStrLeague7() {
        return strLeague7;
    }

    public void setStrLeague7(String strLeague7) {
        this.strLeague7 = strLeague7;
    }

    public String getIdLeague7() {
        return idLeague7;
    }

    public void setIdLeague7(String idLeague7) {
        this.idLeague7 = idLeague7;
    }

    public String getStrDivision() {
        return strDivision;
    }

    public void setStrDivision(String strDivision) {
        this.strDivision = strDivision;
    }

    public String getStrManager() {
        return strManager;
    }

    public void setStrManager(String strManager) {
        this.strManager = strManager;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    public String getStrKeywords() {
        return strKeywords;
    }

    public void setStrKeywords(String strKeywords) {
        this.strKeywords = strKeywords;
    }

    public String getStrRSS() {
        return strRSS;
    }

    public void setStrRSS(String strRSS) {
        this.strRSS = strRSS;
    }

    public String getStrStadiumThumb() {
        return strStadiumThumb;
    }

    public void setStrStadiumThumb(String strStadiumThumb) {
        this.strStadiumThumb = strStadiumThumb;
    }

    public String getStrStadiumDescription() {
        return strStadiumDescription;
    }

    public void setStrStadiumDescription(String strStadiumDescription) {
        this.strStadiumDescription = strStadiumDescription;
    }

    public String getStrStadiumLocation() {
        return strStadiumLocation;
    }

    public void setStrStadiumLocation(String strStadiumLocation) {
        this.strStadiumLocation = strStadiumLocation;
    }

    public String getIntStadiumCapacity() {
        return intStadiumCapacity;
    }

    public void setIntStadiumCapacity(String intStadiumCapacity) {
        this.intStadiumCapacity = intStadiumCapacity;
    }

    public String getStrWebsite() {
        return strWebsite;
    }

    public void setStrWebsite(String strWebsite) {
        this.strWebsite = strWebsite;
    }

    public String getStrFacebook() {
        return strFacebook;
    }

    public void setStrFacebook(String strFacebook) {
        this.strFacebook = strFacebook;
    }

    public String getStrTwitter() {
        return strTwitter;
    }

    public void setStrTwitter(String strTwitter) {
        this.strTwitter = strTwitter;
    }

    public String getStrInstagram() {
        return strInstagram;
    }

    public void setStrInstagram(String strInstagram) {
        this.strInstagram = strInstagram;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public String getStrDescriptionDE() {
        return strDescriptionDE;
    }

    public void setStrDescriptionDE(String strDescriptionDE) {
        this.strDescriptionDE = strDescriptionDE;
    }

    public String getStrDescriptionFR() {
        return strDescriptionFR;
    }

    public void setStrDescriptionFR(String strDescriptionFR) {
        this.strDescriptionFR = strDescriptionFR;
    }

    public String getStrDescriptionCN() {
        return strDescriptionCN;
    }

    public void setStrDescriptionCN(String strDescriptionCN) {
        this.strDescriptionCN = strDescriptionCN;
    }

    public String getStrDescriptionIT() {
        return strDescriptionIT;
    }

    public void setStrDescriptionIT(String strDescriptionIT) {
        this.strDescriptionIT = strDescriptionIT;
    }

    public String getStrDescriptionJP() {
        return strDescriptionJP;
    }

    public void setStrDescriptionJP(String strDescriptionJP) {
        this.strDescriptionJP = strDescriptionJP;
    }

    public String getStrDescriptionRU() {
        return strDescriptionRU;
    }

    public void setStrDescriptionRU(String strDescriptionRU) {
        this.strDescriptionRU = strDescriptionRU;
    }

    public String getStrDescriptionES() {
        return strDescriptionES;
    }

    public void setStrDescriptionES(String strDescriptionES) {
        this.strDescriptionES = strDescriptionES;
    }

    public String getStrDescriptionPT() {
        return strDescriptionPT;
    }

    public void setStrDescriptionPT(String strDescriptionPT) {
        this.strDescriptionPT = strDescriptionPT;
    }

    public String getStrDescriptionSE() {
        return strDescriptionSE;
    }

    public void setStrDescriptionSE(String strDescriptionSE) {
        this.strDescriptionSE = strDescriptionSE;
    }

    public String getStrDescriptionNL() {
        return strDescriptionNL;
    }

    public void setStrDescriptionNL(String strDescriptionNL) {
        this.strDescriptionNL = strDescriptionNL;
    }

    public String getStrDescriptionHU() {
        return strDescriptionHU;
    }

    public void setStrDescriptionHU(String strDescriptionHU) {
        this.strDescriptionHU = strDescriptionHU;
    }

    public String getStrDescriptionNO() {
        return strDescriptionNO;
    }

    public void setStrDescriptionNO(String strDescriptionNO) {
        this.strDescriptionNO = strDescriptionNO;
    }

    public String getStrDescriptionIL() {
        return strDescriptionIL;
    }

    public void setStrDescriptionIL(String strDescriptionIL) {
        this.strDescriptionIL = strDescriptionIL;
    }

    public String getStrDescriptionPL() {
        return strDescriptionPL;
    }

    public void setStrDescriptionPL(String strDescriptionPL) {
        this.strDescriptionPL = strDescriptionPL;
    }

    public String getStrGender() {
        return strGender;
    }

    public void setStrGender(String strGender) {
        this.strGender = strGender;
    }

    public String getStrCountry() {
        return strCountry;
    }

    public void setStrCountry(String strCountry) {
        this.strCountry = strCountry;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }

    public String getStrTeamJersey() {
        return strTeamJersey;
    }

    public void setStrTeamJersey(String strTeamJersey) {
        this.strTeamJersey = strTeamJersey;
    }

    public String getStrTeamLogo() {
        return strTeamLogo;
    }

    public void setStrTeamLogo(String strTeamLogo) {
        this.strTeamLogo = strTeamLogo;
    }

    public String getStrTeamFanart1() {
        return strTeamFanart1;
    }

    public void setStrTeamFanart1(String strTeamFanart1) {
        this.strTeamFanart1 = strTeamFanart1;
    }

    public String getStrTeamFanart2() {
        return strTeamFanart2;
    }

    public void setStrTeamFanart2(String strTeamFanart2) {
        this.strTeamFanart2 = strTeamFanart2;
    }

    public String getStrTeamFanart3() {
        return strTeamFanart3;
    }

    public void setStrTeamFanart3(String strTeamFanart3) {
        this.strTeamFanart3 = strTeamFanart3;
    }

    public String getStrTeamFanart4() {
        return strTeamFanart4;
    }

    public void setStrTeamFanart4(String strTeamFanart4) {
        this.strTeamFanart4 = strTeamFanart4;
    }

    public String getStrTeamBanner() {
        return strTeamBanner;
    }

    public void setStrTeamBanner(String strTeamBanner) {
        this.strTeamBanner = strTeamBanner;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    public String getStrLocked() {
        return strLocked;
    }

    public void setStrLocked(String strLocked) {
        this.strLocked = strLocked;
    }
}
