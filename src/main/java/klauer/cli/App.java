package klauer.cli;

import klauer.inject.DIModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beust.jcommander.JCommander;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Simple main class, which builds up the various components I use for most
 * command-line batch apps
 * 
 * @author Nick Klauer <klauer@gmail.com>
 * 
 */
public class App {
	final static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		try {
			Injector injector = Guice.createInjector(new DIModule(args));
			JCommander com = injector.getInstance(JCommander.class);
			CommandLineParms parms = injector.getInstance(CommandLineParms.class);
			logger.info("args length: " + args.length);
			if (parms.show_help || args.length == 0) {
				StringBuilder b = new StringBuilder();
				com.usage(b);
				System.out.println(b);
			} else {
				logger.info("Do the Hello World thing");
			}
		} catch (Exception e) {
			logger.error("Exception, forcefully exiting application", e);
			System.exit(1);
		} finally {
			logger.info("Ending");
		}

	}
}
