package Views;

import Presenters.Presenter;
import Validation.InputValidation;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityMain extends Activity implements OnInputListener {
    public void onCreate() {
        super.onCreate();
        System.out.println("Input StartDate,EndDate in (YYYYMMDD_HHMMSS) format and hit enter:");
    }
    public void onInput(String input) throws Exception {
        String[] dates = input.split(",");

        if (!InputValidation.isValidDate(dates)) {
            return;
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date startDate = format.parse(dates[0]);
        Date endDate = format.parse(dates[1]);

        Presenter presenter = new Presenter();
        String result = presenter.getFile(startDate, endDate);

        displayResult(result);
    }
    public void displayResult(String results) {
        System.out.println(results);
    }
}