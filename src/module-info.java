module SchulteamVeranstalter {

    requires javafx.controls;
    requires javafx.graphics;
    requires java.base;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.web;
    requires java.desktop;
    requires jlfgr;
    requires java.sql;
    requires java.sql.rowset;
    exports sample;

    opens sample.datamodel;
    opens sample to javafx.fxml;
}