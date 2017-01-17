package caceresenzo.plugin;

public final class UniversalPluginManager extends AbstractPluginManager {
	
	public UniversalPluginManager(PluginRegistry registry, PluginLoader loader) {
		super(registry, loader);
	}
	
	public UniversalPluginManager(PluginLoader loader) {
		super(loader);
	}
	
	public UniversalPluginManager() {
		this(new UniversalPluginLoader());
	}
	
}