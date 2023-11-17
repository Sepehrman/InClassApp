package Models;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

public class Repository implements IRepository {

    public String repositoryPath = ".";
    private static Repository repoInstance;

    public Repository() {
    }


    public static Repository getInstance() {
        if (repoInstance == null) {
            repoInstance = new Repository();
        }
        return repoInstance;
    }
    @Override
    public ArrayList<File> search(Date startDate, Date endDate){

        File folder = new File(repositoryPath);
        ArrayList<File> searched = new ArrayList<File>();
        File[] files = folder.listFiles();

        assert files != null;
        return (ArrayList<File>) Arrays.stream(files).filter(f -> f.lastModified() >= startDate.getTime()
                && f.lastModified() <= endDate.getTime()).collect(Collectors.toList());
    }
}
