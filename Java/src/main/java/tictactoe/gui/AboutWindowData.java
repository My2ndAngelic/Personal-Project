package tictactoe.gui;

import lombok.Getter;
import org.apache.commons.text.StringSubstitutor;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class AboutWindowData {
    @Getter
    private String tTitle = "About ";

    private String tAbout =
            """
            Designed by ${name} in ${time}.
            Version: ${version}
            Description: ${description}
            
            OS: ${os} on ${cpu} CPU.
            JVM: ${jvm}.
            Timezone: ${timezone}
            
            Future expansions:
            - Match import and viewer
            - More accurate counter
            - Lower memory usage
            - Cross platform compatibility
            """;

    /**
     * Dear Java, please put String interpolation in your language. Thank you.
     * @param template
     * @return
     */
    private String returnTAbout(String template) {
        HashMap<String, String> hashMap = new HashMap<>() {{
            put("name", "My2ndAngelic");
            put("description", "A Tic Tac Toe game with some interesting functions.");
            put("jvm", System.getProperty("java.vendor") + " " + System.getProperty("java.version"));
            put("time","June 2022");
            put("version","2012.0609.69.420");
            put("os", System.getProperty("os.name") + " " + System.getProperty("os.arch") + " version " + System.getProperty("os.version"));
            put("cpu", System.getenv("PROCESSOR_ARCHITECTURE"));
            put("timezone", DateTimeFormatter.ofPattern("OOOO zzzz").format(ZonedDateTime.now()));

        }};
        return StringSubstitutor.replace(template, hashMap);
    }

    public String gettAbout() {
        return returnTAbout(tAbout);
    }
}
