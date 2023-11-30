package Models;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public interface IRepository {
String repositoryPath = "../../../Desktop/";
    ArrayList<File> search(Date startDate, Date endDate);
}