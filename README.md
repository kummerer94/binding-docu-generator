# binding-docu-generator maven plugin
Large parts of a binding for eclipse smarthome can be generated automatically from the XML files you create. This is done via this maven plugin.

## Contributing
You are welcome to contribute to this repository. Just send me a pull request.

## Generating the 
**TODO:** CURRENTLY NOT WORKING ON MY LOCAL MACHINE.

**This is only necessary when the .xsd-files change. This should not happen very often.** You need to regenerate the schema classes. To do this, please download the new `binding-description-x.x.x.xsd`, `thing-description-x.x.x.xsd` and `config-description-x.x.x.xsd` and modify the corresponding paths in the XML schemas. (Exchange the paths to the .xsd-files with your local paths.)

To use JAXB we need to generate Java classes with XML annotations. This can be done via the following command:

```
%JAVA_HOME%\bin\xjc src/test/resources/thing-description-1.0.0.xsd -b src/test/resources/bindings.xsd
```

The files will be created in your current working directory. Please move the contents of the package `org.eclipse.smarthome.config_description.v1_0` and `org.eclipse.smarthome.thing_description.v1_0` into the package `org.openhab.schemas`.

Make sure to **modify the namespaces** of the generated `ConfigDescriptions.java` and `ThingDescriptions.java`:
```
@XmlRootElement(name = "config-descriptions", namespace = "http://eclipse.org/smarthome/schemas/config-description/v1.0.0")
```

```
@XmlRootElement(name = "thing-descriptions", namespace = "http://eclipse.org/smarthome/schemas/thing-description/v1.0.0")
```

