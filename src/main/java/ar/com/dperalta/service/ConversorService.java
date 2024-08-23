package ar.com.dperalta.service;

import java.util.HashMap;
import java.util.Map;

public class ConversorService {

    public static String processConversion(String request) {
        Map<String, String> params = parseRequest(request);

        String from = params.get("from");
        String to = params.get("to");
        String value = params.get("value");

        String result = "";

        switch (from) {
            case "decimal":
                try {
                    result = convertFromDecimal(to, Integer.parseInt(value));
                } catch (NumberFormatException e) {
                    System.out.println("El valor proporcionado no es válido en la base " + from);
                    result = "El valor proporcionado no es válido en la base " + from;
                }
                break;
            case "binary":
                try {
                    result = convertFromDecimal(to, Integer.parseInt(value, 2));
                } catch (NumberFormatException e) {
                    System.out.println("El valor proporcionado no es válido en la base " + from);
                    result = "El valor proporcionado no es válido en la base " + from;
                }
                break;
            case "octal":
                try {
                    result = convertFromDecimal(to, Integer.parseInt(value, 8));
                } catch (NumberFormatException e) {
                    System.out.println("El valor proporcionado no es válido en la base " + from);
                    result = "El valor proporcionado no es válido en la base " + from;
                }
                break;
            case "hexadecimal":
                try {
                    result = convertFromDecimal(to, Integer.parseInt(value, 16));
                } catch (NumberFormatException e) {
                    System.out.println("El valor proporcionado no es válido en la base " + from);
                    result = "El valor proporcionado no es válido en la base " + from;
                }
                break;
            default:
                result = "Formato de origen no soportado.";
        }

        return result;
    }

    private static String convertFromDecimal(String to, int i) {
        String convert = "";
        switch (to) {
            case "decimal":
                convert = String.valueOf((i));
                break;
            case "binary":
                convert = Integer.toBinaryString(i);
                break;
            case "octal":
                convert = Integer.toOctalString(i);
                break;
            case "hexadecimal":
                convert = Integer.toHexString(i);
                break;
            default:
                convert = "Formato de origen no soportado.";
        }
        return convert;
    }

    private static Map<String, String> parseRequest(String request) {
        Map<String, String> params = new HashMap<>();
        String[] pairs = request.split("&");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            params.put(keyValue[0], keyValue[1]);
        }
        return params;
    }

}
