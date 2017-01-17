package caceresenzo.plugin;

import java.io.File;
import java.util.Set;

public interface PluginManager {
	
	static final File DEFAULT_SCRIPTS_DIRECTORY = new File("plugins" + File.separator);
	
	PluginLoader getLoader();
	
	Set<Plugin> getScripts();
	
	Plugin getScript(String name);
	
	Set<Plugin> loadScripts(File directory);
	
	Set<Plugin> loadScripts();
	
	void enableScripts();
	
	void disableScripts();
	
}