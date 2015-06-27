### Import Engine
This project provides a client library for the Advantage Navigator import engine. Advantage Navigator is an online tool for energy monitoring provided by Siemens, see https://eadvantage.siemens.com/. The import engine allows to transfer data like meter readings to the online tool by sending messages using HTTPS. Note that for all operations, a valid device user account from Siemens is necessary. The library is licensed under Apache License 2.0.

The following example shows how the library is used. In the example, a new device status is sent to the import engine.

```java
ImportEngineClient client = new ImportEngineClient("user", "secret");

DeviceStatus status = new DeviceStatus(DeviceStatusClass.OK, "Device up and running", "1.1");
DeviceStatusCommand command = new DeviceStatusCommand(status);
	
String result = client.executeCommand(command);
```

More examples can be found in the project's wiki.
