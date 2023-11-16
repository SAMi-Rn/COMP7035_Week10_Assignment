package Presenters;

import Models.Repository;
import Validation.InputValidation;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Presenter {
    public interface IView
    {
        void displayResult(String results);
    }

    private final IView view;
    private final Repository repository;

    public Presenter(IView view) {
        this.view = view;
        repository = Repository.getInstance();
    }
    public void getFile(String input) throws Exception {
        String[] dates = input.split(",");

        if (!InputValidation.isValidDate(dates)) {
            return;
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date startDate = format.parse(dates[0]);
        Date endDate = format.parse(dates[1]);

        ArrayList<File> files = repository.search(startDate, endDate);
        StringBuilder result = new StringBuilder();
        if (files != null) {
            for (File f : files) {
                result.append(f.getPath()).append(" ");
            }
        }
        view.displayResult(result.toString());
    }
}