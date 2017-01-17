package caceresenzo.api;

import caceresenzo.plugin.PluginManager;
import caceresenzo.plugin.UniversalPluginManager;

public final class PluginAPI {

	public static void main(String[] args) {
		PluginManager scriptManager = new UniversalPluginManager();

		scriptManager.loadScripts();
		scriptManager.enableScripts();
	}
	
}