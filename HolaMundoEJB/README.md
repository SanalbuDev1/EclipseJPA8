Este proyecto contiene las siguientes clases y interfaces
```
1.HolaMundoEJBRemote.java
2.HolaMundoEJBImpl.java
3.TestHolaMundoEJB.java
```

> Ademas contiene las siguientes anotaciones

```
@Remote = El cual especifica al servidor de aplicaciones que queremos trabajar con un EJB remoto,
la forma de llamarlo seria la siguiente @EJB(@EJB(lookup="java:global/HolaMundoEJB/HolaMundoEJBImpl!beans.HolaMundoEJBRemote")
o en la clase TestHolaMundo.java se especifica otra manera
```

