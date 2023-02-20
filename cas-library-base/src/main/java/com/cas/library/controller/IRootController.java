package com.cas.library.controller;

import com.cas.library.entity.RequestPrimitive;
import com.cas.library.entity.ResponsePrimitive;

public interface IRootController {

	public ResponsePrimitive doRequest(RequestPrimitive request);

	public ResponsePrimitive doCreate(RequestPrimitive request);

	public ResponsePrimitive doRetrieve(RequestPrimitive request);

	public ResponsePrimitive doUpdate(RequestPrimitive request);

	public ResponsePrimitive doDelete(RequestPrimitive request);

	public ResponsePrimitive doNotify(RequestPrimitive request);

	public ResponsePrimitive doDisco(RequestPrimitive request);

}
