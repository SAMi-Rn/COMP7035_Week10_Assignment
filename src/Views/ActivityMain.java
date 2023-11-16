package Views;

import Presenters.Presenter;

public class ActivityMain extends Activity implements OnInputListener, Presenter.IView {
    private Presenter presenter;
    public void onCreate() {
        super.onCreate();
        presenter = new Presenter(this);
        System.out.println("Input StartDate,EndDate in (YYYYMMDD_HHMMSS) format and hit enter:");
    }
    public void onInput(String input) throws Exception {
        presenter.getFile(input);
    }
    public void displayResult(String results) {
        System.out.println(results);
    }
}