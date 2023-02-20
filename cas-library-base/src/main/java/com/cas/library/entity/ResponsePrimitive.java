package com.cas.library.entity;

import java.math.BigInteger;

public class ResponsePrimitive {

	protected String requestIdentifier;
	protected String to;
	protected String from;
	protected String originatingTimestamp;
	protected BigInteger contentStatus;
	protected Boolean authorSignReqInfo;

	protected Object content;
	protected String location;
	protected String contentType;
	protected String responseStatusMessage;
	protected BigInteger responseStatusCode;

}
