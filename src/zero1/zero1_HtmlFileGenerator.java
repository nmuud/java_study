package zero1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class zero1_HtmlFileGenerator {
    public static void main(String[] args) {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>\n");
        html.append("<html lang=\"utf-8\">\n");
        html.append("<head>\n");
        html.append("    <meta charset=\"UTF-8\">\n");
        html.append("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
        html.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        html.append("    <title>Document</title>\n");
        html.append("    <style>\n");
        html.append("        table { border-collapse: collapse; width: 100%; }\n");
        html.append("        th, td { border: solid 1px #000; padding: 8px; text-align: left; }\n");
        html.append("        th { background-color: #f2f2f2; }\n");
        html.append("    </style>\n");
        html.append("</head>\n");
        html.append("<body>\n");
        html.append("    <h1>자바 환경정보</h1>\n");
        html.append("    <table>\n");
        html.append("        <tr>\n");
        html.append("            <th>Key</th>\n");
        html.append("            <th>Value</th>\n");
        html.append("        </tr>\n");

        for (Object k : System.getProperties().keySet()) {
            String key = k.toString();
            String value = System.getProperty(key);
            html.append("        <tr>\n");
            html.append("            <td>").append(key).append("</td>\n");
            html.append("            <td>").append(value).append("</td>\n");
            html.append("        </tr>\n");
        }

        html.append("    </table>\n");
        html.append("</body>\n");
        html.append("</html>");

        try {
            File file = new File("index.html");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write(html.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
