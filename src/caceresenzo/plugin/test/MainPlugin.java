package caceresenzo.plugin.test;

import caceresenzo.plugin.AbstractPlugin;
import caceresenzo.plugin.PluginConfiguration;
import caceresenzo.plugin.PluginManifest;

@PluginManifest(name = "TestScript", description = "An example script.", version = 0.1, authors = "Enzo CACERES")

public final class MainPlugin extends AbstractPlugin {

    @Override
    public final void onEnable() {
    	System.out.println(" : Plugin Enabled!!!!!!!");
    	
    	PluginConfiguration configuration = new PluginConfiguration();
    	configuration.put("Key", "Value");
    	saveConfiguration(configuration, "config.properties");
    	
    	System.out.println(": " + configuration.get("Key"));
    }

    @Override
    public final void onDisable() {
    	System.out.println(" : Plugin Disabled!!!!!!!");
    }

}