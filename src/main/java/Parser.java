import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    @Argument(metaVar = "Arguments", required = true)
    private List<String> listOfArguments = new ArrayList<>();

    @Option(name = "-c", usage = "Returns SumSize", metaVar = "sum")
    private boolean c;

    @Option(name = "--si", usage = "Changes base 1024 to 1000", metaVar = "base")
    private boolean si;

    @Option(name = "-h", usage = "Returns size in human readable format", metaVar = "human")
    private boolean h;


    public static void main(String[] args) {
        new Parser().duParse(args);
    }

    private int duParse(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            parser.printUsage(System.err);
            return 1;
        }


}








