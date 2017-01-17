package caceresenzo.plugin;

import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractPluginManager implements PluginManager {
	
	private final PluginRegistry registry;
	private final PluginLoader loader;
	
	protected AbstractPluginManager(PluginRegistry registry, PluginLoader loader) {
		this.registry = registry;
		this.loader = loader;
	}
	
	protected AbstractPluginManager(PluginLoader loader) {
		this(new PluginRegistry(), loader);
	}
	
	protected final PluginRegistry getRegistry() {
		return registry;
	}
	
	@Override
	public final PluginLoader getLoader() {
		return loader;
	}
	
	@Override
	public final Set<Plugin> getScripts() {
		return Collections.unmodifiableSet(new HashSet<Plugin>(registry.accessRegistry().values()));
	}
	
	@Override
	public final Plugin getScript(String name) {
		for (Plugin script : getScripts()) {
			if (script.getManifest().name().equalsIgnoreCase(name)) {
				return script;
			}
		}
		return null;
	}
	
	@Override
	public final Set<Plugin> loadScripts(File directory) {
		Set<Plugin> scripts = new HashSet<Plugin>();
		for (File file : directory.listFiles()) {
			Plugin script = getLoader().load(file);
			if (script != null) {
				scripts.add(script);
			}
		}
		for (Plugin script : scripts) {
			registry.registerScript(script.getManifest(), script);
		}
		return scripts;
	}
	
	@Override
	public final Set<Plugin> loadScripts() {
		return loadScripts(DEFAULT_SCRIPTS_DIRECTORY);
	}
	
	@Override
	public final void enableScripts() {
		for (Plugin script : getScripts()) {
			script.enable();
		}
	}
	
	@Override
	public final void disableScripts() {
		for (Plugin script : getScripts()) {
			script.disable();
		}
	}
	
}