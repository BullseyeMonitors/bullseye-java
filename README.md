# Bullseye Java
a java library for connecting to the bullseye monitor web socket.

# Usage
```java
final String[] scopes = {"amazon"};
final BullseyeMonitor monitor = new BullseyeMonitor(
   "API_KEY",
   "DECRYPT_KEY",
   scopes, product -> System.out.println("Product: " + product.getTitle()));
monitor.setVerbose(true);
monitor.connect();
```
