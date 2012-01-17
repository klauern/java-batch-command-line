package klauer.cli;

import com.beust.jcommander.Parameter;

/**
 * Simple POJO bean declaring the various command-line options that are to be expected
 * in this application.  The JCommander web page (http://jcommander.org/) is
 * extremely valuable in that they provide a wealth of examples to bring in.
 * @author Nick Klauer <klauer@gmail.com>
 *
 */
public class CommandLineParms {

	@Parameter(names = { "-h", "--help", "/?", "-?"}, description = "Show this help")
	public boolean show_help;
	
	// add others here
}
