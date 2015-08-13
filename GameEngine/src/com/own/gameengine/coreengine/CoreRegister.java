package com.own.gameengine.coreengine;

import java.util.HashMap;

public class CoreRegister {

	private static HashMap<CoreObject, Object>	register	= new HashMap<>();
	static {
		initializeRegister();
	}

	private CoreRegister() {
	}

	private static void initializeRegister() {
		for (CoreObject coreObject : CoreObject.values())
			register.put(coreObject, null);
	}

	public static Object get(CoreObject coreObject) {
		return register.get(coreObject);
	}

	public static void set(CoreObject coreObject, Object object) {
		register.put(coreObject, object);
	}
}
