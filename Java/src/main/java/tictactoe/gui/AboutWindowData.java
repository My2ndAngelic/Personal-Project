package tictactoe.gui;

import lombok.Getter;
import org.apache.commons.lang3.text.StrSubstitutor;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;

public class AboutWindowData {
    @Getter
    private String tTitle = "About ";

    private String tAbout =
            """
            Designed by {name} in {time}.
            Version: {version}
            Description: {description}
            
            OS: {os} on {cpu} CPU.
            JVM: {jvm}.
            Timezone: {timezone}
            
            Future expansions:
            - Match import and viewer
            - More accurate counter
            - Lower memory usage
            - Cross platform compatibility
            """;

    private String returnTAbout(String template) {
        HashMap<String, String> hashMap = new HashMap<>() {{
            put("name", "My2ndAngelic");
            put("time","June 2022");
            put("version","2012.0609.69.420");
            put("os", System.getProperty("os.arch"));
            put("cpu", System.getenv("PROCESSOR_ARCHITECTURE"));
            put("timezone", ZonedDateTime.now(ZoneId.systemDefault()).toString());
        }};
        return new StrSubstitutor(hashMap).replace(template);
    }

    public String gettAbout() {
        return returnTAbout(tAbout);
    }
}
