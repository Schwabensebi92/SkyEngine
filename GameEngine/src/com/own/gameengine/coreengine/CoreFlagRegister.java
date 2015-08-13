package com.own.gameengine.coreengine;

import java.util.HashMap;

public class CoreFlagRegister {

	private static HashMap<CoreFlag, Boolean>	register	= new HashMap<>();
	static {
		initializeRegister();
	}

	private CoreFlagRegister() {
	}

	private static void initializeRegister() {
		for (CoreFlag flag : CoreFlag.values())
			register.put(flag, false);
	}

	public static boolean isSet(CoreFlag flag) {
		return register.get(flag);
	}

	public static void set(CoreFlag flag) {
		register.put(flag, true);
	}

	public static boolean unsetIfSet(CoreFlag flag) {
		boolean isSet = isSet(flag);
		if (isSet)
			register.put(flag, false);
		return isSet;
	}

	public static boolean setIfUnset(CoreFlag flag) {
		boolean isSet = isSet(flag);
		if (!isSet)
			register.put(flag, true);
		return isSet;
	}
}
