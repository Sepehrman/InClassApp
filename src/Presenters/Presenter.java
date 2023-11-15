package Presenters;

import Models.Repository;
import Views.ActivityMain;

import java.io.File;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Presenter {

    private ActivityMain activity;
    private Repository repository;


    public Presenter(ActivityMain view){
        Repository repository = new Repository();
        this.repository = repository;
        this.activity = view;
    }

    public void getFiles(String input) throws ParseException {
        String[] dates = input.split(",");
        DateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date startDate = format.parse(dates[0]);
        Date endDate = format.parse(dates[1]);
        ArrayList<File> files = this.repository.search(startDate, endDate);
        this.activity.displayResults(files);
    }
}
