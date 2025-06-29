package recursos;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateLabelFromatter extends JFormattedTextField.AbstractFormatter {

    private final String patron = "yyyy-MM-dd";
    private final SimpleDateFormat fechaFormateada = new SimpleDateFormat(patron);
    @Override
    public Object stringToValue(String text) throws ParseException {
        return fechaFormateada.parse(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null){
            Calendar cal = (Calendar) value;
            return fechaFormateada.format(cal.getTime());
        }
        return "";
    }
}
