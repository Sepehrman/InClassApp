package Views;

import Presenters.Presenter;

import java.io.File;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ActivityMain extends Activity implements OnInputListener {
    public void onCreate() {
        super.onCreate();
        System.out.println("Input StartDate,EndDate in (YYYYMMDD_HHMMSS) format and hit enter:");
    }
    public void onInput(String input) throws Exception {
        Presenter presenter = new Presenter(this);
        presenter.getFiles(input);
    }

    public void displayResults(ArrayList<File> files){
        String results = "";
        if (files != null) {
            for (File f : files) {
                results += f.getPath() + " ";
            }
        }
        System.out.println(results);
    }
}