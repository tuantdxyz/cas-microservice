package com.cas.library.entity;

import java.math.BigInteger;
import java.util.List;

public class RequestPrimitive {

	protected BigInteger operation;
	protected String to;
	protected String from;
	protected String requestIdentifier;

	protected List<String> roleIDs;
	protected String originatingTimestamp;
	protected BigInteger resultContent;
	protected List<String> authorSigns;

	protected Object content;
	protected String location;
	protected String contentType;

}
