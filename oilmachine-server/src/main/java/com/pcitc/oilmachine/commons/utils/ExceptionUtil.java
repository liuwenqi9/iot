package com.pcitc.oilmachine.commons.utils;

public class ExceptionUtil {
	public static String getStackTrace(Throwable errors) {
		StringBuffer result = new StringBuffer();
		if (errors != null) {
			result.append(errors);
			StackTraceElement[] trace = errors.getStackTrace();

			if (trace != null) {
				for (int i = 0; i < trace.length; i++)
					result.append("\r\n\tat " + trace[i]);
				Throwable ourCause = errors.getCause();
				if (ourCause != null)
					result.append(getStackTraceAsCause(ourCause, trace));
			}
		}
		return result.toString();
	}

	private static String getStackTraceAsCause(Throwable ourCause,
			StackTraceElement[] causedTrace) {
		StringBuffer result = new StringBuffer();
		StackTraceElement[] trace = ourCause.getStackTrace();
		int m = trace.length - 1, n = causedTrace.length - 1;
		while (m >= 0 && n >= 0 && trace[m].equals(causedTrace[n])) {
			m--;
			n--;
		}
		int framesInCommon = trace.length - 1 - m;
		result.append("\r\nCaused by: " + ourCause);
		for (int i = 0; i <= m; i++)
			result.append("\n\tat " + trace[i]);
		if (framesInCommon != 0)
			result.append("\r\n\t... " + framesInCommon + " more");

		Throwable tempCause = ourCause.getCause();
		if (tempCause != null)
			result.append(getStackTraceAsCause(tempCause, trace));
		return result.toString();
	}
}
