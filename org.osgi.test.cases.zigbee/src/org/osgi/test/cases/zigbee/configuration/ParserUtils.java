
package org.osgi.test.cases.zigbee.configuration;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.osgi.service.zigbee.descriptions.ZCLDataTypeDescription;
import org.w3c.dom.Element;

public class ParserUtils {

	/**
	 * Mark an element attribute as MANDATORY
	 */
	public final static boolean	MANDATORY	= true;

	/**
	 * Mark an element attribute as OPTIONAL
	 */
	public final static boolean	OPTIONAL	= false;

	public static byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character
					.digit(s.charAt(i + 1), 16));
		}
		return data;
	}

	/**
	 * Convert a list like "1, 2, 3" and array [ 1, 2, 3]
	 * 
	 * @param listString
	 * @return the array.
	 */

	public static int[] toArray(String listString) {
		if (listString == null) {
			return new int[0];
		}

		StringTokenizer tokenizer = new StringTokenizer(listString, ",");
		List l = new ArrayList();
		while (tokenizer.hasMoreElements()) {
			l.add(Integer.valueOf(tokenizer.nextToken()));
		}

		int[] array = new int[l.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = ((Integer) l.get(i)).intValue();
		}
		return array;
	}

	public static ZCLDataTypeDescription dataTypeName2dataType(String dataTypeName) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
		Class cls = Class.forName("org.osgi.service.zigbee.types." + dataTypeName);

		Class[] classes = {};
		Method method = cls.getMethod("getInstance", classes);
		ZCLDataTypeDescription dataType = (ZCLDataTypeDescription) method
				.invoke(null, null);

		return dataType;
	}

	public static String getAttribute(Element element, String attributeName, boolean required, final String defaultValue) {
		if (element == null) {
			throw new NullPointerException("element argument cannot be null");
		}

		String attributeValue = element.getAttribute(attributeName);
		if (attributeValue == null || (attributeValue != null && attributeValue.length() == 0)) {
			if (!required) {
				return defaultValue;
			} else {
				throw new RuntimeException("parse error: missing attribute '" + attributeName + "'");
			}
		}

		return attributeValue;
	}

	public static int getAttribute(Element element, String attributeName, boolean required, final int defaultValue) {
		System.out.println("reading attribute " + attributeName);

		if (element == null) {
			throw new NullPointerException("element argument cannot be null");
		}

		String attributeValue = element.getAttribute(attributeName);
		if (attributeValue == null || (attributeValue != null && attributeValue.length() == 0)) {
			if (!required) {
				return defaultValue;
			} else {
				throw new RuntimeException("parse error: missing attribute " + attributeName);
			}
		}

		return Integer.parseInt(attributeValue);
	}

	public static short getAttribute(Element element, String attributeName, boolean required, final short defaultValue) {
		if (element == null) {
			throw new NullPointerException("element argument cannot be null");
		}

		String attributeValue = element.getAttribute(attributeName);
		if (attributeValue == null || (attributeValue != null && attributeValue.length() == 0)) {
			if (!required) {
				return defaultValue;
			} else {
				throw new RuntimeException("parse error: missing attribute " + attributeName);
			}
		}

		return Short.parseShort(attributeValue);
	}

	public static byte getAttribute(Element element, String attributeName, boolean required, final byte defaultValue) {
		if (element == null) {
			throw new NullPointerException("element argument cannot be null");
		}

		String attributeValue = element.getAttribute(attributeName);
		if (attributeValue == null || (attributeValue != null && attributeValue.length() == 0)) {
			if (!required) {
				return defaultValue;
			} else {
				throw new RuntimeException("parse error: missing attribute " + attributeName);
			}
		}

		return Byte.parseByte(attributeValue);
	}

	public static BigInteger getAttribute(Element element, String attributeName, boolean required, final BigInteger defaultValue) {
		if (element == null) {
			throw new NullPointerException("element argument cannot be null");
		}

		String attributeValue = element.getAttribute(attributeName);
		if (attributeValue == null || (attributeValue != null && attributeValue.length() == 0)) {
			if (!required) {
				return defaultValue;
			} else {
				throw new RuntimeException("parse error: missing attribute " + attributeName);
			}
		}

		return new BigInteger(attributeValue);
	}

	public static boolean getAttribute(Element element, String attributeName, boolean required, boolean defaultValue) {
		if (element == null) {
			throw new NullPointerException("element argument cannot be null");
		}

		String attributeValue = element.getAttribute(attributeName);
		if (attributeValue == null || (attributeValue != null && attributeValue.length() == 0)) {
			if (!required) {
				return defaultValue;
			} else {
				throw new RuntimeException("parse error: missing attribute " + attributeName);
			}
		}

		return Boolean.getBoolean(attributeValue);
	}

	public static String getAttribute(Map element, String attributeName, boolean required, final String defaultValue) {
		if (element == null) {
			throw new NullPointerException("element argument cannot be null");
		}

		String attributeValue = (String) element.get(attributeName);
		if (attributeValue == null) {
			if (!required) {
				return defaultValue;
			} else {
				throw new RuntimeException("parse error: missing attribute " + attributeName);
			}
		}

		return attributeValue;
	}

	public static int getAttribute(Map element, String attributeName, boolean required, final int defaultValue) {
		if (element == null) {
			throw new NullPointerException("element argument cannot be null");
		}

		String attributeValue = (String) element.get(attributeName);
		if (attributeValue == null || (attributeValue != null && attributeValue.length() == 0)) {
			if (!required) {
				return defaultValue;
			} else {
				throw new RuntimeException("parse error: missing attribute " + attributeName);
			}
		}

		return Integer.parseInt(attributeValue);
	}

	public static short getAttribute(Map element, String attributeName, boolean required, final short defaultValue) {
		if (element == null) {
			throw new NullPointerException("element argument cannot be null");
		}

		String attributeValue = (String) element.get(attributeName);
		if (attributeValue == null || (attributeValue != null && attributeValue.length() == 0)) {
			if (!required) {
				return defaultValue;
			} else {
				throw new RuntimeException("parse error: missing attribute " + attributeName);
			}
		}

		return Short.parseShort(attributeValue);
	}

	public static byte getAttribute(Map element, String attributeName, boolean required, final byte defaultValue) {
		if (element == null) {
			throw new NullPointerException("element argument cannot be null");
		}

		String attributeValue = (String) element.get(attributeName);
		if (attributeValue == null || (attributeValue != null && attributeValue.length() == 0)) {
			if (!required) {
				return defaultValue;
			} else {
				throw new RuntimeException("parse error: missing attribute " + attributeName);
			}
		}

		return Byte.parseByte(attributeValue);
	}

	public static BigInteger getAttribute(Map element, String attributeName, boolean required, final BigInteger defaultValue) {
		if (element == null) {
			throw new NullPointerException("element argument cannot be null");
		}

		String attributeValue = (String) element.get(attributeName);
		if (attributeValue == null || (attributeValue != null && attributeValue.length() == 0)) {
			if (!required) {
				return defaultValue;
			} else {
				throw new RuntimeException("parse error: missing attribute " + attributeName);
			}
		}

		return new BigInteger(attributeValue);
	}

	public static boolean getAttribute(Map element, String attributeName, boolean required, boolean defaultValue) {
		if (element == null) {
			throw new NullPointerException("element argument cannot be null");
		}

		String attributeValue = (String) element.get(attributeName);
		if (attributeValue == null || (attributeValue != null && attributeValue.length() == 0)) {
			if (!required) {
				return defaultValue;
			} else {
				throw new RuntimeException("parse error: missing attribute " + attributeName);
			}
		}

		return Boolean.getBoolean(attributeValue);
	}
}