package klauer.inject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import klauer.cli.CommandLineParms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beust.jcommander.JCommander;
import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Provides;
import com.google.inject.name.Names;

public class DIModule extends AbstractModule {
	
	public static final String LOG_PROPERTIES_FILE = "/logback.properties";
	final static Logger logger = LoggerFactory.getLogger(DIModule.class);

	JCommander command;
	CommandLineParms parms;

	@Override
	protected void configure() {
		loadProperties(binder());
	}

	/**
	 * Create new instance of Guice's Dependency Injector.
	 * 
	 * @param args
	 *            Command-line Array of arguments passed in when running this
	 *            application.
	 */
	public DIModule(String[] args) {
		parms = new CommandLineParms();
		// JCommander binds the arg[] from main to the simple POJO bean.
		command = new JCommander(parms, args);
	}

	/**
	 * Retrieve and load in the various {@code .properties} files for
	 * configuration data. <br/>
	 * <br/>
	 * The formula for this is pretty simple:
	 * <ol>
	 * <li>get {@code InputStream} for a {@code .properties} file</li>
	 * <li>create a {@code .properties} file for that</li>
	 * <li>Using {@linkplain Names#bindProperties(Binder, Properties)}, bind
	 * each file to the DI instance</li>
	 * <li>use each property with the {@code @Named} annotation, referencing the
	 * property</li>
	 * </ol>
	 * 
	 * @param binder
	 *            Provided by Google Guice
	 * @see DIModule#configure()
	 */
	private void loadProperties(Binder binder) {
		InputStream log = DIModule.class.getResourceAsStream(LOG_PROPERTIES_FILE);
		Properties appProperties = new Properties();
		try {
			appProperties.load(log);
			logger.debug("Add Log Properties");
			Names.bindProperties(binder, appProperties);
		} catch (IOException e) {
			// This is the preferred way to tell Guice something went wrong
			logger.error("Unable to Bind Properties files to Guice: {}", e);
			binder.addError(e);
		}
	}

	@Provides
	CommandLineParms provideCommandLineParms() {
		return this.parms;
	}

	@Provides
	JCommander provideCommander() {
		return this.command;
	}

}
