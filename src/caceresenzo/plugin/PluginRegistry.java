package caceresenzo.plugin;

import java.util.HashMap;
import java.util.Map;

public final class PluginRegistry {
	
	private final Map<PluginManifest, Plugin> registry;
	
	public PluginRegistry(Map<PluginManifest, Plugin> scripts) {
		registry = scripts;
	}
	
	public PluginRegistry() {
		this(new HashMap<PluginManifest, Plugin>());
	}
	
	public synchronized Map<PluginManifest, Plugin> accessRegistry() {
		return registry;
	}
	
	public void registerScript(PluginManifest manifest, Plugin script) {
		accessRegistry().put(manifest, script);
	}
	
	public Plugin getScript(PluginManifest manifest) {
		return accessRegistry().get(manifest);
	}
	
}