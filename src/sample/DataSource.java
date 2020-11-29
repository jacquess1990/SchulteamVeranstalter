package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataSource {
    public static final String DB_NAME = "lehrerliste.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\Profesionalac\\IdeaProjects\\SchulteamVeranstalter\\" + DB_NAME;
    public static final String TEACHER_TABLE = "lehrerliste";
    public static final String COLUMN_TEACHER_NAME = "name";
    public static final String COLUMN_TEACHER_LASTNAME = "lastname";
    public static final String COLUMN_TEACHER_SUBJECT = "subject";
    public static final String COLUMN_TEACHER_PHONE = "phone";
    public static final String COLUMN_TEACHER_EMAIL = "email";
    public static final String COLUMN_TEACHER_NOTES = "notes";

    public static final String QUERY_VIEW_TEACHER_INFO = "SELECT" + COLUMN_TEACHER_NAME + ", " +
            COLUMN_TEACHER_LASTNAME + ", " + COLUMN_TEACHER_SUBJECT + ", " + COLUMN_TEACHER_PHONE +
            ", " + COLUMN_TEACHER_EMAIL + ", " + COLUMN_TEACHER_NOTES + " FROM " + TEACHER_TABLE + " = \"";

    public static final String INSERT_TEACHERS = "INSERT INTO " + TEACHER_TABLE + '(' +
            COLUMN_TEACHER_NAME + " ) VALUES (?)";

    private Connection conn;

    private PreparedStatement queryTeacherInfoView;
    private PreparedStatement insertIntoTeachers;

    public boolean open () {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            queryTeacherInfoView = conn.prepareStatement(QUERY_VIEW_TEACHER_INFO);
            insertIntoTeachers = conn.prepareStatement(INSERT_TEACHERS);

            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to teachers database: " + e.getMessage());
            return false;
        }
    }
}
