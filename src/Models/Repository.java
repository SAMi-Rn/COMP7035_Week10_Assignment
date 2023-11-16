package Models;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

public class Repository implements IRepository {
    private static Repository instance;
    private Repository() {}

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }
    private boolean isValidDate(File file, Date startDate, Date endDate) {
        long lastModified = file.lastModified();
        return lastModified >= startDate.getTime() && lastModified <= endDate.getTime();
    }
    @Override
    public ArrayList<File> search(Date startDate, Date endDate) {
        File folder = new File(repositoryPath);
        return Arrays.stream(Objects.requireNonNull(folder.listFiles()))
                .filter(file -> isValidDate(file, startDate, endDate))
                .collect(Collectors.toCollection(ArrayList::new));

    }
}