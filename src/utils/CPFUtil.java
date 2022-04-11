package utils;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class CPFUtil {

    public static String formater(String cpf) throws ParseException {
        MaskFormatter formatter = new MaskFormatter("###.###.###-##");
        formatter.setValueContainsLiteralCharacters(false);
        return formatter.valueToString(cpf);
    }
}
